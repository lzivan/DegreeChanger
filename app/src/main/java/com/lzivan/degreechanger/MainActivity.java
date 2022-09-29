package com.lzivan.degreechanger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    SeekBar seekCelcius;
    SeekBar seekFahren;
    TextView celdegree;
    TextView fahdegree;
    TextView message;
    int cel_degree;
    int fah_degree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekCelcius = (SeekBar) findViewById(R.id.sbCel);
        seekFahren = (SeekBar) findViewById(R.id.sbFah);
        celdegree = findViewById(R.id.viewCel);
        fahdegree = findViewById(R.id.viewFahren);
        message = findViewById(R.id.msg);

        seekCelcius.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                cel_degree = progress;
                celdegree.setText("" + cel_degree);

                double fd = (cel_degree * 1.80 + 32);
                fah_degree = (cel_degree*9/5)+32;
                fahdegree.setText("" + Math.round(fd * 100.00) / 100.00);
                seekFahren.setProgress(fah_degree);

                if (cel_degree <= 20){
                    message.setText(R.string.message1);
                }else{
                    message.setText(R.string.message2);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekFahren.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                if (seekBar.getProgress() <= 32) {
                    seekBar.setProgress(32);
                } else {
                    fah_degree = progress;
                    fahdegree.setText("" + fah_degree);


                    cel_degree = (fah_degree - 32) * 5 / 9;

                    celdegree.setText("" + Math.round(((fah_degree - 32) / 1.8) * 100.00) / 100.00);
                    seekCelcius.setProgress(cel_degree);


                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}