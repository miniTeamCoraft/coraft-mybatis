package com.coraft.project.model.dao;

import com.coraft.project.model.dto.MemberDTO;
import org.apache.ibatis.session.SqlSession;

public interface MemberDAO {
    MemberDTO checkIdPwd(String doId);
}
