package fr.hugotiem.designpattern.view

import android.content.Intent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import fr.hugotiem.designpattern.R

@Composable
fun HomePage(navController: NavController) {
    Scaffold(backgroundColor = colorResource(id = R.color.app_purple)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(bottom = 20.dp)
        ) {
            Text(
                text = "Accueil",
                color = colorResource(id = R.color.white),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 20.dp)
            )


            Image(
                painter = painterResource(id = R.drawable.home),
                contentDescription = null,
                modifier = Modifier.fillMaxSize().weight(1f, fill = false),
            )


            Surface(
                modifier = Modifier.clickable {
                    navController.navigate("setup")
                }.padding(vertical = 10.dp),
                color = colorResource(id = R.color.grey),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text(
                    text = "Nouvelle partie",
                    modifier = Modifier.padding(
                        vertical = 10.dp,
                        horizontal = 20.dp,
                    )
                )
            }

            Surface(
                modifier = Modifier.clickable {
                    navController.navigate("continue")
                }.padding(vertical = 10.dp),
                color = colorResource(id = R.color.grey),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text(
                    text = "Continuer",
                    modifier = Modifier.padding(
                        vertical = 10.dp,
                        horizontal = 20.dp,
                    )
                )
            }
        }
    }
}