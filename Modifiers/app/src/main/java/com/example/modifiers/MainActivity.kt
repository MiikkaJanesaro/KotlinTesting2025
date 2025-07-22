package com.example.modifiers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.modifiers.ui.theme.ModifiersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ModifiersTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                    ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val reusableModifier = Modifier
        .padding(8.dp)
        .background(Color.Red)
    Column{
        MyText(content = "First Text", modifier = reusableModifier)
        MyText(content = "Second Text")
        MyText(content = "Third Text", modifier = Modifier.fillMaxWidth().background(Color.Blue))
        MyText(content = "Fourth Text", reusableModifier.fillMaxWidth())
    }
}

@Composable
fun MyText (content: String, modifier: Modifier = Modifier){
    Text(
        text = content,
        modifier = modifier
    )
}