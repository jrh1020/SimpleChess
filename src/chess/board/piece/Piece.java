package chess.board.piece;

import chess.board.PlayerColor;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
    // Public fields:

    // Private fields:
    private int x, y; // Location on board
    private PieceType type = PieceType.Null; // Type of piece. Must be set in piece constructor
    private PlayerColor color = PlayerColor.Null; // Piece color. Must be set in piece constructor
    private List<String> moveList; // Retains a list of all the moves made on the board.

    // Basic piece constructor
    public Piece(int x, int y) {
        // Set coordinates
        this.x = x;
        this.y = y;

        moveList = new ArrayList<String>();
    }

    // Get methods:
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public PieceType getType() {
        return type;
    }

    public PlayerColor getColor() {
        return color;
    }

    // Public abstract methods
    public abstract boolean canMove(int newX, int newY);
    public abstract void move(int newX, int newY)/* throws BadMoveException*/;

    // Private methods:
    private int getMoveMultiplier() {
        return color == PlayerColor.White ? 1 : -1;
    }
}
