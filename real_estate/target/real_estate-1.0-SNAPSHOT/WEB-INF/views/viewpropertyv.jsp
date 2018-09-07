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
                <!--
                <div class="col-sm-2 sidenav content_left">
                                                <p><a href="are/home">Area</a></p>
                                                <p><a href="bookin/home">Booking</a></p>
                                                <p><a href="cit/home">City</a></h3></p>
                                                <p><a href="use/home">User</a></p>
                                                <p><a href="feedbac/home">Feedback</a></p>
                                                <p><a href="inquir/home">Inquiry</a></p>
                                                <p><a href="userv/home">Users Info for Visitor</a></p>
                    <p><a href="area/home">Area View</a></p>
                                                <p><a href="paymentMetho/home">Payment Method</a></p>
                                                <p><a href="paymentTyp/home">Payment Type</a</h3></p>
                                                <p><a href="proTyp/home">Property Type</a></p>
                    <p><a href="propertvie/home"> View Property</a></p>
                                                <p><a href="propert/home">Property</a></p>
                    <p><a href="user/home">Users Info</a></p>
                    <p><a href="useru/home">User Info Update</a></p>
                                                <p><a href="reg/home">Registration</a></p>
                                                <p><a href="addPropert/home">Add New Property</a></p>
                                                <p><a href="userTyp/home">User Type</a></p>
                </div>-->



                <!------------------------------->





                <div class="container col-sm-12">
                    <div class="row content">
                        <!--                            <ui:insert name="content">-->


                        <!----------------------------------------->




                        <div ng-controller="PropertyController as objCtrl">
                            <center>
                                <h1> Property Info </h1>
                                <!--                <form name="objForm" method="POST">
                                                    <table>
                                                        <tr><td colspan="2">
                                                                <div ng-if="objCtrl.flag == 'edit'">
                                                                    <h3> Update Property for ID: {{ objCtrl.obj.proId}} </h3> 
                                                                </div> </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Area</td>
                                                            <td>
                                                                <select ng-model="objCtrl.obj.area" ng-options="x.areaName for x in names">
                                                                </select>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>City</td>
                                                            <td>
                                                                <select ng-model="objCtrl.obj.city" ng-options="x.cityName for x in name">
                                                                </select>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Property Type</td>
                                                            <td>
                                                                <select ng-model="objCtrl.obj.proType" ng-options="x.proType for x in nam">
                                                                </select>
                                                            </td>
                                                        </tr>
                                
                                                        <tr>
                                                            <td>Property Name: </td> <td> <input type="text" name="proName" ng-model="objCtrl.obj.proName" required/> 
                                                                <span ng-show="objForm.proName.$error.required" class="msg-val">Property Name is required.</span> </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Property Address: </td> <td><input type="text" name="proAddress" ng-model="objCtrl.obj.proAddress" required/> 
                                                                <span ng-show="objForm.proAddress.$error.required" class="msg-val">Property Address is required.</span> </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Property Size (sqFt): </td> <td> <input type="text" name="sqFt" ng-model="objCtrl.obj.sqFt" required/> 
                                                                <span ng-show="objForm.sqFt.$error.required" class="msg-val">Property Size is required.</span> </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Price: </td> <td> <input type="text" name="price" ng-model="objCtrl.obj.price" required/> 
                                                                <span ng-show="objForm.price.$error.required" class="msg-val">Price is required.</span> </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Property Status: </td> <td> <input type="text" name="dueDate" ng-model="objCtrl.obj.dueDate" required/> 
                                                                <span ng-show="objForm.dueDate.$error.required" class="msg-val">Property Status is required.</span> </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Property Description: </td> <td><input type="text" name="proDes" ng-model="objCtrl.obj.proDes" required/> 
                                                                <span ng-show="objForm.proDes.$error.required" class="msg-val">Property Description is required.</span> </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Floor No.: </td> <td> <input type="text" name="floor" ng-model="objCtrl.obj.floor" required/> 
                                                                <span ng-show="objForm.floor.$error.required" class="msg-val">Floor No. is required.</span> </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Property Image: </td> <td> <input type="text" name="image" ng-model="objCtrl.obj.image" required/> 
                                                                <span ng-show="objForm.image.$error.required" class="msg-val">Property Image is required.</span> </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Quantity: </td> <td> <input type="text" name="quantity" ng-model="objCtrl.obj.quantity" required/> 
                                                                <span ng-show="objForm.quantity.$error.required" class="msg-val">Quantity is required.</span> </td>
                                                        </tr>
                                                        <tr>
                                                            <td colspan="2"> <span ng-if="objCtrl.flag == 'created'" class="msg-success">Property successfully added.</span>
                                                                <span ng-if="objCtrl.flag == 'failed'" class="msg-val">Property already exists.</span> </td>
                                                        </tr>
                                                        <tr><td colspan="2">
                                                                <div ng-if="objCtrl.flag != 'edit'">
                                                                    <input  type="submit" ng-click="objCtrl.addObject()" value="Add Property"/> 
                                                                    <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                                                                </div>
                                                                <div ng-if="objCtrl.flag == 'edit'">
                                                                    <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update Property"/> 	
                                                                    <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                                                                </div> </td>
                                                        </tr>
                                                        <tr>
                                                            <td colspan="2"> <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Property successfully deleted.</span>
                                                        </tr>
                                
                                
                                
                                
                                                                                <tr>
                                                                                    <td colspan="2">
                                                                                        <span ng-if="objCtrl.flag == 'failed'" class="msg-val">Property already exists.</span> </td>
                                                                                </tr>
                                                                                <tr><td colspan="2">
                                                                                        <div ng-if="objCtrl.flag == 'edit'">
                                                                                            <input  type="submit" ng-click="objCtrl.updateObjectDetail()" value="Update Property"/> 	
                                                                                            <input type="button" ng-click="objCtrl.reset()" value="Reset"/>
                                                                                            <input type="button" ng-click="objCtrl.cancelUpdate()" value="Cancel"/>				   
                                                                                        </div> </td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td colspan="2"> <span ng-if="objCtrl.flag == 'deleted'" class="msg-success">Property successfully deleted.</span>
                                                                                </tr>
                                                    </table>     
                                                </form>-->
                                <table class="table table-striped table-bordered table-hover table-condensed">
                                    <tr align="center">
                                        <!--                        <th>Property ID </th> -->
                                        <th>Area</th> 
                                        <th>City</th> 
                                        <th>Property Type</th>
                                        <th>Property Name</th>
                                        <th>Property Address</th>
                                        <th>Property Size (sqFt)</th>
                                        <th>Price</th>
                                        <th>Property Status</th>
                                        <th>Property Description</th>
                                        <th>Floor No.</th>
                                        <!--                        <th>Property Image</th>-->
                                        <th>Quantity</th></tr>
                                    <tr ng-repeat="row in objCtrl.objArray" align="center">
                                        <!--                        <td><span ng-bind="row.proId"></span></td>-->
                                        <td><span ng-bind="row.area.areaName"></span></td>
                                        <td><span ng-bind="row.city.cityName"></span></td>
                                        <td><span ng-bind="row.proType.proType"></span></td>
                                        <td><span ng-bind="row.proName"></span></td>
                                        <td><span ng-bind="row.proAddress"></span></td>
                                        <td><span ng-bind="row.sqFt"></span></td>
                                        <td><span ng-bind="row.price"></span></td>
                                        <td><span ng-bind="row.proStatus"></span></td>
                                        <td><span ng-bind="row.proDes"></span></td>
                                        <td><span ng-bind="row.floor"></span></td>
                                        <!--                        <td><span ng-bind="row.image"></span></td>-->
                                        <td><span ng-bind="row.quantity"></span></td>
                                        <!--                        <td>
                                                                    <input type="button" ng-click="objCtrl.deleteObject(row.proId)" value="Delete"/>
                                                                    <input type="button" ng-click="objCtrl.editObject(row.proId)" value="Edit"/>
                                                                    <span ng-if="objCtrl.flag == 'updated' && row.proId == objCtrl.updatedId" class="msg-success">Property successfully updated.</span> </td> -->
                                    </tr>
                                </table>
                            </center>
                        </div>
                        <script src="${pageContext.request.contextPath}/static/js/lib/angular.min.js"></script>
                        <script src="${pageContext.request.contextPath}/static/js/lib/angular-resource.min.js"></script>
                        <script src="${pageContext.request.contextPath}/static/js/app.js"></script>
                        <script src="${pageContext.request.contextPath}/static/js/controller/property_controller.js"></script>
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

