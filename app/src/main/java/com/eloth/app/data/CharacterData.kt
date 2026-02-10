package com.eloth.app.data

data class Character(
    val age: String,
    val size: String,
    val weight: String,
    val eyes: String,
    val hair: String,
    val hairColor: String,
    val distinctiveSign: String,
    val region: String,
    val specificLocation: String,
    val family: String,
    val goodFortune: String,
    val badFortune: String
)

object CharacterTables {
    
    // Âge, Yeux, Signe (D12)
    val ageEyesSignTable = listOf(
        Triple("Inférieur à 20 ans", "Noirs", "Oreille coupée"),
        Triple("Inférieur à 20 ans", "Noirs", "Oreille coupée"),
        Triple("Entre 20 et 25 ans", "Marrons", "Odeur forte"),
        Triple("Entre 20 et 25 ans", "Marrons", "Odeur forte"),
        Triple("Entre 25 et 30 ans", "Olives", "Grain de beauté"),
        Triple("Entre 25 et 30 ans", "Olives", "Grain de beauté"),
        Triple("Entre 30 et 35 ans", "Verts", "Tâches de rousseur"),
        Triple("Entre 30 et 35 ans", "Verts", "Tâches de rousseur"),
        Triple("Entre 35 et 40 ans", "Bleus", "Cicatrice"),
        Triple("Entre 35 et 40 ans", "Bleus", "Cicatrice"),
        Triple("Supérieur à 40 ans", "Azurs", "Dent cassée"),
        Triple("Supérieur à 40 ans", "Azurs", "Dent cassée")
    )
    
    // Poids et Taille (D12)
    val weightSizeTable = listOf(
        Pair("Inférieur à 50 kg", "Inférieur à 1m50"),
        Pair("Inférieur à 50 kg", "Inférieur à 1m50"),
        Pair("Entre 50 et 60 kg", "Entre 1m50 et 1m60"),
        Pair("Entre 50 et 60 kg", "Entre 1m50 et 1m60"),
        Pair("Entre 60 et 70 kg", "Entre 1m60 et 1m70"),
        Pair("Entre 60 et 70 kg", "Entre 1m60 et 1m70"),
        Pair("Entre 70 et 80 kg", "Entre 1m70 et 1m80"),
        Pair("Entre 70 et 80 kg", "Entre 1m70 et 1m80"),
        Pair("Entre 80 et 90 kg", "Entre 1m80 et 1m90"),
        Pair("Entre 80 et 90 kg", "Entre 1m80 et 1m90"),
        Pair("Supérieur à 90 kg", "Supérieur à 1m90"),
        Pair("Supérieur à 90 kg", "Supérieur à 1m90")
    )
    
    // Coupes de cheveux (D24 - 2 types)
    val hairCutsType1 = listOf(
        "Crâne rasé", "Crâne rasé",
        "Court", "Court",
        "Coupe au bol", "Coupe au bol",
        "Mi-longs", "Mi-longs",
        "Queue de cheval", "Queue de cheval",
        "Longs et lâchés", "Longs et lâchés"
    )
    
    val hairCutsType2 = listOf(
        "Rasé sur les côtés", "Rasé sur les côtés",
        "Court avec frange", "Court avec frange",
        "Au carré", "Au carré",
        "Queue de cheval", "Queue de cheval",
        "Tressés", "Tressés",
        "Longs et lâchés", "Longs et lâchés"
    )
    
    // Couleur de cheveux (D12)
    val hairColorTable = listOf(
        "Noir", "Noir",
        "Brun", "Brun",
        "Châtain", "Châtain",
        "Roux", "Roux",
        "Blond", "Blond",
        "Blanc", "Blanc"
    )
    
    // Régions (D12)
    val regionTable = listOf(
        "Hautbade", "Hautbade",
        "Venetir", "Venetir",
        "Sybna", "Sybna",
        "Austral", "Austral",
        "Oxydia", "Oxydia",
        "Inconnue", "Inconnue"
    )
    
