package fr.hugotiem.designpattern

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import fr.hugotiem.designpattern.ui.theme.DesignPatternTheme
import fr.hugotiem.designpattern.view.*
import fr.hugotiem.designpattern.viewmodel.ContinueViewModel
import fr.hugotiem.designpattern.viewmodel.GameViewModel
import fr.hugotiem.designpattern.viewmodel.ReportViewModel
import fr.hugotiem.designpattern.viewmodel.SetupViewModel

class MainActivity : ComponentActivity() {

    private val gameViewModel by viewModels<GameViewModel>()
    private val setupViewModel by viewModels<SetupViewModel>()
    private val reportViewModel by viewModels<ReportViewModel>()
    private val continueViewModel by viewModels<ContinueViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            DesignPatternTheme {
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") { HomePage(navController) }
                    composable("continue") { ContinuePage(navController, continueViewModel) }
                    composable("report") { ReportPage(navController, reportViewModel) }
                    composable("setup") { SetupPage(navController, setupViewModel) }
                    composable("team-selection") { TeamSelection(navController) }
                    composable("game") { GamePage().GamePage(navController, gameViewModel) }
                }
            }
        }
    }
}
