package com.example.colorpicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout containerMain;

    private TextView textViewRed;
    private TextView textViewGreen;
    private TextView textViewBlue;

    private SeekBar seekBarRed;
    private SeekBar seekBarGreen;
    private SeekBar seekBarBlue;

    private View viewColor;

    private int red;
    private int green;
    private int blue;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initValues();
        initViews();
    }

    private void initValues() {
        red = 255;
        green = 67;
        blue = 42;
    }

    private void initViews() {
        containerMain = (ConstraintLayout)findViewById(R.id.container_main);

        textViewRed = (TextView)findViewById(R.id.text_view_red);
        textViewGreen = (TextView)findViewById(R.id.text_view_green);
        textViewBlue = (TextView)findViewById(R.id.text_view_blue);

        seekBarRed = (SeekBar)findViewById(R.id.seek_bar_red);
        seekBarGreen = (SeekBar)findViewById(R.id.seek_bar_green);
        seekBarBlue = (SeekBar)findViewById(R.id.seek_bar_blue);

        viewColor = (View)findViewById(R.id.view_color);

        seekBarRed.setProgress(red);
        seekBarRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(final SeekBar seekBar, final int progress, final boolean fromUser){
                red = progress;
                updateColor();
            }

            @Override
            public void onStartTrackingTouch(final SeekBar seekBar){

            }

            @Override
            public void onStopTrackingTouch(final SeekBar seekBar){

            }
        });

        seekBarGreen.setProgress(green);
        seekBarGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(final SeekBar seekBar, final int progress, final boolean fromUser){
                green = progress;
                updateColor();
            }

            @Override
            public void onStartTrackingTouch(final SeekBar seekBar){

            }

            @Override
            public void onStopTrackingTouch(final SeekBar seekBar){

            }
        });

        seekBarBlue.setProgress(blue);
        seekBarBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(final SeekBar seekBar, final int progress, final boolean fromUser){
                blue = progress;
                updateColor();
            }

            @Override
            public void onStartTrackingTouch(final SeekBar seekBar){

            }

            @Override
            public void onStopTrackingTouch(final SeekBar seekBar){

            }
        });

        updateColor();

        containerMain.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout(){
                containerMain.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                int screenWidth = containerMain.getWidth();

                int redWidth = textViewRed.getWidth();
                int greenWidth = textViewGreen.getWidth();
                int blueWidth = textViewBlue.getWidth();

                int size48dp = Util.convertDpToPx(48);

                ViewGroup.LayoutParams layoutParams = seekBarRed.getLayoutParams();
                layoutParams.width = screenWidth - size48dp - redWidth;
                seekBarRed.setLayoutParams(layoutParams);

                layoutParams = seekBarGreen.getLayoutParams();
                layoutParams.width = screenWidth - size48dp - greenWidth;
                seekBarGreen.setLayoutParams(layoutParams);

                layoutParams = seekBarBlue.getLayoutParams();
                layoutParams.width = screenWidth - size48dp - blueWidth;
                seekBarBlue.setLayoutParams(layoutParams);
            }
        });
    }

    private void updateColor() {
        // 0xAARRGGBB
        // max 0xff = 255, min 0x00 = 0
        int redShift = red << 16; // red: 0xRR0000 <- 0xRR
        int greenShift = green << 8; // red: 0xGG00 <- 0xGG
        int blueShift = blue; // blue: 0xBB <- 0xBB
        int alphaShift = 0xff << 24; // alpha 0xff000000 <- 0xff // we don't want our color to be transparent.
        int color = alphaShift | redShift | greenShift | blueShift;
        viewColor.setBackgroundColor(color);
    }

}