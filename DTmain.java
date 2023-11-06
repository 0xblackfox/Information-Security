import java.util.Scanner;

public class DTmain {
    public static void main(String[] args) {
        DoubleTransposition obj = new DoubleTransposition();
        Scanner x = new Scanner(System.in);
        String message = x.next();
        char[][] temp=obj.makeArray(message,3,4);
        for(int i=0;i<3;i++){
            for(int j=0;j< 4;j++){
                System.out.print(" "+temp[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");

        String ciphertext=obj.Encrypt(temp,3,4);
        System.out.println("After Encryption: " +ciphertext);
        char[][] temp2=obj.makeArray(ciphertext,3,4);
        String plaintext=obj.decrypt(temp2,3,4);
        System.out.println("After Decryption: " +plaintext);

    }
}
