package com.hendi.room_mvp.mvp.presenter

import android.util.Log
import com.hendi.room_mvp.data.user_db
import com.hendi.room_mvp.mvp.model.g_user
import com.hendi.room_mvp.mvp.view.user_view

class user_PrestImp (view : user_view) : user_prest{
    var usermodel : user_view? = null
    var listUser : MutableList<g_user> = ArrayList()

    init {
        usermodel = view
    }

    override fun user_data() {
        val data = user_db.getDataUser()
        Log.d("Prest response Data",data.size.toString())
        if (data.size > 0){
            usermodel!!.userResponse(data)
        } else {
            usermodel!!.userError("Data kosong")
        }
    }

    override fun user_detail(id: Int) {
        val data = user_db.getUserDetail(id)
        Log.d("Prest response Detail",data.size.toString())
        if (data.size > 0){
            usermodel!!.userResponse(data)
        } else {
            usermodel!!.userError("Data kosong")
        }
    }
}