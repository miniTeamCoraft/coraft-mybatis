package com.coraft.project.model.service;

import com.coraft.project.model.dao.LectureDAO;
import com.coraft.project.model.dto.LectureDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.coraft.project.common.Template.getSqlSession;

public class LectureService {

    private LectureDAO lectureDAO;

    public List<LectureDTO> showAllLectures() {
        SqlSession sqlSession = getSqlSession();
        lectureDAO = sqlSession.getMapper(LectureDAO.class);

        List<LectureDTO> lectureList = lectureDAO.showAllLectures();

        sqlSession.close();

        return lectureList;
    }
}
