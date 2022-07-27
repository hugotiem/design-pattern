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
                "pts2" to 86,
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
                "pts3" to 52
            ),
            mapOf(
                "name" to "5ème player",
                "pts2" to 68,
                "pts3" to 52
            ),
        ) as List
    )
)

val games = listOf<Map<String, *>>(
    mapOf(
        "level" to "ROOKIE",
        "fulltime" to 20
        "team" to teams[0],
    )
)