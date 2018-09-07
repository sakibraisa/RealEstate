<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en-US">
    <head>
        <title> About Us </title>
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
    <body>
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
                <a href="#home">Home</a>
                <a href="about" class="active">About</a>
                <a href="management">Management</a>
                <a href="contact">Contact Us</a>
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
                            <center><img src="${pageContext.request.contextPath}/static/img/background.jpg" alt="" width="100%"/></center>
                        </div>

                        <div>
                            <center>
                                <h4>In last 5 years, ABC has done some prestigious projects maintaining
                                    finest standard of construction, immaculate reliability and absolute commitment.
                                    And this have made ABC a trusted name in the construction industry of this country.</h4><br>
                                <h4>ABC Real Estates Limited was established in the year of 2010.
                                    It is an associate company of Associate Builders Corporation Limited (ABC Ltd).</h4><br>
                                <h4>ABC made its mark as one of the front-runners in the process of reconstructing the infrastructure of Bangladesh.
                                    Finest construction standards, attention to details, personalized client service, firm financial footing and the
                                    leadership of an experienced team of professionals are the key factors that has contributed towards ABC’s success and goodwill.</h4><br>
                                <h4>Our group created a perfect harmony of wisdom & new ideas; and the partnership’s standing
                                    the test of time is a testament of the stability of this Corporate House.
                                    Today, the name ABC has become synonymous to quality & reliance.</h4><br>
                                <h4>When you are looking for a partner for your construction needs,
                                    look no further beyond ABC. Because with us, you always win!</h4>
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

