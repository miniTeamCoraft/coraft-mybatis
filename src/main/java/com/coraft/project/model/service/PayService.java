package com.coraft.project.model.service;

import com.coraft.project.model.dao.PayDAO;
import com.coraft.project.model.dto.PayDTO;
import org.apache.ibatis.session.SqlSession;

import static com.coraft.project.common.Template.getSqlSession;

public class PayService {
    public PayDAO payDAO;

    public boolean insertUserLec(PayDTO pay) {
        SqlSession sqlSession = getSqlSession();
        payDAO = sqlSession.getMapper(PayDAO.class);

        int result = payDAO.insertUserLec(pay);

        if(result > 0) {
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0? true : false;
    }
}
