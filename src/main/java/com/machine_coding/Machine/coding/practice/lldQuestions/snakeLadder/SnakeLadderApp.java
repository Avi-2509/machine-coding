package com.machine_coding.Machine.coding.practice.lldQuestions.snakeLadder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.machine_coding.Machine.coding.practice.lldQuestions.snakeLadder.model.Cell;
import com.machine_coding.Machine.coding.practice.lldQuestions.snakeLadder.model.Player;
import com.machine_coding.Machine.coding.practice.lldQuestions.snakeLadder.model.SnakeLadderBoard;
import com.machine_coding.Machine.coding.practice.lldQuestions.snakeLadder.service.PlayService;
import com.machine_coding.Machine.coding.practice.lldQuestions.snakeLadder.service.SnakeLadderBoardService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SnakeLadderApp {
    public static void main(String[] args) {

        SnakeLadderBoardService snakeLadderBoardService = new SnakeLadderBoardService();
        PlayService playService = new PlayService(snakeLadderBoardService);
        SnakeLadderBoard snakeLadderBoard = snakeLadderBoardService.getSnakeLadderBoard();
        Scanner scanner = new Scanner(System.in);
        int snakeCount = scanner.nextInt();

        List<List<Cell>> board = snakeLadderBoard.getBoard();
        while (snakeCount > 0){
            int startCellNumber = scanner.nextInt();
            int endCellNumber = scanner.nextInt();

            Cell startCell = snakeLadderBoardService.getcell(startCellNumber, board);
            Cell endCell = snakeLadderBoardService.getcell(endCellNumber, board);

            snakeLadderBoardService.addSnake(startCell, endCell, startCellNumber, endCellNumber, board);
            snakeCount -= 1;
        }

        int ladderCount = scanner.nextInt();
        while (ladderCount > 0) {
            int startCellNumber = scanner.nextInt();
            int endCellNumber = scanner.nextInt();

            Cell startCell = snakeLadderBoardService.getcell(startCellNumber, board);
            Cell endCell = snakeLadderBoardService.getcell(endCellNumber, board);

            snakeLadderBoardService.addLadder(startCell, endCell, startCellNumber, endCellNumber, board);
            ladderCount -= 1;
        }

        boolean isAnyPlayerReachedWinningCell = false;
        Player playerOne = new Player();
        playerOne.setName("Avi");
        Player playerTwo = new Player();
        playerTwo.setName("Aman");

        while (true){
            Random random = new Random();
            int diceNumber = random.nextInt(1, 7);

            playService.playBoard(playerOne, snakeLadderBoard, diceNumber);

            if(playerOne.getCurrentCell().getCellNumber() == 100){
                System.out.println(playerOne.getName() + " " + "win");
                break;
            }
            diceNumber = random.nextInt(1, 7);
            playService.playBoard(playerTwo, snakeLadderBoard, diceNumber);
            if(playerTwo.getCurrentCell().getCellNumber() == 100){
                System.out.println(playerTwo.getName() + " " + "win");
                break;
            }
        }

//        try {
//            snakeLadderBoardService.printBoard(board);
//        } catch (Exception exception){
//            System.out.println(exception.getMessage());
//        }

        int playerCount = scanner.nextInt();
    }
}
