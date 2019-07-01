package kgu.klab.energyestimator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var gender = 1
        var level = 1
        var weight = 0
        var age = 0

        weightView.text = weight.toString()+"kg"
        ageView.text = age.toString()+"歳"

        seekBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    weightView.text = progress.toString()+"kg"
                    weight = progress
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {}

                override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            }
        )
        seekBar2.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    ageView.text = progress.toString()+"歳"
                    age = progress
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {}

                override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            }
        )

        genderGroup.setOnCheckedChangeListener{
            group, checkedID ->
            when(checkedID){
                R.id.man -> gender = 1
                R.id.woman -> gender = 2
            }
        }

        activitylevel.setOnCheckedChangeListener{
                group, checkedID ->
            when(checkedID){
                R.id.low -> level = 1
                R.id.medium -> level = 2
                R.id.high -> level = 3
            }
        }

        decision.setOnClickListener {
            val intent = Intent(this,ResultActivity::class.java)
            intent.putExtra("gender", gender)
            intent.putExtra("weight", weight)
            intent.putExtra("age", age)
            intent.putExtra("level", level)
            startActivity(intent)
        }
    }



}
