package com.kh.objet.qna.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import com.kh.objet.notice.model.service.NoticeService;
import com.kh.objet.notice.model.vo.Notice;

import com.kh.objet.qna.model.service.QnaServiceImpl;
import com.kh.objet.qna.model.vo.Qna;
import com.kh.objet.users.model.vo.Users;

@Controller
public class QnaController {
	private static final Logger logger = LoggerFactory.getLogger(QnaController.class);
	
	@Autowired
	private QnaServiceImpl qnaService;
	
	public QnaController() {}
	
	
	// 문의내역 페이지 이동
	   @RequestMapping("selectQnaList.do")
	   public String selectQnaList(@RequestParam(name="page",required=false)String page, 
			   @RequestParam(name="userid",required=false)String userid,
			   Model model){
	      logger.info("page : " + page);
	      int currentPage = 1;
	      if(page !=null) { 
	         currentPage = Integer.parseInt(page);
	      }
	      //페이징
	            int limit = 10;
	            int listCount = qnaService.listCount2(); // 총 목록 갯수
	            
	            logger.info("listCount : " + listCount + ", currentPage : " + currentPage);
	       
	            //페이지 수 계산
	            int maxPage = (int)((double)listCount / limit + 0.9);
	            // 현재 페이지가 포함된 페이지 그룹의 시작값
	            int startPage = (int)((double)currentPage / limit + 0.9);
	            // 현재 페이지가 포함된 페이지 그룹의 끝값
	            int endPage = startPage + limit - 1;
	            
	            if(maxPage < endPage) {
	               endPage = maxPage;
	            }
	            
	            // 쿼리문에 반영할 현재 페이지에 출력할 목록의 시작행과 끝행 계산
	            int startRow = (currentPage - 1) * limit + 1;
	            int endRow = startRow + limit - 1;
	            
	            System.out.println(startRow + ", " + endRow);
	            
	            HashMap<String, Object> map = new HashMap<String, Object>();
	            map.put("startRow", startRow);
	            map.put("endRow", endRow);
	            map.put("userid",userid);
	            
	            List<Qna> list = qnaService.selectQnaList(map);
	                              
	            System.out.println("공지 갯수 : " + list.size());
	            
	            
	            if(list != null && list.size() > 0) {
	               model.addAttribute("list",list);    //전체리스트
	               model.addAttribute("listCount",listCount);  //리스트 전체 갯수
	               model.addAttribute("maxPage",maxPage);
	               model.addAttribute("currentPage",currentPage);
	               model.addAttribute("startPage",startPage);
	               model.addAttribute("endPage",endPage);
	               model.addAttribute("limit",limit);
	               model.addAttribute("page", page);
	               model.addAttribute("userid",userid);
	               
	               /*model.addAttribute("user/myQnaList");*/
	            } else {
	               model.addAttribute("message", currentPage + "페이지 목록 조회 실패");
	               model.addAttribute("common/error");
	            }
	            
	      
	            return "user/myQnaList";
	    }
	          

	      //2020/01/09 문의내역 검색
	   //*회원 검색 컨트롤러

