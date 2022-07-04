package fr.hugotiem.designpattern.ui.theme

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavController
import fr.hugotiem.designpattern.R

@Composable
fun ContinuePage (navController: NavController) {
    Scaffold(
        backgroundColor = colorResource(id = R.color.app_purple)
    ) {

    }
}