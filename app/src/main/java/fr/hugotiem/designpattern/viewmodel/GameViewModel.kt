package fr.hugotiem.designpattern.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.hugotiem.designpattern.model.Game
import fr.hugotiem.designpattern.model.Player
import fr.hugotiem.designpattern.model.Team
import kotlin.random.Random

class GameViewModel: ViewModel() {

    var game = MutableLiveData<Game>()

    val currentPlayerLiveData = MutableLiveData<Player?>()
    val currentTeamLiveData = MutableLiveData<Team>(game.value?.team1)
    val scoreTeam1LiveData = MutableLiveData<Int>(0)
    val scoreTeam2LiveData = MutableLiveData<Int>(0)

    fun fetchGame() {
        val _game = Game.fromJson(games[0])
        game.postValue(_game)
    }

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
                if(currentTeam == game.value?.team1) {
                    scoreTeam1LiveData.postValue(scoreTeam1LiveData.value?.plus(getPoint(pts)))
                } else {
                    scoreTeam2LiveData.postValue(scoreTeam2LiveData.value?.plus(getPoint(pts)))
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

    fun getPoint(pts: Int): Int {
        if(pts == 2) return 2
        return 3
    }
}