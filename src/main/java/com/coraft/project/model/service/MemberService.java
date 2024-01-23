package com.coraft.project.model.service;

import com.coraft.project.model.dao.MemberDAO;
import com.coraft.project.model.dto.MemberDTO;
import org.apache.ibatis.session.SqlSession;

import static com.coraft.project.common.Template.getSqlSession;

public class MemberService {
    private MemberDAO memberDAO;

    public MemberDTO checkIdPwd(String doId) {
        SqlSession sqlSession = getSqlSession();
        memberDAO = sqlSession.getMapper(MemberDAO.class);

        MemberDTO memberOneList = memberDAO.checkIdPwd(doId);

        sqlSession.close();

        return memberOneList;
    }
}
