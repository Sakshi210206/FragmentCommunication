package com.example.fragmentcommunication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fragmentcommunication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var fragmentFirst : FirstFragment
    private lateinit var fragmentSecond : SecondFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        fragmentFirst = supportFragmentManager.findFragmentById(R.id.fragmentFirst) as FirstFragment
        fragmentSecond = supportFragmentManager.findFragmentById(R.id.fragmentSecond) as SecondFragment


        fragmentFirst.onNameSetListener = MyOnNameSetListener()
        fragmentSecond.onCitySetListener = MyOnCitySetListener()


    }

    inner class MyOnNameSetListener:FirstFragment.OnNameSetListener{
        override fun onNameSet(text: String) {
            fragmentSecond.text2=text
            Toast.makeText(this@MainActivity,"onNameSetListener -- $text",Toast.LENGTH_LONG).show()

        }
    }

    inner class MyOnCitySetListener:SecondFragment.OnCitySetListener{
        override fun onCitySet(text: String) {
            fragmentFirst.text1=text
            Toast.makeText(this@MainActivity,"onCitySetListener -- $text",Toast.LENGTH_LONG).show()
        }

    }
    fun sendDataToSecondFragment(text : String){
        fragmentSecond.text2 = text
    }

    fun sendDataToFirstFragment(text : String){
        fragmentFirst.text1 = text
    }
}