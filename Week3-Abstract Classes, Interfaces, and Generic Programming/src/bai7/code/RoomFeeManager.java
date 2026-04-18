package bai7.code;

import java.util.Scanner;

class Standard extends RoomFeeManager {
    static long standardPriceperDay = 500000;

    public Standard(long stayDays, int Case) {
        super(stayDays, Case);
    }

    public long getTotalPrice() {
        if (stayDays > 3) {
            return (long) (0.95 * (stayDays * standardPriceperDay));
        } else {
            return (long) (stayDays * standardPriceperDay);
        }
    }

    public void getInfo() {
        System.out.println("- Case " + Case + ": ");
        System.out.println(getTotalPrice());
    }
}

class VIP extends RoomFeeManager {
    static long standardPriceperDay = 2000000;

    public VIP(long stayDays, int Case) {
        super(stayDays, Case);
    }

    public long getTotalPrice() {
        return (long) (stayDays * standardPriceperDay);
    }

    public void getInfo() {
        System.out.println("- Case " + Case + ": ");
        System.out.println(getTotalPrice());
    }
}

public abstract class RoomFeeManager {
    long stayDays;
    int Case;

    public RoomFeeManager(long stayDays, int Case) {
        this.stayDays = stayDays;
        this.Case = Case;
    }

    public abstract long getTotalPrice();
    public abstract void getInfo();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong dat phong: ");
        int bookingCount = sc.nextInt();
        RoomFeeManager [] roomFeeManager = new RoomFeeManager[bookingCount];

        for (int i = 0; i < bookingCount; i++) {
            System.out.println("Nhap phong: ");
            int room = sc.nextInt();
            System.out.println("Nhap hang muc thue phong: ");
            String typeRoom = sc.next();
            sc.nextLine();

            if (typeRoom.equals("S")) {
                System.out.println("Nhap so dem o lai khach san: ");
                long stayDays = sc.nextLong();
                roomFeeManager[i] = new Standard(stayDays, room);
            } else if (typeRoom.equals("V")) {
                System.out.println("Nhap so dem o lai khach san: ");
                long stayDays = sc.nextLong();
                roomFeeManager[i] = new VIP(stayDays, room);
            }
        }

        for (RoomFeeManager room : roomFeeManager) {
            room.getInfo();
        }
    }
}
