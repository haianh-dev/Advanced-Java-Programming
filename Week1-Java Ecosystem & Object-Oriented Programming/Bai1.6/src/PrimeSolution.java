public static class PrimeSolution {
    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i*i <= n; i += 6) {
            if (n % i == 0 || n %  (i+2) == 0) {
                return false;
            }
        }
        return true;
    }
}
 public static void main(String[] args) {
    PrimeSolution solution = new PrimeSolution();
    System.out.println("5 is Prime? " + solution.isPrime(5));
    System.out.println("78 is Prime? " + solution.isPrime(78));
    System.out.println("71111111 is Prime? " + solution.isPrime(71111111));
    System.out.println("-67 is Prime? " + solution.isPrime(-67));
    System.out.println("0 is Prime? " + solution.isPrime(0));
 }
