package com.example.kotlincoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {

            CoroutineScope(IO).launch{

                Task1()

                Task2()

                Task3()
            }
        }
    }

    private suspend fun updateTask1(str : String)
    {
        withContext(Main){

            SetText1(str)
        }
    }

    private suspend fun updateTask2(str : String)
    {
        withContext(Main){

            SetText2(str)
        }
    }

    private suspend fun updateTask3(str : String)
    {
        withContext(Main){

            SetText3(str)
        }
    }

    private suspend fun Task1()
    {
        updateTask1("Started")
        delay(1000)
        updateTask1("Done")
    }

    private suspend fun Task2()
    {
        updateTask2("Started")
        delay(3000)
        updateTask2("Done")
    }

    private suspend fun Task3()
    {
        updateTask3("Started")
        delay(1000)
        updateTask3("Done")
    }

    private fun SetText1(str:String)
    {
        textView2.text = str
    }

    private fun SetText2(str:String)
    {
        textView4.text = str
    }

    private fun SetText3(str:String)
    {
        textView6.text = str
    }
}