	   @RequestMapping("selectQnaSearchList.do")
	   public String selectQnaSearchList(Model model,Qna qna,
	         @RequestParam(name = "page", required = false) String page,
	         @RequestParam(name = "userid", required = false) String userid,
	         @RequestParam(name = "search", required = false) String search,
	         @RequestParam(name = "searchtype", required = false) String searchtype)
	         {

	      
	      System.out.println("serach : " + search);
	      System.out.println("serach 2: " + searchtype);
	      
	       
	      int currentPage = 1;
	      if(page !=null) {
	         currentPage = Integer.parseInt(page);
	      }
	      //페이징
	      int limit = 10; // 한 페이지에 출력할 목록 갯수
	      HashMap<String, Object> mapp = new HashMap<String, Object>();
	      mapp.put("userid", userid);
	      mapp.put("search", search);
	      mapp.put("searchtype", searchtype);


	      int listCount = qnaService.qnaSearchListCount(mapp);

	      logger.info(currentPage + ", " + listCount);
	      
	      
	            //페이지 수 계산
	            int maxPage = (int)((double)listCount / limit + 0.9);
	            // 현재 페이지가 포함된 페이지 그룹의 시작값
	            int startPage = (int)((double)currentPage / limit + 0.9);
	            // 현재 페이지가 포함된 페이지 그룹의 끝값
	            int endPage = startPage + limit - 1;
	            
	            if(maxPage < endPage) {
	               endPage = maxPage;
	            }
	            
	            // 쿼리문에 반영할 현재 페이지에 출력할 목록의 시작행과 끝행 계산
	            int startRow = (currentPage - 1) * limit + 1;
	            int endRow = startRow + limit - 1;
	            
	            
	            HashMap<String, Object> map = new HashMap<String, Object>();
	            map.put("startRow", startRow);
	            map.put("endRow", endRow);
	            map.put("userid", userid);
	            map.put("search", search);
	            map.put("searchtype", searchtype);
	            map.put("listcount", listCount);


	            List<Qna> nlist = qnaService.selectQnaSearchList(map);
	         
	            logger.info("문의 갯수 : " + nlist.size());
	            
	            
	            if(nlist != null && nlist.size() > 0) {
	            	model.addAttribute("userid", userid);
	               model.addAttribute("search", search);
	               model.addAttribute("searchtype",searchtype);
	               model.addAttribute("list", nlist); // 리스트에 담은 전체 정보
	               model.addAttribute("listCount", listCount); // 전체갯수
	               model.addAttribute("maxPage", maxPage); // 맨마지막페이지
	               model.addAttribute("currentPage", currentPage); // 해당페이지 기본값 1
	               model.addAttribute("startPage", startPage); // 첫페이지
	               model.addAttribute("endPage", endPage); // 끝페이지
	               model.addAttribute("limit", limit); // 한페이지당 출력할갯수 기본값10개
	               
	            } else {
	               model.addAttribute("message", currentPage + "페이지 목록 조회 실패");
	               model.addAttribute("common/error");
	            }
	            
	      
	            return "user/myQnaList";
	   }
	   

	      // 문의내역 상세보기 페이지 이동
	         @RequestMapping("selectQnaDetail.do")
	         public String selectQnaDetail(@RequestParam(value="qnano") int qnano, Model model) {
	            
	               Qna qna = qnaService.selectQnaDetail(qnano);
	               
	               if (qna != null) {
	                   
	                   
	                  model.addAttribute("qna", qna);
	                  model.addAttribute("user/myQnaDetail");

	               } else {
	                  model.addAttribute("message", "공지사항 상세 조회 실패");
	                  model.addAttribute("common/errorPage");
	               }
	               
	            return "user/myQnaDetail";
	         }
	         
	      // 문의내역 수정 페이지 이동
	         @RequestMapping("moveMyQnaEdit.do")
	         public String moveMyQnaEdit() {
	            return "user/myQnaEdit";
	         }
	         // 문의내역 등록 페이지 이동
	                  @RequestMapping("MoveinsertQna.do")
	                  public String MoveinsertQna() {
	                     return "user/myQnaWrite";
	                  }
	         
	               

	         //문의내역 등록작성하는 폼입니다. 
	         
