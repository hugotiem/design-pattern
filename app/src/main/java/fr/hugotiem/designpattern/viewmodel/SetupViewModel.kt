package fr.hugotiem.designpattern.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.hugotiem.designpattern.model.Game
import fr.hugotiem.designpattern.model.Level
import fr.hugotiem.designpattern.model.Team

class SetupViewModel: ViewModel() {
    val myGame = MutableLiveData<Game>()


    fun buildTeam1(team:Team){
        myGame.value = myGame.value?.copyWith(team1 = team)
    }

    fun buildTeam2(team:Team){
        myGame.value = myGame.value?.copyWith(team2 = team)
    }

    fun buildLevel(level: Level){
        myGame.value = myGame.value?.copyWith(level = level)
    }




}