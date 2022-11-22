package de.buw.se4de.entity;

import de.buw.se4de.gameflow.Handler;
import de.buw.se4de.ID;
import de.buw.se4de.GameObject;

import java.awt.*;

public class Sweets extends Projectile {
    public Sweets(int x, int y, ID id, int dir_x, int dir_y, Handler handler){
        super(x,y,id,dir_x,dir_y,handler);
    }
    @Override
    protected void collision() {
        for (int i = 0; i < handler.gameObjects.size(); i++) {
            GameObject temp = handler.gameObjects.get(i);
            if (getBounds().intersects(temp.getBounds())) {
                if (temp.getId() == ID.Wall) {
                    kill();
                }
                if (temp.getId() == ID.Enemy) {
                    ((Enemy)temp).setFriendly(true);
                    kill();
                }
            }
        }
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillOval(x, y, getSizex(), getSizey());
    }
}