	               @RequestMapping(value = "insertQna.do", method = RequestMethod.POST)
	               public ModelAndView insertQna(ModelAndView mv, HttpServletRequest req,
	                     @RequestParam(name = "userid") String userid,
	                     @RequestParam(name = "qnatitle") String qnatitle,
	                  /*   @RequestParam(name = "upfile", required = false) MultipartFile upload,*/
	                     @RequestParam(name = "qnacontent") String qnacontent, Qna qna) {

	               /*
	                  // 새로 들어온 사진 이름 추출
	                  String newFileName = upload.getOriginalFilename();

	                  // 저장할 경로
	                  String path = req.getSession().getServletContext().getRealPath("resources/images/qna");

	                  // 이미지파일 저장하기
	                  if (newFileName != null && !(newFileName.equals(""))) {
	                     
	                     //파일이름 날짜로 만들어서 바꿔주기
	                     SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	                     String renameFileName = sdf.format(new java.sql.Date(System.currentTimeMillis())) + "."
	                           + newFileName.substring(newFileName.lastIndexOf(".") + 1);

	                     try {
	                        upload.transferTo(new File(path + "\\" + renameFileName));
	                        qna.setQnarfile(renameFileName);
	                     } catch (Exception e) {
	                        e.printStackTrace();
	                     }
	                  }*/
	                  
	                  qna.setUserid(userid);
	                  qna.setQnatitle(qnatitle); 
	                  qna.setQnacontent(qnacontent);

	                  int result = qnaService.insertQna(qna);
	                  
	                  if (result > 0) {
	          			mv.addObject("currentPage", "1");
	          			mv.addObject("Qna", qna);
	          			 mv.setViewName("redirect:selectQnaList.do?userid=" + userid);
	          		} else {
	          			mv.addObject("message", "공지사항 등록 실패");
	          			mv.setViewName("common/errorPage");
	          		}

	          		return mv;
	          	}


	      
	         //문의내역 수정하기로 이동하는 버튼
	         @RequestMapping("MoveupdateQna.do")
	         public ModelAndView MoveupdateQna(ModelAndView mv, @RequestParam(name="qnano") int qnano) {

	         Qna qna = qnaService.selectQnaDetail(qnano);

	         mv.addObject("qna", qna);
	         mv.setViewName("user/myQnaEdit");
	         return mv;
	         
	         }
	         
	         // 문의내역 수정
	         @RequestMapping(value = "updateQna.do", method = RequestMethod.POST)
	         public ModelAndView updateQna(ModelAndView mv, HttpServletRequest req,
	         @RequestParam(name = "qnano") int qnano, @RequestParam(name = "qnatitle") String qnatitle,
	          @RequestParam(name = "qnacontent") String qnacontent,
	          @RequestParam(name = "qnatype") String qnatype,@RequestParam(name = "userid") String userid,
	         Qna qna) {

	         qna.setQnano(qnano);
	         qna.setUserid(userid);
	         qna.setQnatitle(qnatitle); 
	         qna.setQnacontent(qnacontent);
	         qna.setQnatype(qnatype);

	         int result = qnaService.updateQna(qna);
	          
	         if (result > 0) {
	        	  mv.addObject("qna", qna);
	        	  mv.setViewName("redirect:selectQnaList.do?userid=" + userid);
	        	
       		} else {
       			mv.addObject("message", "문의내역 실패");
       			mv.setViewName("common/error");
       		}

       		return mv;
       	}
	   
	         
	         //문의내역 삭제하기
	         @RequestMapping("deleteQna.do")
	         public void deleteQna(@RequestParam(value="qnano") int qnano, HttpServletResponse response) throws IOException {
	            int result = qnaService.deleteQna(qnano);
	            
	            String returnValue = null;
	            if(result > 0)
	               returnValue = "ok";
	            else
	               returnValue = "fail";
	            
	            PrintWriter out = response.getWriter();
	            out.append(returnValue);
	            out.flush();
	            out.close();
	         }
	         //문의내역 상세보기 에서 문의글 삭제하기
	       //공지사항 삭제 컨트롤러
	         @RequestMapping("deleteDetailQna.do")
	         public ModelAndView deleteDetailQna(ModelAndView mv, @RequestParam(name = "qnano") int qnano,
	        		 @RequestParam(name = "userid") String userid) {
	        	 
	        
	        

	         int result = qnaService.deleteQna1(qnano);

	         if (result > 0) {
	        	  mv.addObject("qnano", qnano);
	        	  mv.setViewName("redirect:selectQnaList.do?userid=" + userid);
       		} else {
       			mv.addObject("message", "공지사항 등록 실패");
       			mv.setViewName("common/errorPage");
       		}

	         return mv;
	         }
	         
