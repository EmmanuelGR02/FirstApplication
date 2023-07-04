package com.example.firstapplication

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstapplication.ui.theme.FirstApplicationTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main()
        hideKeyboard()
    }

    @SuppressLint("MissingInflatedId")
    fun secondScreen() {
        setContentView(R.layout.second_screen)
        var back_btn = findViewById<Button>(R.id.SecondScreen_back_btn)

        back_btn?.setOnClickListener() {
            main()
        }

    }

    fun usernames(): ArrayList<String> {
        var username = ArrayList<String>()
        username.add("ENRIQUE")
        username.add("EMMANUEL")
        username.add("KEVIN")
        return username
    }

    fun isUsernameValid(name: String): Boolean {
        var name2 = name.uppercase()
        return usernames().contains(name2)
    }


    fun main() {
        setContentView(R.layout.activity_main)
        hideKeyboard()

        // call main button
        var main_button = findViewById<Button>(R.id.main_submit)

        main_button?.setOnClickListener() {
            var name = findViewById<EditText>(R.id.main_userName).text.toString()
            if (isUsernameValid(name) == true) {
                secondScreen()
                findViewById<TextView>(R.id.SecondScreen_text).text = "Welcome, " + name
                findViewById<TextView>(R.id.User_Prompt).text = "What will you be doing today? "
                var input = readLine()
            } else {
                findViewById<TextView>(R.id.main_wrongId).text = "Access Denied"
            }
        }
    }

    fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val hide = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            hide.hideSoftInputFromWindow(view.windowToken, 0)
        }
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    }



}

