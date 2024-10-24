package main;

import figure.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static figure.Team.BLACK;
import static figure.Team.WHITE;

public
    class Board
    extends JPanel {
        public int tileSize = 85;
        final int FPS = 60;

        int cols = 8;
        int rows = 8;

        Graphics2D g2d;

        ArrayList<Figure> figures = new ArrayList<>();


        public Board() {
            setPreferredSize(new Dimension(tileSize * cols, tileSize * rows));
            setBackground(Color.GRAY);
            setBoard();
        }

        public void setBoard() {
            //adding black figures
            figures.add(new Rook(this, 0, 0, BLACK));
            figures.add(new Knight(this, 0, 1, BLACK));
            figures.add(new Bishop(this, 0, 2, BLACK));
            figures.add(new Queen(this, 0, 3, BLACK));
            figures.add(new King(this, 0, 4, BLACK));
            figures.add(new Bishop(this, 0, 5, BLACK));
            figures.add(new Knight(this, 0, 6, BLACK));
            figures.add(new Rook(this, 0, 7, BLACK));

            for (int i = 0; i < cols; i++) figures.add(new Pawn(this, 1, i, BLACK));

            //adding white figures
            for (int i = 0; i < cols; i++) figures.add(new Pawn(this, 6, i, WHITE));

            figures.add(new Rook(this, 7, 0, WHITE));
            figures.add(new Knight(this, 7, 1, WHITE));
            figures.add(new Bishop(this, 7, 2, WHITE));
            figures.add(new Queen(this, 7, 3, WHITE));
            figures.add(new King(this, 7, 4, WHITE));
            figures.add(new Bishop(this, 7, 5, WHITE));
            figures.add(new Knight(this, 7, 6, WHITE));
            figures.add(new Rook(this, 7, 7, WHITE));

        }

        public void paintComponent(Graphics g) {

            g2d = (Graphics2D) g;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    g2d.setColor((i + j) % 2 == 0 ? new Color(210, 128, 63) : new Color(164, 79, 3));
                    g2d.fillRect(i * tileSize, j * tileSize, tileSize, tileSize);
                }
            }


            for (Figure f : figures) {
                f.draw(g2d);
            }
        }



}
