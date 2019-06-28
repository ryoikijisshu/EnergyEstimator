package kgu.klab.energyestimator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.reflect.Array.getDouble

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var gender_number:Int = 0
        var weight_number:Int = 60
        var age_number:Int = 40
        var level_of_physical_activity_number:Int = 0

        PreferenceManager.getDefaultSharedPreferences(this).apply {
            val heightVal = getInt("WEIGHT",60)
            val ageVal = getInt("AGE",40);
            weight_number_text.setText(heightVal.toString())
            age_number_text.setText(ageVal.toString())
            seekBar.progress = heightVal
            seekBar2.progress = ageVal
        }
        seekBar.setOnSeekBarChangeListener(
            object :SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    weight_number_text.text = progress.toString()
                    weight_number = progress
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {

                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {

                }
            }
        )
        seekBar2.setOnSeekBarChangeListener(
            object :SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    age_number_text.text = progress.toString()
                      age_number = progress
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {

                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {

                }
            }
        )
        radioGroup.setOnCheckedChangeListener{
            group, checkedId ->
            when(checkedId){
                R.id.men -> gender_number = 1
                R.id.women -> gender_number = 2
            }

        }
        radioGroup2.setOnCheckedChangeListener{
            group, checkedId ->
            when(checkedId){
                R.id.low -> level_of_physical_activity_number = 1
                R.id.medium -> level_of_physical_activity_number = 2
                R.id.high -> level_of_physical_activity_number = 3
            }
        }
        save_button.setOnClickListener {
            val intent = Intent(this,ResultActivity::class.java)
            intent.putExtra("GENDER_KEY",gender_number)
            intent.putExtra("WEIGHT_KEY",weight_number)
            intent.putExtra("AGE_KEY",age_number)
            intent.putExtra("LEVEL_KEY",level_of_physical_activity_number)
            startActivity(intent)
        }



    }



}
