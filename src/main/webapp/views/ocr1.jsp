<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    $(function () {
        ocr_form.init();
    });
</script>
<div class="col-sm-8  text-left ">
    <div class="container">
        <div class="row content">
            <div class="col-sm-6  text-left ">
                <h1>OCR1</h1>
                <h1>${result.biznum}</h1>
                <h1>${result.bizname}</h1>
                <h1>${result.bizowner}</h1>
                <h1>${result.bizdate}</h1>
                <h1>${result.bizaddress}</h1>
                <form id="ocr_form" class="form-horizontal well" action="/ocr1impl" method="post"
                      enctype="multipart/form-data">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="img">IMG:</label>
                        <div class="col-sm-10">
                            <input type="file" name="img" class="form-control" id="img" placeholder="Enter IMG">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button id="login_btn" type="submit" class="btn btn-default">SEND</button>
                        </div>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>
