package com.machine_coding.Machine.coding.practice.lldQuestions.snakeLadder.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.machine_coding.Machine.coding.practice.lldQuestions.snakeLadder.model.Cell;
import com.machine_coding.Machine.coding.practice.lldQuestions.snakeLadder.model.SnakeLadderBoard;

import java.util.ArrayList;
import java.util.List;

public class SnakeLadderBoardService {
    public void printBoard(List<List<Cell>> board) throws JsonProcessingException {
        for(List<Cell> cellList : board){
            for(Cell cell: cellList){
                System.out.println(new ObjectMapper().writer().writeValueAsString(cell));
            }
        }
    }

    public Cell getcell(int startCellNumber, List<List<Cell>> board) {

        for(List<Cell> cellList : board){
            for(Cell cell: cellList){
                if (cell.getCellNumber() == startCellNumber){
                    return cell;
                }
            }
        }
        return new Cell();
    }

    public void setCell(int startCellNumber, List<List<Cell>> board, Cell newCell) {

        for(List<Cell> cellList : board){
            for(Cell cell: cellList){
                if (cell.getCellNumber() == startCellNumber){
                    cellList.set(cellList.indexOf(cell), newCell);
                }
            }
            board.set(board.indexOf(cellList), cellList);
        }
    }

    public SnakeLadderBoard getSnakeLadderBoard(){
        int cellNumber = 0;
        List<List<Cell>> board = new ArrayList<>();
        for(int i = 0; i < 10; i++){

            List<Cell> cellList = new ArrayList<>();
            for(int j = 0; j < 10; j++){
                Cell cell = new Cell();
                cell.setCellNumber(cellNumber += 1);
                cell.setLadderStarted(Boolean.FALSE);
                cell.setLadderEnded(Boolean.FALSE);
                cell.setSnakeStarted(Boolean.FALSE);
                cell.setSnakeEnded(Boolean.FALSE);

                cellList.add(cell);
            }
            board.add(cellList);
        }

        return new SnakeLadderBoard(board);
    }

    public void addSnake(Cell startCell, Cell endCell, Integer startCellNumber, Integer endCellNumber, List<List<Cell>> board) {
        startCell.setSnakeStarted(Boolean.TRUE);
        startCell.setSnakeNewCellNumber(endCellNumber);
        endCell.setSnakeEnded(Boolean.TRUE);

        setCell(startCellNumber, board, startCell);
        setCell(endCellNumber, board, endCell);
    }

    public void addLadder(Cell startCell, Cell endCell, Integer startCellNumber, Integer endCellNumber, List<List<Cell>> board) {
        startCell.setLadderStarted(Boolean.TRUE);
        startCell.setLadderNewCellNumber(endCellNumber);
        endCell.setLadderEnded(Boolean.TRUE);

        setCell(startCellNumber, board, startCell);
        setCell(endCellNumber, board, endCell);
    }
}
