package chess.board;

public enum PlayerColor {
    Black, White;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
