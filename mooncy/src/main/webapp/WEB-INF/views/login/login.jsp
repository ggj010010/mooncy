<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>


<!DOCTYPE html>

<html>

<head>

    <title>로그인 페이지</title>

    <!-- css 가져오기 -->

    <link rel="stylesheet" type="text/css" href="/resources/js/semantic.min.css">



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

            <h2 class="ui teal image header">

 				로그인 페이지

            </h2>

            <form class="ui large form">

                <div class="ui stacked segment">

                    <div class="field">

                        <div class="ui left icon input">

                            <input type="text" id="m_id" placeholder="아이디">

                        </div>

                    </div>

                    <div class="field">

                        <div class="ui left icon input">

                            <input type="password" id="m_pw" placeholder="비밀번호">

                        </div>

                    </div>

                    <div class="ui fluid large teal submit button" id = "login_btn">로그인</div>

                </div>



                <div class="ui error message"></div>



            </form>



            <div class="ui message">


            </div>

        </div>

    </div>

    <!-- js 가져오기 -->

   <script type="text/javascript" src="http://code.jquery.com/jquery-2.1.4.min.js"></script> 


    <script>

	    $(document).ready(function(){

			$("#login_btn").click(function(){

				var json = {

					m_id : $("#m_id").val(),

					m_pw : $("#m_pw").val()

				};

				

				for(var str in json){

					if(json[str].length == 0){

						alert($("#" + str).attr("placeholder") + "를 입력해주세요.");

						$("#" + str).focus();

						return;

					}

				}

				

				 $.ajax({

					type : "post",

					url : "/login",

					data : json,

					success : function(data) {

						switch (Number(data)) {

						case 0:

							alert("아이디 또는 비밀번호가 일치하지 않습니다.");

							break;

						case 1:

							window.location.href = "/store/store";

	

						default:

							break;

						}

					},

					error : function(error) {

						alert("오류 발생"+ error);

					}

				});

			});

		});

    </script>

</body>



</html>