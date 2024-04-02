package cn.edu.nju.TicTacToe;

import java.util.ArrayList;

/**
 * 五子模式落子的类
 */
public class GameChessStrategy_F extends GameChessStrategy {
    private ArrayList <String> store_of_pos = new ArrayList<>();
    public void putChess(char[][] cells, Player currentPlayer, String chessPos) {
        if (store_of_pos.size() >= 10) {
            int m = store_of_pos.get(0).charAt(1) - '1';
            int n = store_of_pos.get(0).charAt(0) - 'A';
            cells[m][n] = '_';
            store_of_pos.remove(0);
        }
        int i = chessPos.charAt(1) - '1';
        int j = chessPos.charAt(0) - 'A';
        cells[i][j] = currentPlayer == Player.X ? 'X' : 'O';
        store_of_pos.add(chessPos);
    }
}
