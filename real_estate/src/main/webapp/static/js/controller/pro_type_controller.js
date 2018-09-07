'use strict';

app.factory('ProType', ['$resource', function ($resource) {
    return $resource('http://localhost:8080/real_estate/proTyp/proType/:proTypeId', {proTypeId: '@proTypeId'},
	{
		updateProType: {method: 'PUT'}
	}
    );
}]);

app.controller('ProTypeController', ['$scope', 'ProType', function($scope, ProType) {
    var ob = this;
    ob.objArray=[];
    ob.obj = new ProType(); 
    ob.fetchAllObject = function(){
        ob.objArray = ProType.query();
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
        ob.obj = ProType.get({ proTypeId: id}, function() {
	       ob.flag = 'edit'; 
	    });
    };    
    ob.updateObjectDetail = function(){
	console.log('Inside update');
	if($scope.objForm.$valid) {
    	   ob.obj.$updateProType(function(object){
    		console.log(object); 
		ob.updatedId = object.proTypeId;
		ob.reset();
		ob.flag = 'updated'; 
    		ob.fetchAllObject();
           });
	}
    };	
    ob.deleteObject = function(id){
	    console.log('Inside delete');
	    ob.obj = ProType.delete({ proTypeId: id}, function() {
		ob.reset();  
		ob.flag = 'deleted';
    		ob.fetchAllObject(); 
	    });
    };		
    ob.reset = function(){
    	ob.obj = new ProType();
        $scope.objForm.$setPristine();
    };	
    ob.cancelUpdate = function(id){
	    ob.obj = new ProType();
	    ob.flag= '';	
   	    ob.fetchAllObject();
    };    
}]); 


