import java.util.Scanner;

/**
 * 矩阵类，实现矩阵的加法，矩阵乘法，点乘以及转置方法
 * 其中加法和点乘方法需要有两种实现方式
 * 1.传入一个MyMatrix对象进行2个矩阵的操作
 * 2.从控制台（console）读入一个矩阵数据，再进行操作
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * @author Ray Liu & Qin Liu
 *
 */
public class MyMatrix {
	private int[][] data;
	int m;
	int n;
	
	/**
	 * 构造函数，参数为2维int数组
	 * a[i][j]是矩阵中的第i+1行，第j+1列数据
	 * @param a
	 */
	public MyMatrix(int[][] a){
		this.data = a;
		this.m = a.length;
		this.n = a[0].length;
	}

	public int[][] getData() {
		return data;
	}

	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * @param B
	 * @return
	 */
	public MyMatrix plus(MyMatrix B){
		int[][] matrixB = B.getData();
		int[][] out = new int[this.m][this.n];
		for (int i = 0; i < this.m; i++) {
			for (int j = 0; j < this.n; j++) {
				out[i][j] = data[i][j] + matrixB[i][j];
			}
		}
		return new MyMatrix(out);
	}

	
	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * @param B
	 * @return
	 */
	public MyMatrix times(MyMatrix B){
		int[][] matrixB = B.getData();
		int[][] out = new int[this.m][B.n];
		for (int i = 0; i < this.m; i++) {
			for (int j = 0; j < B.n; j++) {
				int sum = 0;
				for (int k = 0; k < this.n; k++) {
					sum += data[i][k] * matrixB[k][j];
				}
				out[i][j] = sum;
			}
		}
		return new MyMatrix(out);
	}
	
	/**
	 * 实现矩阵的点乘，返回一个新的矩阵
	 * @param b
	 * @return
	 */
	public MyMatrix times(int b){
		int [][] out = new int[this.m][this.n];
		for (int i = 0; i < this.m; i++) {
			for (int j = 0; j < this.n; j++) {
				out[i][j] = b * data[i][j];
			}
		}
	    return  new MyMatrix(out);
	}
	
	/**
	 * 实现矩阵的转置，返回一个新的矩阵
	 * @return
	 */
	public MyMatrix transpose(){
		int [][] out = new int[this.n][this.m];
		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.m; j++) {
				out[i][j] = data[j][i];
			}
		}
		return new MyMatrix(out);
	}

	public MyMatrix GetNewMatrix() {
		Scanner scanner = new Scanner(System.in);
		int p = scanner.nextInt();
		int q = scanner.nextInt();
		int [][] out = new int[p][q];
		for (int i = 0; i < p; i++) {
			for (int j = 0; j < q; j++) {
				out[i][j] = scanner.nextInt();
			}
		}
		return new MyMatrix(out);
	}
	/**
	 * 从控制台读入矩阵数据，进行矩阵加法，读入数据格式如下：
	 * m n
	 * m * n 的数据方阵，以空格隔开
	 * example:
	 * 4 3
	 * 1 2 3 
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 返回一个新的矩阵
	 * @return
	 */
	public MyMatrix plusFromConsole(){
		MyMatrix ToPlus = GetNewMatrix();
		return this.plus(ToPlus);
	}
	
	/**
	 * 输入格式同上方法相同
	 * 实现矩阵的乘法
	 * 返回一个新的矩阵
	 * @return
	 */
	public MyMatrix timesFromConsole(){
		MyMatrix ToTimes = GetNewMatrix();
		return this.times(ToTimes);
	}
	
	/**
	 * 打印出该矩阵的数据
	 * 起始一个空行，结束一个空行
	 * 矩阵中每一行数据呈一行，数据间以空格隔开
	 * example：
	 * 
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 
	 */
	public void print(){
		System.out.println();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(data[i][j]);
				if (j != n - 1) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}
