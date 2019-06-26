package kgu.klab.energyestimator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AbsListView
import android.widget.RadioButton
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var weight = 0
    var age = 0
    var gender = 0
    var level = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weightseekBar.setProgress(0)
        weightseekBar.setMax(150)
        ageseekBar.setProgress(0)
        ageseekBar.setMax(120)

        weightseekBar.setOnSeekBarChangeListener(
                object : SeekBar.OnSeekBarChangeListener{
                    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                        textview1.text = progress.toString() + "kg"
                        weight = progress
                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar?) {}
                    override fun onStopTrackingTouch(seekBar: SeekBar?) {}
                }
                )
        ageseekBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    textview2.text = progress.toString() + "歳"
                    age = progress
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {}
                override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            }
        )
        gendergroup.setOnCheckedChangeListener{
            group, checkedId ->
            when(checkedId){
                R.id.man -> gender = 1
                R.id.woman -> gender = 2
            }
        }
        levelgroup.setOnCheckedChangeListener{
                group, checkedId ->
            when(checkedId){
                R.id.low -> level = 1
                R.id.middle -> level = 2
                R.id.high -> level = 3
            }
        }
        nextbutton.setOnClickListener { onnextbuttonTapped(it) }
    }
    fun onnextbuttonTapped(view: View?){
        val intent = Intent(this,ResultActivity::class.java)
        intent.putExtra("weight",weight)
        intent.putExtra("age",age)
        intent.putExtra("gender",gender)
        intent.putExtra("level",level)
        startActivity(intent)
    }
}
