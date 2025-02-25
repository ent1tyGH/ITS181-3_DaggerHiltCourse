package com.plcoding.daggerhiltcourse.data.repository

import android.app.Application
import android.util.Log
import com.plcoding.daggerhiltcourse.R
import com.plcoding.daggerhiltcourse.data.model.Employee
import com.plcoding.daggerhiltcourse.data.remote.MyApi
import com.plcoding.daggerhiltcourse.domain.repository.MyRepository
import javax.inject.Inject

class MyRepositoryImpl @Inject constructor(
    private val api: MyApi,
    private val appContext: Application
) : MyRepository {

    private val employees = mutableListOf(
        Employee("Leo"),
        Employee("Kezia"),
        Employee("Nette"),
        Employee("Denzel")
    )

    init {
        val appName = appContext.getString(R.string.app_name)
        println("Hello from the repository. The app name is $appName")
    }

    override fun doNetworkCall() {
        Log.d("MyRepository", "doNetworkCall")
        employees.add(Employee("Cynthia"))
    }

    override fun getItems(): List<Employee> {
        doNetworkCall()
        return employees
    }
}