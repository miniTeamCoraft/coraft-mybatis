package com.coraft.project.view;

import com.coraft.project.controller.LectureController;
import com.coraft.project.controller.PayController;
import com.coraft.project.model.dto.MemberDTO;
import com.coraft.project.model.service.LectureService;

import java.util.Scanner;

import static com.coraft.project.view.Login.*;

public class Menu {
    Scanner sc = new Scanner(System.in);
    public static MemberDTO user;
    public static LectureController lectureController;
    public static LectureService lectureService;
    public static PayController payController;

    public Menu() {
        user = new MemberDTO();
        lectureController = new LectureController();
        lectureService = new LectureService();
        payController = new PayController();
    }

    public void mainMenu() {
        while (true) {
            System.out.println("\n= 메인메뉴 =========================================");
            System.out.println("1.강의 목록 보기");
            System.out.println("2.회원 정보 확인");
            System.out.println("3.수강신청 목록 확인");
            System.out.println("9.로그아웃");
            System.out.println("-------------------------------------------------");

            System.out.print("메뉴를 선택하세요 : ");
            String num = sc.nextLine();

            switch (num) {
                case "1":
                    lectureController.showListLecture();
                    break;
                case "2":
                    memberController.memberInfo(user);
                    break;
                case "3": payController.userSelectLec(); break;
                case "9":
                    System.out.println("CORAFT를 로그아웃합니다. 감사합니다."); return;
                default:
                    System.out.println("잘못된 메뉴를 선택하셨습니다.");
                    break;
            }
        }
    }
}