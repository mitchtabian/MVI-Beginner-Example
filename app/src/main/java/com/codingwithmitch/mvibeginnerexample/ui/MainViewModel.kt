package com.codingwithmitch.mvibeginnerexample.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.codingwithmitch.mvibeginnerexample.model.BlogPost
import com.codingwithmitch.mvibeginnerexample.model.User
import com.codingwithmitch.mvibeginnerexample.repository.Repository
import com.codingwithmitch.mvibeginnerexample.ui.state.MainViewState
import com.codingwithmitch.mvibeginnerexample.ui.state.MainStateEvent
import com.codingwithmitch.mvibeginnerexample.ui.state.MainStateEvent.*
import com.codingwithmitch.mvibeginnerexample.util.AbsentLiveData

class MainViewModel : ViewModel(){

    private val _stateEvent: MutableLiveData<MainStateEvent> = MutableLiveData()
    private val _viewState: MutableLiveData<MainViewState> = MutableLiveData()

    val viewState: LiveData<MainViewState>
        get() = _viewState

    val dataState: LiveData<MainViewState> = Transformations
        .switchMap(_stateEvent){stateEvent ->
            println("DEBUG: ViewModel: StateEvent: ${stateEvent}")
            stateEvent?.let {
                handleStateEvent(stateEvent)
            }
        }

    fun handleStateEvent(stateEvent: MainStateEvent): LiveData<MainViewState>{
        when(stateEvent){

            is GetBlogPostsEvent -> {
                println("DEBUG: ViewModel: Detected GetBlogPostsEvent...")
                return Repository.getBlogPosts()
            }

            is GetUserEvent -> {
                return Repository.getUser(
                   userId = stateEvent.userId
                )
            }

            is None ->{
                return AbsentLiveData.create()
            }
        }
    }

    fun setStateEvent(event: MainStateEvent){
        val state: MainStateEvent
        state = event
        _stateEvent.value = state
    }

    fun setBlogListData(blogPosts: List<BlogPost>){
        val update = getCurrentViewStateOrNew()
        update.blogPosts = blogPosts
        _viewState.value = update
    }

    fun setUser(user: User){
        val update = getCurrentViewStateOrNew()
        update.user = user
        _viewState.value = update
    }

    fun getCurrentViewStateOrNew(): MainViewState {
        val value = viewState.value?.let{
            it
        }?: MainViewState()
        return value
    }

}

















