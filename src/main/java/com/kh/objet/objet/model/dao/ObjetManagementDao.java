package com.kh.objet.objet.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.objet.objet.model.vo.Objet;

@Repository("objetmDao")
public class ObjetManagementDao {
	@Autowired
	private SqlSessionTemplate mybatisSession;
	public ObjetManagementDao() {}
	public List<Objet> selectAllObjet() {
		return mybatisSession.selectList("adminMapper.selectAllObjet");
	}
	public Objet selectObjetOne(int objetno) {
		return mybatisSession.selectOne("adminMapper.selectObjetOne", objetno);
	}
	public List<Objet> selectObjetRequestManage() {
		return mybatisSession.selectList("adminMapper.selectObjetRequestList");
	}
	public List<Objet> selectObjetReqMain() {
		return mybatisSession.selectList("adminMapper.selectObjetReqMain");
	}

}
