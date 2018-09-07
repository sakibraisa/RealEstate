'use strict';

app.factory('City', ['$resource', function ($resource) {
    return $resource('http://localhost:8080/real_estate/cit/city/:cityId', {cityId: '@cityId'},
	{
		updateCity: {method: 'PUT'}
	}
    );
}]);

app.controller('CityController', ['$scope', 'City', function($scope, City) {
    var ob = this;
    ob.objArray=[];
    ob.obj = new City(); 
    ob.fetchAllObject = function(){
        ob.objArray = City.query();
    };
    ob.fetchAllObject();
    ob.addObject = function(){
	console.log('Inside save');
	if($scope.objForm.$valid) {
	  ob.obj.$save(function(object){
	     console.log(object); 
	     ob.flag= 'created';	
	     ob.reset();	
	     ob.fetchAllObject();
	  },
	  function(err){
	     console.log(err.status);
	     ob.flag='failed';
	  }
          );
        }
    }; 
    ob.editObject = function(id){
	    console.log('Inside edit');
        ob.obj = City.get({ cityId: id}, function() {
	       ob.flag = 'edit'; 
	    });
    };    
    ob.updateObjectDetail = function(){
	console.log('Inside update');
	if($scope.objForm.$valid) {
    	   ob.obj.$updateCity(function(object){
    		console.log(object); 
		ob.updatedId = object.cityId;
		ob.reset();
		ob.flag = 'updated'; 
    		ob.fetchAllObject();
           });
	}
    };	
    ob.deleteObject = function(id){
	    console.log('Inside delete');
	    ob.obj = City.delete({ cityId: id}, function() {
		ob.reset();  
		ob.flag = 'deleted';
    		ob.fetchAllObject(); 
	    });
    };		
    ob.reset = function(){
    	ob.obj = new City();
        $scope.objForm.$setPristine();
    };	
    ob.cancelUpdate = function(id){
	    ob.obj = new city();
	    ob.flag= '';	
   	    ob.fetchAllObject();
    };    
}]); 


