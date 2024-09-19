package ru.hohlayder.it_samsung_project_new_job_for_death;

import static ru.hohlayder.it_samsung_project_new_job_for_death.MainActivity.number_activity;
import static ru.hohlayder.it_samsung_project_new_job_for_death.MyView.buttons;
import static ru.hohlayder.it_samsung_project_new_job_for_death.MyView.random;
import static ru.hohlayder.it_samsung_project_new_job_for_death.MyView.situations;
import static ru.hohlayder.it_samsung_project_new_job_for_death.MyView.stacks;
import static ru.hohlayder.it_samsung_project_new_job_for_death.MyView.kdx;
import static ru.hohlayder.it_samsung_project_new_job_for_death.MyView.kdy;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class AtomButton {
    int nrandom, i=0;
    int xv, xn, yv, yn;
    boolean be;

    public AtomButton(int xv, int xn, int yv, int yn, boolean be) {
        this.be = be;
        this.xv = xv;
        this.xn = xn;
        this.yv = yv;
        this.yn = yn;
    }

    public boolean ifTouch(float x,float y){
        return be && x>xv && x<xn && y>yv && y<yn;
     }

    public void Touch_button(int n,Canvas canvas){
        switch (n) {
            case 0:
                buttons[0].be=false;
                buttons[1].be=false;
                buttons[2].be=false;
                buttons[3].be=false;
                buttons[4].be=false;
                buttons[5].be=false;
                stacks[0].be=false;
                stacks[1].be=false;
                number_activity=-2;
                break;
            case 1:

                break;
            case 2:

                break;
            case 3:
                buttons[0].be=false;
                buttons[1].be=false;
                buttons[2].be=false;
                buttons[3].be=false;
                buttons[4].be=true;
                buttons[5].be=true;
                stacks[0].be=false;
                stacks[1].be=false;
                number_activity=4;
                break;
            case 4:
                int pid = android.os.Process.myPid();
                android.os.Process.killProcess(pid);
                break;
            case 5:
            case 6:
                buttons[0].be=true;
                buttons[1].be=true;
                buttons[2].be=true;
                buttons[3].be=true;
                buttons[4].be=false;
                buttons[5].be=false;
                buttons[6].be=false;
                stacks[0].be=false;
                stacks[1].be=false;
                number_activity=0;
                break;
        }
    }

    public void Touch_stack(int n, Situation situation, Parametr[] parametrs){
        kdy=kdx=0;
        nrandom=(int)(Math.random()*(situations.length-1));
        if(nrandom>=random)
            nrandom++;
        random=nrandom;
        situation.goSituation(parametrs,n);
    }

    public void Hitbox(Canvas canvas, Paint paint){
        if(be)
        canvas.drawRect(xv, yv, xn, yn, paint);
    }
}
