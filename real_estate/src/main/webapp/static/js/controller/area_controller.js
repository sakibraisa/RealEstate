'use strict';

app.factory('City', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/real_estate/cit/city/:cityId', {cityId: '@cityId'},
        {
            updateCity: {method: 'PUT'}
        }
);
}]);

app.factory('Area', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/real_estate/are/area/:areaId', {areaId: '@areaId'},
        {
            updateArea: {method: 'PUT'}
        }
        );
    }]);
app.controller('AreaController', ['$scope', 'Area', 'City' , function ($scope, Area, City) {
         var ob = this;
        ob.objArray = [];
        ob.objArray2 = [];
        ob.obj = new Area();
        ob.obj2 = new City();
        ob.fetchAllObject = function () {
            ob.objArray = Area.query();
            $scope.namm= ob.objArray2 = City.query();
        };
        console.log($scope.names+"hello");
        ob.fetchAllObject();
        ob.addObject = function () {
            console.log('Inside save');
            if ($scope.objForm.$valid) {
                //ob.obj.tspInfo= ob.obj2;
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
            ob.obj = Area.get({areaId: id}, function () {
                ob.flag = 'edit';
            });
        };
        ob.updateObjectDetail = function () {
            console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateArea(function (object) {
                    console.log(object);
                    ob.updatedId = object.areaId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = Area.delete({areaId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        ob.reset = function () {
            ob.obj = new Area();
            $scope.objForm.$setPristine();
        };
        ob.cancelUpdate = function (id) {
            ob.obj = new Area();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]);


