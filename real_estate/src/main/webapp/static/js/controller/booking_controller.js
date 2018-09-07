'use strict';

app.factory('User', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/real_estate/use/user/:userId', {userId: '@userId'},
        {
            updateUser: {method: 'PUT'}
        }
);
}]);
app.factory('ProType', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/real_estate/proTyp/proType/:proTypeId', {proTypeId: '@proTypeId'},
        {
            updateProType: {method: 'PUT'}
        }
);
}]);
app.factory('PaymentMethod', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/real_estate/paymentMetho/paymentMethod/:payMethodId', {payMethodId: '@payMethodId'},
        {
            updatePaymentMethod: {method: 'PUT'}
        }
);
}]);
app.factory('PaymentType', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/real_estate/paymentTyp/paymentType/:payTypeId', {payTypeId: '@payTypeId'},
        {
            updatePaymentType: {method: 'PUT'}
        }
        );


    }]);
app.factory('Booking', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/real_estate/bookin/booking/:bookId', {bookId: '@bookId'},
        {
            updateBooking: {method: 'PUT'}
        }
        );
    }]);

app.controller('BookingController', ['$scope', 'Booking', 'User' , 'ProType' , 'PaymentMethod', 'PaymentType', function ($scope, Booking, User, ProType, PaymentMethod, PaymentType) {
         var ob = this;
        ob.objArray = [];
        ob.objArray2 = [];
        ob.obj = new Booking();
        ob.obj2 = new User();
         ob.obj3 = new ProType();
          ob.obj4 = new PaymentMethod();
           ob.obj5 = new PaymentType();
        ob.fetchAllObject = function () {
            ob.objArray = Booking.query();
            $scope.names= ob.objArray2 = User.query();
            $scope.name= ob.objArray3 = ProType.query();
            $scope.nam= ob.objArray4 = PaymentMethod.query();
            $scope.na= ob.objArray5 = PaymentType.query();
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
            ob.obj = Booking.get({bookId: id}, function () {
                ob.flag = 'edit';
            });
        };
        ob.updateObjectDetail = function () {
            console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateBooking(function (object) {
                    console.log(object);
                    ob.updatedId = object.bookId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = Booking.delete({bookId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        ob.reset = function () {
            ob.obj = new Booking();
            $scope.objForm.$setPristine();
        };
        ob.cancelUpdate = function (id) {
            ob.obj = new Booking();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]);


