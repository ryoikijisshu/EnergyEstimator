package kgu.klab.energyestimator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val sexid = intent.getIntExtra("Sex", 0)
        val weightid = intent.getIntExtra("Weight", 0)
        val oldid = intent.getIntExtra("Old", 0)
        val activityid = intent.getIntExtra("Sex", 0)

        var t = 0.0
        var s = 0.0
        var estimate = 0.0

        when (sexid) {
            0 -> when (oldid) {
                in 1..2 -> t = 61.0
                in 3..5 -> t = 54.8
                in 6..7 -> t = 44.3
                in 8..9 -> t = 40.8
                in 10..11 -> t = 37.4
                in 12..14 -> t = 31.0
                in 15..17 -> t = 27.0
                in 18..29 -> t = 24.0
                in 30..49 -> t = 22.3
                in 50..69 -> t = 21.5
                in 70..100 -> t = 21.5
            }
            1 -> when (oldid) {
                in 1..2 -> t = 59.7
                in 3..5 -> t = 52.2
                in 6..7 -> t = 41.9
                in 8..9 -> t = 38.3
                in 10..11 -> t = 34.8
                in 12..14 -> t = 29.6
                in 15..17 -> t = 25.3
                in 18..29 -> t = 22.1
                in 30..49 -> t = 21.7
                in 50..69 -> t = 20.7
                in 70..100 -> t = 20.7
            }
        }

        when (activityid) {
            0 -> when (oldid) {
                in 1..2 -> s = 1.0
                in 3..5 -> s = 1.0
                in 6..7 -> s = 1.35
                in 8..9 -> s = 1.40
                in 10..11 -> s = 1.45
                in 12..14 -> s = 1.45
                in 15..17 -> s = 1.55
                in 18..29 -> s = 1.50
                in 30..49 -> s = 1.50
                in 50..69 -> s = 1.50
                in 70..100 -> s = 1.45
            }
            1 -> when (oldid) {
                in 1..2 -> s = 1.35
                in 3..5 -> s = 1.45
                in 6..7 -> s = 1.55
                in 8..9 -> s = 1.60
                in 10..11 -> s = 1.65
                in 12..14 -> s = 1.65
                in 15..17 -> s = 1.75
                in 18..29 -> s = 1.75
                in 30..49 -> s = 1.75
                in 50..69 -> s = 1.75
                in 70..100 -> s = 1.70
            }
            2 -> when (oldid) {
                in 1..2 -> s = 1.0
                in 3..5 -> s = 1.0
                in 6..7 -> s = 1.75
                in 8..9 -> s = 1.80
                in 10..11 -> s = 1.85
                in 12..14 -> s = 1.85
                in 15..17 -> s = 1.95
                in 18..29 -> s = 2.00
                in 30..49 -> s = 2.00
                in 50..69 -> s = 2.00
                in 70..100 -> s = 1.95
            }
        }
        //推定エネルギー必要量(kcal/日)= 基礎代謝基準値 * 体重(kg) * 身体活動レベル指数
        estimate = t * weightid * s
        energy.setText(estimate.toString())

        b_back.setOnClickListener{
            finish()
        }
    }
}