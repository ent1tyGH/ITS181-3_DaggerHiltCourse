package com.plcoding.daggerhiltcourse

import android.util.Log
import androidx.lifecycle.ViewModel
import com.plcoding.daggerhiltcourse.domain.repository.MyRepository
import dagger.Lazy
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: Lazy<MyRepository>
): ViewModel() {
    val mame: String = "Mapua"
    init {
        Log.d("MainActivity","MyViewModel $mame")
        repository.get()
    }
    fun getItems(): List<String> {
        return repository.get().getItems()
    }
}


