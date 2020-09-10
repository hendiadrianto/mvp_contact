package com.hendi.room_mvp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hendi.room_mvp.R
import com.hendi.room_mvp.mvp.model.g_user
import kotlinx.android.synthetic.main.c_userlist.view.*

class adapter_user(internal var mContext : Context,internal var list : List<g_user>) : RecyclerView.Adapter<adapter_user.viewUser>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapter_user.viewUser {
        val v = LayoutInflater.from(mContext).inflate(R.layout.c_userlist,parent,false)

        return viewUser(v)
    }

    inner class viewUser(v : View) : RecyclerView.ViewHolder(v){
        fun data(item: g_user, position: Int) {
            itemView.id_nama_cuser.text = item.name
            itemView.id_email_cuser.text = item.email
            itemView.id_nohp_cuser.text = item.nohp
            Glide.with(mContext).load(item.photo).into(itemView.id_photo_cuser)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: adapter_user.viewUser, position: Int) {
        holder.data(list[position],position)
    }
}