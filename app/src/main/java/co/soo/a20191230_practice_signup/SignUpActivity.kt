package co.soo.a20191230_practice_signup

import android.os.Bundle

//    SignUpActivity로 변경함!
class SignUpActivity : BaseActivity() {

    var lastBackTimeValue = 0L


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        setupEvents()
        setValues()

    }


    override fun setupEvents() {

        lastBackTimeValue = 10L

    }

    override fun setValues() {

        lastBackTimeValue = 20L

    }

}
