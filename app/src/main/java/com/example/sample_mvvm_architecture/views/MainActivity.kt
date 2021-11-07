package com.example.sample_mvvm_architecture.views

import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.sample_mvvm_architecture.R
import com.example.sample_mvvm_architecture.databinding.ActivityMainBinding
import com.example.sample_mvvm_architecture.viewmodels.LoginViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding.viewModel = LoginViewModel()
        activityMainBinding.executePendingBindings()
    }

    companion object {
        @BindingAdapter("toastMessage")
        @JvmStatic
        fun runMe(view: View, message: String?) {
            if (message != null) Toast.makeText(view.context, message, Toast.LENGTH_SHORT).show()
        }
    }
}
