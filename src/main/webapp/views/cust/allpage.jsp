<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-8 text-left">
  <h1>cust all page</h1>
  <table class="table">
    <thead>
    <tr>
      <th>id</th>
      <th>name</th>

    </tr>
    </thead>
    <c:forEach var="c" items="${cpage.getList()}">
    <tbody>
    <tr>
      <td><a href="/cust/get?id=${c.id}">${c.id}</a></td>
      <td>${c.name}</td>
    </tr>
    </c:forEach>
    </tbody>
  </table>

  <jsp:include page="../page.jsp"/>
</div>