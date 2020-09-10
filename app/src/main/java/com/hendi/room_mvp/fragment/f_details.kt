package com.hendi.room_mvp.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.hendi.room_mvp.R
import com.hendi.room_mvp.helper.SharedPrefManager
import com.hendi.room_mvp.mvp.model.g_user
import com.hendi.room_mvp.mvp.presenter.user_PrestImp
import com.hendi.room_mvp.mvp.view.menu_view
import com.hendi.room_mvp.mvp.view.user_view
import kotlinx.android.synthetic.main.f_details.view.*
import java.lang.ClassCastException

class f_details : Fragment(),user_view,menu_view {

    lateinit var v : View
    lateinit var sp : SharedPrefManager
    lateinit var mContext : Context
    lateinit var userPrestImp : user_PrestImp
    lateinit var menuKlik : menu_view

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = layoutInflater.inflate(R.layout.f_details,container,false)

        mContext = this.context!!
        sp = SharedPrefManager(mContext)
        userPrestImp = user_PrestImp(this)

        Log.d("Index",sp.spIndex.toString())
        userPrestImp.user_detail(sp.spIndex)

        sp.saveSPInt(SharedPrefManager.SP_FRAGMENT,1)

        menuKlik.menu_klik(1)

        return v
    }

    override fun userResponse(response: List<g_user>) {
        Log.d("Response detail",response.size.toString())
        Glide.with(mContext).load(response[0].photo).into(v.id_image_detail)
        v.id_nama_detail.text = response[0].name
        v.id_nohp_detail.text = response[0].nohp
        v.id_email_detail.text = response[0].email
        v.id_alamat_detail.text = response[0].alamat

    }

    override fun userError(error: String) {

    }

    override fun menu_klik(id: Int) {}

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            menuKlik = context as menu_view
        } catch (e : ClassCastException){
            e.printStackTrace()
        }
    }
}