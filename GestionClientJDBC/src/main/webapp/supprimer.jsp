<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<%
    int Id = Integer.parseInt(request.getParameter("IdClient"));

    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ilcs2", "root", "");

    PreparedStatement ps = conn.prepareStatement("DELETE FROM Client WHERE IdClient=?");
    ps.setInt(1, Id);
    ps.executeUpdate();

    ps.close();
    conn.close();
    response.sendRedirect("Liste.jsp");


%>

