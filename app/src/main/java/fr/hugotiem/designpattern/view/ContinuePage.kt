package fr.hugotiem.designpattern.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import fr.hugotiem.designpattern.R
import fr.hugotiem.designpattern.viewmodel.ContinueViewModel

@Composable
fun ContinuePage (navController: NavController, continueViewModel: ContinueViewModel) {
    val list = arrayListOf<String>("item1", "item2", "item3", "item4", "item5")
    Scaffold(
        topBar = {
            CustomTopAppBar(navController = navController, automaticLeading = true)
        },
        backgroundColor = colorResource(id = R.color.app_purple)
    ) {
        LazyColumn(
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            items(list) { item ->
                Column(
                    modifier = Modifier
                        .padding(
                            vertical = 10.dp
                        )
                        .clickable {
                            navController.navigate("report")
                        }
                ) {
                    Text(
                        text = "Match - TEAM A vs. TEAM B",
                        color = colorResource(id = R.color.white),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Surface(
                        modifier = Modifier
                            .clip(
                                shape = RoundedCornerShape(
                                    topStart = 5.dp,
                                    bottomStart = 20.dp,
                                    topEnd = 20.dp,
                                    bottomEnd = 20.dp
                                ),
                            )
                            .border(
                                2.dp,
                                color = colorResource(id = R.color.white),
                                shape = RoundedCornerShape(
                                    topStart = 5.dp,
                                    bottomStart = 20.dp,
                                    topEnd = 20.dp,
                                    bottomEnd = 20.dp
                                ),
                            )
                    ) {
                        Column(
                            modifier = Modifier
                                .background(
                                    brush = Brush.horizontalGradient(
                                        colors = listOf(
                                            colorResource(id = R.color.white),
                                            colorResource(id = R.color.app_purple)
                                        )
                                    )
                                )
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = item,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(
                                    top = 20.dp,
                                    start = 20.dp,
                                )
                            )
                            Row(
                                verticalAlignment = Alignment.Bottom
                            ) {
                                Text(
                                    text = "VS",
                                    fontWeight = FontWeight.Bold,
                                    color = colorResource(id = R.color.orange),
                                    fontSize = 24.sp,
                                    modifier = Modifier.padding(
                                        bottom = 20.dp,
                                        start = 30.dp
                                    )
                                )
                                Text(
                                    text = item,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(
                                        bottom = 20.dp,
                                        start = 10.dp
                                    )
                                )
                            }

                            Text(
                                text = "02/08/2021",
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 20.dp)
                            )
                            Text(
                                text = "score: 25 - 16",
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(
                                    start = 20.dp,
                                    bottom = 20.dp
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}