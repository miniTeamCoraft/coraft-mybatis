package com.coraft.project.model.dao;

import com.coraft.project.model.dto.LectureDTO;
import com.coraft.project.model.dto.PayDTO;

import java.util.List;

public interface PayDAO {
    int insertUserLec(PayDTO pay);
    List<LectureDTO> userSelectLec(String id);
}
