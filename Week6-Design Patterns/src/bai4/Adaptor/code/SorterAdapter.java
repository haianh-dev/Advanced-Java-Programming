package bai4.Adaptor.code;

import java.util.Arrays;

interface Sorter {
    int[] sort(int[] arr);
}

class LegacySorter {
    public int[] quickSort(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }
}

public class SorterAdapter implements Sorter {
    private LegacySorter sorter;

    public SorterAdapter(LegacySorter sorter) {
        this.sorter = sorter;
    }

    @Override
    public int[] sort(int[] arr) {
        return sorter.quickSort(arr);
    }

    public static void main(String[] args) {
        LegacySorter sorter = new LegacySorter();
        Sorter adaptor = new SorterAdapter(sorter);

        System.out.println("Sorted Array: " + Arrays.toString(adaptor.sort(new int[]{1, 2, 7, 9, 12, 3, 45, 22, -4})));
    }
}
