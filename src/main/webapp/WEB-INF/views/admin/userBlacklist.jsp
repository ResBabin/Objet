<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오브제 관리자 - 블랙리스트 관리</title> 
<!-- 시맨틱유아이 cdn -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
	<link rel='stylesheet' href='//fonts.googleapis.com/earlyaccess/kopubbatang.css'>
<link rel="stylesheet" type="text/css" href="resources/assets/css/KoPubDotum.css">
<link rel="stylesheet" href="//fonts.googleapis.com/earlyaccess/nanummyeongjo.css">  
<style type="text/css">
#um {
	padding: 150px;
	padding-top: 50px;
}

table {
	font-family:'Nanum Gothic';
}
#thchk, #thuserid, #thnick, #thname, #thstart, #thend{
}
#quitdiv {
	position: absolute;
	background: #f7f7f7;
	border: 1px solid #ccc;
	width: 500px;
	height: 415px;
	left: 32%;
	top: 30%; 
	border-radius: 5px;
	padding: 30px;
	box-shadow: 1px 1px 2px #999;
	display: none;
	z-index: 1;
}
#popselect{
	width: 458px;
}
#bllabel{
	font-size: 13pt;
	font-weight: bold;
	margin-left: 70px;
}
#qlabel{
	font-size: 13pt;
	font-weight: bold;
	margin-left: 100px;
}
#blackend{
	width: 375px;
	border: 1px solid #aaa;
	height: 35px;
	border-radius: 5px;
	margin-top: -10px;
	margin-left: 30px;	
	padding-left: 5px;
}
textarea {
	border-radius: 5px;
}
  </style>

