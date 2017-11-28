package chess.board;

import chess.board.piece.Piece;

import java.util.*;

public class Board {

    // Public fields:
    public static int WIDTH = 8; // Standard 8x8 chessboard
    public static int NUM_PLAYERS = 2; // Standard number of players

    // Private fields:
    private Piece[][] boardArray; // Array of all squares on chessboard
    private Player[] players;

    public Board(int numHumanPlayers) {
        if (numHumanPlayers < 0 || numHumanPlayers > NUM_PLAYERS) {
            throw new IllegalArgumentException("Error: Board: Board(): 'numHumanPlayers' = " + numHumanPlayers);
        }

        // Initialize the board squares
        boardArray = new Piece[WIDTH][WIDTH];
        players = new Player[NUM_PLAYERS];

        int i = 0;
        for (; i < numHumanPlayers; i++) {
            players[i] = new Player();
        }

        for (; i < players.length; i++) {
            players[i] = new /*AI*/Player();
        }

        gameLoop();
    }

    private void gameLoop() {

    }

    public static String toAlgebraicNotation(int x, int y) {
        return "" + (char)(x + 'a') + (y + 1);
    }
}
