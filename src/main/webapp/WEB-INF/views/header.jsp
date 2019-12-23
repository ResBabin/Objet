<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- favicon 위치 -->
<link rel="shortcut icon" href="resources/images/favicon-32x32.png">
<link rel="icon" href="resources/images/favicon-32x32.png">
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">

<!-- 시맨틱유아이 cdn -->
<script type="text/javascript" src="/objet/resources/js/jquery-3.4.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<link rel='stylesheet' href='//fonts.googleapis.com/earlyaccess/kopubbatang.css'>
<link rel="stylesheet" type="text/css" href="resources/assets/css/KoPubDotum.css">
<link rel="stylesheet" href="//fonts.googleapis.com/earlyaccess/nanummyeongjo.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel = "stylesheet" type="text/css" href="/objet/resources/css/main.css">
<link rel = "stylesheet" type="text/css" href="/objet/resources/css/search.css">
<style type="text/css">

/* 메뉴아이콘 */
input[id="menuicon"] {display:none;}
input[id="menuicon"] + label {display:block;width:40px;height:30px;position:absolute;cursor:pointer;}
input[id="menuicon"] + label span {display:block;position:absolute;width:100%;height:5px;border-radius:30px;background:#000;transition:all .35s;}
input[id="menuicon"] + label span:nth-child(1) {top:0;}
input[id="menuicon"] + label span:nth-child(2) {top:50%;transform:translateY(-50%);} 
input[id="menuicon"] + label span:nth-child(3) {bottom:0;}
input[id="menuicon"]:checked + label {z-index:3;}
input[id="menuicon"]:checked + label span {background:black;}
input[id="menuicon"]:checked + label span:nth-child(1) {top:50%;transform:translateY(-50%) rotate(45deg);}
input[id="menuicon"]:checked + label span:nth-child(2) {opacity:0;}
input[id="menuicon"]:checked + label span:nth-child(3) {bottom:50%;transform:translateY(50%) rotate(-45deg);}
div[class="sidebar"] {width:220px;height:100%;background:#fff;position:fixed;top:0;left:-300px;z-index:2;transition:all .35s; border: 1px solid lightgray;}
input[id="menuicon"]:checked + label + div {left:0;}
/*헤더 */
header {
  weight: 100%;
  height: 10%;
  background-color: transparent;
  padding: 30px;
  text-align: center;
  font-size: 35px;
  color: black;
  transition: top 0.2s ease-in-out;
  z-index: 10;

} 

/* 사이트 짧은 소개글 */
.intro{
 margin-bottom: 50px;
 text-align: center;
}
  /* 사이트 로고 */
  .meueicon1{
  float: left;
  }
 
.sitemain{
  float:left;
  margin-left: 60px;
  margin-top: -7px;
  }
 
  /* 사이드바 중 로그인 영역 */
  .sidebar1{
  
   background:rgba(0, 0, 0, 0.03);

  position:fixed;
  font-size: 17px;
 width:220px;
 height: 22%;
  color: black;
 
  }
 
  /* 사이드바 중 메뉴영역 박스 시작
    -홈, 전시, 작가, 고객센터 써있는 부분*/
  .sidebar2{
  margin-top: -35px;
 /*  border: 2px solid yellow; */
  font-size: 20px;
  position:fixed;
  list-style:none;
  height: 38%;
  width:220px;
  background-color:#fff;
  color: black;
  }
  
nav {
  width: 100%;
  display: flex;
  justify-content: center;
  position: relative;

}

ul, li {
 
  padding: 0;
  list-style: none;
}


/*  #main-menu > li:hover{
color:#666666;
}  */ 

#main-menu > li > a {
margin-top: -22px;
  margin-left: 10px;
  font-size: 18px;
  color: black;
  text-align: center;
  text-decoration: none;
  letter-spacing: 0.05em;
  display: block;
  padding: 22px 19px; 
 
}

/* 고객센터 하위메뉴 */
#sub-menu {

  width: 220px;
  font-size: 16px;
  position: absolute;
  opacity: 0;
  visibility: hidden;
  transition: all 0.15s ease-in;
}

#sub-menu > li {
margin-top: -17px;
  padding: 15px 60px;
}

#sub-menu > li >  a {
  color: black;
  text-decoration: none;
}

#main-menu > li:hover #sub-menu {
  opacity: 1;
  visibility: visible;
}

#sub-menu > li >  a:hover {
 color: #666666;
}
.photo{
text-align: center;
width: 220px;
margin-top: 50px;
/* border: 2px solid navy; */

height:60%;
}
.nickname{
margin-top: -50px;
text-align: center;
width: 220px;
/* border: 2px solid red; */
height:13%;
}
.follower{
text-align: center;
width: 220px;
/* border: 2px solid green; */
height:13%;
}
.following{
text-align: center;
width: 220px;
/* border: 2px solid yellow; */
height:13%;
}
.artistHome{
font-size: 18px;
width: 220px;
/* border: 2px solid yellow; */
margin-top: 166px;
}

.fd{
margin-bottom: 7px;
margin-top: 7px;
width: 220px;
/* border: 2px solid yellow; */
font-size: 18px;
}
.qna{
width: 220px;
/* border: 2px solid black; */
font-size: 18px;
}

