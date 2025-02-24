package com.plcoding.daggerhiltcourse.data.repository

import android.app.Application
import android.util.Log
import com.plcoding.daggerhiltcourse.R
import com.plcoding.daggerhiltcourse.data.remote.MyApi
import com.plcoding.daggerhiltcourse.domain.repository.MyRepository
import javax.inject.Inject

class MyRepositoryImpl @Inject constructor(
    private val api: MyApi,
    private val appContext: Application
): MyRepository {
    val employees = mutableListOf("Leo", "Kezia", "Nette", "Denzel" )
    init {
        val appName = appContext.getString(R.string.app_name)
        println("Hello from the repository. The app name is $appName")
    }

    override fun doNetworkCall() {
        Log.d("MyRepository", "doNetworkCall")
        employees.add("Cynthia")
    }
    override fun getItems(): List<String> {
        doNetworkCall();
        return employees
    }
}