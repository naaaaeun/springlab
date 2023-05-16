<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<style>
    #w2{
        width:500px;
        border:2px solid red;
    }
</style>
<script>
    let center = {
        init: () => {
            $.ajax({
                url: "/weather2",
                success: (data) => {
                    center.display(data);
                    console.log(data)
                }
            })
        },
        display: (data) => {
            let resultData = data.response.body.items.item;
            let result = "";
            $(resultData).each(function (index, item) {
                result += '<h4>';
                result += item.tm ;
                result += " " + item.ta + "도" ;
                result += '</h4>';
            });
            $('#w2').html(result);
        }
    };

    $(() => {
        center.init();
    });
</script>

<div class="col-sm-8 text-left">
    <h1><spring:message code="site.title"/></h1>
    <p><spring:message code="site.content"/></p>
    <textarea id="w1" cols="100" rows="10">${weatherinfo}</textarea>
    <hr>
    <div id="w2" cols="100" rows="10"></div>
</div>
