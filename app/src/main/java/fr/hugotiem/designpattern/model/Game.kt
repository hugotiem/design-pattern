package fr.hugotiem.designpattern.model

enum class Level { ROOKIE, NORMAL, EXPERT, NONE }

class Game(val team1: Team, val team2: Team, var level: Level, val winner: Team, ) {
    var fulltime: Int? = null
    val quaterTime: Float? = null

    fun buildTeam(team: Team?) {
        // TODO
    }

    fun buildTeam1() {
        buildTeam(team1)
    }

    fun buildTeam2() {
        buildTeam(team2)
    }

    fun buildLevel(level: String) {
        when(level) {
            "débutant" -> this.level = Level.ROOKIE
            "normal" -> this.level = Level.NORMAL
            "Difficile" -> this.level = Level.EXPERT
            else -> print("no level found")
        }
    }

    fun buildTime(time: Int) {
        this.fulltime = time

    }

    fun copyWith(
        team1: Team = this.team1, team2: Team = this.team2, level: Level = this.level, winner: Team = this.winner,
    ): Game {
        return Game(team1, team2, level, winner)
    }

    companion object {

        private fun getLevelEnum(level: String): Level {
            return when(level) {
                "ROOKIE" -> Level.ROOKIE
                "NORMAL" -> Level.NORMAL
                "EXPERT" -> Level.EXPERT
                else -> Level.NONE
            }
        }

        fun fromJson(json: Map<String, *>): Game {
            val team1 = Team.fromJson(json["team1"] as Map<String, *>)
            val team2 = Team.fromJson(json["team2"] as Map<String, *>)
            val level = getLevelEnum(json["level"] as String)
            return Game(team1, team2, level, team1)
        }
    }
}