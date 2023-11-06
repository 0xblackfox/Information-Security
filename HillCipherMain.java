import java.util.Scanner;

public class HillCipherMain {
    public static void main(String[] args) {
        HillCipher obj = new HillCipher();
        Scanner x = new Scanner(System.in);
        System.out.println("Enter the size of the block : ");
        int size = x.nextInt();
        int[][] key = new int[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                key[i][j]=x.nextInt();
            }
        }

        System.out.println("Enter Plain text: (Must be multiple of "+size+"): ");
        String plaintext = x.next();
        System.out.println("Encrypted msg : "+ obj.Encrypt(plaintext,size,key));
    }
}