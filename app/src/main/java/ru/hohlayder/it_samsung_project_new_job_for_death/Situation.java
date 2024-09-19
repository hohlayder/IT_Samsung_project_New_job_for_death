package ru.hohlayder.it_samsung_project_new_job_for_death;

import static ru.hohlayder.it_samsung_project_new_job_for_death.MyView.count;
import android.graphics.Bitmap;

public class Situation{
    int widht, height;
    Bitmap bitmap;
    int dfood_yes, dpeople_yes, dweapon_yes, dreligion_yes, dfood_no, dpeople_no, dweapon_no, dreligion_no;

    public Situation(int widht, int height, Bitmap bitmap, int dfood_yes, int dpeople_yes, int dweapon_yes, int dreligion_yes, int dfood_no, int dpeople_no, int dweapon_no, int dreligion_no) {
        this.widht = widht;
        this.height = height;
        this.bitmap = bitmap;
        this.dfood_yes = dfood_yes;
        this.dpeople_yes = dpeople_yes;
        this.dweapon_yes = dweapon_yes;
        this.dreligion_yes = dreligion_yes;
        this.dfood_no = dfood_no;
        this.dpeople_no = dpeople_no;
        this.dweapon_no = dweapon_no;
        this.dreligion_no = dreligion_no;
    }

    public void goSituation(Parametr[] parametrs, int n) {
        count++;
        switch (n){
            case 0:// убить
                parametrs[0].nvalue+=dfood_yes;
                parametrs[1].nvalue+=dpeople_yes;
                parametrs[2].nvalue+=dweapon_yes;
                parametrs[3].nvalue+=dreligion_yes;
                break;
            case 1:// не убивать
                parametrs[0].nvalue+=dfood_no;
                parametrs[1].nvalue+=dpeople_no;
                parametrs[2].nvalue+=dweapon_no;
                parametrs[3].nvalue+=dreligion_no;
                break;
        }
    }
}
