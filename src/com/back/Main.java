package com.back; // package== 폴더

import java.util.ArrayList;
import java.util.Scanner;
//임의적_예외처리_x.ver

class Saying {
    int no;
    String says;
    String author;
}

public class Main {
    public static void main(String[] args) {

        System.out.println("==명언 앱==");
        Scanner sc = new Scanner(System.in);
        String command = "";
        ArrayList<Saying> lst = new ArrayList<>();
        int cnt = 0;
        while (true) {
            System.out.print("명령) ");
            command = sc.nextLine();
            if (command.equals("종료")) break;
            else if (command.equals("등록")) {
                lst.add(new Saying());
                System.out.print("명언 : ");
                lst.get(cnt).says = sc.nextLine();
                System.out.print("작가 : ");
                lst.get(cnt).author = sc.nextLine();
                lst.get(cnt).no = ++cnt;
                System.out.println(cnt + "번 명언이 등록되었습니다.");
            } else if (command.equals("목록")) {
                System.out.println("번호 / 작가 / 명언\n" + "----------------------");
                for (int i = cnt - 1; i >= 0; i--) {
                    if (lst.get(i).says == null) continue;
                    else System.out.println(lst.get(i).no + " / " + lst.get(i).author + " / " + lst.get(i).says);
                }
            } else if (command.startsWith("삭제?id=")) {
                int id = Integer.parseInt(command.substring(6)) - 1;
                if (id<0 || id>=cnt || lst.get(id).says == null) System.out.println(id + 1 + "번 명언은 존재하지 않습니다.");
                else {
                    lst.get(id).says = null;
                    lst.get(id).author = null;
                }
            } else if (command.startsWith("수정?id=")) {
                int id = Integer.parseInt((command.substring(6))) - 1;
                if (id<0 || id>=cnt || lst.get(id).says == null) System.out.println(id + 1 + "번 명언은 존재하지 않습니다.");
                else {
                    System.out.print("명언(기존): " + lst.get(id).says + "\n 명언 : ");
                    lst.get(id).says = sc.nextLine();
                    System.out.print("작가(기존): " + lst.get(id).author + "\n 작가 : ");
                    lst.get(id).author = sc.nextLine();
                }
            }
        }
    }
}
