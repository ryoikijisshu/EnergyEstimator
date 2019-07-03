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

        var sexID: String = ""
        var levelID: String = ""
        var weightVal: Int = 0
        var ageVal: Int = 0

        sexSelect.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.male -> sexID = "男性"
                R.id.female -> sexID = "女性"
            }
        }

        weightSeek.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                    weightResult.setText(p1.toString())
                    weightVal = p1
                }
                override fun onStartTrackingTouch(p0: SeekBar?) {}
                override fun onStopTrackingTouch(p0: SeekBar?) {}

            }
        )

        ageSeek.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                    ageResult.setText(p1.toString())
                    ageVal = p1
                }
                override fun onStartTrackingTouch(p0: SeekBar?) {}
                override fun onStopTrackingTouch(p0: SeekBar?) {}

            }
        )

        levelSelect.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.level1 -> levelID = "低"
                R.id.level2 -> levelID = "中"
                R.id.level3 -> levelID = "高"
            }
        }

        /*
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        pref.apply {
            val editSex = getString("SEX", "")
            val editHeight = getString("HEIGHT", "")
            val editWeight = getString("WEIGHT", "")
            val editLevel = getString("LEVEL", "")
        }
        */


        calcButton.setOnClickListener {
            val pref = PreferenceManager.getDefaultSharedPreferences(this)
            val editor = pref.edit()
            editor.putString("SEX", sexID)
                  .putInt("WEIGHT", weightVal)
                  .putInt("AGE", ageVal)
                  .putString("LEVEL", levelID)
                  .apply()

            val intent = Intent(this, CheckActivity::class.java)
            startActivity(intent)
        }
    }
}
