'use strict';

app.factory('PaymentMethod', ['$resource', function ($resource) {
    return $resource('http://localhost:8080/real_estate/paymentMetho/paymentMethod/:payMethodId', {payMethodId: '@payMethodId'},
	{
		updatePaymentMethod: {method: 'PUT'}
	}
    );
}]);
//angular.module('myApp.services', ['ngResource']).
//  factory("geoProvider", function($resource) {
//    return {
//      states: $resource('../data/states.json', {}, {
//        query: { method: 'GET', params: {}, isArray: false }
//      }),
//      countries: $resource('../data/countries.json', {}, {
//        query: { method: 'GET', params: {}, isArray: false }
//      })
//    };
//  }); https://stackoverflow.com/questions/17160771/angularjs-a-service-that-serves-multiple-resource-urls-data-sources

app.controller('PaymentMethodController', ['$scope', 'PaymentMethod', function($scope, PaymentMethod) {
    var ob = this;
    ob.objArray=[];
    ob.obj = new PaymentMethod(); 
    ob.fetchAllObject = function(){
        ob.objArray = PaymentMethod.query();
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
        ob.obj = PaymentMethod.get({ payMethodId: id}, function() {
	       ob.flag = 'edit'; 
	    });
    };    
    ob.updateObjectDetail = function(){
	console.log('Inside update');
	if($scope.objForm.$valid) {
    	   ob.obj.$updatePaymentMethod(function(object){
    		console.log(object); 
		ob.updatedId = object.payMethodId;
		ob.reset();
		ob.flag = 'updated'; 
    		ob.fetchAllObject();
           });
	}
    };	
    ob.deleteObject = function(id){
	    console.log('Inside delete');
	    ob.obj = PaymentMethod.delete({ payMethodId: id}, function() {
		ob.reset();  
		ob.flag = 'deleted';
    		ob.fetchAllObject(); 
	    });
    };		
    ob.reset = function(){
    	ob.obj = new PaymentMethod();
        $scope.objForm.$setPristine();
    };	
    ob.cancelUpdate = function(id){
	    ob.obj = new paymentMethod();
	    ob.flag= '';	
   	    ob.fetchAllObject();
    };    
}]); 


