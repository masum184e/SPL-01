class PseudoRandomNumber {
    long MULTIPLIER = 1103515245;
    long INCREMENT = 12345;
    long MODULUS = (long) Math.pow(2, 31);

    long seed;

    PseudoRandomNumber(long seed) {
        this.seed = seed;
    }

    int nextInt() {
        seed = (MULTIPLIER * seed + INCREMENT) % MODULUS;
        return (int) seed;
    }

    int generateRandomNumber(int min, int max) {
        int range = max - min + 1;
        int randomNumber = min + nextInt() % range;
        if(randomNumber<0)randomNumber=randomNumber*-1;
        return randomNumber;
    }
}