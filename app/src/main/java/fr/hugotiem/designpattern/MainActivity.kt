package fr.hugotiem.designpattern

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fr.hugotiem.designpattern.ui.theme.ContinuePage
import fr.hugotiem.designpattern.ui.theme.DesignPatternTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultPreview()
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val navController = rememberNavController()
    DesignPatternTheme {
        NavHost(navController = navController, startDestination = "home") {
            composable("home") { HomePage(navController) }
            composable("continue") { ContinuePage(navController) }
            composable("report") { ReportPage(navController) }
            composable("setup") { SetupPage(navController) }
            composable("team-selection") { TeamSelection(navController) }
        }
    }
}