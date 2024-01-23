package com.coraft.project.controller;

import java.util.Map;

import com.coraft.project.model.dto.MemberDTO;
import static com.coraft.project.view.Login.memberService;
import static com.coraft.project.view.Login.menu;

public class MemberController {
    public void login(MemberDTO memIdPwd) {
        String doId = memIdPwd.getId();
        MemberDTO memberOneList = memberService.checkIdPwd(doId);

        if(memberOneList.getId().equals(memIdPwd.getId())) {
            if (memberOneList.getPwd().equals(memIdPwd.getPwd())) {
                System.out.println(memberOneList.getName() + "님 로그인 성공했습니다.");
                menu.mainMenu();
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

//        boolean result = memberService.registNewMember(user);

        if(memberService.insertUser(user)) {
            System.out.println("회원가입에 성공했습니다.");
        }else {
            System.out.println("회원가입에 실패했습니다.");
        }
    }
}
