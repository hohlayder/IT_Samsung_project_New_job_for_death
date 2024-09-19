package ru.hohlayder.it_samsung_project_new_job_for_death;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Parametr {
    public int value, nvalue, widht, height, height_top, height_bottom, pom=0;
    public boolean ris=false;
    Paint paint;

    public Parametr(int value, int widht, int height) {
        paint = new Paint();
        this.value = this.nvalue = value;
        this.widht = widht;
        this.height = height;
        height_top=height*73/400;
        height_bottom=height*181/800;
    }

    public boolean ifNotNormal(){
            return (value>99 || value<1);
    }


    public void drawPar(Canvas canvas, int i, Paint rpaint){
        canvas.drawRect(i*widht/4, ((100-value)*height_bottom+value*height_top)/100, (i+1)*widht/4, height_bottom, rpaint);
    }

    public void goPar(Canvas canvas, int i){
        if(pom==0) {
            if (nvalue > value) {
                ris = true;
                value++;
                paint.setColor(Color.argb(255, 127, 255, 35));
            } else if (nvalue < value) {
                ris = true;
                value--;
                paint.setColor(Color.argb(255, 255, 82, 35));
            } else {
                ris = false;
                paint.setColor(Color.argb(255, 255, 163, 70));
            }
        }
            drawPar(canvas, i, paint);
        pom++;
        pom%=3;
    }
}
