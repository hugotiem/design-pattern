package fr.hugotiem.designpattern.model

enum class Level { ROOKIE, NORMAL, EXPERT }

class Game {
    var fulltime: Int? = null
    val quaterTime: Float? = null
    val team1: Team? = null
    val team2: Team? = null
    var level: Level = Level.ROOKIE

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

    companion object {
        fun fromJson(json: Map<String, *>): Game {

        }
    }
}