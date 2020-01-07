package com.kh.objet.objet.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.objet.likeobjet.model.vo.LikeObjet;
import com.kh.objet.objet.model.vo.Artist;
import com.kh.objet.objet.model.vo.Objet;
import com.kh.objet.objet.model.vo.ReviewKey;
import com.kh.objet.objet.model.vo.ReviewUp;
import com.kh.objet.paging.model.vo.Paging;
import com.kh.objet.reportboard.model.vo.ReportBoard;
import com.kh.objet.review.model.vo.Review;

@Repository("objetDao")
public class ObjetDao {

	@Autowired
	private SqlSessionTemplate mybatisSession;	
	
	public ObjetDao() {}
	
	
	//박예은
	public ArrayList<Objet> selectObjetAllList(){
		List<Objet> list = mybatisSession.selectList("objetMapper.selectObjetAll");
		return (ArrayList<Objet>)list;
	}
	
	public ArrayList<Artist> selectArtistAllList(){
		List<Artist> list = mybatisSession.selectList("objetMapper.selectArtistAll");
		return (ArrayList<Artist>)list;
	}
	
	public ArrayList<Artist> selectArtistListOrder(String order) {
		List<Artist> list = mybatisSession.selectList("objetMapper.selectArtistListOrder", order);
		return (ArrayList<Artist>)list;
	};
	
	public int insertObjetReport(ReportBoard rb) {
		return mybatisSession.insert("objetMapper.insertObjetReport", rb);
	}
	
	public ArrayList<Objet> selectObjetSearchList(String keyword){
		List<Objet> list = mybatisSession.selectList("objetMapper.objetSearchList", keyword);
		return (ArrayList<Objet>)list;
	}
	
	public Artist selectObjetOne(int objetno) {
		return mybatisSession.selectOne("objetMapper.selectObjetOne", objetno);
	}
	
	public int insertReviewReport(ReportBoard rb) {
		return mybatisSession.insert("objetMapper.insertReviewReport", rb);
	}
	
	public ArrayList<Review> selectReview(int objetno) {
		List<Review> list = mybatisSession.selectList("objetMapper.selectReview", objetno);
		return (ArrayList<Review>)list;
	}

	public Review selectReviewOne(ReviewKey rk) {
		return mybatisSession.selectOne("objetMapper.selectReviewOne", rk);
	}
	
	public ArrayList<Review> selectReviewOrder(ReviewKey rk) {
		List<Review> list = mybatisSession.selectList("objetMapper.selectReviewOrder", rk);
		return (ArrayList<Review>)list;
	}

	public int insertReview(Review review) {
		return mybatisSession.insert("objetMapper.insertReview", review);
	}
	
	public int updateReview(ReviewUp review) {
		return mybatisSession.update("objetMapper.updateReview", review);
	}
	
	public int deleteReview(Review review) {
		return mybatisSession.delete("objetMapper.deleteReview", review);
	}
	
	public int updateRevGood(Review review) {
		return mybatisSession.update("objetMapper.updateRevGood", review);
	}

	public int updateRevGoodReset(Review review) {
		return mybatisSession.update("objetMapper.updateRevGoodReset", review);
	}

	public int updateRevHate(Review review) {
		return mybatisSession.update("objetMapper.updateRevHate", review);
	}

	public int updateRevHateReset(Review review) {
		return mybatisSession.update("objetMapper.updateRevHateReset", review);
	}

	public int insertLikeObjet(LikeObjet likeobjet) {
		return mybatisSession.insert("objetMapper.insertLikeObjet", likeobjet);
	}

	public int deleteLikeObjet(LikeObjet likeobjet) {
		return mybatisSession.delete("objetMapper.deleteLikeObjet", likeobjet);
	}
	
	
	
	
	// 최민영
	// 작가홈 오브제 리스트카운트
	public int selectArtistObjetGetListCount(String userid) {
		return mybatisSession.selectOne("objetMapper.selectArtistObjetGetListCount", userid);
	}

	// 작가홈 오브제 리스트 보기
	public List<Objet> selectArtistObjetList(HashMap<String, Object> map) {
		return mybatisSession.selectList("objetMapper.selectArtistObjetList",map);
	}

	// 작가홈 오브제 검색용 리스트카운트
	public int selectArtistObjetSearchGetListCount(String objettitle) {
		return mybatisSession.selectOne("", objettitle);
	}

	// 작가홈 오브제 검색
	public List<Objet> selectArtistObjetSearch(HashMap<String, Object> map) {
		return mybatisSession.selectList("objetMapper.selectArtistObjetSearch",map);
	}

	
	
	
	
	
	// 오브제 관리-내 오브제 페이지 이동
	public ArrayList<Objet> moveMyObjetList(String userid, Paging paging) {
		int offset = 0;
		int limit = 0;
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<Objet> list = mybatisSession.selectList("", userid, rowBounds);
		return (ArrayList<Objet>) list;
	}

	//오브제 관리-내 오브제 검색
	public List<Objet> selectMyObjetSearch(HashMap<String, Object> map) {
		//검색용 vo 새로 만들어야 할듯
		return mybatisSession.selectList("objetMapper.selectMyObjetSearch", map);
	}

	//오브제 관리 - 내 오브제 상세보기
	public Objet moveMyObjetDetail(int objetno) {
		return mybatisSession.selectOne("", objetno);
	}

	//오브제 관리 - 내 오브제 수정 페이지 이동
	public Objet moveEditObjet(int objetno) {
		return mybatisSession.selectOne("", objetno);
	}

	//오브제 관리 - 내 오브제 수정
	public int updateMyObjet(Objet objet) {
		return mybatisSession.update("", objet);
	}

	//오브제 관리 - 전시 등록
	public int insertObjet(Objet objet) {
		return mybatisSession.insert("", objet);
	}

	// 오브제 관리 - 전시삭제
	public int deleteObjet(int objetno) {
		return mybatisSession.delete("", objetno);
	}


	

	

	
	

	
	
}
