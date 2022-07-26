package tech.dodd.videopoker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import tech.dodd.videopoker.databinding.ActivityMainBinding;

public class MainJavaActivity extends AppCompatActivity {
    ArrayList<Integer> cards;
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //activityMainBinding.setHandlers(this);

        cards = new ArrayList<>();
        cards.addAll(Arrays.asList(101,102,103,104,105,106,107,108, 109, 110, 111, 112, 113));

        deal();
    }

    public void assignCardValues(int card, TextView text) {
        switch (card) {
            case 101:
                text.setCompoundDrawablesWithIntrinsicBounds(null, ResourcesCompat.getDrawable(getResources(), R.drawable.ace, null),null,null);
                text.setText("A");
                break;
            case 102:
                text.setCompoundDrawablesWithIntrinsicBounds(null, ResourcesCompat.getDrawable(getResources(), R.drawable.two, null),null,null);
                text.setText("2");
                break;
            case 103:
                text.setCompoundDrawablesWithIntrinsicBounds(null, ResourcesCompat.getDrawable(getResources(), R.drawable.three, null),null,null);
                text.setText("3");
                break;
            case 104:
                text.setCompoundDrawablesWithIntrinsicBounds(null, ResourcesCompat.getDrawable(getResources(), R.drawable.four, null),null,null);
                text.setText("4");
                break;
            case 105:
                text.setCompoundDrawablesWithIntrinsicBounds(null, ResourcesCompat.getDrawable(getResources(), R.drawable.five, null),null,null);
                text.setText("5");
                break;
            case 106:
                text.setCompoundDrawablesWithIntrinsicBounds(null, ResourcesCompat.getDrawable(getResources(), R.drawable.six, null),null,null);
                text.setText("6");
                break;
            case 107:
                text.setCompoundDrawablesWithIntrinsicBounds(null, ResourcesCompat.getDrawable(getResources(), R.drawable.seven, null),null,null);
                text.setText("7");
                break;
            case 108:
                text.setCompoundDrawablesWithIntrinsicBounds(null, ResourcesCompat.getDrawable(getResources(), R.drawable.eight, null),null,null);
                text.setText("8");
                break;
            case 109:
                text.setCompoundDrawablesWithIntrinsicBounds(null, ResourcesCompat.getDrawable(getResources(), R.drawable.nine, null),null,null);
                text.setText("9");
                break;
            case 110:
                text.setCompoundDrawablesWithIntrinsicBounds(null, ResourcesCompat.getDrawable(getResources(), R.drawable.ten, null),null,null);
                text.setText(R.string.tentext);
                break;
            case 111:
                text.setCompoundDrawablesWithIntrinsicBounds(null, ResourcesCompat.getDrawable(getResources(), R.drawable.jack, null),null,null);
                text.setText("J");
                break;
            case 112:
                text.setCompoundDrawablesWithIntrinsicBounds(null, ResourcesCompat.getDrawable(getResources(), R.drawable.queen, null),null,null);
                text.setText("Q");
                break;
            case 113:
                text.setCompoundDrawablesWithIntrinsicBounds(null, ResourcesCompat.getDrawable(getResources(), R.drawable.king, null),null,null);
                text.setText("K");
                break;
        }
    }

    public void deal() {
        Collections.shuffle(cards);

        if (activityMainBinding.DrawButton.isChecked()) {
            assignCardValues(cards.get(0), activityMainBinding.Card1text);
            assignCardValues(cards.get(1), activityMainBinding.Card2text);
            assignCardValues(cards.get(2), activityMainBinding.Card3text);
            assignCardValues(cards.get(3), activityMainBinding.Card4text);
            assignCardValues(cards.get(4), activityMainBinding.Card5text);
            activityMainBinding.Card1Button.setChecked(false);
            activityMainBinding.Card2Button.setChecked(false);
            activityMainBinding.Card3Button.setChecked(false);
            activityMainBinding.Card4Button.setChecked(false);
            activityMainBinding.Card5Button.setChecked(false);
            activityMainBinding.Card1Button.setClickable(true);
            activityMainBinding.Card2Button.setClickable(true);
            activityMainBinding.Card3Button.setClickable(true);
            activityMainBinding.Card4Button.setClickable(true);
            activityMainBinding.Card5Button.setClickable(true);
        }else{
            if (!activityMainBinding.Card1Button.isChecked()) {
                assignCardValues(cards.get(0), activityMainBinding.Card1text);
            }
            if (!activityMainBinding.Card2Button.isChecked()) {
                assignCardValues(cards.get(1), activityMainBinding.Card2text);
            }
            if (!activityMainBinding.Card3Button.isChecked()) {
                assignCardValues(cards.get(2), activityMainBinding.Card3text);
            }
            if (!activityMainBinding.Card4Button.isChecked()) {
                assignCardValues(cards.get(3), activityMainBinding.Card4text);
            }
            if (!activityMainBinding.Card5Button.isChecked()) {
                assignCardValues(cards.get(4), activityMainBinding.Card5text);
            }
            activityMainBinding.Card1Button.setClickable(false);
            activityMainBinding.Card2Button.setClickable(false);
            activityMainBinding.Card3Button.setClickable(false);
            activityMainBinding.Card4Button.setClickable(false);
            activityMainBinding.Card5Button.setClickable(false);
        }
    }

    public void draw(View v) {
        deal();
    }
}