<script type="text/javascript">
	$(function() {
		$("#checkall").click(function() {
			var check = $("#checkall").prop("checked");
			if (check) {
				$("input[name=useridchk]").prop("checked", true);
			} else {
				$("input[name=useridchk]").prop("checked", false);
			}
		});
		$("input[name=useridchk]").click(function() {
			$("#checkall").prop("checked", false);
		});

		//ajax 정렬
		/* $("#thuserid").click(function() {
			$("#thuserid").attr("class", "sorted descending");
			console.log("1작동");
			thorder("userid desc");
			$("#thuserid").attr("id", "thuserida");

			console.log($("#thuserida").attr('id'));
		});*/
		
	/* 	var clickid = 0, clicknick = 0, clickname = 0, clickstart = 0, clickend = 0;
		
		$("#thuserid").click(function() {
			if(clickid%2 == 0){
				$(".sorted").attr("class", "");
				$("#thuserid").attr("class", "sorted ascending");
				thorder("ida");
				clickid += 1;
				clicknick = 0, clickname = 0, clickstart = 0, clickend = 0;
			} else {
				$(".sorted").attr("class", "");
				$("#thuserid").attr("class", "sorted descending");
				thorder("idd");
				clickid += 1;
				clicknick = 0, clickname = 0, clickstart = 0, clickend = 0;
			}
		});
		$("#thnick").click(function() {
			if(clicknick%2 == 0){
				$(".sorted").attr("class", "");
				$("#thnick").attr("class", "sorted ascending");
				thorder("nicka");
				clicknick += 1;
				clickid = 0, clickname = 0, clickstart = 0, clickend = 0;
			} else {
				$(".sorted").attr("class", "");
				$("#thnick").attr("class", "sorted descending");
				thorder("nickd");
				clicknick += 1;
				clickid = 0, clickname = 0, clickstart = 0, clickend = 0;
			}
		});
		$("#thname").click(function() {
			if(clickname%2 == 0){
				$(".sorted").attr("class", "");
				$("#thname").attr("class", "sorted ascending");
				thorder("namea");
				clickname += 1;
				clicknick = 0, clickid = 0, clickstart = 0, clickend = 0;
			} else {
				$(".sorted").attr("class", "");
				$("#thname").attr("class", "sorted descending");
				thorder("named");
				clickname += 1;
				clicknick = 0, clickid = 0, clickstart = 0, clickend = 0;
			}
		});
		$("#thstart").click(function() {
			if(clickstart%2 == 0){
				$(".sorted").attr("class", "");
				$("#thstart").attr("class", "sorted ascending");
				thorder("starta");
				clickstart += 1;
				clicknick = 0, clickname = 0, clickid = 0, clickend = 0;
			} else {
				$(".sorted").attr("class", "");
				$("#thstart").attr("class", "sorted descending");
				thorder("startd");
				clickstart += 1;
				clicknick = 0, clickname = 0, clickid = 0, clickend = 0;
			}
		});
		$("#thend").click(function() {
			if(clickend%2 == 0){
				$(".sorted").attr("class", "");
				$("#thend").attr("class", "sorted ascending");
				thorder("enda");
				clickend += 1;
				clicknick = 0, clickname = 0, clickstart = 0, clickid = 0;
			} else {
				$(".sorted").attr("class", "");
				$("#thend").attr("class", "sorted descending");
				thorder("endd");
				clickend += 1;
				clicknick = 0, clickname = 0, clickstart = 0, clickid = 0;
			}
		}); */
/* 		function thorder(order) {
			$.ajax({
						url : "userbkorder.do",
						data : {
							order : order
						},
						type : "post",
						dataType : "json",
						success : function(result) {
							var objStr = JSON.stringify(result);
							var jsonObj = JSON.parse(objStr);
							//출력용 문자열 준비 
							var bk = 0;
							//출력할 문자열 만들기
							for ( var i in jsonObj.list) {
								bk += '<tr><td><div class="ui fitted checkbox"><input type="checkbox" name="userselect"> <label></label></div></td><td><i class="small icons" style="bottom: 3px;">'
										+ '<i class="big red dont icon" style="margin-right: 0px;"></i> <i class="black user icon"></i></i> '
										+ '&nbsp; <a href="${ usermd }">'
										+ jsonObj.list[i].userid
										+ "</a></td><td id='tdnick'><a href='${ usermd }'>"
										+ decodeURIComponent(jsonObj.list[i].nickname
												.replace(/\+/gi, " "))
										+ "</a></td><td><a href='${ usermd }'>"
										+ decodeURIComponent(jsonObj.list[i].username
												.replace(/\+/gi, " "))
										+ "</a></td><td>"
										+ jsonObj.list[i].blackstart
										+ "</td><td>"
										+ jsonObj.list[i].blackend
										+ "</td></tr>";
							}
							$("#blacktable").html(bk);
						},
						error : function(request, status, errorData) {
							console.log("error code : " + request.status
									+ "\nMessage : " + request.responseText
									+ "\nError : " + errorData);
						}
					});
		} */
		
		var adminid = $("input[name=adminid]").val();
		$("#endok").click(function() {
			if ($("input[name=useridchk]:checked").length > 0) {
				var confirm_del = confirm("해당 사용자를 블랙리스트에서 해제하시겠습니까?");
				
				if (confirm_del) {
					var checkArr = [];
					$("input[name=useridchk]:checked").each(function() {
						checkArr.push($(this).val());
					});
					$.ajax({
						url : "blackend.do",
						data : {userid : checkArr, adminid : adminid},
						type : "post",
						success : function(result) {
							console.log(result);
							  location.href =  location.href;
						},
						traditional : true,
						error : function(request, status, errorData) {
							console.log("error code : "
									+ request.status + "\nMessage : "
									+ request.responseText
									+ "\nError : " + errorData);
						}
					});
				}
			}else {
				alert("사용자를 선택해주세요.");
			}
		});
		
		$("#quitpop").click(function() {
			$("#quitdiv").css("display", "block");
		});
		$("#quitclose").click(function() {
			$("#quitdiv").css("display", "none");
		});
		
		
		$("#quitok").click(function() { 
			if ($("input[name=useridchk]:checked").length > 0) { 
				if($("input[name=quitreason]:checked").length > 0){ 
				var confirm_del = confirm("해당 탈퇴시키겠습니까?");
		
				if (confirm_del) {
					var checkArr = [];
					$("input[name=useridchk]:checked").each(function() {
						checkArr.push($(this).val()); 
					});
					console.log(checkArr);
					console.log($("input[name=useridchk]:checked").val());
					var blackreason = $("input[name=quitreason]:checked").val();
					if(blackreason == 'etc'){
						blackreason = $("#quitetcreason").val();
					}
					console.log(blackreason);
					var data = { userid : checkArr, quitreason : blackreason};
					console.log(data);
					$.ajax({
						url : "adminquit.do",
						data : data, 
						type : "post",
						success : function(result) {
							console.log(result);
							  location.href = location.href ;
						},
						traditional : true,
						error : function(request, status, errorData) {
							console.log("error code : "
									+ request.status + "\nMessage : "
									+ request.responseText
									+ "\nError : " + errorData);
						}

					});
				}
				}else {
					alert("강제탈퇴 사유를 작성해주세요.");
				}
			}else {
				alert("사용자를 선택해주세요.");
			}
		});
		$('.dropdown').dropdown({});
		$("input[name=userid]").hide();
		
		$("#searchuserid").click(function() { 
		$("input[name=nickname]").hide();
		$("input[name=nickname]").val("");
		$("input[name=userid]").show();
		});
		$("#searchnick").click(function() {
		$("input[name=userid]").hide();
		$("input[name=userid]").val(""); 
		$("input[name=nickname]").show();
		});

		
		
	});
