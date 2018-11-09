<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
    <title>하루일감: 사업자 회원가입</title>
  </head>
  <body>
    <div class="container">
      <form method="post" action="./home">
        <table>
          <thead>
            <tr>
              <th>회원가입</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>아이디</td>
              <td>
                <input type="text" id="userID" name="userID" maxlength="20">
                <button type="button" class="btn btn-danger btn-sm">중복확인</button>
              </td>
                          
            </tr>
            <tr>
              <td>비밀번호</td>
              <td><input type="password" id="userPassword1" name="userPassword1" maxlength="20"></td>            
            </tr>
            <tr>
              <td>비밀번호 확인</td>
              <td><input type="password" id="userPassword2" name="userPassword2" maxlength="20"></td>            
            </tr>
            <tr>
              <td>이름</td>
              <td><input type="text" id="userName" name="userName" maxlength="20"></td>         
            </tr>
            <tr>
              <td>이메일</td>
              <td><input type="email" id="userEmail" name="userEmail" maxlength="20"></td>   
            </tr>
            <tr>
              <td>회사명</td>
              <td><input type="text" id="userCompany" name="userCompany" maxlength="20"></td>
            </tr>
            <tr>
              <td>사업자 번호</td>
              <td><input type="text" id="userNum" name="userNum" maxlength="20"></td>
            </tr>
            <tr>
              <td>계좌</td>
              <td class="dropdown">
                <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">은행
                <span class="caret"></span></button>
                  <ul class="dropdown-menu">
                    <li><a href="#">신한은행</a></li>
                    <li><a href="#">국민은행</a></li>
                    <li><a href="#">기업은행</a></li>
                  </ul>
                <input type="text" id="userAccount" name="userAccount" maxlength="20">
              </td>
              
            </tr>
            <tr>
              <td><button type="button" class="btn btn-warning">회원가입</button></td>
            </tr>
          </tbody>
        </table>
      
      </form>
    </div>
  
  </body>
</html>