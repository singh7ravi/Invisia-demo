package com.example.invisiademo.presentation.ui.gallery

import android.os.Bundle
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.invisiademo.databinding.ActivityDetailsViewBinding
import com.example.myapplication.common.Constant


class DetailsViewActivity : AppCompatActivity() {

    private var _binding: ActivityDetailsViewBinding? = null
    private var _decorView: View? = null
    private var _tapDetector: GestureDetector? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _decorView = window.decorView
        hideSystemUI()

        _binding = ActivityDetailsViewBinding.inflate(layoutInflater)
        setContentView(_binding!!.root)
        _tapDetector = GestureDetector(this,
            object : SimpleOnGestureListener() {
                override fun onSingleTapUp(e: MotionEvent): Boolean {
                    val visible =
                        _decorView!!.systemUiVisibility and View.SYSTEM_UI_FLAG_HIDE_NAVIGATION == 0
                    if (visible) hideSystemUI() else showSystemUI()
                    return true
                }
            })

        intent.extras?.let {
            val newTitle = it.getString(Constant.KEY_TITLE)
            var imgRes = it.getInt(Constant.KEY_IMG_RES)

            _binding?.collapsingToolbarLayout?.title = newTitle
            _binding?.backgroudImage?.setImageResource(imgRes)
        }
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        _tapDetector!!.onTouchEvent(ev!!)
        return super.dispatchTouchEvent(ev)
    }
    private fun hideSystemUI() {
        val uiOptions = (View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION)
        _decorView!!.systemUiVisibility = uiOptions
    }

    private fun showSystemUI() {
        val uiOptions = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION)
        _decorView!!.systemUiVisibility = uiOptions
    }

    override fun onResume() {
        hideSystemUI()
        super.onResume()
    }
}