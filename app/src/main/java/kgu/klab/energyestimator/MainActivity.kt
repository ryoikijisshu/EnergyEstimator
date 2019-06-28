package kgu.klab.energyestimator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.reflect.Array.getInt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var gender= 0
        var level = 0

        radioGroup.setOnCheckedChangeListener{
            group,checkedId ->
            when(checkedId)
            {
                R.id.boyButton -> gender = 1
                R.id.girlButton -> gender = 2

            }
        }
        radioGroup2.setOnCheckedChangeListener{
                group,checkedId ->
            when(checkedId)
            {
                R.id.lowButton -> level = 1
                R.id.middleButton -> level = 2
                R.id.highButton -> level = 3

            }
        }

        var weightvalue : Int = 70
        var agevalue : Int = 20


        PreferenceManager.getDefaultSharedPreferences(this).apply{
            val weightval = getInt("WEIGHT",70)
            val ageval = getInt("AGE",20)
            weighttext.setText(weightval.toString())
            agetext.setText(ageval.toString())
            seekbar1.progress = weightval
            seekbar2.progress = ageval
        }

        seekbar1.setOnSeekBarChangeListener(
                object : SeekBar.OnSeekBarChangeListener{
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        weighttext.text = progress.toString()
                        weightvalue=progress

                    }
                    override
                    fun onStartTrackingTouch(seekBar: SeekBar?) {}
                    override
                    fun onStopTrackingTouch(seekBar: SeekBar?) {}
            })

        seekbar2.setOnSeekBarChangeListener(
                object : SeekBar.OnSeekBarChangeListener{
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        agetext.text = progress.toString()
                        agevalue = progress
                    }
                    override
                    fun onStartTrackingTouch(seekBar: SeekBar?) {}

                    override
                    fun onStopTrackingTouch(seekBar: SeekBar?) {}
                })

        button.setOnClickListener{
            val intent = Intent(this,ResultActivity::class.java)
            intent.putExtra("gender",gender)
            intent.putExtra("weight",weightvalue)
            intent.putExtra("age",agevalue)
            intent.putExtra("level",level)
            startActivity(intent)
        }
    }

    //override fun onPause() {
    //    super.onPause()
    //    PreferenceManager.getDefaultSharedPreferences(this).edit()
    //        .putInt("WEIGHT",textview1.text.toString().toInt())
     //      .apply()
     //   PreferenceManager.getDefaultSharedPreferences(this).edit()
     //       .putInt("AGE",textview2.text.toString().toInt())
     //       .apply()
    //}


}
