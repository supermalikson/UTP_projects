import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprites {


    static BufferedImage sheet;
    public int spriteSize = sheet.getWidth() / 6;

    public Image
            wPawnSprite,
            bPawnSprite,
            wRookSprite,
            bRookSprite,
            wKnightSprite,
            bKnightSprite,
            wBishopSprite,
            bBishopSprite,
            wKingSprite,
            bKingSprite,
            wQueenSprite,
            bQueenSprite;


    static  {
        try {
            sheet = ImageIO.read(new File("Chess2.0\\src\\Chess_Pieces_Sprite.svg.png"));
        } catch (IOException e) {
            System.out.println("Error loading sprite sheet");
        }
    }

    public void draw(Graphics2D g, Image sprite, int x, int y) {
        g.drawImage(sprite, x, y, null);
    }

    public Sprites() {

        wPawnSprite = sheet.getSubimage(
                spriteSize * 5, 0, spriteSize, spriteSize)
                .getScaledInstance(Board.tileSize, Board.tileSize, BufferedImage.SCALE_SMOOTH
                );

        bPawnSprite = sheet.getSubimage(
                spriteSize * 5, spriteSize, spriteSize, spriteSize)
                .getScaledInstance(Board.tileSize, Board.tileSize, BufferedImage.SCALE_SMOOTH
                );

        wRookSprite = sheet.getSubimage(
                        spriteSize * 4, 0, spriteSize, spriteSize)
                .getScaledInstance(Board.tileSize, Board.tileSize, BufferedImage.SCALE_SMOOTH
                );
        bRookSprite = sheet.getSubimage(
                        spriteSize * 4, spriteSize, spriteSize, spriteSize)
                .getScaledInstance(Board.tileSize, Board.tileSize, BufferedImage.SCALE_SMOOTH
                );
        wKnightSprite = sheet.getSubimage(
                        spriteSize * 3, 0, spriteSize, spriteSize)
                .getScaledInstance(Board.tileSize, Board.tileSize, BufferedImage.SCALE_SMOOTH
                );
        bKnightSprite = sheet.getSubimage(
                        spriteSize * 3, spriteSize, spriteSize, spriteSize)
                .getScaledInstance(Board.tileSize, Board.tileSize, BufferedImage.SCALE_SMOOTH
                );

        wBishopSprite = sheet.getSubimage(
                        spriteSize * 2, 0, spriteSize, spriteSize)
                .getScaledInstance(Board.tileSize, Board.tileSize, BufferedImage.SCALE_SMOOTH
                );
        bBishopSprite = sheet.getSubimage(
                        spriteSize * 2, spriteSize, spriteSize, spriteSize)
                .getScaledInstance(Board.tileSize, Board.tileSize, BufferedImage.SCALE_SMOOTH
                );
        wKingSprite = sheet.getSubimage(
                        0, 0, spriteSize, spriteSize)
                .getScaledInstance(Board.tileSize, Board.tileSize, BufferedImage.SCALE_SMOOTH
                );
        bKingSprite = sheet.getSubimage(
                        0, spriteSize, spriteSize, spriteSize)
                .getScaledInstance(Board.tileSize, Board.tileSize, BufferedImage.SCALE_SMOOTH
                );
        wQueenSprite = sheet.getSubimage(
                        spriteSize, 0, spriteSize, spriteSize)
                .getScaledInstance(Board.tileSize, Board.tileSize, BufferedImage.SCALE_SMOOTH
                );
        bQueenSprite = sheet.getSubimage(
                        spriteSize, spriteSize, spriteSize, spriteSize)
                .getScaledInstance(Board.tileSize, Board.tileSize, BufferedImage.SCALE_SMOOTH
                );
    }

}
