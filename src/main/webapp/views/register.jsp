<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
  $(function (){
    register_form.init();
  });

</script>

<div class="col-sm-8 text-center">
  <div class="container">
    <div class="col-sm-6 text-center">
      <h1 style="text-align: center">Register Page</h1>
      <br/>
      <br/>
      <form id="register_form" class="form-horizontal well">
        <div class="form-group">
          <label class="control-label col-sm-2" for="id">ID:</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="id" placeholder="Enter id" name="id">
          </div>
        </div><!--id end-->
        <div class="form-group"><!--pwd start-->
          <label class="control-label col-sm-2" for="pwd">Password:</label>
          <div class="col-sm-10">
            <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
          </div>
        </div><!--pwd end-->
        <div class="form-group"><!--pwd check start-->
          <label class="control-label col-sm-2" for="pwd_check">Password check:</label>
          <div class="col-sm-10">
            <input type="password" class="form-control" id="pwd_check" placeholder="Enter password one more time" name="pwd_check">
          </div>
        </div><!--pwd check end-->
        <div class="form-group"><!--name start-->
          <label class="control-label col-sm-2" for="name">Name:</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
          </div>
        </div><!--name end-->
        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
            <button id="register_btn" type="button" class="btn btn-default">Submit</button>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>