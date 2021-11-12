package com.tuannguyen.shazammusic.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.tuannguyen.shazammusic.BR
import com.tuannguyen.shazammusic.R
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
}
