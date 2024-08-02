import java.util.Arrays;
class rotateMatrixProblem {
  public static void main(String[] args) {
    rotateMatrixProblem mn = new rotateMatrixProblem();
    int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
    mn.rotateMatrix(matrix);
    System.out.println(Arrays.deepToString(matrix));


  }

  public int[][] rotateMatrix(int[][] matrix) {
    if (matrix.length == 0 || matrix.length != matrix[0].length) 
    return new int[][]{{0,0},{0,0}};
    
    int n = matrix.length;
    for (int i=0;i<n;i++) {
      for(int j=i;j<n;j++)
      {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];      // transposing the matrix
        matrix[j][i] = temp;
      }
    }
    
    for(int i=0;i<n;i++)
    {
      for(int j=0;j<n/2;j++)
      {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][n-j-1];  // reversing each rows of the matrix
        matrix[i][n-j-1] = temp;
      }
    }
    return matrix;

  }


}
