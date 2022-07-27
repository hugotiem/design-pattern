package fr.hugotiem.designpattern.model

class Team(val name: String, val players: List<Player>) {

    companion object {
        fun fromJson(json: Map<String, *>): Team {
            val name = json["name"] as String
            val playersJson = json["players"] as List<Map<String, *>>
            val players = playersJson.map { e -> Player.fromJson(e) } as List<Player>
            return Team(name, players)
        }
    }
}