package Demo.States;


import Demo.Entities.*;
import Demo.GamePanel;
import Demo.Resources;
import Demo.Utility;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


/**
 * Created by user on 31-Oct-16.
 */
public class GameState extends State {
    java.util.List<Entity> assets;
    java.util.List<Entity> player;
    java.util.List<Entity> villain;
    Coin[][] coin = new Coin[100][100];
    Hero hero;
    Villain1 villain1;
    Villain2 villain2;
    Villain3 villain3;
    Villain4 villain4;
    public int i, k = 0, j, m = 0, p, count = 0;


    public GameState() {

        this.assets = new ArrayList<>();
        this.player = new ArrayList<>();
        this.villain = new ArrayList<>();
        for (j = 0; j <= 500; j = j + 100) {
            m++;
            for (i = 0; i <= 1000; i = i + 100) {

                this.coin[k][m] = new Coin(i, j);
                // this.assets.add(this.coin[1]);
                this.assets.add(this.coin[k][m]);
                //i = i + 100;
                k++;

                //System.out.println(k);
            }
        }
        this.hero = new Hero(0, 493);
        this.player.add(this.hero);
        this.villain1 = new Villain1(800, 0);
        this.villain2 = new Villain2(300, 200);
        this.villain3 = new Villain3(700, 400);
        this.villain4 = new Villain4(100, 300);
        this.villain.add(this.villain1);
        this.villain.add(this.villain2);
        this.villain.add(this.villain3);
        this.villain.add(this.villain4);


    }

    @Override
    public void update() {
        for (i = 0; i < this.assets.size(); i++)
            this.assets.get(i).update();
        for (i = 0; i < this.assets.size(); i++) {
            if (this.hero.isColliding(this.assets.get(i))) {
                this.assets.get(i).isHidden = true;
                count++;
               System.out.println(count);
            }


        }
        this.assets.get(8).isHidden = true;
        this.assets.get(25).isHidden = true;
        this.assets.get(51).isHidden = true;
        this.assets.get(34).isHidden = true;
        this.player.get(0).update();
        this.villain.get(0).update();
        this.villain.get(1).update();
        this.villain.get(2).update();
        this.villain.get(3).update();
//        for(int s=0;s<this.assets.size();s++) {
//            if (this.villain.get(d).isColliding(this.assets.get(s))) {
//                this.villain.get(d).x=300;
//                this.villain.get(d).y=300;
//            }
//            d++;
//        }


        p = Utility.generate(4);
        //System.out.println(p);
        if (p == 0) {
            this.villain.get(1).x += 100;
            int z = this.rtcollide(1);
            if (this.villain.get(1).isColliding(this.assets.get(z - 1))) {
                this.villain.get(1).x -= 100;
            }
            this.villain.get(2).y += 100;
            int w = this.rtcollide(2);
            if (this.villain.get(2).isColliding(this.assets.get(w - 1))) {
                this.villain.get(2).y -= 100;
            }
            this.villain.get(0).y += 100;
            int f = this.rtcollide(0);
            if (this.villain.get(0).isColliding(this.assets.get(f - 1))) {
                this.villain.get(0).y -= 100;
            }
            this.villain.get(3).y -= 100;
            int g = this.rtcollide(3);
            if (this.villain.get(3).isColliding(this.assets.get(g - 1))) {
                this.villain.get(3).y += 100;
            }
//            this.villain.get(3).y += 100;
//            this.villain.get(0).x += 100;

        }
        if (p == 1) {
            this.villain.get(1).x -= 100;
            int n = this.rtcollide(1);
            if (this.villain.get(1).isColliding(this.assets.get(n - 1))) {
                this.villain.get(1).x += 100;
            }
            this.villain.get(2).x += 100;
            int w = this.rtcollide(2);
            if (this.villain.get(2).isColliding(this.assets.get(w - 1))) {
                this.villain.get(2).x -= 100;
            }
            this.villain.get(0).x -= 100;
            int f = this.rtcollide(0);
            if (this.villain.get(0).isColliding(this.assets.get(f - 1))) {
                this.villain.get(0).x += 100;
            }
            this.villain.get(3).y += 100;
            int g = this.rtcollide(3);
            if (this.villain.get(3).isColliding(this.assets.get(g - 1))) {
                this.villain.get(3).y -= 100;
            }
//            this.villain.get(3).y -= 100;
//            this.villain.get(0).x -= 100;

        }
        if (p == 2) {

            this.villain.get(1).y -= 100;
            int q = this.rtcollide(1);
            if (this.villain.get(1).isColliding(this.assets.get(q - 1))) {
                this.villain.get(1).y += 100;
                this.villain.get(2).x -= 100;
                int w = this.rtcollide(2);
                if (this.villain.get(2).isColliding(this.assets.get(w - 1))) {
                    this.villain.get(2).x += 100;
                }
                this.villain.get(0).x += 100;
                int f = this.rtcollide(0);
                if (this.villain.get(0).isColliding(this.assets.get(f - 1))) {
                    this.villain.get(0).x -= 100;
                }
                this.villain.get(3).x -= 100;
                int g = this.rtcollide(3);
                if (this.villain.get(3).isColliding(this.assets.get(g - 1))) {
                    this.villain.get(3).x += 100;
                }
//            this.villain.get(3).x -= 100;
//            this.villain.get(0).y -= 100;

            }
        }
        if (p == 3) {
            this.villain.get(1).y += 100;
            int l = this.rtcollide(1);
            if (this.villain.get(1).isColliding(this.assets.get(l - 1))) {
                this.villain.get(1).y -= 100;
                this.villain.get(2).y -= 100;
                int w = this.rtcollide(2);
                if (this.villain.get(2).isColliding(this.assets.get(w - 1))) {
                    this.villain.get(2).y += 100;
                }
                this.villain.get(0).y -= 100;
                int f = this.rtcollide(0);
                if (this.villain.get(0).isColliding(this.assets.get(f - 1))) {
                    this.villain.get(0).y += 100;
                }
                this.villain.get(0).y += 100;
                this.villain.get(3).x += 100;
                int g = this.rtcollide(3);
                if (this.villain.get(3).isColliding(this.assets.get(g - 1))) {
                    this.villain.get(3).x -= 100;
                }


            }
        }
    }


