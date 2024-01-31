public class partA{
    public static void main(String[] args) {
        q1();   
    }
    public static void q1() {
        int a[] = { 1, 2, 3, 4, 5, 6 };
        int b[] = { 1, 2, 3, 4, 5, 6 };
        int totalCombinations = a.length * b.length;
    
        //Total Combinations of dices
        System.out.println("Total Combinations of two dices :-" + totalCombinations);
        System.out.println();
    
        int[][] combinations = new int[6][6];
        for (int i = 0; i < a.length; i++) {
          for (int j = 0; j < b.length; j++) {
            combinations[i][j] = a[i] + b[j];
          }
        }
        // Printing the combinations
        System.out.println("Distribution of all Possible combinations:-");
        for (int[] i : combinations) {
          for (int j : i) {
            System.out.print(j + " ");
          }
          System.out.println();
        }
        System.out.println();
    
        // Probability of all Possible Sums
        System.out.println("Probability of all Possible Sums:-");
        for (int i = 2; i <= 12; i++) {
          int count = 0;
          for(int[] row:combinations){
            for(int value:row){
                if(value==i){
                    count++;
                }
            }
          }
          double probability = (double) count / totalCombinations;
          System.out.println("P(Sum = " + i + ") = " + count + "/" + totalCombinations + " = " + probability);
        }
      }
}