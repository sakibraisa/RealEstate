'use strict';

app.factory('Area', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/real_estate/are/area/:areaId', {areaId: '@areaId'},
        {
            updateArea: {method: 'PUT'}
        }
);
}]);
app.factory('City', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/real_estate/cit/city/:cityId', {cityId: '@cityId'},
        {
            updateCity: {method: 'PUT'}
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
app.factory('Property', ['$resource', function ($resource) {
        return $resource('http://localhost:8080/real_estate/propert/property/:proId', {proId: '@proId'},
        {
            updateProperty: {method: 'PUT'}
        }
        );
    }]);

app.controller('PropertyController', ['$scope', 'Property', 'Area' , 'City' , 'ProType', function ($scope, Property, Area, City, ProType) {
         var ob = this;
        ob.objArray = [];
        ob.objArray2 = [];
        ob.obj = new Property();
        ob.obj2 = new Area();
         ob.obj3 = new City();
          ob.obj4 = new ProType();
        ob.fetchAllObject = function () {
            ob.objArray = Property.query();
            $scope.names= ob.objArray2 = Area.query();
            $scope.name= ob.objArray3 = City.query();
            $scope.nam= ob.objArray4 = ProType.query();
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
            ob.obj = Property.get({proId: id}, function () {
                ob.flag = 'edit';
            });
        };
        ob.updateObjectDetail = function () {
            console.log('Inside update');
            if ($scope.objForm.$valid) {
                ob.obj.$updateProperty(function (object) {
                    console.log(object);
                    ob.updatedId = object.proId;
                    ob.reset();
                    ob.flag = 'updated';
                    ob.fetchAllObject();
                });
            }
        };
        ob.deleteObject = function (id) {
            console.log('Inside delete');
            ob.obj = Property.delete({proId: id}, function () {
                ob.reset();
                ob.flag = 'deleted';
                ob.fetchAllObject();
            });
        };
        ob.reset = function () {
            ob.obj = new Property();
            $scope.objForm.$setPristine();
        };
        ob.cancelUpdate = function (id) {
            ob.obj = new Property();
            ob.flag = '';
            ob.fetchAllObject();
        };
    }]);


