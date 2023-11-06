import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class RSA {
    public static void main(String[] args) {
        int p, q, n, z, d = 0, e;
        double encrypt;
        double decrypt;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of p : ");
        p = sc.nextInt();
        System.out.println("Enter the value of q : ");
        q = sc.nextInt();
        System.out.println("Enter the value of e : ");
        e = sc.nextInt();
        int msg= sc.nextInt();
        n = p * q;
        z = (p - 1) * (q - 1);
        d = (z+1)/e;
        encrypt = (Math.pow(msg, e)) % n;
      //  BigInteger N = BigInteger.valueOf(n);
    //    BigInteger C = BigDecimal.valueOf(encrypt).toBigInteger();
      //  decrypt = (C.pow(d)).mod(N);
        decrypt = (Math.pow(encrypt,d))%n;
        System.out.println("Decrypted message is : " + decrypt);
        System.out.println("The value of n = " + n);
        System.out.println("The value of Totient Funtion = " + z);
        System.out.println("the value of d = " + d);
        System.out.println("Encrypted message is : " + encrypt);
        System.out.println("Decrypted message is : " + decrypt);
    }
}