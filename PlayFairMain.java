import java.util.Scanner;

public class PlayFairMain {
    public static void main(String[] args) {
        PlayFair obj = new PlayFair();
        Scanner x = new Scanner(System.in);
        String key =x.next();
        obj.ModifyKey(key);
        obj.KeyGenerate();

        String msg = x.next();
        msg=msg.toUpperCase();
        String msg1=obj.encrypt(msg);
        System.out.println("Encrypted msg : "+msg1);
        //System.out.println("Decrypt msg : "+obj.decrypt(msg1));

    }
}
