package fr.hugotiem.designpattern

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
@Composable
fun GamePage(navController: NavController) {

    Scaffold(
        backgroundColor = colorResource(id = R.color.app_purple),
        topBar = {
        TopAppBar(
            backgroundColor = colorResource(id = R.color.purple_200),
            elevation = 0.dp,
            title = {
                Text(
                    text = "Game",
                    color = colorResource(id = R.color.white),
                    fontSize = 20.sp
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
            },
        )
    }) {
        Card(
            modifier = Modifier
                .padding(15.dp),
            elevation = 10.dp
        ) {
            Column( horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 20.dp)) {
                Row(modifier = Modifier.padding(8.dp)) {
                    Text(text = "équipe 1")
                    SwitchDemo()
                    Text(text = "équipe 2")

                }
                Row() {
                    Text(text = "Score équipe 1 :")
                    Text(text = " 0")
                    Text(text = " Score équipe 2 :")
                    Text(text = " 0")
                }

                Row {
                    Button2Pts()
                    Button3Pts()
                }

                Row {
                    ButtonEnd()
                }
            }

        }


    }
}







@Composable
fun SwitchDemo() {
    val checkedState = remember { mutableStateOf(true) }
    Switch(
        checked = checkedState.value,
        onCheckedChange = { checkedState.value = it }
    )
}

@Composable
fun Button2Pts() {
    Button(onClick = { /* Do something! */ }, colors = ButtonDefaults.textButtonColors(
        backgroundColor = Color.Red
    ), modifier = Modifier.padding(8.dp),
        shape = CircleShape
    ) {
        Text("+2",
            color = Color.White)
    }
}

@Composable
fun Button3Pts() {
    Button(onClick = { /* Do something! */ }, colors = ButtonDefaults.textButtonColors(
        backgroundColor = Color.Green
    ), modifier = Modifier.padding(8.dp),
        shape = CircleShape
    ) {
        Text("+3",
            color = Color.White)
    }
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