	         //CKEditor 이미지 서버로 전송
	         @RequestMapping("qnaFile.do")
	         public String qnaInsertFileMethod(HttpServletRequest req, HttpServletResponse resp,
	         MultipartHttpServletRequest multiFile, @RequestParam MultipartFile upload) throws Exception {

	         /* URL */
	         JSONObject json = new JSONObject();
	         PrintWriter printWriter = null;
	         OutputStream out = null;
	         System.out.println("전송 : " + multiFile.toString());

	         // 파일명 다시 정의하기
	         MultipartFile file = multiFile.getFile("upload");
	         if (file != null) {
	         if (file.getSize() > 0 && StringUtils.isNotBlank(file.getName())) {
	         if (file.getContentType().toLowerCase().startsWith("image/")) {
	         try {
	         String fileName = file.getName();
	         System.out.println("이름1: " + file.getName());

	         byte[] bytes = file.getBytes();
	         HttpSession session = req.getSession();
	         String uploadPath = session.getServletContext().getRealPath("resources/images/qna/");

	         File uploadFile = new File(uploadPath);
	         if (!uploadFile.exists()) {
	         uploadFile.mkdirs();
	         }

	         // 파일명 중복되지않게 랜덤값으로 파일명주기
	         fileName = UUID.randomUUID().toString();

	         // 저장할폴더+파일명
	         uploadPath = uploadPath + "/" + fileName;

	         out = new FileOutputStream(new File(uploadPath));
	         out.write(bytes);

	         printWriter = resp.getWriter();
	         resp.setContentType("text/html");
	         String fileUrl = req.getContextPath() + "/resources/images/qna/" + fileName;

	         json.put("uploaded", 1);
	         json.put("fileName", fileName);
	         json.put("url", fileUrl);

	         printWriter.println(json);
	         } catch (IOException e) {
	         e.printStackTrace();
	         } finally {
	         if (out != null) {
	         out.close();
	         }
	         if (printWriter != null) {
	         printWriter.close();
	         }
	         } // finally

	         } // if
	         } // if
	         } // if
	         return null;

	         } // 메소드
	         
