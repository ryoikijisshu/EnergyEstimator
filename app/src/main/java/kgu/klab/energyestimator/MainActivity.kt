package kgu.klab.energyestimator

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.RadioGroup
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //seekBar age
        seekBarAge.setProgress(20)
        seekBarAge.setMax(99)
        var valueAge:Int=20

        seekBarAge.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                //ツマミがドラッグされると呼ばれる
                override fun onProgressChanged(
                    seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                    // 68 % のようにフォーマト、
                    // この場合、Locale.USが汎用的に推奨される
                    valueAge=progress+1
                    val str = String.format(Locale.US, "%d 歳", valueAge)
                    age2.text = str
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {
                    // ツマミがタッチされた時に呼ばれる
                }

                override fun onStopTrackingTouch(seekBar: SeekBar) {
                    // ツマミがリリースされた時に呼ばれる
                }

            })

        //seekBar weight

        seekBarWeight.setProgress(200)
        seekBarWeight.setMax(700)
        var valueWeight:Double=50.0

        seekBarWeight.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                //ツマミがドラッグされると呼ばれる
                override fun onProgressChanged(
                    seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                    // 68 % のようにフォーマト、
                    // この場合、Locale.USが汎用的に推奨される
                    valueWeight=(progress.toDouble()+300)/10
                    val str = String.format(Locale.US, "%.1f kg", valueWeight)
                    weight2.text = str
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {
                    // ツマミがタッチされた時に呼ばれる
                }

                override fun onStopTrackingTouch(seekBar: SeekBar) {
                    // ツマミがリリースされた時に呼ばれる
                }

            })

        //radioButton sex
        var valueSex:Int=0

        val radioGroupSex: RadioGroup = findViewById(R.id.radioGroupSex)
        radioGroupSex.setOnCheckedChangeListener { _, checkedId: Int ->
            when (checkedId) {
                R.id.radioButtonMale -> valueSex=0
                R.id.radioButtonFemale -> valueSex=1
                else -> throw IllegalArgumentException("not supported")
            }
        }

        //radioButton activity
        var valueActivity:Int=0

        val radioGroupActivity: RadioGroup = findViewById(R.id.radioGroupActivity)
        radioGroupActivity.setOnCheckedChangeListener { _, checkedId: Int ->
            when (checkedId) {
                R.id.radioButtonLow -> valueActivity=0
                R.id.radioButtonMid -> valueActivity=1
                R.id.radioButtonHigh -> valueActivity=2
                else -> throw IllegalArgumentException("not supported")
            }
        }

        buttonConfirm.setOnClickListener(){
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("sex",valueSex)
            intent.putExtra("age",valueAge)
            intent.putExtra("weight",valueWeight)
            intent.putExtra("activity",valueActivity)
            startActivity(intent)
        }
    }




}
