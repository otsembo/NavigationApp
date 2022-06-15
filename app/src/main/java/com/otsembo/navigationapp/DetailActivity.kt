package com.otsembo.navigationapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.otsembo.navigationapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // initialize binding object
        binding = DataBindingUtil.setContentView(this,R.layout.activity_detail)

        val received = intent.getStringExtra(MainActivity.EMAIL)
        binding.email = received

    }

}