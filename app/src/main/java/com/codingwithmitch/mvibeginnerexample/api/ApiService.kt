package com.codingwithmitch.mvibeginnerexample.api

import androidx.lifecycle.LiveData
import com.codingwithmitch.mvibeginnerexample.model.BlogPost
import com.codingwithmitch.mvibeginnerexample.model.User
import com.codingwithmitch.mvibeginnerexample.util.GenericApiResponse
import retrofit2.http.GET

interface ApiService {

    @GET("placeholder/blogs")
    fun getBlogPosts(): LiveData<GenericApiResponse<List<BlogPost>>>

    @GET("placeholder/user")
    fun getUser(): LiveData<GenericApiResponse<User>>
}





