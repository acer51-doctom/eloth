package com.eloth.app.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Boot : Screen("boot")
    object Menu : Screen("menu")
    object MolochStaff : Screen("moloch_staff")
    object CharacterGenerator : Screen("character_generator")
}
