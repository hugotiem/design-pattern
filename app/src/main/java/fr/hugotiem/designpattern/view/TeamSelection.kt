package fr.hugotiem.designpattern.view

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import fr.hugotiem.designpattern.R
import fr.hugotiem.designpattern.viewmodel.SetupViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TeamSelection(navController: NavController, onClick: () -> Unit, onReturn: () -> Unit) {
    val selected: MutableState<Int> = remember {
        mutableStateOf(0)
    }
    Scaffold(
        backgroundColor = colorResource(id = R.color.app_purple),
        topBar = {
            TopAppBar (
                backgroundColor = colorResource(id = R.color.app_purple),
                title = {},
                navigationIcon = {
                    IconButton(onClick = { onReturn() }) {
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
        Image(
            painter = painterResource(id = R.drawable.vs_img),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        val list: List<Int> = listOf<Int>(
            R.drawable.frame_1,
            R.drawable.frame_2,
            R.drawable.frame_3,
            R.drawable.frame_4,
            R.drawable.frame_5,
            R.drawable.frame_6,
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxHeight()
        ) {
            LazyVerticalGrid(
                cells = GridCells.Fixed(count = 2),
                modifier = Modifier.padding(20.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                items(list) { item ->
                    var modifier: Modifier = Modifier
                    if(selected.value == list.indexOf(item)) {
                        modifier = Modifier.border(
                            border = BorderStroke(
                                5.dp, color = colorResource(id = R.color.green)
                            ),
                            shape = RoundedCornerShape(20.dp)
                        )
                    }
                    Box(
                        modifier =  modifier.clickable {
                            selected.value = list.indexOf(item)
                            onClick()

                        }
                    ) {
                        Image(
                            painter = painterResource(id = item),
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth(),
                            contentScale = ContentScale.FillWidth
                        )
                    }
                }
            }
            Surface(
                modifier = Modifier
                    .clickable {
                        onReturn()
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