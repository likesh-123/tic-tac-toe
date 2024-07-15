package models;
import java.util.List;

public class Board {
    private List<List<Cell>> board;
    private int dimension;

    public Board(int dimension){

    }

    public List<List<Cell>> getBoard(){
        return board;
    }

    public void setBoard(List<List<Cell>> board){
        this.board = board;
    }

    public void display(){

    }
}
