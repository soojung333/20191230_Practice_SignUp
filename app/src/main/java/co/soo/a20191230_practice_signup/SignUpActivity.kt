package co.soo.a20191230_practice_signup

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_sign_up.*

//    SignUpActivity로 변경함!
class SignUpActivity : BaseActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        setupEvents()
        setValues()

    }


    override fun setupEvents() {

//        pwEdt.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(s: Editable?) {
//
//            }
//
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//            }
//
//        })


        birthDayTxt.setOnClickListener {
            Toast.makeText(mContext, "생일 지정 텍스트뷰 클릭", Toast.LENGTH_SHORT).show()
        }


        pwEdt.addTextChangedListener {
            val inputStr = it.toString()
            if (inputStr.length == 0 ) {
                pwStatusTxt.text = "비밀번호가 입력되지 않았습니다"
                pwStatusTxt.setTextColor(Color.RED)
            }
            else if (inputStr.length < 8) {
                pwStatusTxt.text = "입력된 비번이 너무 짧습니다"
                pwStatusTxt.setTextColor(Color.GREEN)
                pwStatusTxt.setTextColor(Color.parseColor("#e1d5e7"))

            }
            else {
                pwStatusTxt.text = "사용해도 좋은 비밀번호입니다"
                pwStatusTxt.setTextColor(Color.BLUE)

            }
        }

    }

    override fun setValues() {


    }

}
