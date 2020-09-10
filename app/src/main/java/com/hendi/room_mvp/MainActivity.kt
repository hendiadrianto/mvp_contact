package com.hendi.room_mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import com.hendi.room_mvp.fragment.f_details
import com.hendi.room_mvp.fragment.f_home
import com.hendi.room_mvp.helper.SharedPrefManager
import com.hendi.room_mvp.mvp.view.menu_view
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),menu_view {
    lateinit var sp : SharedPrefManager
    var id_klik = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sp = SharedPrefManager(this)
        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction().replace(R.id.id_frame,f_home()).commit()
        }

        menu_pilih()


    }

    private fun menu_pilih() {
        if (id_klik != 0){
            id_menu_home.setOnClickListener {
                supportFragmentManager.beginTransaction().replace(R.id.id_frame,f_home()).commit()
            }
        }

        if (id_klik != 1){
            id_menu_details.setOnClickListener {
                supportFragmentManager.beginTransaction().replace(R.id.id_frame,f_details()).commit()
            }
        }
    }

    override fun menu_klik(id: Int) {
        id_klik = id
        menu_pilih()

        if (id == 0){
            id_toolbar.text = "Contact App"
            id_phone_book.visibility = View.VISIBLE
            id_phone_book_warna.visibility = View.GONE

            id_contact_warna.visibility = View.VISIBLE
            id_contact_abu.visibility = View.GONE
        } else {
            id_toolbar.text = "Contact Details"
            id_contact_warna.visibility = View.GONE
            id_contact_abu.visibility = View.VISIBLE

            id_phone_book.visibility = View.GONE
            id_phone_book_warna.visibility = View.VISIBLE


        }
    }

}