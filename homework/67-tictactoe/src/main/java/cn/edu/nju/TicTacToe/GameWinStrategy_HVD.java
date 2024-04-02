package cn.edu.nju.TicTacToe;
/**
 * 横竖斜方式获胜对应的类，应该考虑到可扩展性，当有新的获胜模式出现时更易于添加
 * hint：采用接口的方式，接口与实现相分离
 * @author Xin Feng & Qiu Liu
 *
 */
public class GameWinStrategy_HVD {
	/**
	 * 根据需要修改获胜的方法
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
		
		for (int i = 0; winChar == 0 && i < cells.length - 2; i++) {
			for (int j = 0; j < cells.length - 2; j++) {
				if (cells[i][j] != '_' &&
						cells[i][j] == cells[i + 1][j + 1] && cells[i + 1][j + 1] == cells[i + 2][j + 2]) {
					winChar = cells[i][j];
					break;
				}
			}
		}

		for (int i = 0; winChar == 0 && i < cells.length - 2; i++) {
			for (int j = 2; j < cells.length; j++) {
				if (cells[i][j] != '_' &&
						cells[i][j] == cells[i + 1][j - 1] && cells[i + 1][j - 1] == cells[i + 2][j - 2]) {
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