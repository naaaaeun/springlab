<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>

  let register_form = {
    init : function(){
      $('#register_btn').click(function(){
        register_form.send();
      });
      $('#name').keyup(() => {

        let id =$('#id').val();
        let pwd =$('#pwd').val();
        let name =$('#name').val();
        if(id!=""&&pwd!=""&&name!=""){
          $('#register_btn').removeClass('disabled');
        }
      });
      $('#id').keyup(() => {
        $('#register_btn').addClass('disabled');
        var txt_id = $('#id').val();
        if(txt_id.length <= 3){
          $('#check_id').text('4자리 이상이어야 합니다.');
          return;
        }
        $.ajax({
          url : '/checkid',
          data : {id:txt_id},
          success:function(result){
            if(result == 0){
              $('#check_id').text('사용가능합니다.')
              $('#pwd').focus();
            } else{
              $('#check_id').text('사용불가능합니다.')
            }
          }
        })
      });
    },
    send : function(){
      let id =$('#id').val();
      let pwd =$('#pwd').val();
      let name =$('#name').val();
      if(pwd==''){
        $('#pwd').focus();
        return;
      }
      if(name==''){
        $('#name').focus();
        return;
      }
      $('#register_form').attr({
        'action':'/registerimpl',//MainController로 요청을 보낸다.
        'method':'post'
      });
      $('#register_form').submit();
    }
  };
  $(function(){
    register_form.init()
  });

</script>
<div class="col-sm-8 text-left">
  <div class="container">
    <div class="row content">
      <div class="col-sm-6  text-left ">
        <h1>Register Page</h1>
        <form id="register_form" class="form-horizontal well">
          <div class="form-group">
            <label class="control-label col-sm-2" for="id">ID:</label>
            <div class="col-sm-10">
              <input type="text"class="form-control"  name="id" id="id" placeholder="Enter id">
              <%--위 인풋에 대한 키다운 이벤트가 발생--%>
            </div>
            <div class = "col-sm-10" class >
              <span id = "check_id" class = "bg-danger"></span>
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2" for="pwd">Password:</label>
            <div class="col-sm-10">
              <input type="password" class="form-control" name="pwd"  id="pwd" placeholder="Enter password">
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2" for="name">NAME:</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" name="name"  id="name" placeholder="Enter name">
            </div>
          </div>
          <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
              <button id="register_btn" type="button" class="btn btn-default">Register</button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>