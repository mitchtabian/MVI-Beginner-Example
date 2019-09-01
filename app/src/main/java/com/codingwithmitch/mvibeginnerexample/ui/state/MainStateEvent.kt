package com.codingwithmitch.mvibeginnerexample.ui.state

sealed class MainStateEvent {

    class GetBlogPostsEvent: MainStateEvent()

    class GetUserEvent: MainStateEvent()

    class None: MainStateEvent()


}