package fr.hugotiem.designpattern

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TeamSelection(navController: NavController) {
    val selected: MutableState<Int> = remember {
        mutableStateOf(0)
    }
    Scaffold(
        backgroundColor = colorResource(id = R.color.app_purple),
        topBar = {
            TopAppBar (
                title = {},
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            Icons.Filled.ArrowBack,
                            contentDescription = null,
                            tint = colorResource(id = R.color.white)
                        )
                    }
                },
                elevation = 0.dp
            )
        }
    ) {
        val list: List<Int> = listOf<Int>(
            R.drawable.frame_1,
            R.drawable.frame_2,
            R.drawable.frame_3,
            R.drawable.frame_4,
            R.drawable.frame_5,
            R.drawable.frame_6,
        )
        LazyVerticalGrid(
            cells = GridCells.Fixed(count = 2)
        ) {
            items(list) { item ->
                Image(
                    painter = painterResource(id = item),
                    contentDescription = null
                )
            }
        }
    }
}