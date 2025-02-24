package com.plcoding.daggerhiltcourse.domain.repository

interface MyRepository {
    fun doNetworkCall()
    fun getItems(): List<String>
}