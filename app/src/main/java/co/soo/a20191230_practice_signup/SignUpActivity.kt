package co.soo.a20191230_practice_signup

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.graphics.Color
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_sign_up.*

//    SignUpActivity로 변경함!
class SignUpActivity : BaseActivity() {

    var selectedBirthDay:Calendar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        setupEvents()
        setValues()

    }


    override fun setupEvents() {

        birthTimeTxt.setOnClickListener {

            val timePickerDialog = TimePickerDialog(mContext, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->

            }, 20, 5, false)
            timePickerDialog.show()

        }

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

            val datapickerDialog = DatePickerDialog(mContext, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

                val selectedDateStr = "${year} / ${month} / ${dayOfMonth}"
                birthDayTxt.text = selectedDateStr

                selectedBirthDay?.let {
                    Log.d("생년월일선택", "이미 선택된 값을 수정 - 다시선택")

                }.let {
                    Log.d("생년월일선택", "선택된 값이 새로 생김 - 처음선택")
                    selectedBirthDay = Calendar.getInstance()
                }

                selectedBirthDay?.set(Calendar.YEAR, year)
                selectedBirthDay?.set(Calendar.MONTH, month)
                selectedBirthDay?.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                selectedBirthDay?.set(year, month, dayOfMonth)


//                저장된 생년월일을 SimpleDateFormat 을 이용해 출력

                val sdf = SimpleDateFormat("yyyy년 MM월 d일")
                birthDayTxt.text = sdf.format(selectedBirthDay?.time)


            }, 2019, Calendar.DECEMBER, 15)

//            자바에서는 월을 0~11월로 사용함.
//            Calendar 클래스의 변수를 활용해서 월을 입력하면 보기에 직관적.

            datapickerDialog.show()
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
