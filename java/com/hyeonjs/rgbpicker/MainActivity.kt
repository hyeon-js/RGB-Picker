package com.hyeonjs.rgbpicker

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = LinearLayout(this)
        layout.orientation = 1

        val txt = TextView(this)
        txt.text = "미리보기"
        txt.textSize = 32f
        txt.setTextColor(Color.BLACK)
        txt.gravity = Gravity.CENTER
        layout.addView(txt)

        val rt = TextView(this)
        rt.text = "R: 0"
        layout.addView(rt)
        val rb = SeekBar(this)
        rb.max = 255
        layout.addView(rb)

        val gt = TextView(this)
        gt.text = "\nG: 0"
        layout.addView(gt)
        val gb = SeekBar(this)
        gb.max = 255
        layout.addView(gb)

        val bt = TextView(this)
        bt.text = "\nB: 0"
        layout.addView(bt)
        val bb = SeekBar(this)
        bb.max = 255
        layout.addView(bb)

        rb.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                rt.text = "R: $progress"
                txt.setTextColor(Color.argb(255, rb.progress, gb.progress, bb.progress))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })
        gb.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                gt.text = "\nG: $progress"
                txt.setTextColor(Color.argb(255, rb.progress, gb.progress, bb.progress))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })
        bb.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                bt.text = "\nB: $progress"
                txt.setTextColor(Color.argb(255, rb.progress, gb.progress, bb.progress))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        val dev = TextView(this)
        dev.text = "\n© 2023 Hyeon.js, All rights reserved.\n"
        dev.textSize = 12f
        dev.gravity = Gravity.CENTER
        layout.addView(dev)
        val pad = dip2px(16)
        layout.setPadding(pad, pad, pad, pad)
        val scroll = ScrollView(this)
        scroll.addView(layout)
        scroll.setBackgroundColor(Color.WHITE)
        setContentView(scroll)
    }

    fun dip2px(dips: Int) = Math.ceil((dips * resources.displayMetrics.density).toDouble()).toInt()

}