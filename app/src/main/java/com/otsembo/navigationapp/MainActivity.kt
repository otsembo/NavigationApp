package com.otsembo.navigationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.otsembo.navigationapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // email text
    private lateinit var email:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // click listener
        binding.btnGo.setOnClickListener { view: View ->
            email = binding.edtEmail.text.toString()

        }

    }


    // function to make explicit intent
    private fun goToNext(){

        email = binding.edtEmail.text.toString()

        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(EMAIL, email)
        // start navigation
        startActivity(intent)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId

        when(id){
            R.id.menuNavigate -> {
                goToNext()
            }
            R.id.showToast -> {
                Toast.makeText(this, "This is a toast", Toast.LENGTH_LONG).show()
            }
        }

        return true
    }


    companion object {
        const val EMAIL = "email_key"
    }


}