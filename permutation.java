class permutationProblem {
  public static void main(String[] args) {
    permutationProblem mn = new permutationProblem();
    int[] array1 = {1,2,3,4,5};
    int[] array2 = {5,4,3,2,1,0};
    boolean result = mn.permutation(array1, array2);
    System.out.println(result);

  }

  // Permutation
  public boolean permutation(int[] array1, int[] array2){
    if (array1.length != array2.length ) {
      return false;
    }
    int sum1 = 0;
    int sum2 = 0;
    int mul1 = 1;
    int mul2 = 1;

    for (int i = 0; i<array1.length; i++) {
      sum1 += array1[i];
      sum2 += array2[i];
      mul1 *= array1[i];
      mul2 *= array2[i];
    }
    if (sum1 == sum2 && mul1 == mul2) {
      return true;
    }
    return false;
  }

}
