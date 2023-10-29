package com.example.week4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import com.example.week4.ui.theme.Week4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Week4Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Ashish Padma")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val gradientBackground = Brush.verticalGradient(
        colors = listOf(Color.Blue, Color.Cyan)
    )

    val customTextStyle = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        shadow = Shadow(Color.Black, blurRadius = 5f)
    )

    // Create a state to track the number of characters displayed.
    var charactersDisplayed by remember { mutableStateOf(0) }

    // Use LaunchedEffect to change this state at a regular interval.
    LaunchedEffect(key1 = name) {
        delay(100)  // Wait a bit before starting the typing effect
        name.forEach { _ ->
            delay(150)  // Delay between each character
            charactersDisplayed++
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(gradientBackground),
        contentAlignment = Alignment.Center
    ) {
        // Modify Text composable to show characters up to the current index.
        Text(
            text = "Hello Android ${name.take(charactersDisplayed)}!",
            style = customTextStyle,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Week4Theme {
        Greeting("Ashish Padma")
    }
}