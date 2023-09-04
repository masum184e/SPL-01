public class PseudoRandomNumber {
    private static final long MULTIPLIER = 1103515245;
    private static final long INCREMENT = 12345;
    private static final long MODULUS = (long) Math.pow(2, 31);

    private long seed;

    public PseudoRandomNumber(long seed) {
        this.seed = seed;
    }

    public int nextInt() {
        seed = (MULTIPLIER * seed + INCREMENT) % MODULUS;
        return (int) seed;
    }

    public int generateRandomNumber(int min, int max) {
        int range = max - min + 1;
        int randomNumber = min + nextInt() % range;
        if(randomNumber<0)randomNumber=randomNumber*-1;
        return randomNumber;
    }
}
