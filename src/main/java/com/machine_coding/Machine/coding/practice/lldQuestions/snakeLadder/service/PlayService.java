package com.machine_coding.Machine.coding.practice.lldQuestions.snakeLadder.service;

import com.machine_coding.Machine.coding.practice.lldQuestions.snakeLadder.model.Cell;
import com.machine_coding.Machine.coding.practice.lldQuestions.snakeLadder.model.Player;
import com.machine_coding.Machine.coding.practice.lldQuestions.snakeLadder.model.SnakeLadderBoard;

import java.util.List;

public class PlayService {

    SnakeLadderBoardService snakeLadderBoardService;
    public PlayService(SnakeLadderBoardService snakeLadderBoardService){
        this.snakeLadderBoardService = snakeLadderBoardService;
    }
    public void playBoard(Player player, SnakeLadderBoard snakeLadderBoard, Integer diceNumber){
        List<List<Cell>> board = snakeLadderBoard.getBoard();
        Cell cell = player.getCurrentCell();
        int previousCell;
        if(cell == null){
            cell = snakeLadderBoardService.getcell(diceNumber, board);
            previousCell = 0;
        }else{
            previousCell = cell.getCellNumber();
            cell = snakeLadderBoardService.getcell(cell.getCellNumber() + diceNumber, board);
        }

        if(cell.isLadderStarted()){
            cell = snakeLadderBoardService.getcell(cell.getLadderNewCellNumber(), board);
        }
        else if (cell.isSnakeStarted()){
            cell = snakeLadderBoardService.getcell(cell.getSnakeNewCellNumber(), board);
        }

        player.setCurrentCell(cell);
        System.out.println(player.getName() + " rolled a " + diceNumber + " and moved from " + previousCell + " to " +
                player.getCurrentCell().getCellNumber());
    }
}
