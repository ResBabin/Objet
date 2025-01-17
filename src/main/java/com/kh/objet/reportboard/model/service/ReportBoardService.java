package com.kh.objet.reportboard.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kh.objet.reportboard.model.vo.ReportBoard;
import com.kh.objet.review.model.vo.Review;

public interface ReportBoardService {
//public List<ReportBoard> selectReportBList ();
//public List<ReportBoard> selectReportBDetail();
//public Review selectReportDetail(Review review);
public List<ReportBoard> selectReportAllList(ReportBoard report);
public List<ReportBoard> selectReportReason();
public List<ReportBoard> selectReportAll(); 
public int deleteReportbOrigin (ReportBoard reportb);
public int deleteReportb (ReportBoard reportb);
public List<ReportBoard> selectReportCount();
public List<ReportBoard> selectReportMain();
public int selectReportObjetList();
public List<ReportBoard> selectReportObjet();
public int selectReportReviewList();
public List<ReportBoard> selectReportReview();
public List<ReportBoard> selectReportObjetDetail();
public List<ReportBoard> selectReportReviewDetail(); 

}      
