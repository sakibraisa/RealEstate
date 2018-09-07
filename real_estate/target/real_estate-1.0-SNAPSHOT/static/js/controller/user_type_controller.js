'use strict';

app.factory('UserType', ['$resource', function ($resource) {
    return $resource('http://localhost:8080/real_estate/userTyp/userType/:userTypeId', {userTypeId: '@userTypeId'},
	{
		updateUserType: {method: 'PUT'}
	}
    );
}]);

app.controller('UserTypeController', ['$scope', 'UserType', function($scope, UserType) {
    var ob = this;
    ob.objArray=[];
    ob.obj = new UserType(); 
    ob.fetchAllObject = function(){
        ob.objArray = UserType.query();
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
        ob.obj = UserType.get({ userTypeId: id}, function() {
	       ob.flag = 'edit'; 
	    });
    };    
    ob.updateObjectDetail = function(){
	console.log('Inside update');
	if($scope.objForm.$valid) {
    	   ob.obj.$updateUserType(function(object){
    		console.log(object); 
		ob.updatedId = object.userTypeId;
		ob.reset();
		ob.flag = 'updated'; 
    		ob.fetchAllObject();
           });
	}
    };	
    ob.deleteObject = function(id){
	    console.log('Inside delete');
	    ob.obj = UserType.delete({ userTypeId: id}, function() {
		ob.reset();  
		ob.flag = 'deleted';
    		ob.fetchAllObject(); 
	    });
    };		
    ob.reset = function(){
    	ob.obj = new UserType();
        $scope.objForm.$setPristine();
    };	
    ob.cancelUpdate = function(id){
	    ob.obj = new UserType();
	    ob.flag= '';	
   	    ob.fetchAllObject();
    };    
}]); 


