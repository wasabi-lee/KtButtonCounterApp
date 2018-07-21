package io.incepted.ktbuttoncounterapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userInput: EditText = findViewById<EditText>(R.id.main_edit)
        val button: Button = findViewById<Button>(R.id.main_button)
        val textView: TextView = findViewById<TextView>(R.id.main_text)
        textView.text = ""
        textView.movementMethod = ScrollingMovementMethod()

        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                textView.append(userInput.text)
                textView.append("\n")
//                userInput.text.clear()
                userInput.setText("")
            }
        })
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString("text_key", main_text.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        main_text.text = savedInstanceState?.getString("text_key", "")
    }
}
