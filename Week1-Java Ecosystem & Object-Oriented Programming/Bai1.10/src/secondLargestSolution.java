public static class secondLargestSolution {
    public int secondLargest(int[] arr) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        if (arr == null || arr.length < 2) {
            return -1;
        }
        for (int x : arr) {
            if (x > first) {
                second = first;
                first = x;
            }
            if (x < first && x > second) {
                second = x;
            }
        }
        if (second == Integer.MIN_VALUE)   {
            return -1;
        }
        return second;
    }
}
public static void main(String[] args) {
    secondLargestSolution solution = new secondLargestSolution();
    System.out.println("So lon thu 2 trong mang la: " + solution.secondLargest(new int[]{12, 5, 4, 56, -34}));
    System.out.println("So lon thu 2 trong mang la: " + solution.secondLargest(new int[]{12, 12, 4, -56, 4}));
    System.out.println("So lon thu 2 trong mang la: " + solution.secondLargest(new int[]{12}));
    System.out.println("So lon thu 2 trong mang la: " + solution.secondLargest(new int[]{127787, 0, 0, -56, -34}));
}