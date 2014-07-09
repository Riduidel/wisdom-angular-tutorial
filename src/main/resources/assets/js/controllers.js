var phonecatApp = angular.module('phonecatApp', []);

phonecatApp.controller('PhoneListCtrl', function($scope, $http) {
	$http.get(PHONES_LIST).success(function(data) {
		$scope.phones = data;
	});
	$scope.orderProp = 'age';
});