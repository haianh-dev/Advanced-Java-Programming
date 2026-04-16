public static class FibSolution {
    public long fib(long n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        long f0 = 0;
        long f1 = 1;
        long fn = 0;
        for (long i = 2; i <= n; i++) {
            if (f1 > Long.MAX_VALUE - f0) {
                return Long.MAX_VALUE;
            }
            fn = f1 + f0;
            f0 = f1;
            f1 = fn;
        }
        return fn;
    }
}

public static void main(String[] args) {
    FibSolution solution = new FibSolution();
    long[] testCases = {
            -5,
            10,
            18,
            36,
            67,
            100,
    };
    System.out.println("Ket qua:");
    System.out.println("--------");

    for (long n : testCases) {
        long result = solution.fib(n);
        if (result == Long.MAX_VALUE) {
            System.out.println("F(" + n + ") = Vuot qua gioi han (MAX_VALUE)");
        } else {
            System.out.println("F(" + n + ") = " + result);
        }
    }
}