    // Famille par région (D12)
    val familyTable = mapOf(
        "Hautbade" to listOf(
            "Famille de commerçants", "Famille de commerçants",
            "Voyageurs pour représentations artistiques", "Voyageurs pour représentations artistiques",
            "Famille d'artisans", "Famille d'artisans",
            "Famille enlevée par la Confrérie", "Famille enlevée par la Confrérie"
        ),
        "Venetir" to listOf(
            "Famille de criminels", "Famille de criminels",
            "Opposants au pouvoir en place", "Opposants au pouvoir en place",
            "Recueilli(e) par un pêcheur", "Recueilli(e) par un pêcheur",
            "Tous les membres massacrés", "Tous les membres massacrés"
        ),
        "Sybna" to listOf(
            "Tous les membres sont en vie", "Tous les membres sont en vie",
            "Famille noble déchue", "Famille noble déchue",
            "Élevé(e) par des ermites", "Élevé(e) par des ermites",
            "Parents disparus en mer", "Parents disparus en mer"
        ),
        "Austral" to listOf(
            "Tribu nomade", "Tribu nomade",
            "Famille de guerriers", "Famille de guerriers",
            "Éleveurs de bétail", "Éleveurs de bétail",
            "Chasseurs de primes", "Chasseurs de primes"
        ),
        "Oxydia" to listOf(
            "Famille de savants", "Famille de savants",
            "Alchimistes renommés", "Alchimistes renommés",
            "Marchands d'artefacts", "Marchands d'artefacts",
            "Exilés politiques", "Exilés politiques"
        ),
        "Inconnue" to listOf(
            "Origine mystérieuse", "Origine mystérieuse",
            "Amnésie totale", "Amnésie totale",
            "Trouvé(e) abandonné(e)", "Trouvé(e) abandonné(e)",
            "Élevé(e) par des créatures", "Élevé(e) par des créatures"
        )
    )
    
    // Lieux spécifiques par région (D12)
    val locationTable = mapOf(
        "Hautbade" to listOf(
            "Cité marchande de Goldport", "Cité marchande de Goldport",
            "Village côtier de Brisemort", "Village côtier de Brisemort",
            "Forteresse de Hautroc", "Forteresse de Hautroc",
            "Monastère des Cent Flammes", "Monastère des Cent Flammes"
        ),
        "Venetir" to listOf(
            "Port de Sangrenoir", "Port de Sangrenoir",
            "Îles flottantes", "Îles flottantes",
            "Marais de Vespucci", "Marais de Vespucci",
            "Catacombes de l'Ancien Roi", "Catacombes de l'Ancien Roi"
        ),
        "Sybna" to listOf(
            "Forêt éternelle", "Forêt éternelle",
            "Montagnes de Cristal", "Montagnes de Cristal",
            "Temple d'Argent", "Temple d'Argent",
            "Vallée des Brumes", "Vallée des Brumes"
        ),
        "Austral" to listOf(
            "Désert de Cendres", "Désert de Cendres",
            "Oasis de Mirath", "Oasis de Mirath",
            "Ruines du Premier Empire", "Ruines du Premier Empire",
            "Canyon des Vents Hurlants", "Canyon des Vents Hurlants"
        ),
        "Oxydia" to listOf(
            "Académie des Sciences", "Académie des Sciences",
            "Tour de l'Alchimiste Fou", "Tour de l'Alchimiste Fou",
            "Bibliothèque Interdite", "Bibliothèque Interdite",
            "Laboratoire souterrain", "Laboratoire souterrain"
        ),
        "Inconnue" to listOf(
            "Entre les dimensions", "Entre les dimensions",
            "Plan astral", "Plan astral",
            "Poche dimensionnelle", "Poche dimensionnelle",
            "Lieu hors du temps", "Lieu hors du temps"
        )
    )
    
    // Bonne Fortune (D10)
    val goodFortuneTable = listOf(
        "Héritage inattendu",
        "Don naturel pour la magie",
        "Ami influent dans la capitale",
        "Objet magique ancestral",
        "Immunité à une maladie courante",
        "Chance exceptionnelle au jeu",
        "Animal compagnon loyal",
        "Renommée dans votre domaine",
        "Protection divine mineure",
        "Découverte d'un trésor caché"
    )
    
    // Mauvaise Fortune (D10)
    val badFortuneTable = listOf(
        "Traqué par une organisation secrète",
        "Maladie chronique",
        "Dette importante envers un puissant",
        "Malédiction familiale",
        "Recherché pour un crime non commis",
        "Ennemi juré influent",
        "Perte d'un sens (partielle)",
        "Addiction à une substance rare",
        "Vision prophétique terrifiante",
        "Marqué par une entité maléfique"
    )
}
