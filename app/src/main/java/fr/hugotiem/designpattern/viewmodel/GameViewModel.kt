package fr.hugotiem.designpattern.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.hugotiem.designpattern.model.Game
import fr.hugotiem.designpattern.model.Player
import fr.hugotiem.designpattern.model.Team
import kotlin.random.Random

class GameViewModel: ViewModel() {

    val game: Game = Game()

    val currentPlayerLiveData = MutableLiveData<Player?>()
    val currentTeamLiveData = MutableLiveData<Team>()
    val scoreTeam1LiveData = MutableLiveData<Int>(0)
    val scoreTeam2LiveData = MutableLiveData<Int>(0)

    var currentPlayer: Player?
        get() = currentPlayerLiveData.value
        set(value) {
            currentPlayerLiveData.postValue(value)
        }

    var currentTeam: Team?
        get() = currentTeamLiveData.value
        set(value) {
            currentTeamLiveData.postValue(value)
        }

    var scoreTeam1: Int
        get() = scoreTeam1LiveData.value!!
        set(value) {
            scoreTeam1LiveData.postValue(value)
        }

    var scoreTeam2: Int
        get() = scoreTeam2LiveData.value!!
        set(value) {
            scoreTeam2LiveData.postValue(value)
        }

    fun addPts(pts: Int) {
        if(currentPlayer != null) {
            val probability = Random.nextInt(0, 100)
            val userStat = getStat(pts)
            if(probability <= userStat) {
                if(currentTeam == game.team1) {

                }
            } else {
                // NO PTS
                Log.d("$pts pts", "${currentPlayer!!.name} LOSE")
            }
        }
    }

    fun getStat(pts: Int): Int {
        if(pts == 2) return currentPlayer!!.pts2
        return currentPlayer!!.pts3
    }
}