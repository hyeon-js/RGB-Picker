package com.hyeonjs.rgbpicker

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
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
        txt.textSize = 24f
        txt.setTextColor(Color.BLACK)
        layout.addView(txt)

        val rt = TextView(this)
        rt.text = "R: 0"
        layout.addView(rt)
        val rb = SeekBar(this)
        rb.max = 255
        layout.addView(rb)

        val gt = TextView(this)
        gt.text = "R: 0"
        layout.addView(gt)
        val gb = SeekBar(this)
        gb.max = 255
        layout.addView(gb)

        val bt = TextView(this)
        bt.text = "R: 0"
        layout.addView(bt)
        val bb = SeekBar(this)
        bb.max = 255
        layout.addView(bb)

        gb.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                gt.text = "R: $progress"
                txt.setTextColor(Color.argb(255, rb.progress, gb.progress, bb.progress))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })
        rb.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                rt.text = "G: $progress"
                txt.setTextColor(Color.argb(255, rb.progress, gb.progress, bb.progress))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })
        bb.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                bt.text = "B: $progress"
                txt.setTextColor(Color.argb(255, rb.progress, gb.progress, bb.progress))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        val scroll = ScrollView(this)
        scroll.addView(layout)
        scroll.setBackgroundColor(Color.WHITE)
        setContentView(scroll)
    }
}