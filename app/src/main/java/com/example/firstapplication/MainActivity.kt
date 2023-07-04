package com.example.firstapplication

import android.annotation.SuppressLint
import android.os.Bundle
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
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstapplication.ui.theme.FirstApplicationTheme

class MainActivity : ComponentActivity() {
    
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<Button>(R.id.button1)
        val textView1 = findViewById<TextView>(R.id.idTVHeading1)
        val userInput = findViewById<EditText>(R.id.userInput)

        val button2 = findViewById<Button>(R.id.button2)

        button1?.setOnClickListener() {
            textView1.text = userInput.text
        }

        button2?.setOnClickListener() {
            secondScreen()
        }
    }

    fun secondScreen() {
        setContentView(R.layout.second_screen)
    }



}

