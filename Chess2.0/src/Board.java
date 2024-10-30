import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

public class Board extends JPanel {

    static {
        System.loadLibrary("libChessJNIpart");
    }


    Sprites sprites;
    public static int tileSize = 85;
    Graphics2D g2d;

    private int selectedRow = -1;
    private int selectedCol = -1;

    private static final int wPawn = -1, wRook = -2, wKnight = -3, wBishop = -4, wKing = -5, wQueen = -6;
    private static final int bPawn = 1, bRook = 2, bKnight = 3, bBishop = 4, bKing = 5, bQueen = 6;


    public Board() {
        setPreferredSize(new Dimension(tileSize * 8, tileSize * 8));
        setBackground(Color.GRAY);
        setBoard();
        sprites = new Sprites();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = e.getY() / tileSize;
                int col = e.getX() / tileSize;

                myMousePressed(row, col);
                repaint();
                System.out.println(getSelectedRow() + " " + getSelectedCol());
            }

            @Override
            public void mouseDragged(MouseEvent e) {


            }

            @Override
            public void mouseReleased(MouseEvent e) {
                repaint();
            }
        });
    }


    public void paintComponent(Graphics g) {

        g2d = (Graphics2D) g;

        //Draw a board
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                g2d.setColor((i + j) % 2 == 0 ? new Color(210, 128, 63) : new Color(164, 79, 3));

                //Highlighting of selected figure
                if (getSelectedRow() != -1 && getSelectedRow() == i && getSelectedCol() != -1 && getSelectedCol() == j)
                    g2d.setColor(new Color(246, 246, 123));
                if (getPossibleTurns(i, j) == 1)
                    g2d.setColor(new Color(36, 250, 218));

                g2d.fillRect(j * tileSize, i * tileSize, tileSize, tileSize);

            }
        }

        //Draw figures
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (getFigure(i, j)) {
                    case (wPawn) -> sprites.draw(g2d, sprites.wPawnSprite, tileSize*j, tileSize* i);
                    case (bPawn) -> sprites.draw(g2d, sprites.bPawnSprite, tileSize*j, tileSize* i);
                    case (wRook) -> sprites.draw(g2d, sprites.wRookSprite, tileSize*j, tileSize* i);
                    case (bRook) -> sprites.draw(g2d, sprites.bRookSprite, tileSize*j, tileSize* i);
                    case (wKnight) -> sprites.draw(g2d, sprites.wKnightSprite, tileSize*j, tileSize* i);
                    case (bKnight) -> sprites.draw(g2d, sprites.bKnightSprite, tileSize*j, tileSize* i);
                    case (wBishop) -> sprites.draw(g2d, sprites.wBishopSprite, tileSize*j, tileSize* i);
                    case (bBishop) -> sprites.draw(g2d, sprites.bBishopSprite, tileSize*j, tileSize* i);
                    case (wKing) -> sprites.draw(g2d, sprites.wKingSprite, tileSize*j, tileSize* i  );
                    case (bKing) -> sprites.draw(g2d, sprites.bKingSprite, tileSize*j, tileSize* i);
                    case (wQueen) -> sprites.draw(g2d, sprites.wQueenSprite, tileSize*j, tileSize* i);
                    case (bQueen) -> sprites.draw(g2d, sprites.bQueenSprite, tileSize*j, tileSize* i);
                }
            }
        }
    }


    public native void setSelectedRow(int row);
    public native void setSelectedCol(int col);
    public native void setSelectedFigure(int figure);

    public native int getSelectedRow();
    public native int getSelectedCol();
    public native int getSelectedFigure();

    public native void setFigure(int value, int row, int col);

    public native void calculatePossibleMovements(int x, int y);
    public native int getPossibleTurns(int row, int col);
    public native void setPossibleTurnsToZero();

    public native void setBoard();

    public native void moveFigure(int oldX, int oldY, int x, int y);

    public native int getFigure(int row, int col);
    public native void myMousePressed(int row, int col);

}
