package cn.edu.nju.TicTacToe;
/**
 * 横竖方式获胜对应的类
 * @author Xin Feng & Qiu Liu
 *
 */
public class GameWinStrategy_HV extends GameWinStrategy_HVD{
	/**
	 * 自行实现检测获胜的方法
	 * @param cells  棋盘对应的char二维数组
	 * @return  检测结果
	 */
	public Result check(char[][] cells)
	{
		char winChar = 0;
		for(int i=0; i < cells.length; i++){
			for (int j = 0; j < cells.length - 2; j++) {
				if (cells[i][j] != '_' &&
						cells[i][j] == cells[i][j + 1] && cells[i][j + 1] == cells[i][j + 2]) {
					winChar = cells[i][j];
					break;
				}
			}
		}

		for(int j=0; winChar == 0 && j < cells.length; j++){
			for (int i = 0; i < cells.length - 2; i++) {
				if (cells[i][j] != '_' &&
						cells[i][j] == cells[i + 1][j] && cells[i + 1][j] == cells[i + 2][j]) {
					winChar = cells[i][j];
					break;
				}
			}
		}

		switch(winChar) {
			case 'X': return Result.X_WIN;
			case 'O': return Result.O_WIN;
			default: break;
		}

		for(int i = 0; i < cells.length; ++i) {
			for(int j = 0; j < cells.length; ++j) {
				if(cells[i][j] == '_')
					return Result.GAMING;
			}
		}

		return Result.DRAW;
	}
}