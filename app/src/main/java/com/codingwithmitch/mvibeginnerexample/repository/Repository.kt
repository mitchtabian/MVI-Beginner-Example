package com.codingwithmitch.mvibeginnerexample.repository

import androidx.lifecycle.LiveData
import com.codingwithmitch.mvibeginnerexample.api.MyRetrofitBuilder
import com.codingwithmitch.mvibeginnerexample.model.BlogPost
import com.codingwithmitch.mvibeginnerexample.model.User
import com.codingwithmitch.mvibeginnerexample.ui.state.MainViewState
import com.codingwithmitch.mvibeginnerexample.util.*
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.withContext

object Repository {

    fun getBlogPosts(): LiveData<MainViewState> {
        return object: NetworkBoundResource<List<BlogPost>>(){

            override suspend fun handleResult(data: List<BlogPost>) {
                withContext(Main){
                    result.value = MainViewState(
                        isLoading = false,
                        blogPosts = data
                    )
                }
            }

            override suspend fun createCall(): List<BlogPost> {
                return MyRetrofitBuilder.apiService.getBlogPosts()
            }

        }.asLiveData()
    }



    fun getUser(userId: String): LiveData<MainViewState> {
        return object: NetworkBoundResource<User>(){

            override suspend fun handleResult(data: User) {
                withContext(Main){
                    result.value = MainViewState(
                        isLoading = false,
                        user = data
                    )
                }
            }

            override suspend fun createCall(): User {
                return MyRetrofitBuilder.apiService.getUser(userId)
            }

        }.asLiveData()
    }

}
























