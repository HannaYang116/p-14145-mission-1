package com.back; // package== 폴더

import java.util.Scanner;
//임의적_예외처리_x.ver
public class Main {
    public static void main(String[] args) {
        System.out.println("==명언 앱==");
        Scanner sc = new Scanner(System.in);
        String command = "";
        String[][] arr = new String[100][2]; //[n][0]명언 [n][1]작가
        int cnt = 0;  // 명언 개수
        while (true) {
            System.out.print("명령) ");
            command = sc.nextLine();
            if (command.equals("종료")) {
                break;
            } else if (command.equals("등록")) {
                System.out.print("명언 : ");
                arr[cnt][0] = sc.nextLine();
                System.out.print("작가 : ");
                arr[cnt][1] = sc.nextLine();
                cnt++;
                System.out.println(cnt + "번 명언이 등록되었습니다.");
            } else if (command.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                int temp = cnt;
                while (temp >= 1) {
                    if (arr[temp - 1][0] != null) {
                        System.out.print(temp + " / ");
                        System.out.print(arr[temp - 1][1] + " / ");
                        System.out.println(arr[temp - 1][0]);
                    }
                    temp--;
                }
            } else if (command.equals("삭제")) {
                System.out.print("?id=");
                int id = Integer.parseInt(sc.nextLine());
                if (id < 1 || id > cnt || (arr[id-1][0] == null && arr[id-1][1] == null)) {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                } else if (arr[id-1][0] != null || arr[id-1][1] != null) {
                    arr[id-1][0] = null;
                    arr[id-1][1] = null;
                    System.out.println(id + "번 명언이 삭제되었습니다.");
                }
            } else if (command.equals("수정")){
                System.out.print("?id=");
                int id = Integer.parseInt(sc.nextLine());
                if (id < 1 || id > cnt || (arr[id-1][0] == null && arr[id-1][1] == null)) {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                } else if (arr[id-1][0] != null || arr[id-1][1] != null) {
                    System.out.println("명언(기존) : " + arr[id-1][0]);
                    System.out.print("명언 : ");
                    arr[id-1][0] = sc.nextLine();

                    System.out.println("작가(기존) : " + arr[id-1][1]);
                    System.out.print("작가 : ");
                    arr[id-1][1] = sc.nextLine();
                }
            }

        }
    }
}
