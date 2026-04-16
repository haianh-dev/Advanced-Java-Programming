public static class GcdSolution {
    public int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
public static void main(String[] args) {
    GcdSolution solution = new GcdSolution();
    System.out.println("GCD(18, 36) = " + solution.gcd(18, 36));
    System.out.println("GCD(81, 63) = " + solution.gcd(81, 63));
    System.out.println("GCD(13, 0) = " + solution.gcd(13, 0));
    System.out.println("GCD(-16, 38) = " + solution.gcd(16, 38));
}
