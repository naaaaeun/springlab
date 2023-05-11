<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <div class="col-sm-2 sidenav">
        <p><a href="/pic">pic</a></p>
        <c:if test="${logincust != null}">
            <p><a href="websocket">web socket</a></p>
        </c:if>
        <p><a href="/cfr1">cfr1</a></p>
        <p><a href="/cfr2">cfr2</a></p>
    </div>