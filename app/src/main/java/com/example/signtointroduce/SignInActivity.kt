package com.example.signtointroduce

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import java.util.Random

class SignInActivity : AppCompatActivity() {

    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private var userData: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)

        // 1. 로그인 버튼을 누르면 HomeActivity 실행
        // 2. 아이디 비밀번호 여백체크 ( 예외처리 )
        // 3. 비어있는 EditText 에 따라 아이디, 비밀번호 입력요청 Toast 작성
        // 4. 회원가입 버튼을 누르면 SignUpActiviy 실행

        val btn_signin = findViewById<Button>(R.id.btn_signin)
        val btn_signUp = findViewById<Button>(R.id.btn_signup)
        var id_input = findViewById<EditText>(R.id.id_input)
        var pw_input = findViewById<EditText>(R.id.pw_input)
        val logo_image = findViewById<ImageView>(R.id.logo_image)
        var idString: String
        var pwString: String


        // 서브 액티비티로부터 돌아올 때의 결과 값을 받아 올 수 있는 구문
        fun setResultNext() {
            resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == RESULT_OK) {
                    userData = result.data?.getParcelableExtra<User>("userData")
//                    lv.4 이전 Parcelize 사용후 주석처리
//                    val getId = result.data?.getStringExtra("id") ?: ""
//                    val getPw = result.data?.getStringExtra("pw") ?: ""
                    id_input.setText(userData?.name)
                    pw_input.setText(userData?.pw)
                }
            }
        }

        setResultNext()


        // 랜덤한 고양이 사진을 출력하기 위해
        val random = Random()
        val num = random.nextInt(5)+1 // 1~5 번

        when (num) {
            1 -> logo_image.setImageResource(R.drawable.choco_01)
            2 -> logo_image.setImageResource(R.drawable.choco_02)
            3 -> logo_image.setImageResource(R.drawable.choco_03)
            4 -> logo_image.setImageResource(R.drawable.choco_04)
            5 -> logo_image.setImageResource(R.drawable.choco_05)
        }

        btn_signin.setOnClickListener{
            if (id_input.text.isEmpty() || pw_input.text.isEmpty()) { // id와 pw가 비어있을때 체크
                Toast.makeText(this@SignInActivity, "아이디/비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                idString = id_input.text.toString()
                // 정상 로그인시 실행
                Toast.makeText(this@SignInActivity, "로그인 성공", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                // 데이터 전송
                intent.putExtra("userData", userData)
                startActivity(intent)
            }
        }
        btn_signUp.setOnClickListener{
            val intent = Intent(this, SignUpActiviy::class.java)
            resultLauncher.launch(intent)
        }
    }
}