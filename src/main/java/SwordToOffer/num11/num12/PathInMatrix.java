package SwordToOffer.num11.num12;

public class PathInMatrix {
    public static boolean findPath(char[][] matrix, String path) {
        int rows = matrix.length;  //行
        if (rows == 0)
            return false;
        int columns = matrix[0].length;  //列
        int pathLength = 0;//已经找到的链路包含的字符数。 例 要找bfce  若已找到bf 则pathLength = 2
        boolean[][] visited = new boolean[rows][columns];  //默认false

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (findPathCore(matrix, visited, row, column, pathLength, path)) {
                    return true;
                }

            }
        }
        return false;
    }
    public static boolean findPathCore(char[][] matrix, boolean[][] visited,
                                       int row, int column, int pathLength, String path) {
        if (pathLength == path.length())
            return true;
        boolean hasPath = false;
        //如果path.charAt(pathLength) == matrix[row][column] 并且该元素没被访问过，则递归访问下一个
        if (row >= 0 && row < matrix.length && column >= 0 && column < matrix[0].length
                && path.charAt(pathLength) == matrix[row][column] && !visited[row][column]){
            ++ pathLength;
            visited[row][column] = true;

            hasPath = findPathCore(matrix, visited, row-1, column, pathLength, path)||
                    findPathCore(matrix, visited, row+1, column, pathLength, path)||
                    findPathCore(matrix, visited, row, column-1, pathLength, path)||
                    findPathCore(matrix, visited, row, column+1, pathLength, path);
            if (!hasPath){
                --pathLength;
                visited[row][column] = false;
            }
        }
        return hasPath;
    }
    public static void main(String[] args) {
        char[][] matrix = {{'a', 'b', 't', 'g'},
                {'c', 'f', 'z', 's'},
                {'j', 'd', 'e', 'h'}};
        //String s = "hello";System.out.println(s.charAt(0));
        boolean b =PathInMatrix.findPath(matrix, "bfce");
        System.out.println(b);
    }
}
