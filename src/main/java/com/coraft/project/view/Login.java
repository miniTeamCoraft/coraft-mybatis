package com.coraft.project.view;

import com.coraft.project.controller.LectureController;
import com.coraft.project.controller.MemberController;
import com.coraft.project.model.dto.MemberDTO;
import com.coraft.project.model.service.LectureService;
import com.coraft.project.model.service.MemberService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login {
    Scanner sc = new Scanner(System.in);

    public static Menu menu;

    public static MemberController memberController;
    public static MemberService memberService;

//    public static PayController paycont = new PayController();

    public Login() {
        menu = new Menu();
        memberController = new MemberController();
        memberService = new MemberService();
    }

    public void mainLogin() {
        System.out.println("=================================================");
        System.out.println("\n  CORAFT에 오신걸 환영합니다.😊");
        while(true) {
            System.out.println("\n= 로그인 =========================================");
            System.out.println("1.로그인");
            System.out.println("2.회원가입");
            System.out.println("9.종료");
            System.out.println("-------------------------------------------------");
            System.out.print("메뉴를 선택하세요 : ");
            String num = sc.next();

            switch (num) {
                case "1" : memberController.login(doLogin()); break;
                case "2" : memberController.insertUser(doRegist()); break;
                case "9" : System.out.println("CORAFT를 종료합니다."); return;
                default : System.out.println("잘못된 메뉴를 선택하셨습니다. 다시 입력해주세요."); break;
            }
        }
    }

    public MemberDTO doLogin() {
        sc.nextLine();
        System.out.print("아이디를 입력하세요 : ");
        String id = sc.nextLine();
        System.out.print("비밀번호를 입력하세요 : ");
        String pwd = sc.nextLine();
        System.out.println("-------------------------------------------------");

        MemberDTO user = new MemberDTO();
        user.setId(id);
        user.setPwd(pwd);
        return user;
    }

    public Map<String, String> doRegist() {
        System.out.println("\n= 회원가입 =========================================");
        sc.nextLine();
//        String id = memberController.checkId();
        System.out.print("아이디를 입력하세요 : ");
        String id = sc.nextLine();
        System.out.print("비밀번호를 입력하세요 : ");
        String pwd = sc.nextLine();
        System.out.print("이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("나이를 입력하세요 : ");
        String age = sc.nextLine();
        System.out.print("성별을 입력하세요 (여 / 남) : ");
        String gender = sc.nextLine();
        System.out.print("핸드폰 번호를 입력하세요(예시 : 010-0000-0000) : ");
        String phone = sc.nextLine();
        System.out.print("이메일을 입력하세요 : ");
        String email = sc.nextLine();

        System.out.println("-------------------------------------------------");

        Map<String, String> parameter = new HashMap<>();
        parameter.put("id", id);
        parameter.put("pwd", pwd);
        parameter.put("name", name);
        parameter.put("age", age);
        parameter.put("gender", gender);
        parameter.put("phone", phone);
        parameter.put("email", email);

        return parameter;
    }
}
