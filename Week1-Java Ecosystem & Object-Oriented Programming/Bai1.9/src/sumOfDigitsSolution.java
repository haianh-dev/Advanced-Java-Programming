public static class sumOfDigitsSolution {
    public int sumofdigits(int n) {
        int value = Math.abs(n);
        int temp = 0;
        int sum = 0;
        while (value > 0) {
            temp = value % 10;
            sum = sum + temp;
            value = (value - temp) / 10;
        }
        return sum;
    }
}
public static void main(String[] args) {
    sumOfDigitsSolution solution = new sumOfDigitsSolution();
    System.out.println("Tong cac chu so cua 12 la: " + solution.sumofdigits(12));
    System.out.println("Tong cac chu so cua -899 la: " + solution.sumofdigits(-899));
    System.out.println("Tong cac chu so cua 0 la: " + solution.sumofdigits(0));
    System.out.println("Tong cac chu so cua 123456789 la: " + solution.sumofdigits(123456789));
    System.out.println("Tong cac chu so cua -3663 la: " + solution.sumofdigits(-3663));

}
