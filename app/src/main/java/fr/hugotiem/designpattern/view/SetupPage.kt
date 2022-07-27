package fr.hugotiem.designpattern.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import fr.hugotiem.designpattern.R
import fr.hugotiem.designpattern.model.Game
import fr.hugotiem.designpattern.model.Level
import fr.hugotiem.designpattern.model.Team
import fr.hugotiem.designpattern.viewmodel.SetupViewModel
import fr.hugotiem.designpattern.viewmodel.teams

@Composable
fun SetupPage(navController: NavController, setupViewModel: SetupViewModel) {

    val game: Game? by setupViewModel.myGame.observeAsState()

    val openPage: MutableState<Boolean> = remember {
        mutableStateOf(false)
    }

    val currentTeamSetup: MutableState<Int> = remember {
        mutableStateOf(1)
    }

    Scaffold(
        backgroundColor = colorResource(id = R.color.app_purple),
        topBar = {
            CustomTopAppBar(navController = navController, automaticLeading = true, title = "Nouvelle partie")
        }
    ) {
        Image(
            painter = painterResource(id = R.drawable.basket_background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillWidth
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(20.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        shape = RoundedCornerShape(10.dp)
                    )
            ) {
                Column(
                    modifier = Modifier.background(color = colorResource(id = R.color.white).copy(alpha = .8F))
                ) {
                    Text(
                        text = "Choisissez une équipe pour le joueur 1",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(20.dp)
                    )
                    AppAddSurface(navController = navController, text = "Selectionner une equipe",
                    onClick = {
                        currentTeamSetup.value = 1
                        openPage.value = true
                    }, team = game?.team1
                        )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Choisissez une Equipe pour le joueur 2",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(20.dp)
                    )
                    AppAddSurface(navController = navController, text = "Selectionner une equipe",onClick = {
                        currentTeamSetup.value = 2
                        openPage.value = true
                    }, team = game?.team2)
                    Spacer(modifier = Modifier.height(10.dp))
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier.padding(horizontal = 20.dp)
                    ) {
                        Text(
                            text = "Niveau des joueurs :",
                            fontSize = 14.sp
                        )
                        Text(
                            text = "Débutant",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 20.dp)
                    ) {
                        Text(text = "Durée d’une partie :")
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            val time: MutableState<Int> = remember {
                                mutableStateOf(15)
                            }
                            Icon(Icons.Filled.KeyboardArrowUp,
                                contentDescription = null,
                                modifier = Modifier.clickable {
                                    if(time.value < 40) {
                                        time.value += 5
                                    }
                                }
                            )
                            Text(
                                text = "${time.value} min",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Icon(
                                Icons.Filled.KeyboardArrowDown,
                                contentDescription = null,
                                modifier = Modifier.clickable {
                                    if(time.value > 5) {
                                        time.value -= 5
                                    }
                                }
                            )
                        }
                    }
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
                    text = "OK",
                    modifier = Modifier
                        .padding(
                            vertical = 10.dp,
                            horizontal = 20.dp,
                        )
                        .defaultMinSize(minWidth = 100.dp)
                        .clickable {
                            setupViewModel.buildLevel(Level.ROOKIE)
                            navController.navigate("game")
                                   },
                    textAlign = TextAlign.Center
                )
            }
        }
        if(openPage.value) {
            TeamSelection(navController = navController, onClick = {
                if(currentTeamSetup.value == 1) {
                    setupViewModel.buildTeam1(Team.fromJson(teams[0]));
                } else {
                    setupViewModel.buildTeam2(Team.fromJson(teams[1]));
                    Log.d("LOG", game?.team2.toString())
                }

            }, onReturn = {
                openPage.value = false
            })
        }
    }
}




@Composable
fun AppAddSurface(navController: NavController, text: String, team: Team?=null, onClick: () -> Unit = {}) {
    val icon = if(team == null) {
        Icons.Filled.Add
    } else {
        Icons.Filled.Check
    }
    Box(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .clickable {
                onClick()
                //navController.navigate("team-selection")
            }
    ){
        Box(
            modifier = Modifier.clip(shape = RoundedCornerShape(10.dp)),
        ) {
            Row(
                modifier = Modifier
                    .background(color = colorResource(id = R.color.white))
                    .padding(10.dp)
                    .padding(end = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                        onClick()
                    },
                    Modifier.background(
                        color = colorResource(id = R.color.grey),
                        shape = RoundedCornerShape(50)
                    )
                ) {
                    Icon(
                        icon,
                        contentDescription = null,
                        modifier = Modifier.padding(10.dp)
                    )
                }
                if(team != null) {
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        text = "Equipe séléctionné",
                        fontSize = 16.sp
                    )
                } else {
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        text = text,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}