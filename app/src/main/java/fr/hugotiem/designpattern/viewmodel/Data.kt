package fr.hugotiem.designpattern.viewmodel

val teams = listOf<Map<String, *>>(
    mapOf(
        "name" to "first team",
        "players" to listOf<Map<String, *>>(
            mapOf(
                "name" to "first player",
                "pts2" to 68,
                "pts3" to 52
            ),
            mapOf(
                "name" to "second player",
                "pts2" to 50,
                "pts3" to 68
            ),
            mapOf(
                "name" to "third player",
                "pts2" to 68,
                "pts3" to 52
            ),
            mapOf(
                "name" to "4ème player",
                "pts2" to 68,
                "pts3" to 45
            ),
            mapOf(
                "name" to "5ème player",
                "pts2" to 68,
                "pts3" to 52
            ),
        ) as List
    ),
    mapOf(
        "name" to "second team",
        "players" to listOf<Map<String, *>>(
            mapOf(
                "name" to "first player",
                "pts2" to 76,
                "pts3" to 48
            ),
            mapOf(
                "name" to "second player",
                "pts2" to 80,
                "pts3" to 68
            ),
            mapOf(
                "name" to "third player",
                "pts2" to 89,
                "pts3" to 60
            ),
            mapOf(
                "name" to "4ème player",
                "pts2" to 68,
                "pts3" to 68
            ),
            mapOf(
                "name" to "5ème player",
                "pts2" to 76,
                "pts3" to 30
            ),
        )
    )

)

val games = listOf<Map<String, *>>(
    mapOf(
        "level" to "ROOKIE",
        "fulltime" to 20,
        "team1" to teams[0],
        "team2" to teams[1]
    )
)