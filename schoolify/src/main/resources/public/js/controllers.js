
var xAuthTokenHeaderName = 'x-auth-token';

var schoolifyControllers = angular.module('schoolify.controllers',[])
	.controller('IndexController',function($scope, StudentsService) {

	$scope.students = StudentsService.query();

	$scope.deleteEntry = function(student) {
		newsEntry.$remove(function() {
			$scope.students = StudentsService.query();
		});
	};
	}).controller('EditController',function($scope, $routeParams, $location, StudentsService) {
	
		$scope.student = StudentsService.get({id: $routeParams.id});
	
		$scope.save = function() {
			$scope.student.$save(function() {
				$location.path('/');
			});
		};
	}).controller('CreateController',function($scope, $location, StudentsService) {

		$scope.saveStudent = function() {
			StudentsService.save($scope.newStudent, function() {
				$location.path('/');
			});
		};
	}).controller('LoginController',function($scope, $rootScope, $location, $http, $cookieStore, LoginService) {

		$scope.login = function() {
			LoginService.authenticate($.param({username: $scope.username, password: $scope.password}), function(user) {
				$rootScope.user = user;
				$http.defaults.headers.common[ xAuthTokenHeaderName ] = user.token;
				$cookieStore.put('user', user);
				$location.path("/");
			});
		};
	})

schoolifyControllers.controller("ClazzController",['$scope', 'ClazzService', function($scope, ClazzService){
	$scope.data = {};
	ClazzService.query(function(response){
		$scope.data.clazzList = response;
	})
}]);

