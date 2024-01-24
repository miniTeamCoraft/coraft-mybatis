package com.coraft.project.controller;

import com.coraft.project.model.dto.PayDTO;
import com.coraft.project.model.service.PayService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.coraft.project.controller.LectureController.pocketLecture;
import static com.coraft.project.view.Login.memberController;
import static com.coraft.project.view.Menu.user;

public class PayController {
    Scanner sc = new Scanner(System.in);
    public static PayService payService = new PayService();

    public void payCardMember() {
        useCardPay();
        pay();
        userLec();
    }

    public void payBonusMember() {
        usePayPoint();
    }

    public void useCardPay() {
        int getPoint = (int) (pocketLecture.getLecPrice() * 0.05);
        System.out.println(user.getName() + "님의 결제금액은 " + pocketLecture.getLecPrice() + "원 입니다.");
        System.out.println("CORAFT 규정에 따라 결제금액의 5%인 " + getPoint + "포인트 적립됩니다.");
        System.out.println("적립된 포인트는 다음 수강신청 시 사용하실 수 있습니다.");
        int upPoint = getPoint + user.getPoint();
        memberController.updatePoint(upPoint);
    }

    public void usePayPoint() {
        System.out.println("-------------------------------------------------");
        System.out.println("CORAFT 규정에 따라 포인트차감 금액을 제외한 \n결제금액의 5%가 포인트로 적립됩니다.");
        System.out.println("적립된 포인트는 다음 수강신청 시 사용하실 수 있습니다.");
        System.out.println("-------------------------------------------------");

        System.out.println(user.getName() + "님의 결제금액은 " + pocketLecture.getLecPrice() + "원 입니다.");
        System.out.println("보유하신 포인트는 " + user.getPoint() + "포인트 입니다.");
        System.out.println("-------------------------------------------------");

        System.out.print("사용하실 포인트를 입력해 주세요 : ");
        int usePoint = sc.nextInt();

        int payNewPrice = pocketLecture.getLecPrice() - usePoint;

        if (payNewPrice > 0) {
            int minusPoint = user.getPoint() - usePoint;
            System.out.println(usePoint + "포인트 사용하여 " + minusPoint + "포인트 남았습니다.");
            System.out.println("-------------------------------------------------");
            System.out.println(usePoint + "포인트를 차감한 " + payNewPrice + "원은 자동 카드결제됩니다.");
            int getPoint = (int) (payNewPrice * 0.05);
            int upPoint = minusPoint + getPoint;
            pay();
            userLec();
            memberController.updatePoint(upPoint);

        } else if (payNewPrice < 0) {
            System.out.println("포인트 사용 금액이 결제할 금액보다 많습니다. \n포인트를 다시 입력해 주세요");
        } else {
            System.out.println(usePoint + "포인트를 사용하여 전액 포인트 결제 되었습니다.");
            userLec();
        }
    }

    public void pay() {
        System.out.println("-------------------------------------------------");
        System.out.println("카드결제가 진행됩니다.");
        System.out.println(". . .");
        System.out.println("카드 결제가 완료되었습니다. ");
    }

    public void userLec() {
        String userId = user.getId();
        String lectureCode = pocketLecture.getLecCode() + "";

        Map<String, String> parameter = new HashMap<>();
        parameter.put("id", userId);
        parameter.put("lecCode", lectureCode);

        String id = parameter.get("id");
        int code = Integer.parseInt(parameter.get("lecCode")) + 1;

        PayDTO pay = new PayDTO();
        pay.setId(id);
        pay.setLecCode(code);

        if (payService.insertUserLec(pay)) {
            System.out.println("-------------------------------------------------");
            System.out.println("수강 신청 성공했습니다.");
        } else {
            System.out.println("-------------------------------------------------");
            System.out.println("수강 신청 실패했습니다.");
        }
    }


    public void userSelectLec() {
            /*pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);

            rset = pstmt.executeQuery();

            System.out.println("\n[ 신청 내역 ]");
            while(rset.next()) {
                if(rset.getString("LEC_CODE").isEmpty()) {
                    System.out.println("수강 신청 내역이 존재하지 않습니다.");
                }else {
                    System.out.println("강의 이름 : " + rset.getString("LEC_NAME")
                            + " || 날짜 : " + rset.getString("LEC_DATE")
                            + " || 시간 : " + rset.getString("LEC_TIME")
                            + " || 가격 : " + rset.getInt("LEC_PRICE") + "원");
                }
            }*/
    }
}
