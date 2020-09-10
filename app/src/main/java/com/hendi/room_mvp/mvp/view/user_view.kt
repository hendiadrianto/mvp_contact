package com.hendi.room_mvp.mvp.view

import com.hendi.room_mvp.mvp.model.g_user

interface user_view {
    fun userResponse(response : List<g_user>)
    fun userError (error : String)
}