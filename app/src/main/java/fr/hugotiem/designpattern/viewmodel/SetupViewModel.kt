package fr.hugotiem.designpattern.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.hugotiem.designpattern.model.Game
import fr.hugotiem.designpattern.model.Level
import fr.hugotiem.designpattern.model.Team

class SetupViewModel: ViewModel() {
    val myGame = MutableLiveData<Game>(Game.initGame())

    var game: Game?
        get() = myGame.value
        set(value) {
            myGame.postValue(value)
        }

    fun buildTeam1(team:Team){
        Log.d("BUILD", game?.copyWith(team1 = team)?.team1?.name.toString())
        myGame.postValue(game?.copyWith(team1 = team))
    }

    fun buildTeam2(team:Team){
        Log.d("BUILD", game?.team1?.name.toString())
        myGame.postValue(game?.copyWith(team2 = team))
    }

    fun buildLevel(level: Level){
        myGame.postValue(game?.copyWith(level = level))
    }




}