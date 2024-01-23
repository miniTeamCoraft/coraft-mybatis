package com.coraft.project.controller;

import com.coraft.project.model.dto.MemberDTO;
import com.coraft.project.model.service.MemberService;

public class MemberController {
    public final MemberService memberService;

    public MemberController() {
        memberService = new MemberService();
    }

    public void login(MemberDTO memIdPwd) {
        String doId = memIdPwd.getId();
        MemberDTO memberOneList = memberService.checkIdPwd(doId);

        if(memberOneList.getId().equals(memIdPwd.getId())) {
            if (memberOneList.getPwd().equals(memIdPwd.getPwd())) {
                System.out.println(memberOneList.getName() + "님 로그인 성공했습니다.");
            }
        }else {
            System.out.println("로그인 실패했습니다.");
        }
    }
}
