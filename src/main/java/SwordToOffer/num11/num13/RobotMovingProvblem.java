package SwordToOffer.num11.num13;

public class RobotMovingProvblem {
    public static int movingCount(boolean visited[][], int row, int column, int rows, int columns, int k) {

        if (checkRowAndColumnIsMeet(visited, row, column, rows, columns, k)) {
            visited[row][column] = true;
            return 1 + movingCount(visited, row - 1, column, rows, columns, k) +
                    movingCount(visited, row + 1, column, rows, columns, k) +
                    movingCount(visited, row, column - 1, rows, columns, k) +
                    movingCount(visited, row, column + 1, rows, columns, k);
        }

        return 0;
    }

    public static int movingCount(int row, int column, int rows, int columns, int k) {
        boolean visited[][] = new boolean[rows][columns];
        int count =  movingCount(visited, row, column, rows, columns, k);
        return count;
    }


    public static boolean checkRowAndColumnIsMeet(boolean visited[][], int row,
                                                  int column, int rows, int columns, int k) {
        if (row < 0 || row >= rows || column < 0 || column >= columns || visited[row][column])
            return false;
        int bitSum = 0;
        while (row != 0) {
            bitSum += row % 10;
            row = row / 10;
        }
        while (column != 0) {
            bitSum += column % 10;
            column = column / 10;
        }
        return bitSum <= k;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(0, 0, 10, 2, 5));
    }

}



