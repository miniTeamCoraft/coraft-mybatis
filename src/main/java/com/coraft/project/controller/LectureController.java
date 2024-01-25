package com.coraft.project.controller;

import com.coraft.project.model.dto.LectureDTO;
import com.coraft.project.view.Pay;

import java.util.List;
import java.util.Scanner;

import static com.coraft.project.view.Menu.lectureService;

public class LectureController {
    public static Pay pay;
    public static LectureDTO pocketLecture;

    public LectureController() {
        pay = new Pay();
        pocketLecture = new LectureDTO();
    }

    public void showListLecture() {
        Scanner sc = new Scanner(System.in);
        List<LectureDTO> lectureList = lectureService.showAllLectures();

        if (lectureList != null) {
            System.out.println("\n[ 강의 목록 ]");
            for (int i = 0; i < lectureList.size(); i++) {
                System.out.println(lectureList.get(i));
            }
        } else {
            System.out.println("신청 가능한 강의가 없습니다.");
        }
        System.out.println("---------------------------------------------------------------------------------------------------");
        System.out.print("강의를 선택하시겠습니까? (Y / N) ");
        char answer = sc.next().toUpperCase().charAt(0);

        if (answer == 'Y') {
            selectLecture();
        } else if (answer == 'N') {
            System.out.println("이전 페이지로 돌아갑니다.");
        } else {
            System.out.println("잘못된 메뉴를 선택하셨습니다. 강의 목록으로 돌아갑니다.");
        }
    }

    public void selectLecture() {
        Scanner sc = new Scanner(System.in);
        int num = 0;

        while (true) {
            System.out.println("\n= 강의선택 =========================================");
            System.out.println("1.'보컬 클래스'");
            System.out.println("2.'천연 비누 만들기'");
            System.out.println("3.'과자 만들기'");
            System.out.println("4.'레진 손거울 만들기'");
            System.out.println("5.'전통 유리 공예 클래스'");
            System.out.println("9.메인 메뉴로 이동");
            System.out.println("-------------------------------------------------");
            System.out.print("신청할 강의를 선택하세요 : ");
            num = sc.nextInt();

            LectureDTO userSelectLecture = lectureService.selectLecture(num);

            if(userSelectLecture != null) {
                pocketLecture.setLecCode(userSelectLecture.getLecCode());
                pocketLecture.setLecName(userSelectLecture.getLecName());
                pocketLecture.setDate(userSelectLecture.getDate());
                pocketLecture.setTime(userSelectLecture.getTime());
                pocketLecture.setLecPrice(userSelectLecture.getLecPrice());

                System.out.println(pocketLecture);

                pay.mainPayment(pocketLecture);
            }

            if(num == 9) {
                System.out.println("메인 메뉴로 이동합니다.");
                break;
            }
        }
    }
}