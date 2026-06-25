class Solution {
    private int countDigitAtPlace(int n, int digit, int place) {
        int higher;
        int current;
        int lower;

        higher = n / (place * 10);
        current = (n / place) % 10;
        lower = n % place;

        if (digit == 0) {
            // leading zeros
            if (higher == 0)
                return 0;
            if (current > 0)
                return higher * place + place;
            if (current == 0)
                return (higher - 1) * place + lower + 1;
            return (higher - 1) * place;
        }

        if (current > digit)
            return (higher + 1) * place;
        if (current == digit)
            return higher * place + lower + 1;
        return higher * place;
    }
    public int countDigitOne(int n) {
        int total = 0;

        for (int place = 1; place <= n; place *= 10) {
            total += countDigitAtPlace(n, 1, place);
        }

        return total;
    }
}
