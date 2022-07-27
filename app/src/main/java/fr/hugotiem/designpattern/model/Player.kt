package fr.hugotiem.designpattern.model

import androidx.lifecycle.MutableLiveData


class Player(val name: String, val pts2: Int, val pts3: Int) {

    companion object {
        fun createPlayer(): Player {
            return Player("", 0, 0)
        }

        fun fromJson(json: Map<String, *>): Player {
            val name = json["name"] as String
            val pts2 = json["pts2"] as Int
            val pts3 = json["pts3"] as Int
            return Player(name, pts2, pts3)
        }
    }


}