package com.coraft.project.model.dao;

import com.coraft.project.model.dto.MemberDTO;

public interface MemberDAO {
    MemberDTO checkIdPwd(String doId);
    int insertUser(MemberDTO user);
    MemberDTO memberInfo(String id);
    int updatePoint(MemberDTO userPoint);
    MemberDTO checkUserId(String userId);
}
