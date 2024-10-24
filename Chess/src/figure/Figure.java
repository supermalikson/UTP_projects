package figure;

import main.Board;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Figure {

    public int col, row;
    public int x, y;

    public Team team;
    public String name;
    public int value;

    static BufferedImage sheet;

    Image sprite;

    Board board;

    public int spriteSize = sheet.getWidth() / 6;

    public Figure(Board board) {
        this.board = board;
    }

    static  {
            try {
                sheet = ImageIO.read(new File("Chess\\rsc\\Chess_Pieces_Sprite.svg.png"));
            } catch (IOException e) {
                throw new RuntimeException("Error loading sprite sheet", e);
            }

    }

    public void draw(Graphics2D g) {
        g.drawImage(sprite, x, y, null);
    }


}
