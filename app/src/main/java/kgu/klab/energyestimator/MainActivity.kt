package kgu.klab.energyestimator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var n_sex = 0
    var n_wei = 0
    var n_old = 0
    var n_act = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        w_seekBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(seekBar:SeekBar, progress: Int, fromUser: Boolean) {
                    val str = String.format(Locale.US, "%d kg", progress)
                    w_textView.text = str

                    n_wei = progress
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {

                }

                override fun onStopTrackingTouch(seekBar: SeekBar) {

                }
            }
        )

        o_seekBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(seekBar:SeekBar, progress: Int, fromUser: Boolean) {
                    val str = String.format(Locale.US, "%d 歳", progress)
                    o_textView.text = str

                    n_old = progress
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {

                }

                override fun onStopTrackingTouch(seekBar: SeekBar) {

                }
            }
        )

        val sexGroup: RadioGroup = findViewById(R.id.sex_radioGroup)
        sexGroup.setOnCheckedChangeListener{ _, checkedId: Int ->
            when(checkedId){
                R.id.man_radio -> n_sex = 0
                R.id.woman_radio -> n_sex = 1
            }
        }

        val actGroup: RadioGroup = findViewById(R.id.act_radioGroup)
        actGroup.setOnCheckedChangeListener{ _, checkedId: Int ->
            when(checkedId){
                R.id.s_radio -> n_act = 0
                R.id.m_radio -> n_act = 1
                R.id.h_radio -> n_act = 2
            }
        }
    }

    fun onButtonTapped(view: View?){
        val intent =  Intent(this, Main2Activity::class.java)
        intent.putExtra("Sex",n_sex)
        intent.putExtra("Weight",n_wei)
        intent.putExtra("Old",n_old)
        intent.putExtra("Activity",n_act)
        startActivity(intent)
    }
}
