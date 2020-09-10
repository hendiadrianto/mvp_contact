package com.hendi.room_mvp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import com.hendi.room_mvp.helper.isUser
import com.hendi.room_mvp.helper.isValidEmail
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        textWatcher()

        id_btn_login.setOnClickListener {
            if(validation()){
                startActivity(Intent(this,MainActivity::class.java))
            }
        }

    }

    private fun textWatcher() {
        id_user_login.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s!!.length > 0){
                    id_l_user.error = null
                }
            }
        })

        id_email_login.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s!!.length > 0){
                    if (isValidEmail(s.toString())){
                        id_l_email.error = null
                    } else {
                        id_l_email.error = "Format email belum sesuai !"
                    }
                } else {
                    id_l_email.error = "E-mail masih kosong !"
                }
            }
        })

        id_pass_login.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s!!.length > 0){
                    id_l_pass.error = null
                }
            }
        })
    }

    private fun validation() : Boolean {
        if (TextUtils.isEmpty(id_user_login.text.toString())){
            id_l_user.error = "Username masih kosong !"
            return false
        }

        if (TextUtils.isEmpty(id_email_login.text.toString())){
            id_l_email.error = "E-mail masih kosong !"
            return false
        }

        if (TextUtils.isEmpty(id_pass_login.text.toString()) || id_pass_login.text!!.toString().length < 6){
            id_l_pass.error = "Password masih kosong / kurang dari 6 karakter!"
            return false
        }



        return true
    }


}