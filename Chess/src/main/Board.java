package main;

import figure.Figure;
import figure.Knight;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
            figures.add(new Knight(this, 2, 0, WHITE));
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
