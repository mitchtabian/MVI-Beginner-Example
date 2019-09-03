package com.codingwithmitch.mvibeginnerexample.ui

import com.codingwithmitch.mvibeginnerexample.ui.state.MainViewState

interface StateHandler {

    fun onStateChange(viewState: MainViewState?)
}