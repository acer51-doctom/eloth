package com.eloth.app.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.eloth.app.data.Character
import com.eloth.app.data.CharacterTables
import com.eloth.app.ui.theme.*
import kotlin.random.Random

@Composable
fun CharacterGeneratorScreen(
    onNavigateBack: () -> Unit
) {
    var character by remember { mutableStateOf<Character?>(null) }
    var showResult by remember { mutableStateOf(false) }
    var resultAlpha by remember { mutableFloatStateOf(0f) }
    
    val animatedAlpha by animateFloatAsState(
        targetValue = resultAlpha,
        animationSpec = tween(durationMillis = 300),
        label = "result_alpha"
    )
    
    fun generateCharacter() {
        // Roll all dice
        val rollAgeEyesSign = Random.nextInt(0, 12)
        val ageEyesSign = CharacterTables.ageEyesSignTable[rollAgeEyesSign]
        
        val rollWeightSize = Random.nextInt(0, 12)
        val weightSize = CharacterTables.weightSizeTable[rollWeightSize]
        
        val rollHair = Random.nextInt(0, 24)
        val hairCut = if (rollHair < 12) {
            CharacterTables.hairCutsType1[rollHair]
        } else {
            CharacterTables.hairCutsType2[rollHair - 12]
        }
        
        val rollHairColor = Random.nextInt(0, 12)
        val hairColor = CharacterTables.hairColorTable[rollHairColor]
        
        val rollRegion = Random.nextInt(0, 12)
        val region = CharacterTables.regionTable[rollRegion]
        
        val rollFamily = Random.nextInt(0, 8)
        val family = CharacterTables.familyTable[region]?.getOrNull(rollFamily) ?: "Inconnue"
        
        val rollLocation = Random.nextInt(0, 8)
        val location = CharacterTables.locationTable[region]?.getOrNull(rollLocation) ?: "Inconnu"
        
        val rollGoodFortune = Random.nextInt(0, 10)
        val goodFortune = CharacterTables.goodFortuneTable[rollGoodFortune]
        
        val rollBadFortune = Random.nextInt(0, 10)
        val badFortune = CharacterTables.badFortuneTable[rollBadFortune]
        
        character = Character(
            age = ageEyesSign.first,
            size = weightSize.second,
            weight = weightSize.first,
            eyes = ageEyesSign.second,
            hair = hairCut,
            hairColor = hairColor,
            distinctiveSign = ageEyesSign.third,
            region = region,
            specificLocation = location,
            family = family,
            goodFortune = goodFortune,
            badFortune = badFortune
        )
        
        showResult = true
        resultAlpha = 1f
    }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
    ) {
        BackButton(
            onClick = onNavigateBack,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        )
        
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(60.dp))
            
            // Title
            Text(
                text = "GÉNÉRATEUR DE TRAITS D'ELOTH",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = ElothYellow,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .shadow(
                        elevation = 10.dp,
                        spotColor = ElothYellow
                    )
            )
            
            Text(
                text = "Génération automatique des caractéristiques physiques et d'arrière-plan.",
                fontSize = 12.sp,
                color = Gray400,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 32.dp)
            )
            
            // Generate button
            NesButton(
                text = "Générer les Traits",
                onClick = { generateCharacter() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(bottom = 40.dp)
            )
            
            // Character result
            if (showResult && character != null) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(4.dp, ElothRed)
                        .background(Gray900)
                        .padding(24.dp)
                        .alpha(animatedAlpha)
                ) {
                    Column {
                        Text(
                            text = "CARACTÉRISTIQUES GÉNÉRÉES",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = ElothYellow,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 24.dp)
                                .shadow(
                                    elevation = 5.dp,
                                    spotColor = ElothYellow
                                )
                        )
                        
                        CharacterAttribute("Âge", character!!.age)
                        CharacterAttribute("Taille", character!!.size)
                        CharacterAttribute("Poids", character!!.weight)
                        CharacterAttribute("Yeux", character!!.eyes)
                        CharacterAttribute("Cheveux", "${character!!.hair} (${character!!.hairColor})")
                        CharacterAttribute("Signe Distinctif", character!!.distinctiveSign)
                        CharacterAttribute("Région", character!!.region)
                        CharacterAttribute("Lieu Spécifique", character!!.specificLocation)
                        CharacterAttribute("Famille", character!!.family)
                        CharacterAttribute("Bonne Fortune", character!!.goodFortune)
                        CharacterAttribute("Mauvaise Fortune", character!!.badFortune)
                        
                        Divider(
                            color = Gray700,
                            modifier = Modifier.padding(vertical = 16.dp)
                        )
                        
                        Text(
                            text = "HISTORIQUE EN BREF :",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = ElothRed,
                            modifier = Modifier.padding(bottom = 12.dp)
                        )
                        
                        Text(
                            text = buildString {
                                append("Ce personnage est âgé de ${character!!.age} et vient de la région de ${character!!.region}. ")
                                append("Il/Elle est né(e) à ${character!!.specificLocation}. ")
                                append("Il/Elle mesure ${character!!.size} et pèse ${character!!.weight}. ")
                                append("Physiquement, il/elle a une coupe ${character!!.hair} de couleur ${character!!.hairColor} et des yeux ${character!!.eyes}. ")
                                append("Son signe distinctif est : ${character!!.distinctiveSign}. ")
                                append("Son historique familial est : ${character!!.family}.\n\n")
                                append("Le destin lui a accordé une Bonne Fortune : ${character!!.goodFortune}. ")
                                append("Il/Elle doit aussi faire face à une Mauvaise Fortune : ${character!!.badFortune}.")
                            },
                            fontSize = 16.sp,
                            color = Gray200,
                            fontStyle = FontStyle.Italic,
                            lineHeight = 24.sp
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun CharacterAttribute(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .border(0.dp, Gray800)
            .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "$label :",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = ElothYellow,
            modifier = Modifier.weight(0.4f)
        )
        
        Text(
            text = value,
            fontSize = 14.sp,
            color = White,
            modifier = Modifier.weight(0.6f),
            textAlign = TextAlign.End
        )
    }
    
    Divider(
        color = Gray800,
        thickness = 1.dp,
        modifier = Modifier.padding(bottom = 4.dp)
    )
}
