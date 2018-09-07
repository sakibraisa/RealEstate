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

app.factory('Feedback', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/real_estate/feedbac/feedback/:feedId', {feedId: '@feedId'},
        {
            updateFeedback: {method: 'PUT'}
        }
        );
    }]);
app.controller('FeedbackController', ['$scope', 'Feedback', 'User' , 'Inquiry', function ($scope, Feedback, User, Inquiry) {
         var ob = this;
        ob.objArray = [];
        ob.objArray2 = [];
        ob.objArray3 = [];
        ob.obj = new Feedback();
        ob.obj2 = new User();
        ob.obj3 = new Inquiry();
        ob.fetchAllObject = function () {
            ob.objArray = Feedback.query();
            $scope.namm1= ob.objArray2 = User.query();
            $scope.namm2= ob.objArray3 = Inquiry.query();
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
            ob.obj = Feedback.get({feedId: id}, function () {
                ob.flag = 'edit';
            });
        };
        ob.updateObjectDetail = function () {
            console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateFeedback(function (object) {
                    console.log(object);
                    ob.updatedId = object.feedId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = Feedback.delete({feedId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        ob.reset = function () {
            ob.obj = new Feedback();
            $scope.objForm.$setPristine();
        };
        ob.cancelUpdate = function (id) {
            ob.obj = new Feedback();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]);


