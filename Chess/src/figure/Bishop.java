package figure;

import main.Board;

import java.awt.image.BufferedImage;

import static figure.Team.WHITE;

public class Bishop extends Figure{

    public Bishop(Board board, int row, int col, Team team) {
        super(board);
        this.row = row;
        this.col = col;
        this.x = col * board.tileSize;
        this.y = row * board.tileSize;

        this.team = team;

        this.name = "Bishop";

        sprite = sheet.getSubimage(
                        spriteSize * 2, team == WHITE ? 0 : spriteSize, spriteSize, spriteSize)
                .getScaledInstance(board.tileSize, board.tileSize, BufferedImage.SCALE_SMOOTH
                );

    }
}
