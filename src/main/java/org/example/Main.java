package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int count = 0;

        String orderList[] = new String[5];
        int total = 0;
        List<Integer> stampCoupons = new ArrayList<>();
        while (true) {
            System.out.println("☆★☆★ 얼어죽어도 아이스만 ☆★☆★");
            System.out.println("1. 주문하기");
            System.out.println("2. 취소하기");
            System.out.println("3. 결제하기");
            System.out.println("4. 쿠폰 적립하기");
            System.out.print("입력: ");
            int num = sc.nextInt();

            if (num == 1) {
                String menuName = "";
                int menuPrice = 0;
                System.out.println("1. 아메리카노\t3800원");
                System.out.println("2. 에스프레소\t2400원");
                System.out.println("3. 카페라떼\t4200원");
                System.out.println("4. 밀크티\t5100원");
                System.out.println("5. 딸기스무디\t5500원");
                System.out.println("6. 망고스무디\t5600원");
                System.out.println("7. 블루베리스무디\t6000원");
                System.out.println("8. 마카롱\t3000원");
                System.out.println("9. 케이크\t5000원");
                System.out.println("10. 쿠키\t1000원");



                int menuNum = sc.nextInt();
                if (menuNum == 1) {
                    menuName = "아메리카노";
                    menuPrice = 3800;
                } else if (menuNum == 2) {
                    menuName = "에스프레소";
                    menuPrice = 2400;
                } else if (menuNum == 3) {
                    menuName = "카페라떼";
                    menuPrice = 4200;
                } else if (menuNum == 4) {
                    menuName = "밀크티";
                    menuPrice = 5100;
                } else if (menuNum == 5) {
                    menuName = "딸기스무디";
                    menuPrice = 5500;
                } else if (menuNum == 6) {
                    menuName = "망고스무디";
                    menuPrice = 5600;
                } else if (menuNum == 7) {
                    menuName = "블루베리스무디";
                    menuPrice = 6000;
                } else if (menuNum == 8) {
                    menuName = "마카롱";
                    menuPrice = 3000;
                } else if (menuNum == 9) {
                    menuName = "케이크";
                    menuPrice = 5000;
                } else if (menuNum == 10) {
                    menuName = "쿠키";
                    menuPrice = 1000;
                } else {
                    System.out.println("잘못 입력하셨습니다.");
                    continue;
                }

                total += menuPrice;
                orderList[count] = menuName;
                count++;

                System.out.println("주문한 메뉴는 " + menuName + "입니다.");
                System.out.println("가격은 " + menuPrice + "입니다.");
            } else if (num == 2) {
                System.out.println("---주문한 메뉴 리스트---");
                for (int i = 0; i < count; i++) {
                    System.out.println(i + 1 + "." + orderList[i]);
                }
                System.out.print("취소할 메뉴번호: ");
                int cancelNum = sc.nextInt();
                if (1 <= cancelNum && cancelNum <= count) {
                    String delMenu = orderList[cancelNum - 1];
                    System.out.println(delMenu + " 메뉴 삭제!");
                    total -= getMenuPrice(delMenu);
                    for (int i = cancelNum - 1; i < count - 1; i++) {
                        orderList[i] = orderList[i + 1];
                    }
                    orderList[count - 1] = null;
                    count--;
                } else {
                    System.out.println("잘못 입력하셨습니다.");
                }
            } else if (num == 3) {
                System.out.println("결제할 금액: " + total + "원");
                System.out.print("지불할 금액: ");
                int money = sc.nextInt();
                if (money < total) {
                    System.out.println("잔돈이 부족합니다.");
                    continue;
                } else {
                    System.out.println("잔돈은 " + (money - total) + "원 입니다.");
                    total = 0;
                    Arrays.fill(orderList, null);
                    count = 0;
                }
            } else if (num == 4) {
                System.out.println("쿠폰");
                int phoneNumber;
                int totalStamps = 0;
                while (true) {
                    System.out.println("전화번호를 입력하세요:");
                    phoneNumber = sc.nextInt();
                    // 스탬프 쿠폰 발급
                    stampCoupons.add(phoneNumber);
                    totalStamps++;
                    System.out.println("스탬프 쿠폰이 발급되었습니다. 현재 스탬프 개수: " + totalStamps);

                    if (totalStamps == 10) {
                        System.out.println("10개의 스탬프를 모두 모았습니다. 무료 음료를 받을 수 있습니다!");
                        stampCoupons.clear(); // 스탬프 초기화
                        totalStamps = 0;
                    }
                }

            }
        }
    }

    // Helper method to get the price of a menu
    private static int getMenuPrice(String menuName) {
        switch (menuName) {
            case "아메리카노":
                return 3800;
            case "에스프레소":
                return 2400;
            case "카페라떼":
                return 4200;
            case "밀크티":
                return 5100;
            case "딸기스무디":
                return 5500;
            case "망고스무디":
                return 5600;
            case "블루베리스무디":
                return 6000;
            case "마카롱":
                return 3000;
            case "케이크":
                return 5000;
            case "쿠키":
                return 1000;
            default:
                return 0; // Unknown menu, return 0
        }
    }
}