<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page errorPage="erreur.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>calculatrice</title>
</head>
<body>
<form method="POST" action="">
        <table align="center" border="1" >
            <tr>
                <td>Premier opérande :</td>
                <td><input type="number" name="operande1" /></td>
            </tr>
            <tr>
                <td>Deuxième opérande :</td>
                <td><input type="number" name="operande2" /></td>
            </tr>
            <tr>
                <td>Opération :</td>
                <td>
                    <input type="radio" name="operation" value="+" /> Addition<br>
                    <input type="radio" name="operation" value="-" /> Soustraction<br>
                    <input type="radio" name="operation" value="*" /> Multiplication<br>
                    <input type="radio" name="operation" value="/" /> Division
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Calculer" />
                </td>
            </tr>
            
            
        </table>
    </form>
<%
String op1 = request.getParameter("operande1");
String op2 = request.getParameter("operande2");
String operation = request.getParameter("operation");

if (op1 != null && op2 != null && operation != null) {
    double operande1 = Double.parseDouble(op1);
    double operande2 = Double.parseDouble(op2);
    double resultat = 0;
        
    if (operation.equals("+")) {
        resultat = operande1 + operande2;
    } else if (operation.equals("-")) {
        resultat = operande1 - operande2;
    } else if (operation.equals("*")) {
        resultat = operande1 * operande2;
        } else if (operation.equals("/")) {
        	
            resultat = operande1 / operande2;
        	
        }
           
    %>
    
    <table align="center" border="1" cellpadding="5">
        <tr>
            <%
            if (operande2 == 0 && operation.equals("/")){
            	out.println("<h1>Erreur</h1>");
            }else{
            	out.println("<td>Résultat :</td>");
        	    out.println("<td>" +op1+ operation+op2+"="+resultat+"</td>");
        	}
            %>
            
        </tr>
    </table>
    <% } %>
</body>
</html>