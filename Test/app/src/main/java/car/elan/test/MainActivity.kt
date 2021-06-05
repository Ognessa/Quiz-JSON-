package car.elan.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //init
        val startBtn: Button = findViewById(R.id.btn_start)

        //go to quiz when button clicked
        startBtn.setOnClickListener {
            val myIntent = Intent(this, QuizActivity::class.java)
            startActivity(myIntent)
        }

    }
}