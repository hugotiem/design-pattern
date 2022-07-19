package fr.hugotiem.designpattern.view

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import fr.hugotiem.designpattern.R

@Composable
fun CustomTopAppBar(navController: NavController, automaticLeading: Boolean, title: String? = null, onClick: (() -> Unit)? = null) {
    TopAppBar(
        backgroundColor = colorResource(id = R.color.app_purple),
        elevation = 0.dp,
        title = {
            if(title != null) {
                Text(
                    text = title,
                    color = colorResource(id = R.color.white),
                    fontSize = 20.sp,
                )
            }
        },
        navigationIcon = {
            if(automaticLeading) {
                IconButton(onClick = {
                    if(onClick == null) {
                        navController.popBackStack()
                    } else {
                        onClick()
                    }
                }) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = null,
                        tint = colorResource(id = R.color.white)
                    )
                }
            }
        }
    )
}