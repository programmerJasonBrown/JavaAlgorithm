package zuoShen.class07;

public class ShortestPath {
    public static int process(int[][] matrix, int i, int j) {
//      如果已经走到最右下角了，返回右下角的值
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            return matrix[i][j];
        }
//      如果走到了最后一行，则只能往右走了
        if (i == matrix.length - 1) {
            return matrix[i][j] + process(matrix, i, j + 1);
        }
//      如果走到了最后一列，则只能往下走了
        if (j == matrix[0].length - 1) {
            return matrix[i][j] + process(matrix, i + 1, j);
        }
//      右边位置到右下角的最短路径和
        int right = process(matrix, i, j + 1);
//      下边位置到右下角的最短路径和
        int down = process(matrix, i + 1, j);

        return matrix[i][j] + Math.min(right, down);
    }
}
