package controller;

import service.ApplicationService;

import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

import static utility.Utility.COMMA_SEPARATED_DELIMITER;

public class ApplicationController {
    private static Scanner sc = new Scanner(System.in);
    private ApplicationService applicationService = new ApplicationService();

    public void takeUserInput() {
        System.out.println("\nPlease enter your chess piece and it's current position separated by a space. Eg. King D5");
        String userInputString = sc.nextLine();
        System.out.println("You Entered : " + userInputString);
        processUserInput(userInputString);
    }

    private void processUserInput(String userInputString) {
        try {
            List<String> possibleMoves = applicationService.getMovesFor(userInputString);
            displayPossibleMovesToUser(possibleMoves);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        takeUserInput();
    }

    private void displayPossibleMovesToUser(List<String> possibleMoves) {
        if (possibleMoves.isEmpty()) {
            System.out.println("The player cannot move anywhere!");
        } else {
            System.out.print("Possible moves are: ");
            StringJoiner sj = new StringJoiner(COMMA_SEPARATED_DELIMITER);
            possibleMoves.forEach(sj::add);
            System.out.println(sj);
        }
    }
}