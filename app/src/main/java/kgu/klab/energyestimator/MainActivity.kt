package kgu.klab.energyestimator

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.RadioButton
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.reflect.Array.getInt

class MainActivity : AppCompatActivity() {

    lateinit var prefs : PreferenceManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var weightt = 0
        var agee = 0



        seekBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener{

                override fun onProgressChanged(seekBar: SeekBar?,
                                           progress: Int,
                                           fromUser: Boolean){
                weight_value.text = progress.toString()
                    weightt = progress
            }
                override
                fun onStartTrackingTouch(seekBar: SeekBar?){}

                override
                fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        seekBar2.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener{

                override fun onProgressChanged(seekBar: SeekBar?,
                                               progress: Int,
                                               fromUser: Boolean){
                    age_value.text = progress.toString()
                    agee = progress
                }
                override
                fun onStartTrackingTouch(seekBar: SeekBar?){}

                override
                fun onStopTrackingTouch(seekBar: SeekBar?) {}
            })

        radioGroup.setOnCheckedChangeListener{
            group, checkedId ->
                //sex_value.text = findViewById<RadioButton>(checkedId).text
        }

        radioGroup2.setOnCheckedChangeListener{
            group, checkedId ->
                //level_value.text = findViewById<RadioButton>(checkedId).text
        }

        button.setOnClickListener{
            val intent = Intent(this, ResultActivity::class.java)
            val checkedId = radioGroup.checkedRadioButtonId
            val checkedId2 = radioGroup2.checkedRadioButtonId
            intent.putExtra("Sex",checkedId)
            intent.putExtra("Level",checkedId2)
            intent.putExtra("Weight",weightt)
            intent.putExtra("Age",agee)
            startActivity(intent)
        }

    }




}
