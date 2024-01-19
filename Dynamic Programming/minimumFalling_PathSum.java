/*  Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1). */

public class minimumFalling_PathSum {
    public static int minFallingPathSum(int[][] matrix) {
        int N = matrix.length;

        if(N == 1){
            return matrix[0][0];
        }
        int min = Integer.MAX_VALUE;

        for(int i=1;i<N;i++){
            for(int j=0;j<N;j++){
                if(j == 0){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j],matrix[i-1][j+1]);
                }
                else if(j == N-1){
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j],matrix[i-1][j-1]);
                }
                else{
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j],Math.min(matrix[i-1][j-1],matrix[i-1][j+1]));
                }

                if(i == N-1){
                    min = matrix[i][j] < min ? matrix[i][j] : min;
                }
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        minFallingPathSum(matrix);
    }
}