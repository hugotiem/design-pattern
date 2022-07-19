package fr.hugotiem.designpattern.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import fr.hugotiem.designpattern.R
import fr.hugotiem.designpattern.viewmodel.ReportViewModel
import java.util.*

@Composable
fun ReportPage(navController: NavController, reportViewModel: ReportViewModel) {
    Scaffold(
        backgroundColor = colorResource(id = R.color.app_purple),
        topBar = {
            TopAppBar(
                backgroundColor = colorResource(id = R.color.app_purple),
                elevation = 0.dp,
                title = {
                    Text(
                        text = "Détails",
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
        Column(modifier = Modifier.padding(20.dp)) {
            Text(
                text = "Match - TEAM A vs. TEAM B ",
                color = colorResource(id = R.color.white),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 40.dp)
            )
            Row() {
                Text(
                    text = "Date: ",
                    color = colorResource(id = R.color.white),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "02/08/2021",
                    color = colorResource(id = R.color.orange),
                    fontWeight = FontWeight.Bold
                )
            }
            Row() {
                Text(
                    text = "Points: ",
                    color = colorResource(id = R.color.white),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "25 - 16",
                    color = colorResource(id = R.color.orange),
                    fontWeight = FontWeight.Bold
                )
            }
            Row(
                modifier = Modifier.padding(bottom = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Gagnant: ",
                    color = colorResource(id = R.color.white),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "TEAM A",
                    color = colorResource(id = R.color.orange),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Column(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(10.dp))
                    .background(color = colorResource(id = R.color.white).copy(alpha = .8F))
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(10.dp))
                        .padding(10.dp)
                ) {
                    Text(
                        text = "TEAM A",
                        fontWeight = FontWeight.Bold
                    )
                    Box(
                        modifier = Modifier
                            .background(color = colorResource(id = R.color.black))
                            .height(60.dp)
                            .width(2.dp)
                    )
                    Text(
                        text = "TEAM B",
                        fontWeight = FontWeight.Bold
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = "78%",
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "POSSESSION",
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "55%",
                        fontWeight = FontWeight.Bold
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = "78%",
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "TIRS A 3 PTS",
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "55%",
                        fontWeight = FontWeight.Bold
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = "78%",
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "PASSES REUSSIS",
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "55%",
                        fontWeight = FontWeight.Bold
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = "78%",
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "PRECISION",
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "55%",
                        fontWeight = FontWeight.Bold
                    )
                }
                Box(
                    modifier = Modifier
                        .background(
                            color = colorResource(id = R.color.black)
                        )
                        .width(2.dp)
                        .height(100.dp)
                        .padding(vertical = 10.dp)
                )
            }
        }
        
    }
}