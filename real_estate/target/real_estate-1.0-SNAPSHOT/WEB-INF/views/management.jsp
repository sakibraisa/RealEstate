<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en-US">
    <head>
        <title> Management </title>
        <meta charset="UTF-8" content="width=device-width, initial-scale=1"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="<c:url value='/static/js/app.js' />"></script>

        <style>
            body {
                margin: 0;
                font-family: Arial, Helvetica, sans-serif;
            }

            /*            header{
                            background-color: #555;
                            color: white;
                            padding: 15px;
                        }*/
            .topnav {
                overflow: hidden;
                background-color: #333;
            }
            .topnav a {
                float: left;
                color: #f2f2f2;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
                font-size: 17px;
            }
            .topnav a:hover {
                background-color: #ddd;
                color: black;
            }
            .topnav a.active {
                background-color: #4CAF50;
                color: white;
            }
            .topnav-right {
                float: right;
            }
            .navbar {
                margin-bottom: 0;
                border-radius: 0;
            }
            .row.content {min-height: 750px}
            .sidenav {
                padding-top: 20px;
                background-color: #f1f1f1;
                height: 100%;
            }
            footer {
                background-color: #555;
                color: white;
                padding: 15px;
            }
            @media screen and (max-width: 800px) {
                .sidenav {
                    height: auto;
                    padding: 15px;
                }
                .row.content {height:auto;} 
            }
        </style>
    </head>    
    <body ng-app="myApp">
        <div class="container-fluid">
            <div class="header">
                <div class="row">
                    <div>
                        <img src="${pageContext.request.contextPath}/static/img/logo.jpg" alt="" width="100%"/>
                    </div>
                </div>
            </div>



            <!---------------------------------------->








            <div class="topnav">
                <a href="index">Home</a>
                <a href="about">About</a>
                <a href="management" class="active">Management</a>
                <a href="contact">Contact</a>
                <div class="topnav-right">
                    <a href="reg/home">Sign Up</a>
                </div>
            </div>   









            <!---------------------------------------->



            <div class="row content">






                <!------------------------------->





                <div class="container col-sm-12">
                    <div class="row content">





                        <!----------------------------------------->


                        <div>
                            <img src="${pageContext.request.contextPath}/static/img/management.jpg" alt="" width="100%"/>
                        </div>





                        <div>
                            <center>
                                <h4>Arch. Mostaqur Rahman, is the Director of this company, executed a number of prestigious projects before joining ABC.
                                    As Director-in-Charge, he executed various types of projects including Power Plants, High Rise Buildings, Pharmaceutical Factories,
                                    Fertilizer Factories, Bridges, University Campus etc. </h4><br>
                                <h4>Mr. Ghosh is responsible for the execution of all projects undertaken by the company.
                                    In ABC Real Estates Ltd, he supervises land acquisition, finance and overall project management.</h4><br>
                                <h4>Rashed Chowdhury, a successful entrepreneur of  Bangladesh, ABC Building Products Limited.
                                    He has obtained Higher Diploma in Business Studies, UK. and a Post Graduate degree in Management Studies, UK. He oversees business development, finance and organizational policy designs of ABC Real Estates Limited.
                                    Apart from business, Mr. Chowdhury has a keen interest in other essential spheres of life like education and sports.</h4><br>
                                <h4>Sabina Alam is a Director of ABC Real Estates Ltd. She has obtained B.A (Hons) Degree in English Literature from Dhaka University.
                                    She started her professional career in <b>INTERSPEED ADVERTISING</b> as an Executive. In 2004, she joined ABC Real Estate Ltd as a director. Here, she looks after the Administration.
                            </center>
                        </div>






                    </div>
                </div>


                <!----------------------------------------->



            </div>





            <!----------------------------------------->      





            <div class="footer">
                <footer class="container text-center">
                    <p>@copyright: ABC ESTATE LTD.</p>
                </footer>
            </div>


            <!----------------------------------------->


        </div>

        <!----------------------------------------->                  



    </body>
</html>

