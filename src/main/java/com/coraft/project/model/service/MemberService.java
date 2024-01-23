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

    public boolean insertUser(MemberDTO user) {
        SqlSession sqlSession = getSqlSession();
        memberDAO = sqlSession.getMapper(MemberDAO.class);

        int result = memberDAO.insertUser(user);

        if(result > 0) {
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0? true : false;
    }

    public MemberDTO memberInfo(String id) {
        SqlSession sqlSession = getSqlSession();
        memberDAO = sqlSession.getMapper(MemberDAO.class);

        MemberDTO member = memberDAO.memberInfo(id);

        sqlSession.close();

        return member;
    }
}
