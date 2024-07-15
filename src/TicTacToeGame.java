import controllers.GameController;
import models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {

        // System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the dimension of the board.");
        int dimension = scanner.nextInt();

        System.out.println("Are there any bots in this?");
        String isBotString = scanner.next();

        List<Player> players= new ArrayList<>();
        int toIterate = dimension - 1;

        // Add validations for already taken symbols

         if(isBotString.equals("y")) {
             toIterate -= 1;

             System.out.println("Enter the name of the bot: ");
             String name = scanner.next();

             System.out.println("Enter the symbol of the bot: ");
             char symbol = scanner.next().charAt(0);

             players.add(new Bot(name, symbol, BotDifficultyLevel.EASY));
         }

         for (int i = 1; i < toIterate; i++){
             System.out.println("Enter the name of the player: " + i + 1);
             String name = scanner.next();

             System.out.println("Enter the symbol of the player: " + i + 1);
             char symbol = scanner.next().charAt(0);

             players.add(new Player(name, symbol, PlayerType.HUMAN));

         }

         GameController gameController = new GameController();
        Game game = gameController.createGame(
                dimension,
                players
        );

        while(gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)){

            System.out.println("This is current state of the board");
            gameController.displayBoard(game);

            System.out.println("Do you want to do an undo? yes/no");
            String needUndo = scanner.next();

            if(needUndo.equals("yes")){
                gameController.undo(game);
            }else{
                gameController.executeNextMove(game);
            }
        };

        // DRAW or ENDED
        System.out.println("The game has ended");
        if (game.getGameStatus().equals(GameStatus.ENDED))
            System.out.println("The winner is: " + gameController.getWinner(game).getName());
        gameController.displayBoard(game);
    }
}