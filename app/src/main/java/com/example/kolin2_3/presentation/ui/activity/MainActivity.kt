package com.example.kolin2_3.presentation.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavGraph
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.kolin2_3.R
import com.example.kolin2_3.data.PreferenceHelper
import com.example.kolin2_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binidng: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binidng = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binidng.root)
        navControl()
    }

    fun navControl(){

        val preferenceHelper = PreferenceHelper(this)
        if (!preferenceHelper.isShovOnBoard) {
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.fcv_activity_main) as NavHostFragment
            val navController = navHostFragment.navController
            val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
            navGraph.setStartDestination(R.id.viewPagerFragment)
            navController.graph = navGraph
        }
    }
}