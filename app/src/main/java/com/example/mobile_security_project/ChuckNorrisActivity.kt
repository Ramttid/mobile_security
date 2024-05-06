package com.example.mobile_security_project

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.mobile_security_project.interfaces.ApiService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ChuckNorrisActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val button = Button(this).apply {
            layoutParams = ViewGroup.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
            gravity = Gravity.CENTER
            text = "Click Me"
        }

        button.setOnClickListener {
            fetchChuckNorrisJoke()
        }

        setContentView(button)
    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setMessage("Are you sure you want to exit?")
            .setPositiveButton("Yes") { _, _ ->
                super.onBackPressed()
            }
            .setNegativeButton("No", null)
            .show()
    }

    private fun fetchChuckNorrisJoke() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.chucknorris.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)

        lifecycleScope.launch {
            try {
                val response = apiService.getRandomJoke()
                if (response.isSuccessful) {
                    val joke = response.body()

                    joke?.let {
                        val toastLayout = LinearLayout(this@ChuckNorrisActivity).apply {
                            orientation = LinearLayout.VERTICAL
                            setBackgroundColor(Color.BLACK)
                            setPadding(16, 16, 16, 16)
                            gravity = Gravity.CENTER
                        }

                        val toastTextView = TextView(this@ChuckNorrisActivity).apply {
                            layoutParams = LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.WRAP_CONTENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT
                            )
                            text = it.value
                            textSize = 22f
                            setTextColor(Color.WHITE)
                            gravity = Gravity.CENTER
                        }

                        toastLayout.addView(toastTextView)

                        val toast = Toast(this@ChuckNorrisActivity).apply {
                            view = toastLayout
                            duration = Toast.LENGTH_LONG
                            setGravity(Gravity.CENTER, 0, 0)
                        }

                        toast.show()
                    }

                } else {
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

