package bai5.code;

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public K getKey() {
        return key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return key + " - " + value;
    }
}

public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> p1 = new Pair<>("Tuoi", 20);
        Pair<String, String> p2 = new Pair<>("Ma SV", "SV001");
        Pair<Integer, Double> p3 = new Pair<>(105, 21.5);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}

// Yêu cầu : Thử nghiệm lỗi
// Lỗi biên dịch: Không thể truyền tham số String "Hai mươi" vào vị trí của Integer.
// Pair<String, Integer> errorPair = new Pair<>("Lỗi", "Hai mươi");