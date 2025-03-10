package com.machine_coding.Machine.coding.practice.lldQuestions.chessgame.pieces;

import com.machine_coding.Machine.coding.practice.lldQuestions.chessgame.Board;
import com.machine_coding.Machine.coding.practice.lldQuestions.chessgame.Color;

public class Rook extends Piece {
    public Rook(Color color, int row, int col) {
        super(color, row, col);
    }

    @Override
    public boolean canMove(Board board, int destRow, int destCol) {
        return (row == destRow || col == destCol);
    }
}
