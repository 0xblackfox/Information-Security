import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Knapsack {
    public static void main(String[] args) {
        Integer[] private_key = {1,2,4,10,20,40};
        int[] public_key = new int[private_key.length];
        int n = 31, m=110, sum=0;
        int checker=0;
        int[] summation= new int[3];
        int xyz=0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input : ");
        String plaintext = sc.next();
       // String plaintext = "100100111100101110";
        char[] char_arr = plaintext.toCharArray();

        for (int i=0;i<private_key.length;i++){
            public_key[i]= (private_key[i] * n) % m;
        }


        here:
        for(int j=0;j<char_arr.length;j++){
            for (int k=xyz;k<public_key.length;k++){
                xyz++;
                sum = sum + (Character.getNumericValue(char_arr[j])*public_key[k]);
                if(xyz==public_key.length-1){
                    summation[checker]=sum;
                    checker++;
                    j++;
                    xyz=0;
                    sum=0;
                }
                continue here;
            }
        }
        //Encryption output value
        System.out.print("Encryption : ");
        for(int output=0;output<summation.length;output++){
            System.out.print(summation[output]+" ");
        }
        System.out.println(" ");

        //Decryption
        System.out.print("Decryption: ");
         int inverse_mod_value =  modInverse(n, m);
        for(int decry=0;decry<summation.length;decry++){
         int value = (summation[decry]*inverse_mod_value ) % m;
            sum_up(new ArrayList<Integer>(Arrays.asList(private_key)),value,new ArrayList<Integer>(Arrays.asList(private_key)));
        }

    }
    static int modInverse(int a, int m) {
        for (int x = 1; x < m; x++)
            if (((a%m) * (x%m)) % m == 1)
                return x;
        return 1;
    }
    static void sum_up(ArrayList<Integer> numbers, int target,ArrayList<Integer> check) {
        sum_up_recursive(numbers,target,new ArrayList<Integer>(),check);
    }
    static void sum_up_recursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial,ArrayList<Integer> check) {
        int s = 0;
        for (int x: partial) s += x;
        if (s == target) {
            ArrayList<Integer> newList = new ArrayList<Integer>();
            String s1 = "";
            for (int i : check) {
                int hukka = 0;
                for (int j : partial) {
                    if (i == j) {
                        newList.add(1);
                        hukka += 1;
                    }
                }
                if (hukka==0){
                    newList.add(0);
                }
            }
            for(Integer j : newList){
                s1+=j.toString();
            }
            System.out.print(s1+" ");
        }
        if (s >= target)
            return;
        for(int i=0;i<numbers.size();i++) {
            ArrayList<Integer> remaining = new ArrayList<Integer>();
            int n = numbers.get(i);
            for (int j=i+1; j<numbers.size();j++) remaining.add(numbers.get(j));
            ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
            partial_rec.add(n);
            sum_up_recursive(remaining,target,partial_rec,check);
        }
    }
}