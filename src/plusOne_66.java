public class plusOne_66 {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; --i) {
            ++digits[i];
            digits[i] %= 10;
            if (digits[i] != 0)
                return digits;
        }
        // All other digits have already became 0
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public int[] plusOne_2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }
            digits[i] = 0;
        }
        // All other digits have already became 0, 999 + 1
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
