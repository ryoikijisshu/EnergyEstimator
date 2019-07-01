package kgu.klab.energyestimator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.RadioButton
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var gender:Int=1
        var active:Int=2
        var weight:Int=weightBar.progress
        var age:Int=ageBar.progress

        weightText.setText(weightBar.progress.toString()+"kg")
        ageText.setText(ageBar.progress.toString()+"歳")

        genderGroup.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId) {
                R.id.man->gender=1
                R.id.woman->gender=2
            }

        }

        activeGroup.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId) {
                R.id.low->active=1
                R.id.medium->active=2
                R.id.high->active=3
            }

        }

        weightBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    weightText.text = progress.toString()+"kg"
                    weight=progress
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {}

                override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            }
        )

        ageBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    ageText.text = progress.toString()+"歳"
                    age=progress
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {}

                override fun onStopTrackingTouch(seekBar: SeekBar?) {}
            }
        )

        save.setOnClickListener { //onsaveButtonTapped(it)
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("GENDER", gender)
            intent.putExtra("ACTIVE", active)
            intent.putExtra("WEIGHT", weight)
            intent.putExtra("AGE", age)
            startActivity(intent)

        }
    }
}

