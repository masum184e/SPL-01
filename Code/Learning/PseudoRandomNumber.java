class PseudoRandomNumber {
    static long multiplier = 1103515245;
    static long increment = 12345;
    static long modulus = (long) Math.pow(2, 31);
    long seed;

    PseudoRandomNumber(long seed) {
        this.seed = seed;
    }

    int nextInt() {
        seed = (multiplier * seed + increment) % modulus;
        return (int) seed;
    }

    int generateRandomNumber(int min, int max) {
        int range = max - min + 1;
        return min + nextInt() % range;
    }

    int pseudoRandomNumber(int min, int max) {
        int randomNumber = generateRandomNumber(min, max);
        if (randomNumber < 0) {
            randomNumber = -randomNumber;
        }
        return randomNumber;
    }

    public static void main(String[] args) {
        PseudoRandomNumber random = new PseudoRandomNumber(System.currentTimeMillis());

        int randomNumber = random.pseudoRandomNumber(0, 9);
        System.out.println("Random number between 0 and 9: " + randomNumber);
    }
}
