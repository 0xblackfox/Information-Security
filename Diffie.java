public class Diffie {
    public static void main(String[] args) {
        long p = 11 ,g=7 , alice_private_key=3,bob_private_key=9;
        long introder_private_key_a=8,introder_private_key_b=6;

        long a_public_key = public_key_generation(p,g,alice_private_key);
        long b_public_key= public_key_generation(p,g,bob_private_key);
        long a_secret_key = secret_key_generation(a_public_key,bob_private_key,p);
        long b_secret_key = secret_key_generation(b_public_key,alice_private_key,p);

        long introder_public_key_a = public_key_generation(p,g,introder_private_key_a);
        long introder_public_key_b = public_key_generation(p,g,introder_private_key_b);
        long secret_a = intruder_secret_key(a_public_key,p,introder_private_key_b);
        long secret_b = intruder_secret_key(b_public_key,p,introder_private_key_a);

        long secret_key_alice = secret_key_generation(introder_public_key_b,alice_private_key,p);
        long secret_key_bob = secret_key_generation(introder_public_key_a,bob_private_key,p);

        System.out.println("Before Attack----------------------------------");
        System.out.println("Secret key of alice ::::"+a_secret_key);
        System.out.println("Secret key of bob   ::::"+b_secret_key+"\n");
        System.out.println("After Attack----------------------------------");
        System.out.println("Darth computed secret key for alice::"+secret_a);
        System.out.println("Darth computed secret key for Bob::"+secret_b+"\n");
        System.out.println("Alice computed Secret key :::: "+secret_key_alice);
        System.out.println("Bob computed Secret key   ::::"+secret_key_bob);
    }
    private static long intruder_secret_key(long public_key, long p, long i) {
        long k = (long)Math.pow(public_key,i) % p;
        return k;
    }

    private static long secret_key_generation(long public_key, long private_key, long p) {
        long k = (long)Math.pow(public_key,private_key) % p;
        return k;
    }

    private static long public_key_generation(long p, long g, long key) {
        long k = (long)Math.pow(g,key) % p;
        return k;
    }
}
