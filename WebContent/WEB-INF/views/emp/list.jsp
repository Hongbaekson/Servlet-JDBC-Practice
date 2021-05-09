<%@page import="dto.Emp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% List<Emp> eList = (List) request.getAttribute("list");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border-collapse: collapse;
	border: 1px solid #ccc;
}
td {
	border-top: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
	
	padding: 5px 10px;
}
td:hover {
	background: #FAFAD2;
}
</style>

</head>
<body>

<h1>EMP 리스트</h1>
<hr>
<table>
<%	for(int i=0; i<eList.size(); i++) { %>
<tr>
	<td><%=eList.get(i).getEmpno() %></td> 
	
	
	<td>
        <a href="/emp/detail?eno=<%=eList.get(i).getEmpno() %>">
            
            <%=eList.get(i).getEname() %> 
        </a>
    
	</td>
			
	<td><%=eList.get(i).getJob() %></td>
	<td><%=eList.get(i).getMgr() %></td>
	<td><%=eList.get(i).getHiredate() %></td>
	<td><%=eList.get(i).getSal() %></td>
	<td><%=eList.get(i).getComm() %></td>
	<td><%=eList.get(i).getDeptno() %></td>
</tr>
<%	} %>
</table>

</body>
</html>







