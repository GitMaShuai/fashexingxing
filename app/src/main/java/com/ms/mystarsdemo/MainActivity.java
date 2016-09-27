package com.ms.mystarsdemo;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;

import confetto.CommonConfetti;


public class MainActivity extends AppCompatActivity {

    protected ViewGroup container;
    protected int goldDark, goldMed, gold, goldLight;
    protected int[] colors;
    private boolean isFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container= (ViewGroup) findViewById(R.id.container);
        final Resources res = getResources();
        goldDark = res.getColor(R.color.gold_dark);
        goldMed = res.getColor(R.color.gold_dark);
        gold = res.getColor(R.color.gold_dark);
        goldLight = res.getColor(R.color.gold_dark);
        colors = new int[] { goldDark, goldMed, gold, goldLight };

        int shous_H = getInt("82") + getInt("00");
//        int shous_H = getbyte("fe23") ;
        Log.d("mmm","fe="+(int)getInt("82")+"---00="+(int)getInt("00")+"shous_H==="+shous_H);

        isFirst=true;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (isFirst) {
//            for (int i = 0; i < 1; i++) {
                getCommonConfetti().infinite();
//            }
            isFirst=false;
        }
    }

    private CommonConfetti getCommonConfetti() {
        final int centerX = container.getWidth() / 2;
        final int centerY = container.getHeight() /  2;
        Log.d("mmm","centerX="+centerX+"--centerY="+centerY);
        return CommonConfetti.explosion(container, centerX, centerY, colors);
    }

    private static byte getbyte(String str) {
        return (byte) Integer.parseInt(str,16);
    }

    private static int getInt(String str) {
        return   Integer.valueOf(str,16);
    }
}