#accordian1 {
    margin-top:-30px;
	background: #fff;
	width: 220px;
	color: black;
}

/* 메뉴 스타일 */
.accordian1 {
    font-size: 18px;
	cursor: pointer;
	background: #fff;
}

#accordian1 li {
	list-style-type: none;
}

/* 서브메뉴 스타일 */
#accordian1 ul ul li a {
	color: black;
	text-decoration: none;
	font-size: 18px;
	display: block;
	padding: 10px;
	transition: all 0.15s;
}
/* active 클래스 외에 것은 보이지 않게 하기 */
#accordian1 ul ul {
	display: none;
}
#accordian1 li.active ul {
	display: block;
}
.sidebar3{
  height: 30%;
 background:rgba(0, 0, 0, 0.03);

}
.bloginwrite{/* 비로그인시 박스안에 들어갈 글 */
margin-top: 10px;
font-size: 14px;
font-family: Courier New;
font-style: oblique;
}
#blogo{/* 비로그인시 안에 들어가는 아이콘 */
margin-top: 50px;
border-radius:50%;
}

.sidebar4{

}
a{
color: black;
}
/* 사이드바 안에 계정 찾기 */
.forget{
  
  font-size: 16px;
  margin-left: 2px;
  margin-top: 230px;
  } 
  /* 사이드 바 안에 로그아웃 내 정보 수정 */
  .logout{
  
  font-size: 16px;
  margin-left: 10px;
  margin-top: 55px;
  } 
  /* 더보기 */
  .more{
  margin-top: 70px;
   /* border: 2px solid red; */
  text-align: right;
  margin-right: 30px;
  margin-bottom:10px;
  }
  #startbutton{
  margin-top: 27px;
  }
  
 </style>
  
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
     <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
   <script type="text/javascript">
   
   $(function(){
		$(".accordian1").click(function(){
			$("#accordian1 ul ul").slideUp();
			if(!$(this).next().is(":visible"))
			{
				$(this).next().slideDown();
			}
		})
	})
	</script>
</head>
<body>
<header>
<div class="sitemain"><a href="main.do">
<img src="resources/images/objet_logo_black.png" width="70px" height="50px"></a></div> 
<!--메뉴 아이콘-->
<input type="checkbox" id="menuicon">
<label for="menuicon">
   <span></span>
   <span></span>
   <span></span>
</label>

<!--메뉴 아이콘-->
<!-- 비로그인시 메뉴 아이콘 열리는 사이드바 -->
<div class="sidebar">
<div class="sidebar3">
<img id="blogo" src="resources/images/basicprofilepic.png" width="60px" height="60px">
<div class="bloginwrite">The moment everything becomes an inspiration</div>
<button class="tiny ui black basic circular button" id= "startbutton">오브제 시작하기</button>
</div>
<div class="sidebar4">
<nav role="navigation">
 <ul id="main-menu">
 
    <li><a href="#">홈</a></li>
     
    <li><a href="#">전시</a></li>
    
    <li><a href="#">작가</a></li>
    
    <li><a href="#">고객센터</a>
      <ul id="sub-menu">
        <li><a href="#" aria-label="subemnu">FAQ</a></li>
        <li><a href="#" aria-label="subemnu">공지사항</a></li>
        </ul>
        </li>
        </ul>
        </nav>
</div>
<div class="forget">
계정을 잃어버리셨습니까?
</div>
</div> 
<!--로그인시 메뉴 아이콘 열리는 사이드바-->
<!-- <div class="sidebar">
<div class="sidebar1">
<div class="photo">
<i class="big user circle icon"></i>
</div>
<div class="nickname">닉네임</div>
<div class="follower">팔로워수</div>
<div class="following">팔로잉수</div>
</div>
<div class="artistHome"><p onclick="location.href='artistHomeMain.do'">작가홈</p></div>
<div id="accordian1">
	<ul>
		<li>
			<span class="accordian1">오브제관리</span>
			<ul>
				<li><a href="moveMyObjetList.do">내 오브제</a></li>
				<li><a href="moveCreateObjet.do">오브제 등록</a></li>
				<li><a href="moveMyLikeObjetList.do">관심오브제</a></li>
				<li><a href="moveMyVisitedObjetList.do">다녀온오브제</a></li>
			</ul>
		</li>
		
		<li><div class="fd"><p onclick="location.href='moveFeedList.do'">피드알림</p></div></li>
		<li><div class="qna"><p onclick="location.href='moveMyQnaList.do'">문의내역</p></div></li>
	</ul>
</div>

<div class="sidebar2">
<nav role="navigation">
 <ul id="main-menu">
 
    <li><a href="main.do">홈</a></li>
     
    <li><a href="objetMain.do">전시</a></li>
    
    <li><a href="#">작가</a></li>
    
    <li><a href="moveCs.do">고객센터</a>
      <ul id="sub-menu">
        <li><a href="moveFaqMain.do" aria-label="subemnu">FAQ</a></li>
        <li><a href="moveNotice.do" aria-label="subemnu">공지사항</a></li>
        </ul>
        </li>
        </ul>
        </nav>
        <div class= "logout">
        <div class="small ui buttons">
  <button class="ui black basic button">내 정보 수정</button>
  <button class="ui black basic button">로그아웃</button>
</div>
</div>
</div>
</div> -->
</header>
</body>
</html>