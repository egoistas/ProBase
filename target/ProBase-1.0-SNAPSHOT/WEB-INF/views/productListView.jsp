<%-- 
    Document   : productListView
    Created on : 10-Jan-2024, 09:04:56
    Author     : georg
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    //body
    </head>
    <body>
        <div class="container">
            <jsp:include page="_header.jsp"></jsp:include>
            <h1>Product List</h1>
            <table>
                <thead>
                <th>Code</th>
                <th>Name</th>
                <th>Price</th>
                <th>Edit</th>
                <th>Delete</th>
                </thead>
                <tbody>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <td>${product.getCode()}</td>
                        <td>${product.getName()}</td>
                        <td>${product.getPrice()}</td>
                        <td><a href="editProduct?code=${product.getCode()}">Edit</a></td>
                        <td><a href="deleteProduct?product=${product.getCode()}">Delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <jsp:include page="_footer.jsp"></jsp:include>
    </body>
</html>
