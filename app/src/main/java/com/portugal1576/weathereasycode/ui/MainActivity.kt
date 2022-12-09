package com.portugal1576.weathereasycode.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.portugal1576.weathereasycode.R
import com.portugal1576.weathereasycode.databinding.ActivityMainBinding
import com.portugal1576.weathereasycode.utils.APP

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        APP = this
//        navController = Navigation.findNavController(this, R.id.nav_fragment)
        navController = Navigation.findNavController(this, R.id.nav_fragment)
    }
}
