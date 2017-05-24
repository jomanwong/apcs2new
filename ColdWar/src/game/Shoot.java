package game;

import javax.swing.ImageIcon;

public class Shoot extends Enemy {

    private final String shotImg = "src/game/images/shot.png";
    private final int H_SPACE = 6;
    private final int V_SPACE = 1;

    public Shoot() {
    }

    public Shoot(int x, int y) {

        initShot(x, y);
    }
    
 
    private void initShot(int x, int y) {

        ImageIcon ii = new ImageIcon(shotImg);
        setImage(ii.getImage());
        
        setX(x + H_SPACE);
        setY(y - V_SPACE);
    }
}