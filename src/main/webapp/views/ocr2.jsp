<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    $(function(){
    });
</script>
<div class="col-sm-8 text-left">
    <div class="container">
        <div class="col-sm-6 text-left">
            <h1>ocr2</h1>
            <br/>
            <h1>${result.type}</h1>
            <h1>${result.comnum}</h1>
            <h1>${result.amount}</h1>
            <form action="/ocr2impl" enctype="multipart/form-data" method="post" id="ocr2_form" class="form-horizontal well">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="img">IMG:</label>
                    <div class="col-sm-10">
                        <input type="file" class="form-control" placeholder="input img" id="img" name="img">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button id="ocr2_btn" type="submit" class="btn btn-default">submit</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>