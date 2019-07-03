package kgu.klab.energyestimator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_check.*

class CheckActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check)

        PreferenceManager.getDefaultSharedPreferences(this).apply {
            sexCheck.setText(getString("SEX", ""))
            weightCheck.setText(getInt("WEIGHT", 0).toString())
            ageCheck.setText(getInt("AGE", 0).toString())
            levelCheck.setText(getString("LEVEL", ""))
        }

        yesButton.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            startActivity(intent)
        }

        noButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
