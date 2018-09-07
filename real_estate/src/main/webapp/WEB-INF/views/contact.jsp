<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en-US">
    <head>
        <title> Contact Us </title>
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
                <a href="about">About</a>
                <a href="management">Management</a>
                <a href="contact" class="active">Contact Us</a>
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
                            <img src="${pageContext.request.contextPath}/static/img/contact.jpg" alt="" width="100%"/>
                        </div>


                        <div class="container">
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="recent">
                                        <h3>Send us a message</h3>
                                    </div>		
                                    <form role="form">
                                        <div class="form-group">						
                                            <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                                        </div>

                                        <textarea class="form-control" rows="8"></textarea>
                                        <button type="submit" class="btn btn-default">Submit</button>
                                    </form>
                                </div>

                                <div class="col-lg-6">
                                    <div class="recent">
                                        <h3>Get in touch with us</h3>
                                    </div>
                                    <div class="">
                                        <p>We would like to make bigger our contact with you. We welcome you to suggest us ennovative
                                            opinios/advices about us. This will also create a strong bonding between you and the company.</p>
                                        <p>It will be pleasure for us to receive massages from you. 
                                            We really want this necessarily because all on a sudden any kind of creative 
                                            idea may generate a great momentum.</p>

                                        <h4>Address:</h4>ABC Real Estate Ltd.  |  PO Box 23456 <br>
                                        Uttara, Dhaka, Bangladesh<br>
                                        <h4>Telephone:</h4>345 578 59 45 416</br>
                                        <h4>Fax:</h4>123 456 789
                                    </div>										
                                </div>			
                            </div>
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

