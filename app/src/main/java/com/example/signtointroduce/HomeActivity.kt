package com.example.signtointroduce

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        val choco1 = findViewById<ImageView>(R.id.choco1)
        val choco2 = findViewById<ImageView>(R.id.choco2)
        val choco3 = findViewById<ImageView>(R.id.choco3)
        val choco4 = findViewById<ImageView>(R.id.choco4)
        val choco5 = findViewById<ImageView>(R.id.choco5)
        val data_id = findViewById<TextView>(R.id.dataId)
        val data_name = findViewById<TextView>(R.id.dataName)
        val data_age = findViewById<TextView>(R.id.dataAge)
        val data_MBTI = findViewById<TextView>(R.id.dataMBTI)
        val btn_finish = findViewById<ConstraintLayout>(R.id.layout_btn_finish)

        // 랜덤한 고양이 사진을 출력하기 위해
        val random = Random()
        val num = random.nextInt(5)+1 // 1~5 번

        when (num) {
            1 -> choco1.setImageResource(R.drawable.choco_1)
            2 -> choco2.setImageResource(R.drawable.choco_2)
            3 -> choco3.setImageResource(R.drawable.choco_3)
            4 -> choco4.setImageResource(R.drawable.choco_4)
            5 -> choco5.setImageResource(R.drawable.choco_5)
        }
        val userData = intent.getParcelableExtra<User>("userData")
        data_id.text = "${data_id.text} ${userData?.id}"
        data_name.text = "${data_name.text} ${userData?.name}"
        data_MBTI.text = "${data_MBTI.text} ${userData?.mbti}"

        btn_finish.setOnClickListener {
            finish()
        }
    }
}