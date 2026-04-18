package Bai8.code;

public class Person {
    private String name;
    private Person me;

    public Person(String name) {
        this.name = name;
    }

    public Person(Person me) {
        this.name = me.name;
    }

    public void setMe(Person other) {
        this.me = other;
    }

    public Person getMe() {
        return me;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Person p = new Person("Kirk");
        p.setMe(p);
        System.out.println(p.getMe().getName());
        p = null;
    }
}

/*
1. Sau khi setMe(p) có bao nhiêu đối tượng tồn tại?
- Chỉ có 1 đối tượng duy nhất tồn tại trong bộ nhớ (đối tượng mang tên "Kirk").
2. Sau dòng lệnh p = null; đối tượng Person có bị xóa ngay lập tức khỏi bộ nhớ không? Giải thích cơ chế hoạt động của Garbage Collection trong trường hợp này.
- Không, đối tượng không bị xóa ngay lập tức.
- Giải thích cơ chế: rong Java, lập trình viên không có quyền xóa đối tượng trực tiếp. Khi bạn gán p = null, bạn chỉ đang "cắt đứt" sợi dây kết nối từ hàm main tới đối tượng trong bộ nhớ.
+ Bộ thu gom rác (Garbage Collector - GC) là một tiến trình chạy ngầm tự động. GC sẽ tự quyết định thời điểm đi "dọn rác" (thường là khi nó rảnh rỗi hoặc khi bộ nhớ Heap sắp đầy). Khi GC chạy, nó sẽ quét qua bộ nhớ, phát hiện ra đối tượng "Kirk" không còn ai bên ngoài kết nối tới nữa, lúc đó nó mới thực sự tiêu hủy đối tượng này để giải phóng RAM.
3. Đối tượng Person có thể được truy cập lại không? Giải thích.
- Tuyệt đối không thể truy cập lại được nữa.
- Giải thích: Để điều khiển được một đối tượng trong bộ nhớ Heap, chương trình bắt buộc phải đi qua các biến tham chiếu nằm ở hàm main (bộ nhớ Stack). Vì sợi dây kết nối duy nhất là p đã bị cắt đứt (p = null), chương trình đã hoàn toàn "mất dấu" địa chỉ của đối tượng này. Dù bên trong đối tượng vẫn có biến me tự trỏ vào chính nó, nhưng trường hợp này trong Java gọi là "Hòn đảo cô lập" (Island of Isolation) - tự nó chơi với nó chứ không ai bên ngoài chạm vào được nữa.
4. Vẽ sơ đồ bộ nhớ (Stack và Heap) tại 2 thời điểm: trước và sau khi p = null.
*/
