<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    let login_form={
        init:function (){
            $('#login_btn').click(function (){
                login_form.send(); //send 호출
            });
        },
        send:function (){
            $('#login_form').attr({
                'action':'/loginimpl', //보통 이 이름으로 많이 함.
                'method':'post'//형태 확인하기 위해 일단 get방식으로 진행.
            });
            $('#login_form').submit();
        }
    }
    $(function (){
        login_form.init();
    })
</script>
<div class="col-sm-8 text-center">
    <div class="container">
        <div class="col-sm-6 text-center">
            <h1 style="text-align: center">Login Page</h1>
            <br/>
            <br/>
            <form id="login_form" class="form-horizontal well">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="id">ID:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="id" placeholder="Enter id" name="id">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="pwd">Password:</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <div class="checkbox">
                            <label><input type="checkbox" name="remember"> Remember me</label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button id="login_btn" type="button"  class="btn btn-default">Submit</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>