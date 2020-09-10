package com.hendi.room_mvp.helper

import android.content.Context
import android.content.SharedPreferences

class SharedPrefManager(context: Context) {

    internal var sp: SharedPreferences
    internal var spEditor: SharedPreferences.Editor

    val spIndex: Int
        get() = sp.getInt(SP_INDEX, 0)
    val spFragment: Int
        get() = sp.getInt(SP_FRAGMENT, 0)


    init {
        sp = context.getSharedPreferences(SP_APP, Context.MODE_PRIVATE)
        spEditor = sp.edit()
    }

    fun saveSPInt(keySP: String, value: Int) {
        spEditor.putInt(keySP, value)
        spEditor.commit()
    }


    companion object {
        val SP_APP = "spCRMApp"

        val SP_INDEX = "index"
        val SP_FRAGMENT = "fragment"
    }


}