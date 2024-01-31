import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class partB{
    public static void main(String[] args) {
        int[] dieA = {1,2,3,4,5,6};
        int[] dieB = {1,2,3,4,5,6};

        HashSet<Integer> set = probability(dieA,dieB);
        HashSet<Integer> result = unDoomDice(dieA, dieB);

        System.out.println("Probability of obtaining the sums remains the same:- " + set.equals(result));
    }

    public static HashSet<Integer> probability(int[] dieA,int[] dieB){
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<dieA.length;i++){
            for(int j=0;j<dieB.length;j++){
                int sum = dieA[i] + dieB[j];
                if(map.containsKey(sum)){
                    map.put(sum, map.get(sum)+1);
                }else{
                    map.put(sum,1);
                }
            }
        }
        return new HashSet<>(map.values());
    }

    public static HashSet<Integer> unDoomDice(int[] dieA,int[] dieB){
        HashSet<Integer> set = probability(dieA, dieB);
        int[] newDieA = {4,4,4,4,4,4};
        HashSet<Integer> result = probability(newDieA, dieB);
        boolean status = set.equals(result);
        int i=0;
        while(!status){
            newDieA[i] = i+1;
            result = probability(newDieA, dieB);
            status = set.equals(result);
            i++; 
        }
        System.out.println("UnDoomed DieA:- "+Arrays.toString(newDieA));
        System.out.println("UnDoomed DieB:- "+Arrays.toString(dieB));
        
        return result;
    }
}