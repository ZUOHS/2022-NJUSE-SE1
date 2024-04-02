package cn.nju.test9arrivalofgeneral2;

public class ArrivalOfGeneral {

    /**
     * 处理士兵交换次数
     * @param num 士兵个数
     * @param heightArr 身高数组
     * @return 交换次数
     */
    public static int calculate(int num, int[] heightArr) {
        int max = heightArr[0];
        int min = heightArr[0];
        int max_index = 0;
        int min_index = 0;
        for (int i = 0; i < num; i++) {
            if (heightArr[i] > max) {
                max = heightArr[i];
                max_index = i;
            } else if (heightArr[i] <= min) {
                min = heightArr[i];
                min_index = i;
            }
        }
        if (min_index >= max_index) {
            return (num - 1 - min_index) + max_index;
        } else {
            return (num - 1 - min_index) + max_index - 1;
        }
    }
}