	         //CkEditor 이미지 수정
	         // 공지사항 수정 : 서버로 파일 전송 보내는 컨트롤러ajax
	         @RequestMapping("updateQnaFile.do")
	         public String updateQnaFile(HttpServletRequest req, HttpServletResponse resp,
	         MultipartHttpServletRequest multiFile, @RequestParam MultipartFile upload) throws Exception {

	         /* URL */
	         JSONObject json = new JSONObject();
	         PrintWriter printWriter = null;
	         OutputStream out = null;
	         System.out.println("전송 : " + multiFile.toString());

	         // 파일명 다시 정의하기
	         MultipartFile file = multiFile.getFile("upload");
	         if (file != null) {
	         if (file.getSize() > 0 && StringUtils.isNotBlank(file.getName())) {
	         if (file.getContentType().toLowerCase().startsWith("image/")) {
	         try {
	         String fileName = file.getName();
	         System.out.println("이름1: " + file.getName());

	         byte[] bytes = file.getBytes();
	         HttpSession session = req.getSession();
	         String Path = session.getServletContext().getRealPath("resources/images/qna/");// webapp

	         File uploadFile = new File(Path);
	         if (!uploadFile.exists()) {
	         uploadFile.mkdirs();
	         }

	         // 파일명 중복되지않게 랜덤값으로 파일명주기
	         fileName = UUID.randomUUID().toString();

	         // 저장할폴더+파일명
	         Path = Path + "/" + fileName;

	         /*새 파일 패스에 생성하기 : 
	         FileOutputStream 은 무조건 해당 파일을 생성한다.*/ 
	         out = new FileOutputStream(new File(Path));

	         //새 파일을 바이트로 작성하기
	         out.write(bytes);

	         printWriter = resp.getWriter();
	         resp.setContentType("text/html");
	         String fileUrl = req.getContextPath() + "/resources/images/qna/" + fileName;

	         /* int a = adminService.noticeUrlInsert(fileUrl); */
	         // json 데이터로 등록
	         // {"uploaded" : 1, "fileName" : "test.jpg", "url" : "/img/test.jpg"}
	         // 이런 형태로 리턴이 나가야함.
	         json.put("uploaded", 1);
	         json.put("fileName", fileName);
	         json.put("url", fileUrl);

	         printWriter.println(json);
	         } catch (IOException e) {
	         e.printStackTrace();
	         } finally {
	         if (out != null) {
	         out.close();
	         }
	         if (printWriter != null) {
	         printWriter.close();
	         }
	         } // finally
	         } // if
	         } // if
	         } // if
	         return null;

	         } // 메소드
	         


/////////////////////////// 관리자 QnaController ////////////////////////////////
@RequestMapping("qnam.do")
public String selectQnaListAd(Model model, HttpServletRequest request) {
   Map<String, String> map = new HashMap<>();
   String qnatype = request.getParameter("qnatype");
   String qnaanswertype = request.getParameter("qnaanswertype");
   String qnatitle = request.getParameter("qnatitle");
   String userid = request.getParameter("userid");
   map.put("qnatype", qnatype);
   map.put("qnaanswertype", qnaanswertype);
   map.put("qnatitle", qnatitle);
   map.put("userid", userid);
   
   int currentPage = 1;
   if (request.getParameter("page") != null) {
      currentPage = Integer.parseInt(request.getParameter("page"));
   }
   int limit = 10; // 한 페이지에 출력할 목록 갯수
   int listCount = qnaService.selectQnaCountAd(map); // 테이블의 전체 목록 갯수 조회
   // 총 페이지 수 계산
   int maxPage = listCount / limit;
   if (listCount % limit > 0)
      maxPage++;

   // currentPage 가 속한 페이지그룹의 시작페이지숫자와 끝숫자 계산
   // 예, 현재 34페이지이면 31 ~ 40 이 됨. (페이지그룹의 수를 10개로 한 경우)
   int beginPage = (currentPage / limit) * limit + 1;
   if (currentPage % limit == 0) {
      beginPage -= limit;
   }
   int endPage = beginPage + 9;
   if (endPage > maxPage)
      endPage = maxPage;

   // currentPage 에 출력할 목록의 조회할 행 번호 계산
   int startRow = (currentPage * limit) - 9;
   int endRow = currentPage * limit;
   map.put("startRow", Integer.toString(startRow));
   map.put("endRow", Integer.toString(endRow));

   ArrayList<Qna> qnalist = (ArrayList<Qna>) qnaService.selectQnaListAdmin(map);

   model.addAttribute("qnalist", qnalist);
   model.addAttribute("currentPage", currentPage);
   model.addAttribute("listCount", listCount);
   model.addAttribute("maxPage", maxPage);
   model.addAttribute("beginPage", beginPage);
   model.addAttribute("endPage", endPage);
   model.addAttribute("qnatype", qnatype);
   model.addAttribute("qnaanswertype", qnaanswertype);
   model.addAttribute("qnatitle", qnatitle);
   model.addAttribute("userid", userid);
   return "admin/QnaManagement";

}
@RequestMapping("qnamd.do")
public String selectQnaOneAd(@RequestParam("qnano") int qnano, Model model) {
   String view = "";
   Qna qna  = qnaService.selectQnaDetailAdmin(qnano);
   if(qna != null) {
      model.addAttribute("qnamd", qna);
      view = "admin/QnaManageDetail";
   }else {
      model.addAttribute("message", "qna 조회 실패");
      view = "common/error";
   }
   return view;
}
@RequestMapping("moveanswer.do")
public String moveAnswerPage(@RequestParam("qnano") int qnano, Model model) {
   Qna qna = qnaService.selectQnaDetailAdmin(qnano);
   model.addAttribute("question", qna);
   return "admin/QnaAnswer";
}

@RequestMapping(value="qnaanswer.do", method=RequestMethod.POST)
public String updateQnaAnswer(HttpServletRequest request, Qna qna, Model model) {
   String view = "";
   request.getParameter("qnano");
   qna.setQnaanswer(request.getParameter("qnaanswer"));
   qna.setQnaanswertype("답변완료");
   qna.setAdminid(request.getParameter("adminid"));
   int result = qnaService.updateQnaAnswer(qna);
   if(result > 0) {
      view = "redirect:qnam.do?page=1";
   }else {
      model.addAttribute("message", "1:1문의 답변 실패");
      view = "common/error";
   }
   return view;
}
}

