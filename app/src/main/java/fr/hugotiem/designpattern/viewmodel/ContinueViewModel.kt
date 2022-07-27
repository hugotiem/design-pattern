package fr.hugotiem.designpattern.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.hugotiem.designpattern.model.Game

class ContinueViewModel: ViewModel() {
    val gameListLiveData = MutableLiveData<List<Game>>()

    var gameList: List<Game>?
        get() = gameListLiveData.value
        set(value) = gameListLiveData.postValue(value)

    fun fetchGames() {
        var game = Game.fromJson(games[0])
        gameListLiveData.postValue(listOf(game, game, game, game, game))
    }

}