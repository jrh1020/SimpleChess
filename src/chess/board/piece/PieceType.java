package chess.board.piece;

public enum PieceType {
    Pawn, Rook, Knight, Bishop, Queen, King;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
