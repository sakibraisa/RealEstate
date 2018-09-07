<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en-US">
    <head>
        <title> Property View </title>
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
                <a class="active" href="index">Home</a>
                <a href="about">About</a>
                <a href="management">Management</a>
                <a href="contact">Contact</a>
                <div class="topnav-right">
                    <a href="reg/home">Sign Up</a>
                </div>
            </div>   









            <!---------------------------------------->


            <div class="row content">

                <div class="col-sm-2 sidenav content_left">
<!--                    <p><a href="${pageContext.request.contextPath}/are/home">Area</a></p>-->
                    <p><a href="${pageContext.request.contextPath}/areab/home">View Areas</a></p>
<!--                    <p><a href="${pageContext.request.contextPath}/areav/home">Area-V</a></p>-->
<!--                    <p><a href="${pageContext.request.contextPath}/bookin/home">Booking</a></p>-->
<!--                    <p><a href="${pageContext.request.contextPath}/bookins/home">Booking-S</a></p>-->
                    <p><a href="${pageContext.request.contextPath}/bookinb/home">Bookings Info</a></p>
<!--                    <p><a href="${pageContext.request.contextPath}/cit/home">City</a></h3></p>
                    <p><a href="${pageContext.request.contextPath}/use/home">User</a></p>-->
<!--                    <p><a href="${pageContext.request.contextPath}/feedbac/home">Feedback</a></p>
                    <p><a href="${pageContext.request.contextPath}/feedbacs/home">Feedback-S</a></p>-->
                    <p><a href="${pageContext.request.contextPath}/feedbacb/home">Feedbacks Info</a></p>
<!--                    <p><a href="${pageContext.request.contextPath}/inquir/home">Inquiry</a></p>
                    <p><a href="${pageContext.request.contextPath}/inquirs/home">Inquiry-S</a></p>-->
                    <p><a href="${pageContext.request.contextPath}/inquirb/home">Inquirys Info</a></p>
<!--                    <p><a href="${pageContext.request.contextPath}/userv/home">Users Info for Visitor</a></p>
                    <p><a href="${pageContext.request.contextPath}/propertvie/home"> View Property</a></p>-->
                    <p><a href="${pageContext.request.contextPath}/propertvieb/home"> View Properties</a></p>
<!--                    <p><a href="${pageContext.request.contextPath}/propertviev/home"> View Property-V</a></p>-->
<!--                    <p><a href="${pageContext.request.contextPath}/paymentMetho/home">Payment Method</a></p>
                    <p><a href="${pageContext.request.contextPath}/paymentTyp/home">Payment Type</a</h3></p>
                    <p><a href="${pageContext.request.contextPath}/proTyp/home">Property Type</a></p>-->
<!--                    <p><a href="${pageContext.request.contextPath}/user/home">Users Info</a></p>-->
                    <p><a href="${pageContext.request.contextPath}/userb/home">User Info Update</a></p>
<!--                    <p><a href="${pageContext.request.contextPath}/useru/home">View Users</a></p>-->
<!--                    <p><a href="${pageContext.request.contextPath}/propert/home">Property</a></p>-->
<!--                    <p><a href="${pageContext.request.contextPath}/area/home">Area View</a></p>-->
<!--                    <p><a href="${pageContext.request.contextPath}/addPropert/home">Add New Property</a></p>-->
<!--                    <p><a href="${pageContext.request.contextPath}/userTyp/home">User Type</a></p>-->
                </div>



                <!------------------------------->





                <div class="container col-sm-10">
                    <div class="row content">
                        <!--                            <ui:insert name="content">-->


                        <!----------------------------------------->



                        <div>
                            <marquee>
                                <h2>
                                    Welcome Buyer
                                </h2>
                            </marquee>
                        </div>






                        <div>
                            <img src="${pageContext.request.contextPath}/static/img/buyer.jpg" alt="" width="100%"/>
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