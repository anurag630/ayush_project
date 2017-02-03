package Demo.Entities;

import Demo.Demo;

import java.awt.*;

/**
 * Created by user on 01-Nov-16.
 */
abstract public class Entity {
    public int x=0;
    public int y=0;
    public Rectangle rectangle;
    public boolean isHidden=false;
    public Entity(int x, int y) {
        this.x=x;
        this.y=y;
        this.rectangle=new Rectangle();
    }

    public abstract Image getImage();

    public abstract int getWidth();

    public abstract int getHeight();

    public void update() {
    }
    public boolean isColliding(Entity otherEntity){
        this.setBound();
        otherEntity.setBound();
        if(this.isHidden==true||otherEntity.isHidden==true)
            return false;
        else
            return this.rectangle.intersects(otherEntity.rectangle);
    }
    public void setBound(){
        this.rectangle.setBounds(this.x,this.y,this.getWidth(),this.getHeight());
    }
}
