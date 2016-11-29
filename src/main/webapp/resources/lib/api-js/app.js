(function() {
    'use strict';
	var dcs = angular.module('dcsApp', []);
	
	dcs.controller('loginCtr', function ($scope, $http) {
		$scope.authenticate = function() {
			var username = $scope.username;
			var password = $scope.password;
		        $http({
		            method: 'POST',
		            url: 'authenticate',
		            data: 'strUsername='+username+',strPassword='+password,
		            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		         }).success(
		                function(data, status, headers, config) {
		                        alert(data);
		                }).error(function(data, status, headers, config) {
		                                // called asynchronously if an error occurs
		                                // or server returns response with an error status.
		        });
		};
	});
})();
