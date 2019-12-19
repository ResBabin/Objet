package com.kh.objet.qna.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.objet.qna.model.service.QnaServiceImpl;
import com.kh.objet.qna.model.vo.Qna;

@Controller
public class QnaController {
	private static final Logger logger = LoggerFactory.getLogger(QnaController.class);
	
	@Autowired
	private QnaServiceImpl qnaService;
	
	public QnaController() {}
	
	
	// 최민영 ****************************************************************************************
	// 문의내역 페이지 이동
		@RequestMapping("moveMyQnaList.do")
		public String moveMyQnaList() {
			return "user/myQnaList";
		}
		
		@RequestMapping("qnam.do")
		public ModelAndView selectQnaList(ModelAndView mv){
			ArrayList<Qna> qnalist = (ArrayList<Qna>) qnaService.selectQnaList();
			mv.addObject("qnalist", qnalist);
			mv.setViewName("admin/QnaManagement");
			return mv;
		} 
		
		@RequestMapping("qnamd.do")
		public ModelAndView selectQnaDetail(ModelAndView mv, @RequestParam("qnano") int qnano) {
			Qna qnamd = qnaService.selectQnaDetail(qnano);
			ArrayList<Qna> qnalist = (ArrayList<Qna>) qnaService.selectQnaList();
			if (qnamd != null) {
				mv.addObject("qnamd", qnamd);
				mv.addObject("qnalist", qnalist);			
				mv.setViewName("admin/QnaManageDetail");
			} else {
				mv.addObject("message", "QnA 상세 조회 실패");
				mv.setViewName("common/error");
			}
			return mv;
		}
		
}
