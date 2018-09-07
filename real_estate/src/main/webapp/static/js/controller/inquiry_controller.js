'use strict';

app.factory('User', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/real_estate/use/user/:userId', {userId: '@userId'},
        {
            updateUser: {method: 'PUT'}
        }
);
}]);

app.factory('Inquiry', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/real_estate/inquir/inquiry/:inqId', {inqId: '@inqId'},
        {
            updateInquiry: {method: 'PUT'}
        }
        );
    }]);
app.controller('InquiryController', ['$scope', 'Inquiry', 'User' , function ($scope, Inquiry, User) {
         var ob = this;
        ob.objArray = [];
        ob.objArray2 = [];
        ob.obj = new Inquiry();
        ob.obj2 = new User();
        ob.fetchAllObject = function () {
            ob.objArray = Inquiry.query();
            $scope.namm2= ob.objArray2 = User.query();
        };
        console.log($scope.names+"hello");
        ob.fetchAllObject();
        ob.addObject = function () {
            console.log('Inside save');
            if ($scope.objForm.$valid) {
                ob.obj.$save(function (object) {
                    console.log(object);
                    ob.flag = 'created';
                    ob.reset();
                    ob.fetchAllObject();
                },
                        function (err) {
                            console.log(err.status);
                            ob.flag = 'failed';
                        }
                );
            }
        };
        ob.editObject = function (id) {
            console.log('Inside edit');
            ob.obj = Inquiry.get({inqId: id}, function () {
                ob.flag = 'edit';
            });
        };
        ob.updateObjectDetail = function () {
            console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateInquiry(function (object) {
                    console.log(object);
                    ob.updatedId = object.inqId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = Inquiry.delete({inqId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        ob.reset = function () {
            ob.obj = new Inquiry();
            $scope.objForm.$setPristine();
        };
        ob.cancelUpdate = function (id) {
            ob.obj = new inqId();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]);


