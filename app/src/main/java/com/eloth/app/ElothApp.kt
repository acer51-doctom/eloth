package com.eloth.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.eloth.app.navigation.Screen
import com.eloth.app.ui.screens.*

@Composable
fun ElothApp() {
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(
                onNavigateToBoot = {
                    navController.navigate(Screen.Boot.route) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                }
            )
        }
        
        composable(Screen.Boot.route) {
            BootScreen(
                onNavigateToMenu = {
                    navController.navigate(Screen.Menu.route) {
                        popUpTo(Screen.Boot.route) { inclusive = true }
                    }
                },
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        
        composable(Screen.Menu.route) {
            MenuScreen(
                onNavigateToMoloch = {
                    navController.navigate(Screen.MolochStaff.route)
                },
                onNavigateToCharacter = {
                    navController.navigate(Screen.CharacterGenerator.route)
                },
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        
        composable(Screen.MolochStaff.route) {
            MolochStaffScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        
        composable(Screen.CharacterGenerator.route) {
            CharacterGeneratorScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
