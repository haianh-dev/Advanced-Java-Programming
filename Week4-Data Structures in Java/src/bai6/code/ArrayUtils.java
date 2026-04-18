package bai6.code;

class Student implements Comparable<Student>{
    String name;
    int gpa;

    public Student(String name, int gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.gpa, other.gpa);
    }

    @Override
    public String toString() {
        return name + "(" + gpa + ")";
    }
}

public class ArrayUtils {
    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        }

    public static <T extends Comparable<T>> void sort(T[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i ++) {
            for (int j = 0; j < (len - i - 1); j ++) {
                if  (array[j].compareTo(array[j+1])>0) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static <T> void printArray(T[] array) {
        for (T t: array) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] integer = {5, 1, 3, 2};
        sort(integer);
        printArray(integer);

        String[] string = {"Java", "C++", "Python"};
        sort(string);
        printArray(string);

        Student[] student = {
                new Student("NguyenVanA", 5),
                new Student("TranThiB", 8),
                new Student("LeVanC", 6)
        };
        sort(student);
        printArray(student);
    }
}