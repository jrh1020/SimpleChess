package chess.board;

import chess.board.piece.Piece;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/*
    class Board:
        Handles the chessboard, the players, all the pieces, and setting up.
 */

public class Board {

    // Public fields:
    public static final int WIDTH = 8; // Standard 8x8 chessboard
    public static final int NUM_PLAYERS = PlayerColor.values().length; // Standard number of players

    public static final String BOARD_LAYOUT = "resource/chess.json"; // Location of standard chessboard layout

    // Private fields:
    private Piece[][] boardArray; // Array of all squares on chessboard
    private Player[] players;

    public Board(int numHumanPlayers, String boardFileName) throws IOException {
        if (numHumanPlayers < 0 || numHumanPlayers > NUM_PLAYERS) {
            throw new IllegalArgumentException("Error: Board: Board(): 'numHumanPlayers' = " + numHumanPlayers);
        }

        // Initialize the board squares and player array
        boardArray = new Piece[WIDTH][WIDTH];
        players = new Player[NUM_PLAYERS];

        // Initialize Player White
        players[PlayerColor.White.ordinal()] = new Player(PlayerColor.White);

        // Initialize Player Black
        players[PlayerColor.Black.ordinal()] = new Player(PlayerColor.Black);

        initializeBoard(boardFileName);
        gameLoop();
    }

    private void initializeBoard(String boardFileName) throws IOException {
        String BOARD_DELIMETER = "board";
        String PIECE_DELIMETER = "piece";
        String COLOR_DELIMETER = "color";
        String POSITION_DELIMETER = "position";

        InputStream boardFile;
        // Load default chess layout
        if (boardFileName == null) {
            // Load the default class resource
            boardFile = getClass().getClassLoader().getResourceAsStream(BOARD_LAYOUT);

        // Otherwise load from file
        } else {
            boardFile = new FileInputStream(boardFileName);
        }

        // Dump the contents of the JSON file into a String and into a JSONObject
        JSONObject boardJson = new JSONObject(new String(boardFile.readAllBytes()));

        // The "board" JSONArray holds an array of all the pieces and their info
        JSONArray pieceArray = boardJson.getJSONArray(BOARD_DELIMETER);
        for (Object pieceObj : pieceArray) {
            // Get all the piece information
            String pieceType = ((JSONObject)pieceObj).getString(PIECE_DELIMETER);
            String playerColor = ((JSONObject)pieceObj).getString(COLOR_DELIMETER);
            String piecePos = ((JSONObject)pieceObj).getString(POSITION_DELIMETER);

            for (PlayerColor p : PlayerColor.values()) {

            }
        }
    }

    private void gameLoop() {

    }

    // Only works for standard chessboards
    public static String toAlgebraicNotation(int x, int y) {
        return "" + (char)(x + 'a') + (y + 1);
    }

    // Only works for standard chessboards
    public static int[] toGeometricNotation(String alg) {
        if (alg.length() > 2)
            throw new IllegalArgumentException("Error: Board: toGeometricNotation(String): alg length > 2. alg = " + alg);

        int x = (int)(alg.charAt(0) - 'a');
        int y = Integer.parseInt(alg.substring(1)) - 1;
        return new int[]{x, y};
    }
}
