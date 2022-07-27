package fr.hugotiem.designpattern.view

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
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
import fr.hugotiem.designpattern.model.Team
import fr.hugotiem.designpattern.viewmodel.GameViewModel

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

    Scaffold(
        backgroundColor = colorResource(id = R.color.app_purple),
        topBar = {
            CustomTopAppBar(navController = navController, automaticLeading = true, onClick = {
                gameViewModel.currentPlayer = null
                navController.popBackStack()
            })
        }
    ) {

        Column() {
            val checkedState = remember { mutableStateOf(true) }
            Row(modifier = Modifier.padding(8.dp)) {
                gameViewModel.game.team1?.name?.let { it1 -> Text(text = it1) }
                SwitchDemo(checkedState)
                gameViewModel.game.team2?.name?.let { it1 -> Text(text = it1) }

            }
            Row() {
                Text(text = "Score équipe 1 : $scoreTeam1State")
                Text(text = " Score équipe 2 : $scoreTeam2State")
            }

            val players: List<Player> = currentTeamState?.players ?: listOf()

            LazyVerticalGrid(cells = GridCells.Adaptive(minSize = 130.dp), content = {
                items(players) { player ->
                    ButtonPlayer(
                        text = player.name,
                        color = colorResource(id = R.color.grey),
                        player = player
                    )
                }
            })

            Row {
                ButtonPts(
                    text = "+2",
                    color = Color.Red,
                    onClick = {
                        gameViewModel.addPts(2)
                    }
                )
                ButtonPts(
                    text = "+3",
                    color = Color.Green,
                    onClick = {
                        gameViewModel.addPts(3)
                    }
                )
            }

            if(currentUserState != null) {
                Text(currentUserState!!.name)
            } else {
                Text(text = "NO PLAYER")


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
fun ButtonPlayer(text: String, color: Color, player: Player) {
    ButtonPts(text = text, color = color, onClick = {
        // CurrentPlayer.currentPlayer = player
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