package com.tuannguyen.shazammusic.presentation

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.tuannguyen.shazammusic.BR
import com.tuannguyen.shazammusic.databinding.ActivityMainBinding
import com.tuannguyen.shazammusic.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    private var bindingVariable: Int = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.setVariable(bindingVariable, viewModel)
        setContentView(binding.root)
    }

    fun showProgressbar() {
        binding.progressCircular.visibility = View.VISIBLE
    }

    fun hideProgressBar() {
        binding.progressCircular.visibility = View.GONE
    }

    fun hideKeyboard() {
        val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        currentFocus?.let {
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
        }
    }
}
