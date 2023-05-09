<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="col-sm-8 text-left">
    <h1>jsp 02</h1>
    <c:if test="${rcust!=null}">

        <h3>${rcust.id}</h3>
        <c:if test="${rcust.id=='id01'}">
            <h4>콜센터 직원</h4>
        </c:if>
    </c:if>
<%--    jstl if else--%>
    <c:choose>
        <c:when test="${num==3}">
            <p>num is 3</p>
        </c:when>
        <c:when test="${num==2}">
            <p>num is 2</p>
        </c:when>
        <c:otherwise>
            <p>num is 1</p>
        </c:otherwise>
    </c:choose>
    <h1>end page</h1>
</div>