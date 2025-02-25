package com.plcoding.daggerhiltcourse

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.plcoding.daggerhiltcourse.data.model.Employee
import com.plcoding.daggerhiltcourse.presentation.viewmodel.MyViewModel
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

                        items.forEachIndexed { index, item ->
                            Log.d("MainActivity", "${index + 1} Employee: ${item.name}")
                        }

                        Log.d("MainActivity", "My name is ${viewModel.name}")
                        Greetings(
                            employees = items,
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greetings(employees: List<Employee>, modifier: Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        employees.forEach { employee ->
            EmployeeCard(employee = employee)
        }
    }
}

@Composable
fun EmployeeCard(employee: Employee) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Text(
                text = employee.name,
                style = MaterialTheme.typography.h6
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEmployeeCard() {
    DaggerHiltCourseTheme {
        EmployeeCard(employee = Employee("Preview Name"))
    }
}