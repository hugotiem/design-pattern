package fr.hugotiem.designpattern.view

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack

import androidx.compose.runtime.*

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import fr.hugotiem.designpattern.R
import fr.hugotiem.designpattern.model.Player
import kotlin.random.Random
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.text.style.TextAlign
import fr.hugotiem.designpattern.model.Level
import fr.hugotiem.designpattern.model.Team
import fr.hugotiem.designpattern.viewmodel.GameViewModel
import fr.hugotiem.designpattern.viewmodel.games

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GamePage(navController: NavController, gameViewModel: GameViewModel) {

    val currentUserState: Player? by gameViewModel.currentPlayerLiveData.observeAsState()
    val currentTeamState: Team? by gameViewModel.currentTeamLiveData.observeAsState()
    val scoreTeam1State: Int? by gameViewModel.scoreTeam1LiveData.observeAsState()
    val scoreTeam2State: Int? by gameViewModel.scoreTeam2LiveData.observeAsState()

    val roundState: MutableState<Int> = remember {
        mutableStateOf(1)
    }

    val ptsState: MutableState<String?> = remember {
        mutableStateOf(null)
    }

    LaunchedEffect(Unit) {
        gameViewModel.fetchGame()
    }

    Scaffold(
        backgroundColor = colorResource(id = R.color.app_purple),
        topBar = {
            CustomTopAppBar(navController = navController, automaticLeading = true, onClick = {
                gameViewModel.currentPlayer = null
                navController.popBackStack()
            })
        }
    ) {

        Column(
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            val checkedState = remember { mutableStateOf(false) }
            if(checkedState.value) {
                gameViewModel.currentTeamLiveData.postValue(gameViewModel.game.value?.team1)
            } else {
                gameViewModel.currentTeamLiveData.postValue(gameViewModel.game.value?.team2)
            }
            Row(modifier = Modifier.padding(8.dp)) {
                gameViewModel.game.value?.team1?.name?.let { it1 -> Text(text = it1, color = Color.White) }
                SwitchDemo(checkedState)
                gameViewModel.game.value?.team2?.name?.let { it1 -> Text(text = it1, color = Color.White) }

            }
            Row() {
                Text(text = "Score équipe 1 : $scoreTeam1State", color = Color.White)
                Text(text = " Score équipe 2 : $scoreTeam2State", color = Color.White)
            }

            val players: List<Player> = currentTeamState?.players ?: listOf()

            LazyVerticalGrid(cells = GridCells.Adaptive(minSize = 130.dp), content = {
                items(players) { player ->
                    ButtonPlayer(
                        text = player.name,
                        color = colorResource(id = R.color.grey),
                        player = player,
                        onClick = {
                            gameViewModel.currentPlayerLiveData.postValue(player)
                        }
                    )
                }
            })

            Row {
                ButtonPts(
                    text = "+2",
                    color = Color.Red,
                    onClick = {
                        if(currentUserState != null) {
                            gameViewModel.addPts(2)
                            checkedState.value = !checkedState.value
                            gameViewModel.currentPlayerLiveData.postValue(null)
                        }
                    }
                )
                ButtonPts(
                    text = "+3",
                    color = Color.Green,
                    onClick = {
                        if(currentUserState != null) {
                            val hasWin = gameViewModel.addPts(3)
                            if(hasWin != null) {
                                if(hasWin) {
                                    ptsState.value = "Win!"
                                } else {
                                    ptsState.value = "Lose..."
                                }
                            }
                            checkedState.value = !checkedState.value
                            gameViewModel.currentPlayerLiveData.postValue(null)
                        }
                    }
                )
            }

            if(currentUserState != null) {
                Text(currentUserState!!.name, color = Color.White)
            } else {
                Text(text = "NO PLAYER",  color = Color.White)
                if(ptsState.value != null) {
                    Text(text = ptsState.value!!, color = Color.White)
                }
            }

            Surface(
                modifier = Modifier
                    .clickable {
                        navController.navigate("")
                    }
                    .padding(vertical = 20.dp),
                color = colorResource(id = R.color.grey),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text(
                    text = "Terminer",
                    modifier = Modifier
                        .padding(
                            vertical = 10.dp,
                            horizontal = 20.dp,
                        )
                        .defaultMinSize(minWidth = 100.dp)
                        .clickable {
                            navController.navigate("report")
                        },
                    textAlign = TextAlign.Center
                )
            }

        }


    }
}

@Composable
fun SwitchDemo(checkedState: MutableState<Boolean>) {
    // val checkedState = remember { mutableStateOf(true) }
    Switch(
        checked = checkedState.value,
        onCheckedChange = { checkedState.value = it }
    )
}

@Composable
fun ButtonPts(text: String, color: Color, onClick: () -> Unit) {
    Button(onClick = { onClick() }, colors = ButtonDefaults.textButtonColors(
        backgroundColor = color
    ), modifier = Modifier.padding(8.dp),
        shape = CircleShape
    ) {
        Text(text = text,
            color = Color.White)
    }
}

@Composable
fun ButtonPlayer(text: String, color: Color, player: Player, onClick: () -> Unit) {
    ButtonPts(text = text, color = color, onClick = {
       onClick()
        /*val generated = Random.nextInt(0, 100)
        if(generated <= pourcent) {
            Log.d("mess", "WIN")
        } else {
            Log.d("mess", "LOSE")
        }*/
    })
}


@Composable
fun ButtonEnd() {
    Button(onClick = { /* Do something! */ }, colors = ButtonDefaults.textButtonColors(
        backgroundColor = Color.Gray
    ), modifier = Modifier.padding(8.dp),
        shape = CircleShape
    ) {
        Text("Fin de parti",
            color = Color.White)
    }
}