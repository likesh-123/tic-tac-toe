package models;

import exceptions.InvalidGameConstructionParameterException;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameStatus gameStatus;
    private int nextPlayerIndex;
//    private GameWinningStrategy gameWinningStrategy;
    private Player winner;

    private Game (){

    }

    public static GameBuilder getGameBuilder(){
        return new GameBuilder();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

//    public GameWinningStrategy getGameWinningStrategy() {
//        return gameWinningStrategy;
//    }
//
//    public void setGameWinningStrategy(GameWinningStrategy gameWinningStrategy) {
//        this.gameWinningStrategy = gameWinningStrategy;
//    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public static class GameBuilder{
        private int dimension;
        private List<Player> players;

        public GameBuilder(){

        }

        public GameBuilder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public boolean validate() throws InvalidGameConstructionParameterException{
            if(dimension < 3)
                throw new InvalidGameConstructionParameterException("Dimension of the Game cannot be less than 3");

            if (this.players.size() != this.dimension - 1)
                throw new InvalidGameConstructionParameterException("Total number of players should be " + (dimension - 1));

            return true;
        }

        public Game build() throws InvalidGameConstructionParameterException{
            // If there is any validations
            validate();

            Game game = new Game();
            game.setGameStatus(GameStatus.IN_PROGRESS);
            game.setPlayers(players);
            game.setMoves(new ArrayList<>());
            game.setBoard(new Board(dimension));
            game.setNextPlayerIndex(0);

            return game;
        }
    }
}
