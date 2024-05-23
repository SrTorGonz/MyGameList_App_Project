package com.example.mygamelist

class GamesProvider {
    companion object{
        val GameList= listOf<Videojuego>(
            Videojuego(
                "Elden Ring",
                "Elden Ring takes place in the Lands Between, a fictional realm over which several demigods rule. It was previously ruled over by the immortal Queen Marika, who acted as keeper of the Elden Ring, a powerful force that manifested itself as the physical concept of order. When Marika shattered the Elden Ring and disappeared, her demigod children began fighting over pieces of the Ring in an event called The Shattering. Each demigod has a shard of the Ring called a Great Rune, which corrupts them with power. In the game, the player character is a Tarnished, one of a group of exiles from the Lands Between who are summoned back after the Shattering. The player must traverse the realm to repair the Elden Ring and become the Elden Lord.",
                "https://images.igdb.com/igdb/image/upload/t_cover_big/co4jni.webp",
                "February 25, 2022",
                listOf("PC","Xbox","Playstation"),
                listOf("Adventure","RPG","Action")
            ),
            Videojuego(
                "The Legend of Zelda: Breath of the Wild",
                "Link is awakened in a room by a voice calling him and learns that he has been asleep for 100 years after failing to stop a monster called Calamity Ganon. Although the monster is being held in Hyrule Castle by Princess Zelda, Calamity Ganon's power continues to grow and if not stopped he will eventually break free with enough power to destroy the entire world. Link embarks on his quest to defeat Calamity Ganon and save Hyrule and Zelda.",
                "https://images.igdb.com/igdb/image/upload/t_cover_big/co3p2d.webp",
                "March 3, 2017",
                listOf("Nintendo Switch", "Wii U"),
                listOf("Adventure", "Puzzle","Open World")
            ),
            Videojuego(
                "God of War(2018)",
                "Many years have passed since Kratos, Spartan warrior and former Greek God of War, took his vengeance against the Greek Gods, and he now lives with his young son Atreus in ancient Norway in the realm of Midgard. The game begins after the death of the Jötunn warrior Faye, Kratos' second wife and Atreus' mother, whose last request was for her ashes to be spread at the highest speak of the nine realms. Kratos and Atreus prepare a funeral pyre for her, mourn her death and soon go on a hunt as per Kratos' desire. However much to Kratos' disappointment, Atreus proves his incompetence and lack of focus, making Kratos reconsider taking Atreus in his journey. Kratos is soon attacked by a mysterious stranger with godlike powers, and who cannot feel anything physically. After seemingly killing him, Kratos reluctantly takes Atreus with him and begins their journey.",
                "https://images.igdb.com/igdb/image/upload/t_cover_big/co1tmu.webp",
                "April 20, 2018",
                listOf("Playstation", "PC"),
                listOf("Adventure", "Action", "RPG")
            ),
            Videojuego(
                "Red Dead Redemption 2",
                "America, 1899. The end of the wild west era has begun as lawmen hunt down the last remaining outlaw gangs. Those who will not surrender or succumb are killed." +
                        "\n" +
                        "After a robbery goes badly wrong in the western town of Blackwater, Arthur Morgan and the Van der Linde gang are forced to flee. With federal agents and the best bounty hunters in the nation massing on their heels, the gang must rob, steal and fight their way across the rugged heartland of America in order to survive. As deepening internal divisions threaten to tear the gang apart, Arthur must make a choice between his own ideals and loyalty to the gang who raised him.",
                "https://images.igdb.com/igdb/image/upload/t_cover_big/co1q1f.webp",
                "October 26, 2018",
                listOf("PC", "Xbox", "Playstation"),
                listOf("Adventure", "Action","Open World")
            ),
            Videojuego(
                "Cyberpunk 2077",
                "In 2077, following an economic collapse sometime during the early 21st century, the United States is forced to rely on large corporations to survive. These corporations deal in a wide range of areas, such as weapons, robotics, cybernetics, pharmaceuticals, communications and biotechnology, and many of these companies operate above the law. The world in between is where decadence, sex and pop culture mix with violent crime, extreme poverty and the unattainable promise of the American Dream. You play as V, a mercenary outlaw deeply embedded in the crime-ridden city of Night City, going after a one-of-a-kind implant that is the key to immortality.",
                "https://images.igdb.com/igdb/image/upload/t_cover_big/co7497.webp",
                "December 10, 2020",
                listOf("PC", "Xbox", "Playstation"),
                listOf("Adventure", "RPG", "Action")
            )
        )
    }
}