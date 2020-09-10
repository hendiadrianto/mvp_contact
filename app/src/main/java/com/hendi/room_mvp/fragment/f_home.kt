package com.hendi.room_mvp.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.hendi.room_mvp.R
import com.hendi.room_mvp.adapter.adapter_user
import com.hendi.room_mvp.helper.SharedPrefManager
import com.hendi.room_mvp.mvp.model.g_user
import com.hendi.room_mvp.mvp.presenter.user_PrestImp
import com.hendi.room_mvp.mvp.view.menu_view
import com.hendi.room_mvp.mvp.view.user_view
import com.hendi.submissiondicoding.Model.ItemOnClick
import kotlinx.android.synthetic.main.f_home.view.*
import java.lang.ClassCastException

@Suppress("DEPRECATION")
class f_home : Fragment(),user_view,menu_view {
    lateinit var mContext : Context

    lateinit var adapterUser : adapter_user
    lateinit var v : View
    lateinit var userPrestImp : user_PrestImp
    lateinit var menuklik : menu_view
    lateinit var sp : SharedPrefManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = layoutInflater.inflate(R.layout.f_home,container,false)
        mContext = this.context!!
        sp = SharedPrefManager(mContext)

        userPrestImp = user_PrestImp(this)
        userPrestImp.user_data()

        sp.saveSPInt(SharedPrefManager.SP_FRAGMENT,0)

        menuklik.menu_klik(0)

        return v
    }

    override fun userResponse(response: List<g_user>) {
        Log.d("response",response.size.toString())
        v.id_rv_main.layoutManager = LinearLayoutManager(mContext)
        adapterUser = adapter_user(mContext, response)
        v.id_rv_main.adapter = adapterUser
        adapterUser.notifyDataSetChanged()
        onClickUser(adapterUser)
    }

    private fun onClickUser(adapterUser: adapter_user) {
        v.id_rv_main.addOnItemTouchListener(ItemOnClick(mContext,object :ItemOnClick.OnItemClickListener{
            override fun onItemClick(view: View, position: Int) {
                sp.saveSPInt(SharedPrefManager.SP_INDEX,position)
                fragmentManager!!.beginTransaction().replace(R.id.id_frame,f_details()).addToBackStack(null).commit()
            }
        }))
    }

    override fun userError(error: String) {
        Toast.makeText(mContext,error,Toast.LENGTH_SHORT).show()
    }

    override fun menu_klik(id: Int) {
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            menuklik = context as menu_view
        } catch (e : ClassCastException){
            e.printStackTrace()
        }
    }

}