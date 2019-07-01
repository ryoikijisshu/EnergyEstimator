package kgu.klab.energyestimator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.RadioButton
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.age_result
import kotlinx.android.synthetic.main.activity_main.level
import kotlinx.android.synthetic.main.activity_main.seibetu
import kotlinx.android.synthetic.main.activity_main.weight_result

class MainActivity : AppCompatActivity() {

    var seibetu_result: String =""
    var level_result: String =""
    var weightval:Int =0
    var ageval:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*PreferenceManager.getDefaultSharedPreferences(this).apply {

            weightval = getInt("WEIGHT",0)
            weight_result.setText(weightval.toString())
            seekBar.progress = weightval

            ageval = getInt("AGE",0)

            age_result.setText(ageval.toString())
            seekBar.progress = ageval

        }*/

        seekBar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                weight_result.text = progress.toString()
                weightval=progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        seekBar2.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                age_result.text = progress.toString()
                ageval=progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        seibetu.setOnCheckedChangeListener{
            group, checkedId -> seibetu_result = findViewById<RadioButton>(checkedId).text as String
            //intent.putExtra("seibetu",seibetu_result)
            //Log.d("ashida",seibetu_result)
        }

        level.setOnCheckedChangeListener{
                group, checkedId -> level_result = findViewById<RadioButton>(checkedId).text as String
                intent.putExtra("seibetu",level_result)
        }
    }

    fun onCalculateButtonTapped(view: View?){

        val intent = Intent(this,Result::class.java)

        intent.putExtra("age",ageval)
        intent.putExtra("weight",weightval)
        intent.putExtra("seibetu",seibetu_result)
        intent.putExtra("level",level_result)


        startActivity(intent)

    }

}


