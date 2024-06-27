package com.example.signtointroduce

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random

class SignUpActiviy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        val signup_btn_signup = findViewById<Button>(R.id.signup_btn_signup)
        var name_input: String
        var id_input: String
        var pw_input: String
        var mbti_input: String
        val signup_logo = findViewById<ImageView>(R.id.signup_logo)


        // 랜덤한 고양이 사진을 출력하기 위해
        val random = Random()
        val num = random.nextInt(5)+1 // 1~5 번

        when (num) {
            1 -> signup_logo.setImageResource(R.drawable.choco_01)
            2 -> signup_logo.setImageResource(R.drawable.choco_02)
            3 -> signup_logo.setImageResource(R.drawable.choco_03)
            4 -> signup_logo.setImageResource(R.drawable.choco_04)
            5 -> signup_logo.setImageResource(R.drawable.choco_05)
        }
        signup_btn_signup.setOnClickListener{
            name_input = findViewById<EditText>(R.id.signup_name_input).text.toString()
            id_input = findViewById<EditText>(R.id.signup_id_input).text.toString()
            pw_input = findViewById<EditText>(R.id.signup_pw_input).text.toString()
            mbti_input = findViewById<EditText>(R.id.signup_mbti_input).text.toString()

            if (name_input.isEmpty() || id_input.isEmpty() || pw_input.isEmpty()) {
                Toast.makeText(this@SignUpActiviy, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@SignUpActiviy, "회원가입 완료", Toast.LENGTH_SHORT).show()

                val userData = User(name_input, id_input, pw_input, mbti_input)
                val intent = Intent()
                intent.putExtra("userData", userData)
//                lv.4 이전 Parcelize 사용후 주석처리
//                intent.putExtra("name",name_input.toString())
//                intent.putExtra("id",id_input.toString())
//                intent.putExtra("pw",pw_input.toString())
//                intent.putExtra("mbti",mbti_input.toString())
                setResult(RESULT_OK,intent)
                finish()
            }
        }
    }
}