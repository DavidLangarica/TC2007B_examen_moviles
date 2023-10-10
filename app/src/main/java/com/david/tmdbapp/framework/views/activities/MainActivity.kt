package com.david.tmdbapp.framework.views.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.david.tmdbapp.R
import com.david.tmdbapp.databinding.ActivityMainBinding
import com.david.tmdbapp.framework.views.fragments.MoviesFragment

/*
 * Class that defines the MainActivity
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var currentFragment: Fragment

    /*
     * Function that is called when the activity is created
     *
     * @param savedInstanceState: Bundle?
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        exchangeCurrentFragment(MoviesFragment())
    }

    /*
     * Function that initializes the binding
     */
    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    /*
     * Function that exchanges the current fragment
     *
     * @param newFragment: Fragment - Fragment to be shown
     */
    private fun exchangeCurrentFragment(newFragment: Fragment) {
        currentFragment = newFragment

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_content_main, currentFragment)
            .commit()
    }
}