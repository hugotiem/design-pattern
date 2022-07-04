package fr.hugotiem.designpattern

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ReportPage(navController: NavController) {
    Scaffold(
        backgroundColor = colorResource(id = R.color.app_purple),
        topBar = {
            TopAppBar(
                backgroundColor = colorResource(id = R.color.app_purple),
                elevation = 0.dp
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = null,
                        tint = colorResource(id = R.color.white)
                    )
                }
            }
        }
    ) {

    }
}