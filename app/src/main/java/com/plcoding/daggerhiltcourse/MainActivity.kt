package com.plcoding.daggerhiltcourse

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.plcoding.daggerhiltcourse.ui.theme.DaggerHiltCourseTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DaggerHiltCourseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface {
                        val viewModel = hiltViewModel<MyViewModel>()
                        val items = viewModel.getItems()
                        var n = 0
                        for (item in items) {
                            ++n
                            Log.d("MainActivity", "$n Employee: $item")
                        }
                        Log.d("MainActivity", "My name is ${viewModel.mame}")
                        Log.d("MainActivity", "Call)ing Greeting")
                        Greetings(
                            descriptions = items,
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greetings (descriptions: List<String>, modifier: Modifier) {
    Column() {
        for (desc in descriptions) {
            Greeting(
                description = desc,
                mod = modifier
            )
        }
    }
}
@Composable
fun Greeting (description: String, mod: Modifier) {
    Row() {
        Text(
            text = description
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewGreeting () {
//    DaggerHiltCourseTheme {
//        Greeting()
//    }
//}