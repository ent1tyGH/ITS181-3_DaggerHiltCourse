package com.plcoding.daggerhiltcourse.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.plcoding.daggerhiltcourse.data.model.Employee
import com.plcoding.daggerhiltcourse.domain.repository.MyRepository
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: Lazy<MyRepository>
) : ViewModel() {

    val name: String = "Mapua"

    init {
        Log.d("MyViewModel", "MyViewModel initialized with name $name")
        repository.get()
    }

    fun getItems(): List<Employee> {
        return repository.get().getItems()
    }
}