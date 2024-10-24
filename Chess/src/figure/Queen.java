package figure;

import main.Board;

import java.awt.image.BufferedImage;

import static figure.Team.WHITE;

public class Queen extends Figure{

    public Queen(Board board, int row, int col, Team team) {
        super(board);
        this.row = row;
        this.col = col;
        this.x = col * board.tileSize;
        this.y = row * board.tileSize;

        this.team = team;

        this.name = "Knight";

        sprite = sheet.getSubimage(
                        spriteSize * 1, team == WHITE ? 0 : spriteSize, spriteSize, spriteSize)
                .getScaledInstance(board.tileSize, board.tileSize, BufferedImage.SCALE_SMOOTH
                );

    }
}
