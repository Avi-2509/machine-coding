package com.machine_coding.Machine.coding.practice.lldQuestions.snakeLadder.model;

import java.util.ArrayList;
import java.util.List;

public class SnakeLadderBoard {
    List<List<Cell>> board = new ArrayList<>();
    public SnakeLadderBoard(final List<List<Cell>> board){
        this.board = board;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }
}
