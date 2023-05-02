<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--   <div class="container">--%>
<div class="col-sm-8 text-left">

  <h3> Map Center </h3>
  <img src="/uimg/${gmarker.img}">
  <h3>${gmarker.id}</h3>
  <h3><a href="${gmarker.target}">${gmarker.title}</a></h3>

  <h4>menu</h4>
  <table class="table">
    <thead>
    <tr>
      <th>img</th>
      <th>item</th>
      <th>price</th>

    </tr>
    </thead>
    <c:forEach var="m" items="${mlist}">
    <tbody>
    <tr>
      <td><img href="/uimg/${m.imgname}">${m.id}</td>
      <td>${m.item}</td>
      <td>${m.price}</td>
    </tr>
    </c:forEach>
    </tbody>
  </table>
</div>