package com.david.tmdbapp.framework.views.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.david.tmdbapp.R
import com.david.tmdbapp.databinding.ActivityMainBinding
import com.david.tmdbapp.framework.views.fragments.MoviesFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var currentFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        exchangeCurrentFragment(MoviesFragment())
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun exchangeCurrentFragment(newFragment: Fragment) {
        currentFragment = newFragment

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_content_main, currentFragment)
            .commit()
    }
}