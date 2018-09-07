<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Real Estate</title>
        <meta charset="utf-8">
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
            .row.content {min-height:490px}
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
                <a class="active" href="#home">Home</a>
                <a href="about">About</a>
                <a href="management">Management</a>
                <a href="contact">Contact Us</a>
                <div class="topnav-right">
                    <a href="reg/home">Sign Up</a>
                </div>
            </div>   
















            <!---------------------------------------->





            <div class="content_area">
                <div class="container-fluid text-center">    



                    <!---------------------------------------->    
                    <!---------------------------------------->    


                    <div class="row content">




                        <!---------------------------------------->       



                        <div class="col-sm-3 sidenav content_left">
                            <h4>
                            <p><a href="admin">Admin</a></p>
                            <p><a href="seller">Seller</a></p>
                            <p><a href="buyer">Buyer</a></p>
                            <p><a href="visitor">Visitor</a></p>
                            </h4>
<!--                            <p><a href="${pageContext.request.contextPath}/are/home">Area</a></p>
                    <p><a href="${pageContext.request.contextPath}/areab/home">Area-B</a></p>
                    <p><a href="${pageContext.request.contextPath}/areav/home">Area-V</a></p>
                    <p><a href="${pageContext.request.contextPath}/bookin/home">Booking</a></p>
                    <p><a href="${pageContext.request.contextPath}/bookins/home">Booking-S</a></p>
                    <p><a href="${pageContext.request.contextPath}/bookinb/home">Booking-B</a></p>
                    <p><a href="${pageContext.request.contextPath}/cit/home">City</a></h3></p>
                    <p><a href="${pageContext.request.contextPath}/use/home">User</a></p>
                    <p><a href="${pageContext.request.contextPath}/feedbac/home">Feedback</a></p>
                    <p><a href="${pageContext.request.contextPath}/feedbacs/home">Feedback-S</a></p>
                    <p><a href="${pageContext.request.contextPath}/feedbacb/home">Feedback-B</a></p>
                    <p><a href="${pageContext.request.contextPath}/inquir/home">Inquiry</a></p>
                    <p><a href="${pageContext.request.contextPath}/inquirs/home">Inquiry-S</a></p>
                    <p><a href="${pageContext.request.contextPath}/inquirb/home">Inquiry-B</a></p>
                    <p><a href="${pageContext.request.contextPath}/userv/home">Users Info for Visitor</a></p>
                    <p><a href="${pageContext.request.contextPath}/propertvie/home"> View Property</a></p>
                    <p><a href="${pageContext.request.contextPath}/propertvieb/home"> View Property-B</a></p>
                    <p><a href="${pageContext.request.contextPath}/propertviev/home"> View Property-V</a></p>
                    <p><a href="${pageContext.request.contextPath}/paymentMetho/home">Payment Method</a></p>
                    <p><a href="${pageContext.request.contextPath}/paymentTyp/home">Payment Type</a</h3></p>
                    <p><a href="${pageContext.request.contextPath}/proTyp/home">Property Type</a></p>
                    <p><a href="${pageContext.request.contextPath}/user/home">Users Info</a></p>
                    <p><a href="${pageContext.request.contextPath}/userb/home">Users Info-B</a></p>
                    <p><a href="${pageContext.request.contextPath}/useru/home">User Info Update</a></p>
                    <p><a href="${pageContext.request.contextPath}/propert/home">Property</a></p>
                    <p><a href="${pageContext.request.contextPath}/area/home">Area View</a></p>
                    <p><a href="${pageContext.request.contextPath}/addPropert/home">Add New Property</a></p>
                    <p><a href="${pageContext.request.contextPath}/userTyp/home">User Type</a></p>-->
                        </div>





                        <!----------------------------------------> 




                        <div class="container col-sm-6">
                            <!--                            <div class="row content">-->
                            <h2>Welcome</h2>  
                            <div id="myCarousel" class="carousel slide" data-ride="carousel">
                                <!-- Indicators -->
                                <ol class="carousel-indicators">
                                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                                    <li data-target="#myCarousel" data-slide-to="1"></li>
                                    <li data-target="#myCarousel" data-slide-to="2"></li>
                                    <li data-target="#myCarousel" data-slide-to="3"></li>
                                </ol>

                                <!-- Wrapper for slides -->
                                <div class="carousel-inner">
                                    <div class="item active">
                                        <img src="${pageContext.request.contextPath}/static/img/1.jpg" alt="">
                                    </div>

                                    <div class="item">
                                        <img src="${pageContext.request.contextPath}/static/img/2.jpg" alt="">
                                    </div>

                                    <div class="item">
                                        <img src="${pageContext.request.contextPath}/static/img/3.jpg" alt="">
                                    </div>
                                    <div class="item">
                                        <img src="${pageContext.request.contextPath}/static/img/4.jpg" alt="">
                                    </div>
                                </div>

                                <!-- Left and right controls -->
                                <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                                    <span class="glyphicon glyphicon-chevron-left"></span>
                                    <span class="sr-only">Previous</span>
                                </a>
                                <a class="right carousel-control" href="#myCarousel" data-slide="next">
                                    <span class="glyphicon glyphicon-chevron-right"></span>
                                    <span class="sr-only">Next</span>
                                </a>
                            </div>
                            <!--                            </div>-->

                            <div>
                                <h4>Urban housing has taken a very metropolitan look in Bangladesh during last two decades. We stand out with an edge of experience of over 5 years.
                                    On principle, We believe in quality, not quantity. Selective operation backed up by a strong foundation & earnest commitment to always offer only the very best to its valued clientele.
                                    For an honest relationship, You're most Welcome!</h4>
                            </div>
                            <!--                            </div>-->
                        </div>




                        <!---------------------------------------->                 




                        <div class="col-sm-3 sidenav content_right">
                            <!--                            <div class="row content">-->
                            <div class="well">
                                <form action="/action_page.php" method="get">
                                    <center>
                                        <div>
                                            <table border="1" cellpadding="5" cellspacing="2">
                                                <thead>
                                                    <tr align="center">
                                                        <th colspan="2">Login Here</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>User Name</td>
                                                        <td><input type="text" name="username" required/></td>
                                                    </tr>
                                                    <tr>
                                                        <td>User Type</td>
                                                        <td><input type="radio" value="Admin" name="userType" ng-model="objCtrl.obj.userType" required/>Admin<br/>
                                                            <input type="radio" value="Seller" name="userType" ng-model="objCtrl.obj.userType" required/>Seller<br/>
                                                            <input type="radio" value="Buyer" name="userType" ng-model="objCtrl.obj.userType" required/>Buyer
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Password</td>
                                                        <td><input type="password" name="password" required/></td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="2" align="center"><input type="submit" onclick="return check(this.form)" value="Login" />
                                                            &nbsp;&nbsp;
                                                            <input type="reset" value="Reset" />
                                                        </td>                        
                                                    </tr>                    
                                                </tbody>
                                            </table>
                                        </div>
                                    </center>
                                </form>
                                <script language="javascript">
                                    function check(form)
                                    {

                                        if (form.userType.value == "Admin" && form.pwd.value == "")
                                        {
                                            return "admin";
                                        } else if (form.userType.value == "Buyer" && form.pwd.value == "")
                                        {
                                            return "buyer";
                                        } else
                                            (form.userType.value == "Seller" && form.pwd.value == "")
                                        {
                                            return "seller";
                                        }
                                        {
                                            alert("Error Password or Username")
                                            return false;
                                        }
                                    }
                                </script>
                            </div>
                            <!--                            </div>-->
                        </div>



                        <!----------------------------------------> 






                    </div>




                    <!---------------------------------------->                 
                    <!---------------------------------------->               





                    <div class="footer">
                        <footer class="container-fluid text-center">
                            <p>@copyright: ABC ESTATE LTD.</p>
                        </footer>
                    </div>
                </div>
                </body>
                </html>