</script>
<c:import url="adminHeader.jsp" />
</head>
<body>
	<div id="um">
	<div id="quitdiv">
		<label id="qlabel">강제 탈퇴 사유를 선택해 주세요.</label>
		<br><br><hr><br>
		<input type="radio" value="욕설 및 비방" name="quitreason">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 욕설 및 비방<br><br>
		<input type="radio" value="부적절한 컨텐츠" name="quitreason">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 부적절한 컨텐츠<br><br>
		<input type="radio" value="광고 및 스팸" name="quitreason">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 광고 및 스팸<br><br>
		<input type="radio" value="etc" name="quitreason">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 기타<br>
		<textarea id="quitetcreason" rows="4" cols="53" placeholder="기타 사유를 작성해주세요." style="margin-top: 15px; margin-left: 30px; padding: 10px; margin-bottom: 13px; resize: none;"></textarea>
		<br>
		<div align="center">
		<button class="ui grey button" id="quitok">등록</button> &nbsp;&nbsp;&nbsp;
		<button class="ui button" id="quitclose">취소</button>
		</div>
		<input type="hidden" value="${ sessionScope.loginUser.userid }" name="adminid">
	</div>
	<div align="right">
		<form action="userbk.do" method="get">
				<input type="submit" class="ui basic button" value="검색">
				<div class="ui right action left icon input">
					<i class="search icon"></i>
					<input type="search" placeholder="닉네임 검색" name="nickname"> 
					<input type="search" placeholder="아이디 검색" name="userid"> 
					<input type="hidden" value="1" name="page">
					<!-- <input type="hidden" value="" name="usertype">
					<input type="hidden" value="" name="blackyn">
					<input type="hidden" value="" name="quityn"> -->
					<div class="ui basic floating dropdown button">
						<div class="text">닉네임</div>
						<i class="dropdown icon"></i>
						<div class="menu">
							<div class="item" id="searchnick">닉네임</div>
							<div class="item" id="searchuserid">아이디</div> 
						</div>
					</div>
				</div>
			</form>
	</div>
