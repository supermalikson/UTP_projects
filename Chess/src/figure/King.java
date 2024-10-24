package figure;

import main.Board;

import java.awt.image.BufferedImage;

import static figure.Team.WHITE;

public class King extends Figure{

    public King(Board board, int row, int col, Team team) {
        super(board);
        this.row = row;
        this.col = col;
        this.x = col * board.tileSize;
        this.y = row * board.tileSize;

        this.team = team;

        this.name = "King";

        sprite = sheet.getSubimage(
                        spriteSize * 0, team == WHITE ? 0 : spriteSize, spriteSize, spriteSize)
                .getScaledInstance(board.tileSize, board.tileSize, BufferedImage.SCALE_SMOOTH
                );

    }
}
