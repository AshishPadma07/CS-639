package com.example.midtermashishpadma



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.midtermashishpadma.ui.theme.MidtermashishpadmaTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MidtermashishpadmaTheme {
                ConverterScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConverterScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        var meters by remember { mutableStateOf("") }
        var millimeters by remember { mutableStateOf("") }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background.copy(alpha = 0.7f))
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .background(Color.White.copy(alpha = 0.7f))
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text(
                        text = "Ashish Padma",
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Box(
                    modifier = Modifier
                        .background(Color.White.copy(alpha = 0.7f))
                        .padding(16.dp)
                ) {
                    OutlinedTextField(
                        value = meters,
                        onValueChange = { meters = it },
                        label = { Text("Enter meters") },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(onDone = { /* Close keyboard if needed */ })
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = {
                    millimeters = metersToMillimeters(meters)
                }) {
                    Text("Convert")
                }

                Spacer(modifier = Modifier.height(16.dp))

                Box(
                    modifier = Modifier
                        .background(Color.White.copy(alpha = 0.7f))
                        .padding(16.dp)
                ) {
                    Text(text = "Result: $millimeters mm", color = Color.Black)
                }
            }
        }
    }
}

fun metersToMillimeters(meters: String): String {
    return try {
        val mm = meters.toDouble() * 1000
        mm.toString()
    } catch (e: NumberFormatException) {
        "Invalid input"
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ConverterPreview() {
    MidtermashishpadmaTheme {
        ConverterScreen()
    }
}