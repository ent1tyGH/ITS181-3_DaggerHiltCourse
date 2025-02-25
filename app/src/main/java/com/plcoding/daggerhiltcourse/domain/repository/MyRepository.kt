package com.plcoding.daggerhiltcourse.domain.repository

import com.plcoding.daggerhiltcourse.data.model.Employee

interface MyRepository {
    fun doNetworkCall()
    fun getItems(): List<Employee>
}