# Instructions supplémentaires pour ELOTH Android

## 🎵 Ajout des sons (optionnel)

Si tu veux ajouter les sons d'origine :

1. Crée le dossier `app/src/main/res/raw/`
2. Ajoute tes fichiers audio :
   - `lancement.mp3` : Son de démarrage
   - `fx_transition.mp3` : Son de transition

3. Modifie `BootScreen.kt` pour jouer les sons :
   ```kotlin
   import android.media.MediaPlayer
   import androidx.compose.ui.platform.LocalContext
   
   val context = LocalContext.current
   val bootSound = remember { MediaPlayer.create(context, R.raw.lancement) }
   val transitionFx = remember { MediaPlayer.create(context, R.raw.fx_transition) }
   
   // Jouer le son
   LaunchedEffect(Unit) {
       bootSound.start()
   }
   ```

## 🖼️ Icône de l'application

Pour personnaliser l'icône :

1. Crée une icône ELOTH (rouge et jaune) avec :
   - Image Asset Studio dans Android Studio
   - Ou un outil externe comme https://romannurik.github.io/AndroidAssetStudio/

2. Dans Android Studio :
   - Clic droit sur `res/` → New → Image Asset
   - Configure ton icône
   - Les fichiers seront générés automatiquement dans `mipmap-*/`

## 🔤 Police Press Start 2P

Pour ajouter la police rétro :

1. Télécharge : https://fonts.google.com/specimen/Press+Start+2P
2. Crée : `app/src/main/res/font/press_start_2p.ttf`
3. Dans `Type.kt`, remplace :
   ```kotlin
   val PressStart2P = FontFamily(Font(R.font.press_start_2p))
   
   // Puis ajoute fontFamily = PressStart2P aux TextStyle
   ```

## 🚀 Générer l'APK

Pour créer un APK installable :

1. **Debug APK** (pour tests) :
   ```bash
   ./gradlew assembleDebug
   # APK dans : app/build/outputs/apk/debug/app-debug.apk
   ```

2. **Release APK** (pour distribution) :
   ```bash
   ./gradlew assembleRelease
   # Puis signer l'APK avec ton keystore
   ```

3. **Via Android Studio** :
   - Build → Build Bundle(s) / APK(s) → Build APK(s)
   - L'APK sera dans `app/build/outputs/apk/`

## 📦 Optimisations possibles

### Performance

- Réduire le nombre d'étoiles sur les appareils bas de gamme
- Utiliser `remember` pour éviter les recompositions
- LazyColumn pour les longues listes (si ajoutées)

### Stockage

Pour sauvegarder les personnages :

```kotlin
// Dans CharacterGeneratorScreen.kt
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.google.gson.Gson

// Sauvegarder
val gson = Gson()
val json = gson.toJson(character)
dataStore.edit { preferences ->
    preferences[stringPreferencesKey("saved_character")] = json
}

// Charger
val savedJson = dataStore.data.map { preferences ->
    preferences[stringPreferencesKey("saved_character")]
}
```

## 🧪 Tests

Pour tester l'application :

1. **Émulateur Android** :
   - AVD Manager → Create Virtual Device
   - Choisis Pixel 6 ou similaire
   - API 34 (Android 14)

2. **Appareil physique** :
   - Active le mode développeur
   - Active le débogage USB
   - Connecte via USB

## 🎨 Customisation avancée

### Modifier les animations

Dans `MolochStaffScreen.kt`, change :
```kotlin
val totalDuration = 4500L // Durée totale en ms
val totalSteps = 20 // Nombre d'étapes
```

### Ajouter de nouveaux effets

Dans `MolochEffects.kt`, ajoute :
```kotlin
101 to "Ton nouvel effet magique"
```

### Personnaliser les couleurs

Dans `Color.kt` :
```kotlin
val CustomColor = Color(0xFFHEXCODE)
```

## 🔧 Résolution de problèmes courants

### Gradle sync failed
```bash
# Terminal dans le projet
./gradlew clean
./gradlew build --refresh-dependencies
```

### Compose version mismatch
- Vérifie que toutes les dépendances Compose utilisent la même version
- Dans `build.gradle.kts`, utilise un BOM (Bill of Materials)

### OutOfMemoryError
Dans `gradle.properties`, augmente :
```properties
org.gradle.jvmargs=-Xmx4096m -Dfile.encoding=UTF-8
```

## 📱 Compatibilité

- **Minimum** : Android 8.0 Oreo (API 26)
- **Cible** : Android 14 (API 34)
- **Testé sur** : Pixel, Samsung Galaxy, OnePlus

## 🌍 Internationalisation (i18n)

Pour ajouter d'autres langues :

1. Crée `res/values-fr/strings.xml` (français)
2. Crée `res/values-en/strings.xml` (anglais)
3. Ajoute les traductions

## 📊 Métriques

Taille approximative de l'APK :
- Debug : ~5-7 MB
- Release (minified) : ~3-4 MB

## 🎓 Ressources utiles

- [Jetpack Compose Docs](https://developer.android.com/jetpack/compose)
- [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)
- [Material Design 3](https://m3.material.io/)
- [Android Developers](https://developer.android.com/)

Bon développement ! 🚀
