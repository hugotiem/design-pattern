package fr.hugotiem.designpattern.model

import androidx.lifecycle.MutableLiveData


class Player(val name: String, val pts2: Int, val pts3: Int) {

    companion object {
        fun createPlayer(): Player {
            return Player("", 0, 0)
        }
    }


}