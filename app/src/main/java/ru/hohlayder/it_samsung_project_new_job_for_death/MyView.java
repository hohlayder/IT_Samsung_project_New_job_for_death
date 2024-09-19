package ru.hohlayder.it_samsung_project_new_job_for_death;

import static java.lang.Thread.sleep;
import static ru.hohlayder.it_samsung_project_new_job_for_death.MainActivity.number_activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {

    public MyView(Context context) {
        super(context);
    }

    Paint paint = new Paint();
    public static int random, count;
    int religion_yes=2,religion_no=-5;
    float x = 0, y = 0, x1 = 0, y1 = 0, x2 = 0, y2 = 0, dx = 0, vx, vy, dy = 0, touch=0;
    public static float kdx = 0, kdy = 0;
    boolean first_launch = true, first_game = true, first_download = true;
    Bitmap end, loading, loading_cart, bm1p,bm2p,bm2par,bm3p,bmp_helpfood,bmp_helppeople,bmp_peopleorfoodnetr,bmp_peopleorfoodotr,bmp_peopleorfoodpol,bmp_peopleorweaponnetr,bmp_peopleorweaponotr,bmp_peopleorweaponpol,bmp_religionanimal,bmp_religionpeople;
    Bitmap[] fon = new Bitmap[]{bm1p,bm2p,bm2par,bm3p,loading_cart,end}, carts = new Bitmap[]{bmp_helpfood,bmp_helppeople,bmp_peopleorfoodnetr,bmp_peopleorfoodotr,bmp_peopleorfoodpol,bmp_peopleorweaponnetr,bmp_peopleorweaponotr,bmp_peopleorweaponpol,bmp_religionanimal,bmp_religionpeople};
    Situation help_food,help_people,people_or_food_netr,people_or_food_otr,people_or_food_pol,people_or_weapon_netr,people_or_weapon_otr,people_or_weapon_pol,religion_animal,religion_people;
    int[] button_const= new int[2];
    public static AtomButton[] buttons;
    public static AtomButton[] stacks;
    public static Parametr[] parametrs;
    public static Situation[] situations;

    int z=-1;
    int[] resources = new int[]{R.drawable.fone1,R.drawable.fone2,R.drawable.fone2params,R.drawable.foneexit3,R.drawable.loadingcart,R.drawable.end}, cart_res = new int[]{R.drawable.helpfood,R.drawable.helppeople,R.drawable.peopleorfoodnetr,R.drawable.peopleorfoodotr,R.drawable.peopleorfoodpol,R.drawable.peopleorweaponnetr,R.drawable.peopleorweaponotr,R.drawable.peopleorweaponpol,R.drawable.religionanimal,R.drawable.religionpeople};
    Paint load_paint = new Paint();

    public void drawHitbox(Canvas canvas) {
        paint.setColor(Color.argb(127, 0, 255, 0));
        buttons[0].Hitbox(canvas,paint);
        paint.setColor(Color.argb(127, 255, 255, 0));
        buttons[1].Hitbox(canvas,paint);
        paint.setColor(Color.argb(127, 0, 0, 255));
        buttons[2].Hitbox(canvas,paint);
        paint.setColor(Color.argb(127, 255, 0, 0));
        buttons[3].Hitbox(canvas,paint);
        paint.setColor(Color.argb(127, 255, 0, 0));
        buttons[4].Hitbox(canvas,paint);
        paint.setColor(Color.argb(127, 0, 255, 0));
        buttons[5].Hitbox(canvas,paint);
        paint.setColor(Color.argb(127, 255, 127, 0));
        buttons[6].Hitbox(canvas,paint);
        paint.setColor(Color.argb(127, 255, 127, 0));
        stacks[0].Hitbox(canvas,paint);
        stacks[1].Hitbox(canvas,paint);
        paint.setColor(Color.argb(127, 100, 100, 100));
        canvas.drawCircle(x, y, 100, paint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (first_launch) {

            load_paint.setColor(Color.argb(255, 255, 163, 70));

            touch=(float)this.getHeight()/100;

            button_const[0] = this.getWidth() / 13;
            button_const[1] = this.getWidth() / 7;
            AtomButton play = new AtomButton(button_const[0], button_const[0] * 12, this.getHeight() * 13 / 44, this.getHeight() * 43 / 104, false);
            AtomButton save = new AtomButton(button_const[0], button_const[0] * 12, this.getHeight() * 43 / 104, this.getHeight() * 17 / 32, false);
            AtomButton setting = new AtomButton(button_const[0], button_const[0] * 12, this.getHeight() * 17 / 32, this.getHeight() * 2 / 3, false);
            AtomButton exit = new AtomButton(button_const[0], button_const[0] * 12,  this.getHeight() * 37 / 52, this.getHeight() * 45 / 52, false);

            AtomButton exit_yes = new AtomButton(button_const[1], this.getWidth() * 20 / 41, this.getHeight() * 17 / 30, this.getHeight() * 41 / 64, false);
            AtomButton exit_no = new AtomButton(this.getWidth() * 21/41, button_const[1] * 6, this.getHeight() * 17/30, this.getHeight() * 41/64, false);

            AtomButton die_yes = new AtomButton(this.getWidth() /3, this.getWidth() * 2/3, this.getHeight() * 8 / 25, this.getHeight() * 9 / 19, false);
            AtomButton die_no = new AtomButton(this.getWidth() /3, this.getWidth() * 2/3 , this.getHeight() * 200/260, this.getHeight() * 12/13, false);

            AtomButton end = new AtomButton(button_const[0], button_const[0] * 12,  this.getHeight() * 42 / 52, this.getHeight() * 49 / 52, false);


            buttons= new AtomButton[]{play, save, setting, exit, exit_yes, exit_no, end};
            stacks= new AtomButton[]{die_yes, die_no};

            loading = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.loading), this.getWidth(), this.getHeight(), true);

            Parametr food = new Parametr(50,this.getWidth(),this.getHeight());
            Parametr people = new Parametr(50,this.getWidth(),this.getHeight());
            Parametr weapon = new Parametr(50,this.getWidth(),this.getHeight());
            Parametr religion = new Parametr(50,this.getWidth(),this.getHeight());

            parametrs= new Parametr[]{food,people,weapon,religion};

            first_launch = false;
        }
        switch (number_activity) {
            case -2: // Загрузка карточек
                if(first_download) {
                    paint.setColor(Color.argb(255,127,81,35));
                    canvas.drawRect(0,0,this.getWidth(),this.getHeight(),paint);
                    canvas.drawRect(0, 0, ((this.getWidth() * 3 / 54) * (carts.length - z - 1) + (this.getWidth() * 25 / 27) * (z + 1)) / carts.length, this.getHeight(), load_paint);
                    canvas.drawBitmap(fon[4], 0, 0, null);
                    if (z >= 0)
                        carts[z] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), cart_res[z]), this.getWidth(), this.getHeight(), true);
                    invalidate();
                    if (z == carts.length - 1){
                        number_activity = 1;
                        stacks[0].be = true;
                        stacks[1].be = true;
                        first_download=false;
                    }
                    z++;
                }
                else{
                    for(int i=0;i<parametrs.length;i++)
                    parametrs[i].value=parametrs[i].nvalue=50;
                    count=0;
                    number_activity = 1;
                    stacks[0].be = true;
                    stacks[1].be = true;
                }
                break;
            case -1: // Загрузка фонов
                paint.setColor(Color.argb(255, 127, 81, 35));
                canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), paint);
                canvas.drawRect(0, 0, ((this.getWidth() * 3 / 54) * (fon.length - z - 1) + (this.getWidth() * 51 / 54) * (z + 1)) / fon.length, this.getHeight(), load_paint);
                canvas.drawBitmap(loading, 0, 0, null);
                if (z >= 0)
                    fon[z] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), resources[z]), this.getWidth(), this.getHeight(), true);
                invalidate();
                if (z == fon.length - 1) {
                    number_activity = 0;
                    buttons[0].be = true;
                    buttons[1].be = true;
                    buttons[2].be = true;
                    buttons[3].be = true;
                    z = -2;
                }
                z++;
                break;
            case 0: // Главный (первый) экран
            canvas.drawBitmap(fon[0], 0, 0, null);
            for(int i=0;i<buttons.length;i++)
                if(buttons[i].ifTouch(vx,vy)) {
                    buttons[i].Touch_button(i, canvas);
                    vx=vy=kdx=kdy=0;
                }
            break;
            case 1: // Экран игры
                if(first_game){
                    religion_people =       new Situation(this.getWidth(),this.getHeight(),carts[9],0,-10,0,40,0,0,0,-20);
                    religion_animal =       new Situation(this.getWidth(),this.getHeight(),carts[8],-10,0,0,20,0,0,0,-10);
                    people_or_weapon_pol =  new Situation(this.getWidth(),this.getHeight(),carts[7],0,0,10,religion_yes,0,10,0,religion_no);
                    people_or_weapon_otr =  new Situation(this.getWidth(),this.getHeight(),carts[6],0,-10,0,religion_yes,0,0,-10,religion_no);
                    people_or_weapon_netr = new Situation(this.getWidth(),this.getHeight(),carts[5],0,-10,10,religion_yes,0,10,-10,religion_no);
                    people_or_food_pol =    new Situation(this.getWidth(),this.getHeight(),carts[4],10,0,0,religion_yes,0,10,0,religion_no);
                    people_or_food_otr =    new Situation(this.getWidth(),this.getHeight(),carts[3],0,-10,0,religion_yes,-10,0,0,religion_no);
                    people_or_food_netr =   new Situation(this.getWidth(),this.getHeight(),carts[2],10,-10,0,religion_yes,-10,10,0,religion_no);
                    help_people =           new Situation(this.getWidth(),this.getHeight(),carts[1],0,0,0,religion_yes,0,-10,0,religion_no);
                    help_food =             new Situation(this.getWidth(),this.getHeight(),carts[0],10,0,0,religion_yes,0,0,0,religion_no);
                    situations = new Situation[]{help_food,help_people,people_or_food_netr,people_or_food_otr,people_or_food_pol,people_or_weapon_netr,people_or_weapon_otr,people_or_weapon_pol,religion_animal,religion_people};
                    random=(int)(Math.random()*situations.length);
                    first_game=false;
                }
                canvas.drawBitmap(fon[1], 0, 0, null);
                for(int i=0;i<4;i++)
                    parametrs[i].goPar(canvas,i);
                canvas.drawBitmap(fon[2], 0, 0, null);
                canvas.drawBitmap(situations[random].bitmap, dx, dy, null);
                for(int i=0;i<stacks.length;i++) {
                    if (stacks[i].ifTouch(kdx, kdy)) {
                        stacks[i].Touch_stack(i, situations[random], parametrs);
                        vx=vy=kdx=kdy=0;
                    }
                }
                for(int i=0;i<parametrs.length;i++)
                    if(parametrs[i].ifNotNormal()) {
                        number_activity = 5;
                        stacks[0].be = false;
                        stacks[1].be = false;
                        buttons[6].be = true;
                    }
                break;
            case 4: // Экран подтверждения выхода
                canvas.drawBitmap(fon[3], 0, 0, null);
                for(int i=0;i<buttons.length;i++)
                    if(buttons[i].ifTouch(vx,vy)) {
                        buttons[i].Touch_button(i, canvas);
                        vx=vy=kdx=kdy=0;
                    }
                break;
            case 5: // Экран проигрыша
                canvas.drawBitmap(fon[5], 0, 0, null);
                paint.setColor(Color.argb(127, 127, 81, 35));
                paint.setTextSize(80);
                canvas.drawText(Integer.toString(count),this.getWidth()/5,this.getHeight()*35/80,paint);
                for(int i=0;i<buttons.length;i++)
                    if(buttons[i].ifTouch(vx,vy)) {
                        buttons[i].Touch_button(i, canvas);
                        vx=vy=kdx=kdy=0;
                    }
                break;
        }
        //drawHitbox(canvas);
        invalidate();
    }


        @Override
        public boolean onTouchEvent (MotionEvent event){
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: // нажатие
                    x = x1 = event.getX();
                    y = y1 = event.getY();
                    dx = event.getX()-this.getWidth()/2;
                    dy = event.getY()-this.getHeight()/13*8;
                    break;

                case MotionEvent.ACTION_MOVE: // движение
                    x = event.getX();
                    y = event.getY();
                    dx = event.getX()-this.getWidth()/2;
                    dy = event.getY()-this.getHeight()/13*8;
                    break;

                case MotionEvent.ACTION_UP: // отпускание
                case MotionEvent.ACTION_CANCEL:
                    x = x2 = event.getX();
                    y = y2 = event.getY();
                    kdx = dx+this.getWidth()/2;
                    kdy = dy+this.getHeight()/13*8;
                    dx = dy = 0;
                    break;
            }
            if (x1 < x2+touch && x1 > x2-touch && y1 < y2+touch && y1 > y2-touch) {
                vx = x1;
                vy = y1;
            }

            return true;
        }

}