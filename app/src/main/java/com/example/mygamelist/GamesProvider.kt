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
                listOf("Adventure","RPG","Action"),
                "A",
                ""
            ),
            Videojuego(
                "The Legend of Zelda: Breath of the Wild",
                "Link is awakened in a room by a voice calling him and learns that he has been asleep for 100 years after failing to stop a monster called Calamity Ganon. Although the monster is being held in Hyrule Castle by Princess Zelda, Calamity Ganon's power continues to grow and if not stopped he will eventually break free with enough power to destroy the entire world. Link embarks on his quest to defeat Calamity Ganon and save Hyrule and Zelda.",
                "https://images.igdb.com/igdb/image/upload/t_cover_big/co3p2d.webp",
                "March 3, 2017",
                listOf("Nintendo Switch", "Wii U"),
                listOf("Adventure", "Puzzle","Open World"),
                "A",
                ""

            ),
            Videojuego(
                "God of War(2018)",
                "Many years have passed since Kratos, Spartan warrior and former Greek God of War, took his vengeance against the Greek Gods, and he now lives with his young son Atreus in ancient Norway in the realm of Midgard. The game begins after the death of the Jötunn warrior Faye, Kratos' second wife and Atreus' mother, whose last request was for her ashes to be spread at the highest speak of the nine realms. Kratos and Atreus prepare a funeral pyre for her, mourn her death and soon go on a hunt as per Kratos' desire. However much to Kratos' disappointment, Atreus proves his incompetence and lack of focus, making Kratos reconsider taking Atreus in his journey. Kratos is soon attacked by a mysterious stranger with godlike powers, and who cannot feel anything physically. After seemingly killing him, Kratos reluctantly takes Atreus with him and begins their journey.",
                "https://images.igdb.com/igdb/image/upload/t_cover_big/co1tmu.webp",
                "April 20, 2018",
                listOf("Playstation", "PC"),
                listOf("Adventure", "Action", "RPG"),
                "A",
                ""

            ),
            Videojuego(
                "Red Dead Redemption 2",
                "America, 1899. The end of the wild west era has begun as lawmen hunt down the last remaining outlaw gangs. Those who will not surrender or succumb are killed." +
                        "\n" +
                        "After a robbery goes badly wrong in the western town of Blackwater, Arthur Morgan and the Van der Linde gang are forced to flee. With federal agents and the best bounty hunters in the nation massing on their heels, the gang must rob, steal and fight their way across the rugged heartland of America in order to survive. As deepening internal divisions threaten to tear the gang apart, Arthur must make a choice between his own ideals and loyalty to the gang who raised him.",
                "https://images.igdb.com/igdb/image/upload/t_cover_big/co1q1f.webp",
                "October 26, 2018",
                listOf("PC", "Xbox", "Playstation"),
                listOf("Adventure", "Action","Open World"),
                "A",
                ""

            ),
            Videojuego(
                "Cyberpunk 2077",
                "In 2077, following an economic collapse sometime during the early 21st century, the United States is forced to rely on large corporations to survive. These corporations deal in a wide range of areas, such as weapons, robotics, cybernetics, pharmaceuticals, communications and biotechnology, and many of these companies operate above the law. The world in between is where decadence, sex and pop culture mix with violent crime, extreme poverty and the unattainable promise of the American Dream. You play as V, a mercenary outlaw deeply embedded in the crime-ridden city of Night City, going after a one-of-a-kind implant that is the key to immortality.",
                "https://images.igdb.com/igdb/image/upload/t_cover_big/co7497.webp",
                "December 10, 2020",
                listOf("PC", "Xbox", "Playstation"),
                listOf("Adventure", "RPG", "Action"),
                "A",
                ""

            ),
            Videojuego(
                "Hollow Knight",
                "A 2D metroidvania with an emphasis on close combat and exploration in which the player enters the once-prosperous now-bleak insect kingdom of Hallownest, travels through its various districts, meets friendly inhabitants, fights hostile ones and uncovers the kingdom's history while improving their combat abilities and movement arsenal by fighting bosses and accessing out-of-the-way areas.",
                "https://images.igdb.com/igdb/image/upload/t_cover_big/co1rgi.webp",
                "February 24, 2017",
                listOf("PC", "Xbox", "Playstation","Nintendo Switch"),
                listOf("Adventure", "Indie", "Platform"),
                "A",
                ""

            ),
            Videojuego(
                "Wuthering Waves",
                "Welcome to the new world, Rover.\n" +
                        "This is an age of struggle. Since the Calament a hundred years ago, beings hitherto unknown have taken root in our world, sowing discord and destruction. Civilization as we know it once teetered on the brink of collapse.\n" +
                        "This is an age of hope. Survivors have buried the hatchet with their kin and enemies, also started to rebuild from the ruins. They find hope in the glories of the bygone days. They erect cities and factories. They sing the praises of restoration.\n" +
                        "As for you, Rover from the beyond. Whatever might have led to your awakening, we welcome you to these troubled lands. Your journey here will cross with many others'--and will be marked by mysteries and battles.\n" +
                        "You shall go down as a legend, one that will bring rejuvenation to mankind.",
                "https://images.igdb.com/igdb/image/upload/t_cover_big/co896o.webp",
                "May 21, 2024",
                listOf("PC", "Android", "Playstation","iOS"),
                listOf("Adventure", "RPG", "Action","Fantasy"),
                "B",
                "https://cdn1.epicgames.com/spt-assets/c1586295960b46f88bbfeec32c199e0e/wuthering-waves-uj7dz.jpg?h=270&quality=medium&resize=1&w=480"

            ),
            Videojuego(
                "Duck Detective:The Secret Salami",
                "Solving crime is no walk in the pond. You are a down-on-his-luck detective who also happens to be a duck. Use your powers of de-duck-tion to inspect evidence, fill in the blanks, and bust the case wide open, in a narrative mystery adventure where nothing is quite as it seems.",
                "https://images.igdb.com/igdb/image/upload/t_cover_big/co7gxl.webp",
                "May 22, 2024",
                listOf("PC", "Nintendo Switch"),
                listOf("Adventure", "Puzzle", "Thriller","Mystery"),
                "B",
                "https://assets.nintendo.com/image/upload/ar_16:9,c_lpad,w_1240/b_white/f_auto/q_auto/ncom/software/switch/70010000078227/0686f86757a7ce5ff9bb9eedf40c27389a590bb8426a10aa27c80dbdb90c48ce"

            ),
            Videojuego(
                "Hades II",
                "As the immortal Princess of the Underworld, you'll explore a bigger, deeper mythic world, vanquishing the forces of the Titan of Time with the full might of Olympus behind you, in a sweeping story that continually unfolds through your every setback and accomplishment. New locations, challenges, upgrade systems, and surprises await as you delve into the ever-shifting Underworld again and again.",
                "https://images.igdb.com/igdb/image/upload/t_cover_big/co888c.webp",
                "May 5, 2024",
                listOf("PC"),
                listOf("Adventure", "Roguelite", "Indie","RPG"),
                "B",
                "https://cdn1.epicgames.com/spt-assets/ea0a24395cd641d7bbde3e5d78ad462c/hades-ii-14pcw.png?h=270&quality=medium&resize=1&w=480"

            ),
            Videojuego(
                "Paper Mario: The Thousand-Year Door",
                "A remake of the second game in the Paper Mario series, originally released for the Nintendo GameCube.\n" +
                        "\n" +
                        "Turn the page and join Mario and friends in an RPG adventure to discover the legendary treasure behind the ancient Thousand-Year Door. Will Mario complete his papery quest, or will he crumple under the pressure?",
                "https://images.igdb.com/igdb/image/upload/t_cover_big/co83vd.webp",
                "May 25, 2024",
                listOf("Nintendo Switch"),
                listOf("Action", "Fantasy", "RPG"),
                "B",
                "https://assets.nintendo.com/image/upload/f_auto/q_auto/dpr_1.5/ncom/software/switch/70010000072957/fdd5d8ca46d7ea4e45397ae560e807742de2d7d744570297ddbabf69d6d23f33"

            ),
            Videojuego(
                "XDefiant",
                "Ubisoft's worlds collide in a free-to-play, first-person arena shooter where you compete to be the best in fast-paced online matches!\n" +
                        "\n" +
                        "Join an always-evolving experience with regular updates bringing new playable factions and a growing collection of maps, weapons, and game modes. With cross-play, you will be able to join your friends across available platforms.",
                "https://images.igdb.com/igdb/image/upload/t_cover_big/co6dta.webp",
                "May 20, 2024",
                listOf("Nintendo Switch"),
                listOf("Action", "Multiplayer", "Shooter","First Person"),
                "B",
                "https://cdn.oneesports.gg/cdn-data/2023/06/xdefiant_ubisoft.jpg"

            ),
            Videojuego(
                "Senua's Saga: Hellblade II",
                "The sequel to the award winning Hellblade: Senua’s Sacrifice, Senua returns in a brutal journey of survival through the myth and torment of Viking Iceland. Intent on saving those who have fallen victim to the horrors of tyranny, Senua faces a battle of overcoming the darkness within and without",
                "https://images.igdb.com/igdb/image/upload/t_cover_big/co81i4.webp",
                "May 20, 2024",
                listOf("Xbox","Pc"),
                listOf("Action", "Fantasy", "Shooter","Horror"),
                "B",
                "https://www.mundodeportivo.com/alfabeta/hero/2024/01/captura.1705609624.5228.jpg?width=768&aspect_ratio=16:9&format=nowebp"

            ),
            Videojuego(
                "Black Myth: Wukong",
                "Black Myth: Wukong is an action RPG rooted in Chinese mythology. The story is based on Journey to the West, one of the Four Great Classical Novels of Chinese literature. You shall set out as the Destined One to venture into the challenges and marvels ahead, to uncover the obscured truth beneath the veil of a glorious legend from the past.",
                "https://images.igdb.com/igdb/image/upload/t_cover_big/co7pnk.webp",
                "August 19, 2024",
                listOf("PC","Playstation","Xbox"),
                listOf("Adventure", "RPG", "Action","Fantasy"),
                "C",
                ""

            ),
            Videojuego(
                "Star Wars Outlaws",
                "Experience the first-ever open world Star Wars game, set between the events of The Empire Strikes Back and Return of the Jedi. Explore distinct planets across the galaxy, both iconic and new. Risk it all as Kay Vess, an emerging scoundrel seeking freedom and the means to start a new life, along with her companion Nix. Fight, steal, and outwit your way through the galaxy’s crime syndicates as you join the galaxy’s most wanted.",
                "https://images.igdb.com/igdb/image/upload/t_cover_big/co77oz.webp",
                "August 29, 2024",
                listOf("PC","Playstation","Xbox"),
                listOf("Adventure", "Sciene Fiction", "Action","Star Wars"),
                "C",
                ""

            ),
            Videojuego(
                "Assassin's Creed Shadows",
                "Experience an epic historical action-adventure story set in feudal Japan! Become a lethal shinobi Assassin and a powerful legendary samurai as you explore a beautiful open world in a time of chaos. Switch seamlessly between two unlikely allies as you discover their common destiny. Master complementary playstyles, create your shinobi league, customize your hideout, and usher in a new era for Japan.",
                "https://images.igdb.com/igdb/image/upload/t_cover_big/co87cu.webp",
                "November 14, 2024",
                listOf("PC","Playstation","Xbox"),
                listOf("Adventure", "RPG", "Action","Historical"),
                "C",
                ""

            ),
            Videojuego(
                "World of Goo 2",
                "Use living liquid creatures to build bridges, grow towers, terraform terrain, and fuel flying machines. The world is beautiful, dangerous, and evolving.",
                "https://images.igdb.com/igdb/image/upload/t_cover_big/co7h9z.webp",
                "August 1, 2024",
                listOf("PC","Nintendo Switch"),
                listOf("Indie", "Puzzle", "Simulator","Strategy"),
                "C",
                ""

            )

        )
    }
}