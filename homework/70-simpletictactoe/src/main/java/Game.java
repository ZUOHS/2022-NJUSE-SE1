import java.util.Arrays;

public class Game {
    
    //游戏主方法playGame
    //输入为对弈双方轮番落子的位置，以英文逗号为间隔，X先走

    public Result playGame(String s){
        Board myBoard = new Board();
        String[] moves = s.split(",");
        char player = 'X';
        for (String move: moves) {
            myBoard.NextMove(move, player);
            player = player == 'X' ? 'O' : 'X';
            myBoard.print();
        }

		return myBoard.check();
    }

    public static void main(String[] args){
        Game game = new Game();
        Result result = game.playGame(Arrays.toString(args));
        System.out.println(result);
    }
}

class Board {
    char [][] cells = new char[3][3];
    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = '_';
            }
        }
    }

    public void NextMove(String move,char player) {
        int i = move.charAt(1) - '1';
        int j = move.charAt(0) - 'A';
        cells[i][j] = player;
    }

    public void print() {
        System.out.println("  A B C");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < 3; j++) {
                System.out.print(" ");
                System.out.print(cells[i][j]);
            }
            System.out.println();
        }
    }

    public Result check() {
        char winner = 0;
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] != '_' &&
                cells[i][0] == cells[i][1] && cells[i][1] == cells[i][2]) {
                winner = cells[i][0];
                break;
            } else if (cells[0][i] != '_' &&
                cells[0][i] == cells[1][i] && cells[1][i] == cells[2][i]) {
                winner = cells[0][i];
                break;
            }
        }
        if (cells[1][1] != '_' && cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2]) {
            winner = cells[1][1];
        } else if (cells[1][1] != '_' && cells[0][2] == cells[1][1] && cells[1][1] == cells[2][0]) {
            winner = cells[1][1];
        }

        if (winner == 'X') {
            return Result.X_WIN;
        } else if (winner == 'O') {
            return Result.O_WIN;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == '_') {
                    return Result.GAMING;
                }
            }
        }
        return Result.DRAW;
    }
}