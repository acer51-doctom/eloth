# ELOTH - Application Android

Application Android native en Kotlin pour le jeu de rôle ELOTH, avec générateur de personnages et Bâton de Moloch.

## 🎮 Fonctionnalités

- **Écran d'introduction animé** : Animation du titre avec champ d'étoiles
- **Bâton de Moloch** : Lance un D100 avec animation progressive et affichage de l'effet
- **Générateur de personnage** : Création automatique de personnages avec caractéristiques, région, famille, fortunes
- **Design rétro-gaming** : Esthétique NES avec couleurs ELOTH (rouge #C82400 et jaune #FCFF00)
- **Navigation fluide** : Navigation entre les écrans avec bouton retour

## 📱 Technologies utilisées

- **Kotlin** : Langage de programmation principal
- **Jetpack Compose** : UI moderne et déclarative
- **Material3** : Composants Material Design 3
- **Navigation Compose** : Navigation entre écrans
- **Coroutines** : Gestion des animations asynchrones
- **MVVM Architecture** : Architecture moderne Android

## 🚀 Installation

### Prérequis

- Android Studio Hedgehog (2023.1.1) ou plus récent
- JDK 8 ou supérieur
- SDK Android API 26 (Android 8.0 Oreo) minimum
- SDK Android API 34 (Android 14) recommandé

### Étapes d'installation

1. **Cloner ou télécharger le projet**
   ```bash
   # Si vous utilisez git
   git clone <url-du-projet>
   cd ElothApp
   ```

2. **Ouvrir dans Android Studio**
   - Lancez Android Studio
   - File → Open
   - Sélectionnez le dossier `ElothApp`
   - Attendez que Gradle se synchronise

3. **Synchroniser Gradle**
   - Android Studio devrait automatiquement synchroniser le projet
   - Si non : File → Sync Project with Gradle Files

4. **Construire le projet**
   - Build → Make Project
   - Ou utilisez le raccourci : Ctrl+F9 (Windows/Linux) / Cmd+F9 (Mac)

5. **Lancer l'application**
   - Connectez un appareil Android ou lancez un émulateur
   - Run → Run 'app'
   - Ou cliquez sur le bouton ▶️ Play dans la barre d'outils

## 📁 Structure du projet

```
ElothApp/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/eloth/app/
│   │       │   ├── data/              # Modèles de données
│   │       │   │   ├── CharacterData.kt
│   │       │   │   └── MolochEffects.kt
│   │       │   ├── navigation/        # Navigation
│   │       │   │   └── Screen.kt
│   │       │   ├── ui/
│   │       │   │   ├── screens/       # Écrans de l'app
│   │       │   │   │   ├── BootScreen.kt
│   │       │   │   │   ├── CharacterGeneratorScreen.kt
│   │       │   │   │   ├── Components.kt
│   │       │   │   │   ├── MenuScreen.kt
│   │       │   │   │   ├── MolochStaffScreen.kt
│   │       │   │   │   ├── SplashScreen.kt
│   │       │   │   │   └── Starfield.kt
│   │       │   │   └── theme/         # Thème et couleurs
│   │       │   │       ├── Color.kt
│   │       │   │       ├── Theme.kt
│   │       │   │       └── Type.kt
│   │       │   ├── ElothApp.kt        # Navigation principale
│   │       │   └── MainActivity.kt    # Point d'entrée
│   │       ├── res/
│   │       │   └── values/
│   │       │       ├── strings.xml
│   │       │       └── themes.xml
│   │       └── AndroidManifest.xml
│   └── build.gradle.kts
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
└── README.md
```

## 🎨 Personnalisation

### Couleurs ELOTH

Les couleurs sont définies dans `ui/theme/Color.kt` :

```kotlin
val ElothRed = Color(0xFFC82400)       // Rouge principal
val ElothRedDark = Color(0xFF9E1C00)   // Rouge foncé (ombres)
val ElothYellow = Color(0xFFFCFF00)    // Jaune ELOTH
```

### Ajouter la police Press Start 2P

Pour une expérience plus fidèle au design original :

1. Téléchargez la police Press Start 2P : https://fonts.google.com/specimen/Press+Start+2P
2. Créez le dossier : `app/src/main/res/font/`
3. Ajoutez le fichier `press_start_2p.ttf`
4. Décommentez la ligne dans `ui/theme/Type.kt` :
   ```kotlin
   val PressStart2P = FontFamily(Font(R.font.press_start_2p))
   ```

## 🐛 Dépannage

### Erreur de synchronisation Gradle

- Vérifiez votre connexion Internet
- File → Invalidate Caches / Restart
- Supprimez les dossiers `.gradle` et `.idea`, puis rouvrez le projet

### L'application ne se lance pas

- Vérifiez que l'API minimale de votre émulateur/appareil est 24+
- Clean Project : Build → Clean Project
- Rebuild : Build → Rebuild Project

### Erreurs de compilation Kotlin

- Vérifiez que vous utilisez Kotlin 1.9.20 ou compatible
- Tools → Kotlin → Configure Kotlin Plugin Updates

## 📝 Changelog

### Version 1.0.0 (Initiale)

- ✅ Écran de démarrage avec bouton "DÉMARRER"
- ✅ Animation du titre ELOTH avec descente progressive
- ✅ Menu de sélection (Bâton de Moloch / Créer personnage)
- ✅ Bâton de Moloch avec animation de D100
- ✅ Générateur de personnage complet
- ✅ Navigation avec bouton retour
- ✅ Champ d'étoiles animé en arrière-plan

## 🎯 Améliorations futures possibles

- [ ] Son et effets sonores (lancement.mp3, fx_transition.mp3)
- [ ] Sauvegarde des personnages générés
- [ ] Partage de personnages
- [ ] Historique des lancers du Bâton de Moloch
- [ ] Mode sombre/clair
- [ ] Traductions multilingues
- [ ] Animations supplémentaires

## 📱 Compatibilité

- **Minimum** : Android 8.0 Oreo (API 26)
- **Cible** : Android 14 (API 34)
- **Testé sur** : Pixel, Samsung Galaxy, OnePlus
- **Couverture** : ~95% des appareils Android actifs

## 📄 Licence

Ce projet est un portage Android du jeu web ELOTH original.

## 👨‍💻 Développement

Développé avec ❤️ en Kotlin et Jetpack Compose.

Pour toute question ou suggestion, n'hésitez pas à ouvrir une issue !
