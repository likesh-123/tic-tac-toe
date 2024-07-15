package models;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> board;
    private int dimension;

    public Board(int dimension){
        this.board = new ArrayList<>();
        for (int i = 0; i < dimension; i++){
            board.add(new ArrayList<>());
            for (int j = 0; j < dimension; j++){
                this.board.get(i).add(new Cell(i, j, CellState.EMPTY));
            }
        }
    }

    public List<List<Cell>> getBoard(){
        return board;
    }

    public void setBoard(List<List<Cell>> board){
        this.board = board;
    }

    public void display(){
        for (int i = 0; i < board.size(); i++){
            board.add(new ArrayList<>());
            for (int j = 0; j < board.size(); j++){
                if(this.board.get(i).get(j).getCellState().equals(CellState.EMPTY))
                    System.out.println("|   |");
                else
                    System.out.println("| " + this.board.get(i).get(j).getPlayer().getSymbol() + " |");
            }
            System.out.println();
        }
    }
}
