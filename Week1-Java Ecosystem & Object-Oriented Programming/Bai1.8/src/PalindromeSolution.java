public static class PalindromeSolution {
    public boolean isPalindrome(int n) {
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
        return reversed == n;
    }
}
public static void main(String[] args) {
    PalindromeSolution solution = new PalindromeSolution();
    System.out.println("12 is Palindrome? " + solution.isPalindrome(12));
    System.out.println("80 is Palindrome? " + solution.isPalindrome(80));
    System.out.println("-78 is Palindrome? " + solution.isPalindrome(-78));
    System.out.println("1441441 is Palindrome? " + solution.isPalindrome(1441441));
}