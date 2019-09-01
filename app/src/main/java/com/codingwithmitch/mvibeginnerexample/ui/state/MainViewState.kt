package com.codingwithmitch.mvibeginnerexample.ui.state

import com.codingwithmitch.mvibeginnerexample.model.BlogPost
import com.codingwithmitch.mvibeginnerexample.model.User

data class MainViewState(

    var blogPosts: List<BlogPost>? = null,
    var user: User? = null

)