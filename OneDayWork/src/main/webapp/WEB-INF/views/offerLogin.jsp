<%@page import="com.lx.odw.vo.OfferVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>offerer Login</title>
<script
  src="https://code.jquery.com/jquery-3.3.1.js"
  integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
  crossorigin="anonymous"></script>
<style>
 html, body{
            margin: 0px;
            padding: 0px;
            height: 100%;
            width: 100%;
            }
            #center{
                margin-top: 250px;
            }
            #id,#pw{
                width: 400px;
                height: 30px;
            }
            #offererLogin{
                width: 405px;
                height: 40px;
                background-color: #03611c;
                color: white;
                font-size: 13pt;
        }
</style>
</head>
<body>
<%List<OfferVO> list = (List<OfferVO>) request.getAttribute("offerId"); %>
<form action="offerLogin.do" method="post">
 <center id="center">
          <table>
            <tr>
                <td> <img src="resources/img/haru.png" width="80px" height="80px"></td>
                <td><h1>하루일감</h1></td>
            </tr>
        </table>
           <h4>구인자 로그인</h4>
        <table>
        <tr>
            <td>
                <input type="text" id="id" name="id" placeholder=" ID" >
            </td>
            </tr>
            <tr>
            <td>
                <input type="password" id="pw" name="pw" placeholder=" PassWord">
            </td>
            </tr>
        </table>
           <br>
        <div>
               <input type="submit" value="로그인" id="offererLogin" name="offererLogin">
        </div>
           </center>
</form>
</body>
</html>