package com.machine_coding.Machine.coding.practice.lldQuestions.snakeLadder.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {
    int cellNumber;
    boolean isLadderStarted;
    boolean isLadderEnded;
    boolean isSnakeStarted;
    boolean isSnakeEnded;
    int ladderNewCellNumber;
    int snakeNewCellNumber;
}
