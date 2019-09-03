package com.codingwithmitch.mvibeginnerexample.ui.state

sealed class MainStateEvent {

    class GetBlogPostsEvent: MainStateEvent()

    class GetUserEvent(
        val userId: String
    ): MainStateEvent()

    class None: MainStateEvent()


}