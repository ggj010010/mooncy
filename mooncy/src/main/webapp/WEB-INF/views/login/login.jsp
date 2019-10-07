<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>


<!DOCTYPE html>

<html>

<head>

    <title>�α��� ������</title>

    <!-- css �������� -->

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

 				�α��� ������

            </h2>

            <form class="ui large form">

                <div class="ui stacked segment">

                    <div class="field">

                        <div class="ui left icon input">

                            <input type="text" id="m_id" placeholder="���̵�">

                        </div>

                    </div>

                    <div class="field">

                        <div class="ui left icon input">

                            <input type="password" id="m_pw" placeholder="��й�ȣ">

                        </div>

                    </div>

                    <div class="ui fluid large teal submit button" id = "login_btn">�α���</div>

                </div>



                <div class="ui error message"></div>



            </form>



            <div class="ui message">


            </div>

        </div>

    </div>

    <!-- js �������� -->

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

						alert($("#" + str).attr("placeholder") + "�� �Է����ּ���.");

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

							alert("���̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");

							break;

						case 1:

							window.location.href = "/store/store";

	

						default:

							break;

						}

					},

					error : function(error) {

						alert("���� �߻�"+ error);

					}

				});

			});

		});

    </script>

</body>



</html>