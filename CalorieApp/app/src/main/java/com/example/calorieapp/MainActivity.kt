package com.example.calorieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calorieapp.ui.theme.CalorieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalorieAppTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    CalorieApp(
                        modifier = Modifier.padding(innerpadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CalorieApp (modifier: Modifier = Modifier) {
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Heading("Calories")
        WeightField(weightInput = weightInput,onValueChange={ weightInput = it })
    }
}


@Preview(showBackground = true)
@Composable
fun CalorieAppPreview() {
    CaloriesTheme {
        CalorieApp()
    }
}

@Composable
fun Heading(title: String) {
    Text(
        text = title,
        fontSize = 24.sp,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.fillMaxWidth().padding(top = 16.dp,bottom = 16.dp)
    )
}

@Composable
fun WeightField(weightInput: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = weightInput,
        onValueChange = onValueChange,
        label = { Text(text="Enter Weight") },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier.fillMaxWidth()
    )
}