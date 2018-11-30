<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>haruMainPage</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="//code.jquery.com/jquery-1.12.4.min.js"></script>
<style type="text/css">
.menu_item{width: 200px;height: 200px;}
a{text-decoration: none; color: black;}
</style>
</head>
<body>

<!-- Container (The Band Section) -->
<div id="band" class="container text-center">
  <table class="table">
  	<tr class="row">
  		<td class="col-sm-4"><a href="registration.do"><img class="menu_item" src="resources/img/add_work.png"><br><br><span class="text-center">일감 등록</span></a> </td>
  		<td class="col-sm-4"><a href="projectList.do"><img class="menu_item" src="resources/img/manage_work.png"><br><br><span class="text-center">일감 목록</span></a> </td>
  		<td class="col-sm-4"><a href="manageCommute.do"><img class="menu_item" src="resources/img/manage_commute.png"><br><br><span class="text-center">출퇴근 관리</span></a> </td>
  	</tr>
  </table>
  </div>
</div>

<!-- Container (TOUR Section) -->
<div id="tour" class="bg-1">
  <div class="container">
    <h3 class="text-center">하루일감 소개</h3>
    <p class="text-center">업종별 일감, 정보 제공; 위치기반 서비스 제공; 전자 근로 계약서</p>
    
    <div class="row text-center">
      <div class="col-sm-4">
        <div class="thumbnail">
          <img src="resources/img/laptop.png " alt="Paris" width="100" height="90">
          <p><strong>업종별 일감 제공</strong></p>
          
          <button class="btn" data-toggle="modal" data-target="#Modal1">상세보기</button>
        </div>
      </div>
      <div class="col-sm-4">
        <div class="thumbnail">
          <img src="resources/img/main2.png" alt="Paris"  width="100" height="90">
          <p><strong>위치기반 서비스</strong></p>
          
          <button class="btn" data-toggle="modal" data-target="#Modal2">상세보기</button>
        </div>
      </div>
      <div class="col-sm-4">
        <div class="thumbnail">
          <img src="resources/img/main3.png" alt="Paris"  width="100" height="90">
          <p><strong>전자 근로 계약서</strong></p>
          
          <button class="btn" data-toggle="modal" data-target="#jeonja">상세보기</button>
        </div>
      </div>
    </div>
  </div>
  
  <!-- Modal -->
    <div class="modal fade" id="Modal1" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">×</button>
          <h4>업종별 일감 제공</h4>
        </div>
        <div class="modal-body">
          <form role="form">
            <div class="form-group">
            <img src="resources/img/offer_job.png" width="175%%">
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal">
            <span class="glyphicon glyphicon-remove"></span> Cancel
          </button>  
        </div>
      </div>
    </div>
  </div>
    <div class="modal fade" id="Modal2" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">×</button>
          <h4>위치기반 서비스</h4>
        </div>
        <div class="modal-body">
          <form role="form">
            <div class="form-group">
            <img src="resources/img/find_job.jpg" width="100%">
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal">
            <span class="glyphicon glyphicon-remove"></span> Cancel
          </button>  
        </div>
      </div>
    </div>
  </div>
  <div class="modal fade" id="jeonja" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">×</button>
          <h4>전자 근로 계약서</h4>
        </div>
        <div class="modal-body">
          <form role="form">
            <div class="form-group">
            <img src="resources/img/contract.PNG" width="100%">
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal">
            <span class="glyphicon glyphicon-remove"></span> Cancel
          </button>  
        </div>
      </div>
    </div>
  </div>
  <!-- Modal -->
  
</div>

<!-- Container (Contact Section) -->
<div id="contact" class="container">
  <h3 class="text-center">고객 센터</h3>
  <p class="text-center"><em>불편한 사항이 있으면 연락 주세요</em></p>

  <div class="row">
    <div class="col-md-4">
      <p>Fan? Drop a note.</p>
      <p><span class="glyphicon glyphicon-map-marker"></span>공간정보 아카데미, LX</p>
      <p><span class="glyphicon glyphicon-phone"></span>Phone: +82 010-1234-5678</p>
      <p><span class="glyphicon glyphicon-envelope"></span>Email: haruligam@mail.com</p>
    </div>
    <div class="col-md-8">
      <div class="row">
        <div class="col-sm-6 form-group">
          <input class="form-control" id="name" name="name" placeholder="Name" type="text" required>
        </div>
        <div class="col-sm-6 form-group">
          <input class="form-control" id="email" name="email" placeholder="Email" type="email" required>
        </div>
      </div>
      <textarea class="form-control" id="comments" name="comments" placeholder="Comment" rows="5"></textarea>
      <br>
      <div class="row">
        <div class="col-md-12 form-group">
          <button class="btn pull-right" type="submit">보내기</button>
        </div>
      </div>
    </div>
  </div>
  <br>
  <h3 class="text-center">Team</h3>  
  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#home">이제운</a></li>
    <li><a data-toggle="tab" href="#menu1">김한슬</a></li>
    <li><a data-toggle="tab" href="#menu2">김동가</a></li>
    <li><a data-toggle="tab" href="#menu3">최선주</a></li>
    <li><a data-toggle="tab" href="#menu4">윤정민</a></li>
  </ul>

  <div class="tab-content">
    <div id="home" class="tab-pane fade in active">
      
      <p><em>팀장, 프로젝트 총괄, 웹＊앱 개발</em></p>
      <p><img src="resources/img/lee.png" alt="Random Name" width="10%"></p>
    </div>
    <div id="menu1" class="tab-pane fade">
     
      <p><em>기획 총괄, 웹 개발</em></p>
      <p><img src="resources/img/han.jpg" alt="Random Name" width="10%"></p>
    </div>
    <div id="menu2" class="tab-pane fade">
      
      <p><em>앱 개발, DB구축</em></p>
      <p><img src="resources/img/ga.png" alt="Random Name" width="10%"></p>
    </div>
    <div id="menu3" class="tab-pane fade">
      
      <p><em>웹 개발 총괄, 기획</em></p>
      <p><img src="resources/img/sun.png" alt="Random Name" width="10%"></p>
    </div>
    <div id="menu4" class="tab-pane fade">
      
      <p><em>앱 개발, DB설계</em></p>
      <p><img src="resources/img/min.png" alt="Random Name" width="10%"></p>
    </div>
  </div>
</div>

<!-- Image of location/map -->
<img src="map.jpg" class="img-responsive" style="width:100%">

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>