<%-- 			<div align="center" 
			style="padding: 20px; font-family:'Nanum Gothic'; font-size: 14pt; margin-bottom: -16px; background: black; color: white;">
	블랙리스트 회원 : ${ bklist.size() } 명</div>  --%><br> 
			<div id="bkt" colspan="6" style="text-align: center; font-weight: bold;font-size: 13pt; border-bottom: white 1.5px solid; font-family:'Nanum Gothic';">
			블랙리스트 ： ${ bklist.size() } 명</div><br>
		<table class="ui sortable celled table selectable">
			<thead>
				<tr>
					<th width="5" id="thchk">
						<div class="ui fitted checkbox">
							<input type="checkbox" id="checkall"> <label></label>
						</div> 
					</th>
					<th class="" id="thuserid" width="200">회원ID</th>
					<th class="" id="thnick" width="200">닉네임</th>
					<th class="" id="thname" width="200">이름</th>
					<th class="" id="thstart" width="300">블랙리스트 등록일</th>
					<th class="" id="thend" width="300">블랙리스트 종료일</th>
				</tr>
			</thead>
			<tbody id="blacktable">
				<c:forEach items="${ bklist }" var="userbk">
					<c:url value="usermd.do" var="usermd">
						<c:param name="userid" value="${ userbk.userid }" />
					</c:url>
					<tr>
						<td>
							<div class="ui fitted checkbox"><input type="checkbox" name="useridchk" value="${ userbk.userid }"> <label></label></div>
						</td>
						<td><i class="small icons" style="bottom: 3px;"> <i
								class="big red dont icon" style="margin-right: 0px;"></i> <i
								class="black user icon"></i></i> &nbsp; <a href="${ usermd }">${ userbk.userid }</a></td>
						<td id="tdnick"><a href="${ usermd }">${ userbk.nickname }</a></td>
						<td><a href="${ usermd }">${ userbk.username }</a></td>
						<td>${ userbk.blackstart }</td>
						<td>${ userbk.blackend }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div align="right">
			<button class="ui button" id="endok">
				<i class="undo icon"></i>블랙리스트 해제
			</button>
			<button class="ui grey button" id="quitpop"	>
				<i class="x icon"></i>강제탈퇴
			</button>
		</div><br>
		<div align="center">
		<div class="ui pagination menu"  id="pagingdiv">
		<c:if test="${ currentPage eq 1 }">
		<a href="/objet/userbk.do?page=1" class="disabled item"><i class="angle double left icon"></i></a>
		</c:if>
		<c:if test="${ currentPage ne 1 }">
		<a href="/objet/userbk.do?page=1" class="item"><i class="angle double left icon"></i></a>
		</c:if>
		<c:if test="${ beginPage - 10 < 1 }">
		<c:if test="${ currentPage eq 1 }"><a href="/objet/userbk.do?page=1" class="disabled item"><i class="angle left icon"></i></a></c:if>
		<c:if test="${ currentPage ne 1 }"><a href="/objet/userbk.do?page=1" class="item"><i class="angle left icon"></i></a></c:if>
		</c:if>
		<c:if test="${ beginPage - 10 >= 1 }">
		<a href="/objet/userbk.do?page=${ currentPage }" class="item"><i class="angle left icon"></i></a>
		</c:if>
		<c:forEach begin="${ beginPage }" end="${ endPage }" var="p">
		<c:if test="${ p eq currentPage }">
<%-- 		<a href="/objet/userbk.do?page=${ p }" class="active item">${ p }</a> --%>
		<a class="active item pages" id="pages">${ p }</a>
		</c:if>
		<c:if test="${ p ne currentPage }">
<%-- 		<a href="/objet/userbk.do?page=${ p }" class="item">${ p }</a> --%>
		<a class="item pages" id="pages">${ p }</a>
		</c:if>
		</c:forEach>
		<c:if test="${  endPage + 10 > maxPage }">
		<c:if test="${ currentPage eq endPage }">
		<a href="/objet/userbk.do?page=${ maxPage }" class="disabled item"><i class="angle right icon"></i></a>
		</c:if>
		<c:if test="${ currentPage ne endPage }">
		<a href="/objet/userbk.do?page=${ maxPage }" class="item"><i class="angle right icon"></i></a>
		</c:if>
		</c:if>
		<c:if test="${ endPage + 10 <= maxPage }">
		<a href="/objet/userbk.do?page=${ endPage + 10 }" class="item"><i class="angle right icon"></i></a>
		</c:if>
		<c:if test="${ currentPage eq endPage }">
		<a href="/objet/userbk.do?page=${ endPage }" class="disabled item"><i class="angle double right icon"></i></a>
		</c:if>
		<c:if test="${ currentPage ne endPage }">
		<a href="/objet/userbk.do?page=${ endPage }" class="item"><i class="angle double right icon"></i></a>
		</c:if>
	</div>
	</div>
	</div>
	<c:import url="../footer.jsp"/>
	
	
</body>
</html>