<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>



<!DOCTYPE html>

<html>

<script>

   function addDash(dateCtl){

      if(dateCtl.value.length == 4 || dateCtl.value.length == 7){

         dateCtl.value += "-";

      }

   }

</script>

<head>

<meta charset="UTF-8">

<title>ȸ������ ������</title>

<!-- css �������� -->

<link rel="stylesheet" type="text/css"

   href="/resources/js/semantic.min.css">



<style type="text/css">

body {

   background-color: #FFFFFF;

}



body>.grid {

   height: 100%;

}



.image {

   margin-top: -100px;

}



.column {

   max-width: 450px;

}

</style>

</head>



<body>

   <div class="ui middle aligned center aligned grid">

      <div class="column">

         <h2 class="ui teal image header">ȸ������ ������</h2>

         <div class="ui large form">

            <div class="ui stacked segment">

               <div class="field">

                  <div class="ui left icon input">

                     <input type="text" id="c_id" placeholder="���̵�" autofocus

                        autocomplete="off">

                  </div>

               </div>

               <div class="field">

                  <div class="ui left icon input">

                     <input type="text" id="c_name" placeholder="�̸�">

                  </div>

               </div>



               <div class="field">

                  <div class="ui left icon input">

                     <input type="password" id="c_pw" placeholder="��й�ȣ">

                  </div>

               </div>

               <div class="field">

                  <div class="ui left icon input">

                     <input type="password" id="c_pw2" placeholder="��й�ȣ Ȯ��">

                  </div>

               </div>

               <div class="field">

                  <div class="ui left icon input">

                     <input type="text" id="c_tel" placeholder="����ó(-���� �Է�)">

                  </div>

               </div>

               <div class="field">

                  <div class="ui left icon input">

          <div class="field" >

                     �� <input type="radio" id="c_sex" value="0"style="margin-right:25px;"/>



                      �� <input type="radio" id="c_sex" value="1"/>

                     </div>

                  </div>

               </div>

               <div class="field">

                  <div class="ui left icon input">

                     <input type="date" id="c_birth" size="9" 

                     placeholder="�������  ex)20190606" 

                     onKeyPress="addDash(this)"

                     maxlength="10">

                  </div>

               </div>

               <button class="ui fluid large teal submit button" id="register_btn">ȸ������</button>

            </div>



            <div class="ui error message"></div>



         </div>



         <div class="ui message">

            �α��� �� ������ �ִٸ� <a href="/login/login">����</a>�� �����ּ���.

         </div>

      </div>

   </div>

   <!-- js �������� -->

   <script src="/resources/js/jquery3.3.1.min.js"></script>

   <script src="/resources/js/semantic.min.js"></script>

   <script>

      $(document)

            .ready(

                  function() {

                     $("#register_btn")

                           .click(

                                 function() {

                                    var json = {

                                       c_id : $("#c_id").val(),

                                       c_pw : $("#c_pw").val(),

                                       c_name : $("#c_name").val(),

                                       c_tel : $("#c_tel").val(),

                                       

                                       c_sex : $("#c_sex").val(),

                                       c_birth : $("#c_birth").val()

                                       

                                    };

                                    

                                    for ( var str in json) {

                                       if (json[str].length == 0) {

                                          alert($("#" + str)

                                                .attr(

                                                      "placeholder")

                                                + " ������ �Է����ּ���.");

                                          $("#" + str).focus();

                                          return false;

                                       }

                                    }

                                    if($("#c_pw").val() == $("#c_pw2").val()){

                                    $.ajax({

                                             type : "post",

                                             url : "/insertCustomer",

                                             data : json,

                                             success : function(

                                                   data) {

                                                switch (Number(data)) {

                                                case 0:

                                                   alert("���������� ȸ������ �Ǿ����ϴ�.");

                                                   window.location.href = "/login/login";

                                                   break;

                                                case 1:

                                                   alert("���̵� �ߺ� �Ǿ����ϴ�.");

                                                   

                                                   break;

                                             

                                                default:

                                                   alert("�˼����� ������ �߻� �߽��ϴ�. [Error Code :"

                                                         + Number(data)

                                                         + "]");

                                                   break;

                                                }

                                             },

                                             error : function(

                                                   error) {

                                                alert("���� �߻�"

                                                      + error);

                                             }

                                          });

                                    }

                                    else{

                                       alert('��й�ȣ �� ��ġ���� �ʽ��ϴ�.');

                                    }

                                 });

                  });

   </script>

</body>