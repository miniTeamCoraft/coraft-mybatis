package com.coraft.project.model.dao;

import com.coraft.project.model.dto.LectureDTO;

import java.util.List;

public interface LectureDAO {
    List<LectureDTO> showAllLectures();
    LectureDTO selectLecture(int num);
}
