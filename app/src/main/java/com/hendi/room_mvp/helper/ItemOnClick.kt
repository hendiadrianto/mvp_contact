package com.hendi.submissiondicoding.Model

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemOnClick(mContext : Context,private val mListener : OnItemClickListener?) : RecyclerView.OnItemTouchListener {
    internal var mGestureDetector: GestureDetector
    interface OnItemClickListener{
        fun onItemClick(view : View,position: Int)
    }

    init {
        mGestureDetector = GestureDetector(mContext, object : GestureDetector.SimpleOnGestureListener() {
            override fun onSingleTapUp(e: MotionEvent): Boolean {
                return true
            }
        })
    }

    override fun onTouchEvent(p0: RecyclerView, p1: MotionEvent) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onInterceptTouchEvent(p0: RecyclerView, p1: MotionEvent): Boolean {
        val childView = p0!!.findChildViewUnder(p1!!.x,p1.y)
        if (childView != null && mListener != null && mGestureDetector.onTouchEvent(p1)){
            mListener.onItemClick(childView,p0.getChildAdapterPosition(childView))
        }
        return false
    }

    override fun onRequestDisallowInterceptTouchEvent(p0: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}