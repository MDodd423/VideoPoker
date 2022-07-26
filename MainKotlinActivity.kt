package tech.dodd.videopoker

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import tech.dodd.videopoker.databinding.ActivityMainBinding

class MainKotlinActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var cards: MutableList<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.handlers = this

        cards = mutableListOf(101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113)

        deal()
    }

    private fun assignCardValues(card: Int, text: TextView) {
        when (card) {
            101 -> {
                text.setCompoundDrawablesWithIntrinsicBounds(null, ResourcesCompat.getDrawable(resources, R.drawable.ace, null), null, null)
                text.text = "A"
            }
            102 -> {
                text.setCompoundDrawablesWithIntrinsicBounds(null, ResourcesCompat.getDrawable(resources, R.drawable.two, null), null, null)
                text.text = "2"
            }
            103 -> {
                text.setCompoundDrawablesWithIntrinsicBounds(null, ResourcesCompat.getDrawable(resources, R.drawable.three, null), null, null)
                text.text = "3"
            }
            104 -> {
                text.setCompoundDrawablesWithIntrinsicBounds(null, ResourcesCompat.getDrawable(resources, R.drawable.four, null), null, null)
                text.text = "4"
            }
            105 -> {
                text.setCompoundDrawablesWithIntrinsicBounds(null, ResourcesCompat.getDrawable(resources, R.drawable.five, null), null, null)
                text.text = "5"
            }
            106 -> {
                text.setCompoundDrawablesWithIntrinsicBounds(null, ResourcesCompat.getDrawable(resources, R.drawable.six, null), null, null)
                text.text = "6"
            }
            107 -> {
                text.setCompoundDrawablesWithIntrinsicBounds(null, ResourcesCompat.getDrawable(resources, R.drawable.seven, null), null, null)
                text.text = "7"
            }
            108 -> {
                text.setCompoundDrawablesWithIntrinsicBounds(null, ResourcesCompat.getDrawable(resources, R.drawable.eight, null), null, null)
                text.text = "8"
            }
            109 -> {
                text.setCompoundDrawablesWithIntrinsicBounds(null, ResourcesCompat.getDrawable(resources, R.drawable.nine, null), null, null)
                text.text = "9"
            }
            110 -> {
                text.setCompoundDrawablesWithIntrinsicBounds(null, ResourcesCompat.getDrawable(resources, R.drawable.ten, null), null, null)
                text.text = getString(R.string.tentext)
            }
            111 -> {
                text.setCompoundDrawablesWithIntrinsicBounds(null, ResourcesCompat.getDrawable(resources, R.drawable.jack, null), null, null)
                text.text = "J"
            }
            112 -> {
                text.setCompoundDrawablesWithIntrinsicBounds(null, ResourcesCompat.getDrawable(resources, R.drawable.queen, null), null, null)
                text.text = "Q"
            }
            113 -> {
                text.setCompoundDrawablesWithIntrinsicBounds(null, ResourcesCompat.getDrawable(resources, R.drawable.king, null), null, null)
                text.text = "K"
            }
        }
    }

    fun draw(v: View) {
        if (v.id == R.id.DrawButton) {
            deal()
        }
    }

    private fun deal() {
        cards.shuffle()

        binding.apply {
            if (DrawButton.isChecked) {
                assignCardValues(cards[0] as Int, Card1text)
                assignCardValues(cards[1] as Int, Card2text)
                assignCardValues(cards[2] as Int, Card3text)
                assignCardValues(cards[3] as Int, Card4text)
                assignCardValues(cards[4] as Int, Card5text)
                Card1Button.isChecked = false
                Card2Button.isChecked = false
                Card3Button.isChecked = false
                Card4Button.isChecked = false
                Card5Button.isChecked = false
                Card1Button.isClickable = true
                Card2Button.isClickable = true
                Card3Button.isClickable = true
                Card4Button.isClickable = true
                Card5Button.isClickable = true
            } else {
                if (!Card1Button.isChecked) {
                    assignCardValues(cards[0] as Int, Card1text)
                }
                if (!Card2Button.isChecked) {
                    assignCardValues(cards[1] as Int, Card2text)
                }
                if (!Card3Button.isChecked) {
                    assignCardValues(cards[2] as Int, Card3text)
                }
                if (!Card4Button.isChecked) {
                    assignCardValues(cards[3] as Int, Card4text)
                }
                if (!Card5Button.isChecked) {
                    assignCardValues(cards[4] as Int, Card5text)
                }
                Card1Button.isClickable = false
                Card2Button.isClickable = false
                Card3Button.isClickable = false
                Card4Button.isClickable = false
                Card5Button.isClickable = false
            }
        }
    }
}