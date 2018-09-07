'use strict';

app.factory('PaymentType', ['$resource', function ($resource) {
    return $resource('http://localhost:8080/real_estate/paymentTyp/paymentType/:payTypeId', {payTypeId: '@payTypeId'},
	{
		updatePaymentType: {method: 'PUT'}
	}
    );
}]);

app.controller('PaymentTypeController', ['$scope', 'PaymentType', function($scope, PaymentType) {
    var ob = this;
    ob.objArray=[];
    ob.obj = new PaymentType(); 
    ob.fetchAllObject = function(){
        ob.objArray = PaymentType.query();
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
        ob.obj = PaymentType.get({ payTypeId: id}, function() {
	       ob.flag = 'edit'; 
	    });
    };    
    ob.updateObjectDetail = function(){
	console.log('Inside update');
	if($scope.objForm.$valid) {
    	   ob.obj.$updatePaymentType(function(object){
    		console.log(object); 
		ob.updatedId = object.payTypeId;
		ob.reset();
		ob.flag = 'updated'; 
    		ob.fetchAllObject();
           });
	}
    };	
    ob.deleteObject = function(id){
	    console.log('Inside delete');
	    ob.obj = PaymentType.delete({ payTypeId: id}, function() {
		ob.reset();  
		ob.flag = 'deleted';
    		ob.fetchAllObject(); 
	    });
    };		
    ob.reset = function(){
    	ob.obj = new PaymentType();
        $scope.objForm.$setPristine();
    };	
    ob.cancelUpdate = function(id){
	    ob.obj = new PaymentType();
	    ob.flag= '';	
   	    ob.fetchAllObject();
    };    
}]); 


