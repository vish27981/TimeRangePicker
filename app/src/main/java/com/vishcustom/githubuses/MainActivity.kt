package com.vishcustom.githubuses

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import com.github.ybq.android.spinkit.style.DoubleBounce
import com.vishcustom.githubuses.databinding.ActivityMainBinding
import nl.joery.timerangepicker.TimeRangePicker
import render.animations.Attention
import render.animations.Bounce
import render.animations.Render
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //time range picker

        binding.picker.setOnTimeChangeListener(object : TimeRangePicker.OnTimeChangeListener {
            override fun onStartTimeChange(startTime: TimeRangePicker.Time) {
                Toast.makeText(this@MainActivity, "Start time: "+startTime,Toast.LENGTH_LONG).show()
            }

            override fun onEndTimeChange(endTime: TimeRangePicker.Time) {
                Toast.makeText(this@MainActivity, "End time: " + endTime.hour,Toast.LENGTH_LONG).show()
            }

            override fun onDurationChange(duration: TimeRangePicker.TimeDuration) {
                Toast.makeText(this@MainActivity, "Duration: " + duration.hour,Toast.LENGTH_LONG).show()
            }
        })

        //spin kit
        val doubleBounce =  DoubleBounce()
        binding.spinKit.setIndeterminateDrawable(doubleBounce);

        binding.spinKit.setOnClickListener{val render = Render(this)
            //set Animation
            render.setAnimation(Attention().Flash(binding.spinKit))
            render.start()

        }

        /**
         * binding.button.setOnClickListener{
         *
         *             //normal toast
         *                 MotionToast.createToast(this,"Hurray Success","Upload Completed Successfully!",
         *                 //for dark toast
         *                 //MotionToast.darkToast(this,"Hurray Success","Upload Completed Successfully!",
         *                 MotionToastStyle.SUCCESS,
         *                 MotionToast.GRAVITY_BOTTOM,
         *                 MotionToast.LONG_DURATION,
         *                 ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helvetica_regular))
         */


    }
}