    @Override
    public void render(Graphics g) {
        g.drawImage(Resources.bg, 0, 0, null);
        // g.drawImage(Resources.villain2, 300, 200, null);
        g.drawImage(this.villain.get(0).getImage(), this.villain.get(0).x, this.villain.get(0).y, null);
        g.drawImage(this.villain.get(1).getImage(), this.villain.get(1).x, this.villain.get(1).y, null);
        g.drawImage(this.villain.get(2).getImage(), this.villain.get(2).x, this.villain.get(2).y, null);
        g.drawImage(this.villain.get(3).getImage(), this.villain.get(3).x, this.villain.get(3).y, null);
        //g.drawImage(Resources.villain3, 700, 400, null);
        //g.drawImage(Resources.villain4, 0, 2, null);
        for (int j = 0; j < k; j++) {
            if (this.assets.get(j).isHidden == false)
                g.drawImage(this.assets.get(j).getImage(), this.assets.get(j).x, this.assets.get(j).y, null);
        }
        g.drawImage(this.player.get(0).getImage(), this.player.get(0).x, this.player.get(0).y, null);
        //g.drawImage(this.assets.get(1).getImage(), this.assets.get(1).x, this.assets.get(1).y, null);

        if (this.villain.get(1).isColliding(this.player.get(0))) {
            System.out.println("lost lost lost lost");
            GamePanel.currentState = new GameOver();
        }
        if (this.villain.get(0).isColliding(this.player.get(0))) {
            System.out.println("lost lost lost lost");
            GamePanel.currentState = new GameOver();
        }
        if (this.villain.get(2).isColliding(this.player.get(0))) {
            System.out.println("lost lost lost lost");
            GamePanel.currentState = new GameOver();
        }
        if (this.villain.get(3).isColliding(this.player.get(0))) {
            System.out.println("lost lost lost lost");
            GamePanel.currentState = new GameOver();
        }
        if(count==56)
            GamePanel.currentState=new GameWin();


    }

    public void keyPressed(int keyCode) {
        if (keyCode == KeyEvent.VK_DOWN) {
            this.hero.y += 50;
        }
        if (keyCode == KeyEvent.VK_UP) {
            this.hero.y -= 50;
        }
        if (keyCode == KeyEvent.VK_LEFT) {
            this.hero.x -= 50;
//            System.out.println(1);
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            this.hero.x += 50;
        }
    }

    public int rtcollide(int t) {
        int s;
        for (s = 0; s < this.assets.size(); s++) {
            if ((this.villain.get(t).x + 100) == this.assets.get(s).x && this.villain.get(t).y == this.assets.get(s).y) {
                //System.out.println("collide");
                break;
            }
        }
        return s;
    }

}
