<%@page import="dto.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
  <%-- JSP --%>
  <%-- 컨트롤러가 Request체를 이용하여 전달한 Model객체 꺼내오기(얻어오기) --%>
  
  <%
  
  Emp result = (Emp) request.getAttribute("result");
  
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>사원 정보 상세 보기 </h1>
    <hr>
    
    <table border="1">
      <tr>
        <th>사원번호</th>
        <th>사원이름</th>
        <th>직무</th>
        <th>매니저</th>
        <th>입사날짜</th>
        <th>급여</th>
        <th>상여금</th>
        <th>부서번호</th>
      </tr>
      <tr>
        <td><%=result.getEmpno() %></td>
        <td><%=result.getEname()%></td>
        <td><%=result.getJob()%></td>
        <td><%=result.getMgr() %></td>
        <td><%=result.getHiredate() %></td>
        <td><%=result.getSal() %></td>
        <td><%=result.getComm() %></td>
        <td><%=result.getDeptno() %></td>
      </tr>
    </table>
    
    <a href="/emp/list"><button>목록</button></a>
    
</body>
</html>