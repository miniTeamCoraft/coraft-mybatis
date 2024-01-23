package com.coraft.project.controller;

import com.coraft.project.model.dto.LectureDTO;
import com.coraft.project.model.dto.MemberDTO;

import java.util.List;

import static com.coraft.project.view.Menu.lecture;
import static com.coraft.project.view.Menu.lectureService;

public class LectureController {
    public void showListLecture() {
        List<LectureDTO> lectureList = lectureService.showAllLectures();

        if(lectureList != null) {

            System.out.println("\n[ 강의 목록 ]");
            for(int i = 0; i < lectureList.size(); i++) {
                System.out.println(lectureList.get(i));
            }

        } else {
            System.out.println("신청 가능한 강의가 없습니다.");
        }
    }
}
