package com.example.calvinwang.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class GamePage extends AppCompatActivity {
    /**
     * this is my game board. It is a boolean 2D array.
     * false means this spot has not been occupied.
     * yes means that this spot is already occupied.
     * Attempts to play on any occupied spots should trigger error message to show"I don't know?".
     */
    public static int[][] board;
    private List<Moves> moves;
    private ImageButton button01;
    private ImageButton button02;
    private ImageButton button00;
    private ImageButton button11;
    private ImageButton button12;
    private ImageButton button10;
    private ImageButton button20;
    private ImageButton button21;
    private ImageButton button22;
    private TextView showWhoseTurn;
    private String firstName;
    private String secondName;

    /**
     * this function makes the move.
     * it should check whether this spot is already occupied.
     * if occupied, show error message. return false;
     * if not occupied, make the spot on the board true. return true
     * finally check if the game is won.
     * @param x x coordinate (row)
     * @param y y coordinate (column)
     * @return true if this move is successful.
     */
    private boolean makeAMove(int x, int y) {
        if (board[x][y] != 0) {
            // show the error message.
            return false;
        } else {
            board[x][y] = whoseMove();
            if (checkWin()) {
                return true;
            }
            setShowWhoseTurn();
            return true;
        }
    }

    // the cluster of functions to makeAMove, called when the imagebutton is pressed.
    public void play00(View view) {
        if (makeAMove(0, 0)) {
            if (board[0][0] == 1) {
                button00.setImageResource(R.color.blue);
            } else {
                button00.setImageResource(R.color.orange);
            }
            moves.add(0, new Moves(0, 0, board[0][0]));
        }
    }
    public void play01(View view) {
        if (makeAMove(0, 1)) {
            if (board[0][1] == 1) {
                button01.setImageResource(R.color.blue);
            } else {
                button01.setImageResource(R.color.orange);
            }
            moves.add(0, new Moves(0, 1, board[0][1]));
        }
    }
    public void play02(View view) {
        if (makeAMove(0, 2)) {
            if (board[0][2] == 1) {
                button02.setImageResource(R.color.blue);
            } else {
                button02.setImageResource(R.color.orange);
            }
            moves.add(0, new Moves(0, 2, board[0][2]));
        }
    }
    public void play10(View view) {
        if (makeAMove(1, 0)) {
            if (board[1][0] == 1) {
                button10.setImageResource(R.color.blue);
            } else {
                button10.setImageResource(R.color.orange);
            }
            moves.add(0, new Moves(1, 0, board[1][0]));
        }
    }
    public void play11(View view) {
        if (makeAMove(1, 1)) {
            if (board[1][1] == 1) {
                button11.setImageResource(R.color.blue);
            } else {
                button11.setImageResource(R.color.orange);
            }
            moves.add(0, new Moves(1, 1, board[1][1]));
        }
    }
    public void play12(View view) {
        if (makeAMove(1, 2)) {
            if (board[1][2] == 1) {
                button12.setImageResource(R.color.blue);
            } else {
                button12.setImageResource(R.color.orange);
            }
            moves.add(0, new Moves(1, 2, board[1][2]));
        }
    }
    public void play20(View view) {
        if (makeAMove(2, 0)) {
            if (board[2][0] == 1) {
                button20.setImageResource(R.color.blue);
            } else {
                button20.setImageResource(R.color.orange);
            }
            moves.add(0, new Moves(2, 0, board[2][0]));
        }
    }
    public void play21(View view) {
        if (makeAMove(2, 1)) {
            if (board[2][1] == 1) {
                button21.setImageResource(R.color.blue);
            } else {
                button21.setImageResource(R.color.orange);
            }
            moves.add(0, new Moves(2, 1, board[2][1]));
        }
    }
    public void play22(View view) {
        if (makeAMove(2, 2)) {
            if (board[2][2] == 1) {
                button22.setImageResource(R.color.blue);
            } else {
                button22.setImageResource(R.color.orange);
            }
            moves.add(0, new Moves(2, 2, board[2][2]));
        }
    }


    /**
     * set up all the spots to be false "unoccupied".
     * @param board
     */
    private static void setUpBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = 0;
            }
        }
    }

    /**
     * use a static int to represent which player is supposed to play now.
     * in case of undo, just call whoseMove() again.
     */
    private  static int whoseTurn;

    /**
     * change int whoseTurn from 1 to 2, or the other way around.
     * @return which player is supposed to play now
     */
    private static int whoseMove() {
        if (whoseTurn == 1) {
            whoseTurn = 2;
            return 1;
        } else {
            whoseTurn = 1;
            return 2;
        }
    }


    private static int firstMove() {
        Random random = new Random();
        if (random.nextBoolean()) {
            return 1;
            // display which player makes the first move.
        } else {
            return 2;
        }
    }

    private boolean checkWin() {
        Intent intent = new Intent(this, Winner.class);
        boolean end = false;
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] != 0) {
                if (board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                    if (board[i][0] == 1) {
                        intent.putExtra("winner", firstName);
                    } else {
                        intent.putExtra("winner", secondName);
                    }
                    startActivity(intent);
                    end = true;
                }
            }
            if (board[0][i] != 0) {
                if (board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                    if (board[i][0] == 1) {
                        intent.putExtra("winner", firstName);
                    } else {
                        intent.putExtra("winner", secondName);
                    }
                    startActivity(intent);
                    end = true;
                }
            }
        }
        if (board[1][1] != 0) {
            if (board[0][0] == board[1][1] && board[1][1] == board[2][2]
                    || board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
                if (board[1][1] == 1) {
                    intent.putExtra("winner", firstName);
                } else {
                    intent.putExtra("winner", secondName);
                }
                startActivity(intent);
                end = true;
            }
        }
        return end;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);
        //initialise all the buttons
        button00 = findViewById(R.id.button00);
        button01 = findViewById(R.id.button01);
        button02 = findViewById(R.id.button02);
        button10 = findViewById(R.id.button10);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);
        button20 = findViewById(R.id.button20);
        button21 = findViewById(R.id.button21);
        button22 = findViewById(R.id.button22);
        firstName = MainActivity.first;
        secondName = MainActivity.second;
        //create a list of moves for the convenience of undo and redo
        moves = new ArrayList();
        //initialise my board here. and also set it up.
        board = new int[3][3];
        setUpBoard(board);
        //let function firstMove() decide who plays first by changing int whoseTurn.
        whoseTurn = firstMove();
        showWhoseTurn = findViewById(R.id.showWhoseTurn);
        setShowWhoseTurn();
    }

    public void setShowWhoseTurn() {
        if (whoseTurn == 1) {
            showWhoseTurn.setText(firstName + " Plays");
        } else {
            showWhoseTurn.setText(secondName + " Plays");
        }
    }

    public void undo(View view) {
        try {
            int i = moves.get(0).getI();
            int j = moves.get(0).getJ();
            String coordinate = "" + i + j;
            switch (coordinate) {
                case "00":
                    button00.setImageResource(R.color.blankspot);
                    break;
                case "01":
                    button01.setImageResource(R.color.blankspot);
                    break;
                case "02":
                    button02.setImageResource(R.color.blankspot);
                    break;
                case "10":
                    button10.setImageResource(R.color.blankspot);
                    break;
                case "11":
                    button11.setImageResource(R.color.blankspot);
                    break;
                case "12":
                    button12.setImageResource(R.color.blankspot);
                    break;
                case "20":
                    button20.setImageResource(R.color.blankspot);
                    break;
                case "21":
                    button21.setImageResource(R.color.blankspot);
                    break;
                case "22":
                    button22.setImageResource(R.color.blankspot);
                    break;
            }
            board[i][j] = 0;
            whoseMove();
            setShowWhoseTurn();
            moves.remove(0);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "I CAN'T DO THAT, DAVID",
                    Toast.LENGTH_LONG).show();
        }
    }

}
