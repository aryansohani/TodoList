<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ page import="java.sql.*, lovejava.Model" %>

<%
Model m = new Model();
ResultSet rs = m.show();
%>

<h2>Task List</h2>

<%
while (rs.next()) {
%>
    <p>
        <%= rs.getString("task") %>

        <a href="<%= request.getContextPath() %>/DeleteServlet?id=<%= rs.getInt("id") %>"
           onclick="return confirm('Delete this task?')">
            <button style="color:red;">Delete</button>
        </a>
    </p>
<%
}
m.close(); // ✅ MUST BE HERE
%>

<a href="<%= request.getContextPath() %>/index.html">
    <button>➕ Add More Tasks</button>
</a>



</body>
</html>