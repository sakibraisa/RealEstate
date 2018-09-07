<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en-US">
    <head>
        <title> Inquiry </title>
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
<!--                        <div class="col-sm-2 sidenav content_left">
                            <p><a href="are/home">Area</a></p>
                            <p><a href="bookin/home">Booking</a></p>
                            <p><a href="cit/home">City</a></h3></p>
                            <p><a href="use/home">User</a></p>
                            <p><a href="feedbac/home">Feedback</a></p>
                            <p><a href="inquir/home">Inquiry</a></p>
                                                        <p><a href="userv/home">Users Info for Visitor</a></p>
                                                        <p><a href="propertvie/home"> View Property</a></p>
                            <p><a href="paymentMetho/home">Payment Method</a></p>
                            <p><a href="paymentTyp/home">Payment Type</a</h3></p>
                            <p><a href="proTyp/home">Property Type</a></p>
                                                        <p><a href="user/home">Users Info</a></p>
                                                        <p><a href="useru/home">User Info Update</a></p>
                            <p><a href="propert/home">Property</a></p>
                                                        <p><a href="area/home">Area View</a></p>
                                                        <p><a href="reg/home">Registration</a></p>
                            <p><a href="addPropert/home">Add New Property</a></p>
                            <p><a href="userTyp/home">User Type</a></p>
                        </div>-->



<!------------------------------->





                        <div class="container col-sm-12">
                            <div class="row content">
                                <!--                            <ui:insert name="content">-->


<!----------------------------------------->





                                <div ng-controller="InquiryController as objCtrl">
                                    <center>
                                        <h1> Inquiry Info </h1>
                                        <form name="objForm" method="POST">
                                            <table>
                                                <tr><td colspan="2">
                                                        <div ng-if="objCtrl.flag != 'edit'">
                                                            <h3> Add New Inquiry </h3> 
                                                        </div>
                                                        <div ng-if="objCtrl.flag == 'edit'">
                                                            <h3> Update Inquiry for ID: {{ objCtrl.obj.inqId}} </h3> 
                                                        </div> </td>
                                                </tr>
                                                <tr>
                                                    <td>User</td>
                                                    <td>
                                                        <select ng-model="objCtrl.obj.user" ng-options="x.uname for x in namm2">
                                                        </select>
                                                    </td>
                                                </tr>

                                                <tr>
                                                    <td>Inquiry Name: </td> <td> <input type="text" name="inqName" ng-model="objCtrl.obj.inqName" required/> 
                                                        <span ng-show="objForm.inqName.$error.required" class="msg-val">Inquiry Name is required.</span> </td>
                                                </tr>
                                                <tr>
                                                    <td>Inquiry Title: </td> <td> <input type="text" name="inqTitle" ng-model="objCtrl.obj.inqTitle" required/> 
                                                        <span ng-show="objForm.inqTitle.$error.required" class="msg-val">Inquiry Title is required.</span> </td>
                                                </tr>
                                                <tr>
                                                    <td>Inquiry Description: </td> <td> <input type="text" name="inqDes" ng-model="objCtrl.obj.inqDes" required/> 
                                                        <span ng-show="objForm.inqDes.$error.required" class="msg-val">Inquiry Description is required.</span> </td>
                                                </tr>
                                                <!--                    <tr>
                                                                        <td>Inquiry Contact: </td> <td> <input type="text" name="inqContact" ng-model="objCtrl.obj.inqContact" required/> 
                                                                            <span ng-show="objForm.inqContact.$error.required" class="msg-val">Inquiry Contact is required.</span> </td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td>Inquiry Email: </td> <td> <input type="text" name="inqEmail" ng-model="objCtrl.obj.inqEmail" required/> 
                                                                            <span ng-show="objForm.inqEmail.$error.required" class="msg-val">Inquiry Email is required.</span> </td>
                                                                    </tr>-->
                                                <tr>
                                                    <td>Inquiry Date: </td> <td> <input type="date" name="inqDate" ng-model="objCtrl.obj.inqDate" required/> 
                                                        <span ng-show="objForm.inqDate.$error.required" class="msg-val">Inquiry Date is required.</span> </td>
                                                </tr>


                                                <tr>
                                                    <td colspan="2"> <span ng-if="objCtrl.flag == 'created'" class="msg-success">Inquiry successfully added.</span>
                                                        <span ng-if="objCtrl.flag == 'failed'" class="msg-val">Inquiry already exists.</span> </td>
                                                </tr>
                                                <tr><td colspan="2">
                                                        <div ng-if="objCtrl.flag != 'edit'">
                                                            <input  type="submit" ng-click="objCtrl.addObject()" value="Add Inquiry"/> 
                                                            <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                                                        </div>
                                                        <div ng-if="objCtrl.flag == 'edit'">
                                                            <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update Inquiry"/> 	
                                                            <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                                                        </div> </td>
                                                </tr>
                                                <tr>
                                                    <td colspan="2"> <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Inquiry successfully deleted.</span>
                                                </tr>
                                            </table>     
                                        </form>
<!--                                        <table class="table table-striped table-bordered table-hover table-condensed">
                                            <tr align="center"><th>Inquiry ID </th> 
                                                <th>User</th> 
                                                <th>Inquiry Name</th>
                                                <th>Inquiry Title</th>
                                                <th>Inquiry Description</th>
                                                                    <th>Inquiry Contact</th>
                                                                    <th>Inquiry Email</th>
                                                <th>Inquiry Date</th></tr>
                                            <tr ng-repeat="row in objCtrl.objArray" align="center">
                                                <td><span ng-bind="row.inqId"></span></td>
                                                <td><span ng-bind="row.user.uname"></span></td>
                                                <td><span ng-bind="row.inqName"></span></td>
                                                <td><span ng-bind="row.inqTitle"></span></td>
                                                <td><span ng-bind="row.inqDes"></span></td>
                                                                    <td><span ng-bind="row.inqContact"></span></td>
                                                                    <td><span ng-bind="row.inqEmail"></span></td>
                                                <td><span ng-bind="row.inqDate"></span></td>
                                                <td>
                                                    <input type="button" ng-click="objCtrl.deleteObject(row.inqId)" value="Delete"/>
                                                    <input type="button" ng-click="objCtrl.editObject(row.inqId)" value="Edit"/>
                                                    <span ng-if="objCtrl.flag == 'updated' && row.inqId == objCtrl.updatedId" class="msg-success">Inquiry successfully updated.</span> </td> 
                                            </tr>
                                        </table>-->
                                    </center>
                                </div>
                                <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
                                <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
                                <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
                                <script src="${pageContext.request.contextPath}/static/js/controller/inquiry_controller.js"></script>
                                <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/style.css"/>

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

