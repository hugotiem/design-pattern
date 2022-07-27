package fr.hugotiem.designpattern.model

import android.util.Log

enum class Level { ROOKIE, NORMAL, EXPERT, NONE }

class Game(val team1: Team?, val team2: Team?, var level: Level?, val winner: Team?, ) {
    var fulltime: Int? = null
    val quaterTime: Float? = null


    fun copyWith(
        team1: Team? = this.team1, team2: Team? = this.team2, level: Level? = this.level, winner: Team? = this.winner,
    ): Game {
        return Game(team1, team2, level, winner)
    }

    companion object {
        fun initGame(): Game {
            return Game(null, null, null,null)
        }

        private fun getLevelEnum(level: String): Level {
            return when(level) {
                "ROOKIE" -> Level.ROOKIE
                "NORMAL" -> Level.NORMAL
                "EXPERT" -> Level.EXPERT
                else -> Level.NONE
            }
        }

        fun fromJson(json: Map<String, *>): Game {
            Log.d("Game:fromjson", "team1.name")
            val team1 = Team.fromJson(json["team1"] as Map<String, *>)
            Log.d("Game:fromjson", team1.name)
            val team2 = Team.fromJson(json["team2"] as Map<String, *>)
            val level = getLevelEnum(json["level"] as String)
            return Game(team1, team2, level, team1)
        }
    }
}