package com.codingwithmitch.mvibeginnerexample.repository

import androidx.lifecycle.LiveData
import com.codingwithmitch.mvibeginnerexample.api.ApiService
import com.codingwithmitch.mvibeginnerexample.api.MyRetrofitBuilder
import com.codingwithmitch.mvibeginnerexample.model.BlogPost
import com.codingwithmitch.mvibeginnerexample.model.User
import com.codingwithmitch.mvibeginnerexample.ui.state.MainViewState
import com.codingwithmitch.mvibeginnerexample.util.ApiSuccessResponse
import com.codingwithmitch.mvibeginnerexample.util.DataState
import com.codingwithmitch.mvibeginnerexample.util.GenericApiResponse

object Repository {

    val apiService: ApiService = MyRetrofitBuilder
        .retrofitBuilder
        .build()
        .create(ApiService::class.java)

    fun getBlogPosts(): LiveData<DataState<MainViewState>> {
        return object: NetworkBoundResource<List<BlogPost>, MainViewState>(){

            override fun handleApiSuccessResponse(response: ApiSuccessResponse<List<BlogPost>>) {
                result.value = DataState.data(
                    null,
                    MainViewState(
                        blogPosts = response.body,
                        user = null
                    )
                )
            }

            override fun createCall(): LiveData<GenericApiResponse<List<BlogPost>>> {
                return apiService.getBlogPosts()
            }

        }.asLiveData()

    }

    fun getUser(): LiveData<DataState<MainViewState>> {
        return object: NetworkBoundResource<User, MainViewState>(){

            override fun handleApiSuccessResponse(response: ApiSuccessResponse<User>) {
                result.value = DataState.data(
                    null,
                    MainViewState(
                        blogPosts = null,
                        user = response.body
                    )
                )
            }

            override fun createCall(): LiveData<GenericApiResponse<User>> {
                return apiService.getUser()
            }

        }.asLiveData()

    }

}
























