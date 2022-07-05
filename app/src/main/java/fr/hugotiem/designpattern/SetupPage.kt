package fr.hugotiem.designpattern

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
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

@Composable
fun SetupPage(navController: NavController) {
    Scaffold(
        backgroundColor = colorResource(id = R.color.app_purple),
        topBar = {
            TopAppBar(
                backgroundColor = colorResource(id = R.color.app_purple),
                elevation = 0.dp,
                title = {
                    Text(
                        text = "Nouvelle partie",
                        color = colorResource(id = R.color.white),
                        fontSize = 20.sp,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = null,
                            tint = colorResource(id = R.color.white)
                        )
                    }
                }
            ) 
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
                    AppAddSurface(navController = navController, text = "Selectionner une equipe")
                    Spacer(modifier = Modifier.height(10.dp))
                    AppAddSurface(navController = navController, text = "Créer une équipe")
                    Text(
                        text = "Choisissez une Equipe pour le joueur 2",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(20.dp)
                    )
                    AppAddSurface(navController = navController, text = "Selectionner une equipe")
                    Spacer(modifier = Modifier.height(10.dp))
                    AppAddSurface(navController = navController, text = "Créer une équipe")
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
                            Icon(Icons.Filled.KeyboardArrowUp, contentDescription = null)
                            Text(
                                text = "15 min",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Icon(Icons.Filled.KeyboardArrowDown, contentDescription = null)
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
                        .defaultMinSize(minWidth = 100.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun AppAddSurface(navController: NavController, text: String) {
    Box(
        modifier = Modifier.padding(horizontal = 20.dp)
    ){
        Box(
            modifier = Modifier.clip(shape = RoundedCornerShape(10.dp)),
        ) {
            Row(
                modifier = Modifier
                    .background(color = colorResource(id = R.color.white))
                    .padding(10.dp).padding(end = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                        //navController.navigate("")
                    },
                    Modifier.background(
                        color = colorResource(id = R.color.grey),
                        shape = RoundedCornerShape(50)
                    )
                ) {
                    Icon(
                        Icons.Filled.Add,
                        contentDescription = null,
                        modifier = Modifier.padding(10.dp)
                    )
                }
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = text,
                    fontSize = 16.sp
                )
            }
        }
    }
}