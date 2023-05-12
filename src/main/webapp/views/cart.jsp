<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
  .item_img{
    width: 50px; height: 50px;
  }
</style>

<div class="col-sm-8 text-left">
  <div class="container">

    <div class="row content">
      <div class="col-sm-9 text-left">
        <h3>Item All Page</h3>
          <c:set var="total" value="0"/>
            <table class="table table-hover">
              <thead>
              <tr>
                <th>IMG</th>
                <th>ID</th>
                <th>NAME</th>
                <th>PRICE</th>
                <th>COUNT</th>
                <th>total price</th>
                <th>REGDATE</th>
                <th>DELETE</th>
              </tr>
              </thead>

              <tbody>
              <c:forEach var="obj" items="${allcart}">
                <tr>
                  <td><img class="item_img" src="/uimg/${obj.item_imgname}"></td>
                  <td><a href="/item/get?id=${obj.item_id}">${obj.item_id}</a></td>
                  <td>${obj.item_name}</td>
                  <td><fmt:formatNumber value="${obj.item_price}" pattern="###,###원" /></td>
                  <td><fmt:formatNumber value="${obj.cnt}" pattern="###,###개" /></td>
                  <td><fmt:formatNumber value="${obj.cnt*obj.item_price}" pattern="###,###원" /></td>
                  <td><fmt:formatDate  value="${obj.rdate}" pattern="dd-MM-yyyy" /></td>
                  <td><a href="/item/delcart?id=${obj.id  }" class="btn btn-info" role="button">delete</a></td>
                </tr>
                <c:set var="total" value="${total+(obj.cnt*obj.item_price)}"/>
              </c:forEach>
              </tbody>
            </table>
          <fmt:formatNumber value="${total}" pattern="###,###원"/>
      </div>
    </div>
  </div>
</div>