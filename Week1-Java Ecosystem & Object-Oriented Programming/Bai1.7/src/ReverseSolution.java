public static class ReverseSolution {
    public int reverse(int n) {
        long reversed = 0;
        int temp = Math.abs(n);
        while (temp > 0) {
            int lastDig = temp % 10;
            reversed = reversed * 10 + lastDig;
            temp = temp / 10;
        }
        if (n < 0) {
            reversed = - reversed;
        }
        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) reversed;
    }
}
public static void main(String[] args) {
    ReverseSolution solution = new ReverseSolution();
    System.out.println("Reversed(12) la " + solution.reverse(12));
    System.out.println("Reversed(244442) la " + solution.reverse(244442));
    System.out.println("Reversed(-36) la " + solution.reverse(-36));
    System.out.println("Reversed(60) la " + solution.reverse(60));
}