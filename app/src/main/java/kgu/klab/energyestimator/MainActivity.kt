package kgu.klab.energyestimator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var sex:Int=1
        var weight:Int=0
        var age:Int=0
        var level:Int=1
        sex_group.setOnCheckedChangeListener{
            group,checkedId ->
            when(checkedId)
            {
                R.id.sex1 ->sex=1
                R.id.sex2 ->sex=2
            }
        }
        level_group.setOnCheckedChangeListener{
                group,checkedId ->
            when(checkedId)
            {
                R.id.level1 ->level=1
                R.id.level2 ->level=2
                R.id.level3 ->level=3
            }
        }
        seekbar.setOnSeekBarChangeListener(
            object:SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(seekBar: SeekBar?,progress: Int,fromUser: Boolean ){
                    weighttext1.text=progress.toString()
                    weight=progress
                }

                override fun onStartTrackingTouch(seekBar:SeekBar?) {
                }
                override fun onStopTrackingTouch(seekBar:SeekBar?) {
                }

            }
        )
        seekBar2.setOnSeekBarChangeListener(
            object:SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(seekBar: SeekBar?,progress: Int,fromUser: Boolean ){
                    agetext1.text=progress.toString()
                    age=progress
                }

                override fun onStartTrackingTouch(seekBar:SeekBar?) {
                }
                override fun onStopTrackingTouch(seekBar:SeekBar?) {
                }

            }
        )
       button.setOnClickListener{
            val intent= Intent(this,ContextActivity::class.java)
            intent.putExtra("SEX_KEY",sex)
            intent.putExtra("WEIGHT_KEY",weight)
            intent.putExtra("AGE_KEY",age)
            intent.putExtra("LEVEL_KEY",level)
            startActivity(intent)
        }
    }


}
