package com.coraft.project.controller;

import java.util.Map;

import com.coraft.project.model.dto.MemberDTO;

import static com.coraft.project.view.Login.*;
import static com.coraft.project.view.Menu.user;

public class MemberController {
    public void login(MemberDTO loginUser) {
        String doId = loginUser.getId();
        MemberDTO memberOneList = memberService.checkIdPwd(doId);

        if(memberOneList != null) {
            if(memberOneList.getId().equals(loginUser.getId())) {
                if (memberOneList.getPwd().equals(loginUser.getPwd())) {
                    System.out.println(memberOneList.getName() + "님 로그인 성공했습니다.");
                    user.setId(memberOneList.getId());
                    user.setPwd(memberOneList.getPwd());
                    user.setName(memberOneList.getName());
                    user.setAge(memberOneList.getAge());
                    user.setGender(memberOneList.getGender());
                    user.setPhone(memberOneList.getPhone());
                    user.setPoint(memberOneList.getPoint());

                    menu.mainMenu();
                }else {
                    System.out.println("로그인 실패했습니다.");
                }
            }else {
                System.out.println("로그인 실패했습니다.");
            }
        }else {
            System.out.println("로그인 실패했습니다.");
        }

    }

    public void insertUser(Map<String, String> parameter) {
        String id = parameter.get("id");
        String pwd = parameter.get("pwd");
        String name = parameter.get("name");
        int age = Integer.parseInt(parameter.get("age"));
        String gender = parameter.get("gender");
        String phone = parameter.get("phone");
        String email = parameter.get("email");

        MemberDTO user = new MemberDTO();
        user.setId(id);
        user.setPwd(pwd);
        user.setName(name);
        user.setAge(age);
        user.setGender(gender);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPoint(5000);

        if(memberService.insertUser(user)) {
            System.out.println("회원가입에 성공했습니다.");
        }else {
            System.out.println("회원가입에 실패했습니다.");
        }
    }

    public void memberInfo(MemberDTO user) {
        String id = user.getId();
        MemberDTO member = memberService.memberInfo(id);

        if(member != null) {
            System.out.println(member);
        }else {
            System.out.println("회원 정보가 존재하지 않습니다.");
        }
    }

    public void updatePoint(Map<String, String> parameter) {
        String id = parameter.get("id");
        int point = Integer.parseInt(parameter.get("point"));

        MemberDTO userPoint = new MemberDTO();
        userPoint.setId(id);
        userPoint.setPoint(point);

        if(memberService.updatePoint(userPoint)) {
            System.out.println("포인트 업데이트 성공했습니다.");
        }else {
            System.out.println("포인트 업데이트 실패했습니다.");
        }
    }
}
