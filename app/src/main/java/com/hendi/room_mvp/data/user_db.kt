package com.hendi.room_mvp.data

import android.util.Log
import com.hendi.room_mvp.mvp.model.g_user

object user_db {

    var data = arrayOf(
        arrayOf(
            "Bambang Sutoyo",
            "https://www.kacyasinda.com/wp-content/uploads/2019/01/birkan-sokullu-410x410.jpg",
            "bambang123@gmail.com",
            "08572345678",
            "Jl. Curug jaya no 65"
        ),
        arrayOf(
            "Irfan Kartono",
            "https://i.pinimg.com/736x/f6/b1/51/f6b15132d42beb9bd7a753f74e863dd0.jpg",
            "Irfan.kartono@gmail.com",
            "082134567879",
            "Jl. Jambu biru no 43"
        ),
        arrayOf(
            "Agus Riyanto",
            "https://4.bp.blogspot.com/-BrvFeLI07wo/TzpPMhznb_I/AAAAAAAAA8w/kqDvqkUVo28/s1600/dude_harlino.jpg",
            "yaya.juju@gmail.com",
            "082198765456",
            "Jl. Kunyit asam no 32"
        ),
        arrayOf(
            "Budi Aji Wibowo",
            "https://get.pxhere.com/photo/man-person-people-boy-cute-male-portrait-child-facial-expression-smile-family-kids-beautiful-smile-little-kids-portrait-photography-807621.jpg",
            "budi.aji33@gmail.com",
            "02167889992",
            "Jl. Senopati baru no 98"
        ),
        arrayOf(
            "Agung Kusnoto",
            "http://4.bp.blogspot.com/-lTUBGqMGsQ4/Uu7v7aIHTZI/AAAAAAAABeM/zGJH2rIzYzo/s1600/gambar+bayi+lucu+tua.jpg",
            "singa.tiger@gmail.com",
            "081237636363",
            "Jl. Pinangsih Ibu no 67"
        ),
        arrayOf(
            "Sri Hartini",
            "https://i.pinimg.com/736x/a0/fc/b1/a0fcb1b0a20567a19da52a600ffe614c.jpg",
            "sri.har@gmail.com",
            "08386777722",
            "Jl. Angakara atas no 38"
        )

    )


    fun getUserDetail (id : Int) : ArrayList<g_user> {
        val list = ArrayList<g_user>()
        for (i in 0..data.size) {
            if (i == id ){
                Log.d("Index Data",i.toString())
                val user = g_user()
                user.name = data[i].get(0)
                user.photo = data[i].get(1)
                user.email = data[i].get(2)
                user.nohp = data[i].get(3)
                user.alamat = data[i].get(4)

                list.add(user)
            }
        }

        return list
    }

    fun getDataUser(): ArrayList<g_user> {
        val list = ArrayList<g_user>()
        for (i in data) {
            val user = g_user()
            user.name = i[0]
            user.photo = i[1]
            user.email = i[2]
            user.nohp = i[3]
            user.alamat = i[4]

            list.add(user)
        }
        return list
    }
}