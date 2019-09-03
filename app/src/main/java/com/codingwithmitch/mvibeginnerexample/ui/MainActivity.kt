package com.codingwithmitch.mvibeginnerexample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.codingwithmitch.mvibeginnerexample.R
import com.codingwithmitch.mvibeginnerexample.ui.state.MainViewState
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    StateHandler
{
    override fun onStateChange(viewState: MainViewState?) {
        handleStateChange(viewState)
    }

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        showMainFragment()
    }

    fun showMainFragment(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, MainFragment(), "MainFragment")
            .commit()
    }

    fun handleStateChange(viewState: MainViewState?){
        println("DEBUG: StateChange : ${viewState}")
        viewState?.let{

            // Handle loading
            showProgressBar(viewState.isLoading)
        }
    }

    fun showProgressBar(isVisible: Boolean){
        if(isVisible){
            progress_bar.visibility = View.VISIBLE
        }
        else{
            progress_bar.visibility = View.INVISIBLE
        }
    }

}























