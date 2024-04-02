package edu.nju;

import java.util.Scanner;

/**
 * 实现矩阵的加法、乘法以及控制台输出
 * 其中加法和乘法需要有两种实现方式
 * 1.传入一个矩阵进行2个矩阵的操作
 * 2.从控制台（console）读入一个矩阵，再进行操作
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * @author Ray Liu & Qin Liu
 */
public class MatrixCalculation {
	
	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * @return result matrix = A + B
	 */
	public int[][] plus(int[][] A, int[][] B){
		int [][] out = new int [A.length][A[0].length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				out[i][j] = A[i][j] + B[i][j];
			}
		}
		return out;
	}
	
	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * @return result matrix = A * B
	 */
	public int[][] times(int[][] A, int[][] B){
		int out [][] = new int [A.length][B[0].length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B[0].length; j++) {
				int sum = 0;
				for (int m = 0; m < A[0].length; m++) {
					sum += A[i][m] * B[m][j];
				}
				out[i][j] = sum;
			}
		}
		return out;
	}
	
	/**
	 * 从控制台读入矩阵数据，进行矩阵加法，读入数据格式如下：
	 * m n
	 * m * n 的数据方阵，以空格隔开
	 * 连续读入2个矩阵数据
	 * example:
	 * 4 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 4 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 返回一个新的矩阵
	 */
	public int [][] plusFromConsole(){
		Scanner scanner = new Scanner(System.in);
		//scan in the first matrix
		int m_a = scanner.nextInt();
		int n_a = scanner.nextInt();
		int a[][] = new int [m_a][n_a];
		for (int i = 0; i < m_a; i++) {
			for (int j = 0; j < n_a; j++) {
				a[i][j] = scanner.nextInt();
			}
		}

		//scan the second matrix
		int m_b = scanner.nextInt();
		int n_b = scanner.nextInt();
		int b[][] = new int [m_b][n_b];
		for (int i = 0; i < m_b; i++) {
			for (int j = 0; j < n_b; j++) {
				b[i][j] = scanner.nextInt();
			}
		}

		//add
		for (int i = 0; i < m_a; i++) {
			for (int j = 0; j< n_a; j++) {
				a[i][j] += b[i][j];
			}
		}
		return a;
	}

	/**
	 * 输入格式同上方法相同
	 * 实现矩阵的乘法
	 * 返回一个新的矩阵
	 */
	public int[][] timesFromConsole(){
		Scanner scanner = new Scanner(System.in);
		//scan in the first matrix
		int m_a = scanner.nextInt();
		int n_a = scanner.nextInt();
		int a[][] = new int [m_a][n_a];
		for (int i = 0; i < m_a; i++) {
			for (int j = 0; j < n_a; j++) {
				a[i][j] = scanner.nextInt();
			}
		}

		//scan the second matrix
		int m_b = scanner.nextInt();
		int n_b = scanner.nextInt();
		int b[][] = new int [m_b][n_b];
		for (int i = 0; i < m_b; i++) {
			for (int j = 0; j < n_b; j++) {
				b[i][j] = scanner.nextInt();
			}
		}

		//times
		int out[][] = new int [m_a][n_b];
		for (int i = 0; i < m_a; i++) {
			for (int j = 0; j < n_b; j++) {
				int sum = 0;
				for (int k = 0; k < n_a; k++) {
					sum += a[i][k] * b[k][j];
				}
				out[i][j] = sum;
			}
		}
		return out;
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
	public void print(int[][] A){
		System.out.println();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				System.out.print(A[i][j]);
				if (j != A[0].length - 1) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
