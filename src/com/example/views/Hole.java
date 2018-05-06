package com.example.views;

import com.example.views.concrete.EllipticStyle;

import javax.swing.event.ChangeListener;
import java.awt.*;

public abstract class Hole extends View implements ChangeListener {

    private com.example.model.Hole hole;

    @Override
    public void draw(Graphics2D g2) {
        this.setSize(new Dimension(getStyle().getWidth(), getStyle().getHeight()));
        Shape shape = getStyle().getShape();
        g2.setColor(getStyle().getColor());
        g2.draw(shape);
        initStones2(g2);
    }

    public Hole(Style newStyle, com.example.model.Hole hole){
        super(newStyle);
        this.hole = hole;
    }

    public void initStones2(Graphics2D g2) {

        Stone stone;

        int x = getWidth() / 2 - 8;


        int y = getHeight() / 2 - 8;


        int arc = 180; // amount and direction of arc to sweep

        int stoneDist = 8;
        for (int i = 0; i < hole.getStones(); i++ ) {

            int stoneRad = 8;
            int mod = i % 4;
            if(mod == 0){
                x = x + (stoneDist);
                y = y + (stoneDist);
            }
            else if(mod == 1){
                x = x - (stoneDist);
                y = y + (stoneDist);
            }
            else if(mod == 2){
                x = x - (stoneDist);
                y = y - (stoneDist);
            }
            else{
                x = x + (stoneDist);
                y = y - (stoneDist);
                stoneDist = stoneDist + stoneRad;
            }
            stone = new Stone(x, y, new EllipticStyle(Color.BLACK, stoneRad, stoneRad));


            g2.fill(stone.getStyle().makeshape(x, y, stoneRad, stoneRad));



            arc = -arc; // reverse the direction of the arc
        }

    }

    public com.example.model.Hole getHole(){
        return hole;
    }
}
