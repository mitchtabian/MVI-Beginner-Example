package com.codingwithmitch.mvibeginnerexample.ui

import com.codingwithmitch.mvibeginnerexample.util.DataState

interface DataStateHandler {

    fun onDataStateChange(dataState: DataState<*>?)
}