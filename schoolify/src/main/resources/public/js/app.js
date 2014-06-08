
var xAuthTokenHeaderName = 'x-auth-token';

angular.module('schoolify', ['ngRoute', 'ngCookies', 'schoolify.services'])
	.config(
		[ '$routeProvider', '$locationProvider', '$httpProvider', function($routeProvider, $locationProvider, $httpProvider) {

			$routeProvider.when('/create', {
				templateUrl: 'partials/create.html',
				controller: CreateController
			});

			$routeProvider.when('/edit/:id', {
				templateUrl: 'partials/edit.html',
				controller: EditController
			});

			$routeProvider.when('/login', {
				templateUrl: 'partials/login.html',
				controller: LoginController
			});

			$routeProvider.otherwise({
				templateUrl: 'partials/index.html',
				controller: IndexController
			});

			$locationProvider.hashPrefix('!');

			/* Intercept http errors */
			var interceptor = function ($rootScope, $q, $location) {

		        function success(response) {
		            return response;
		        }

		        function error(response) {

		            var status = response.status;
		            var config = response.config;
		            var method = config.method;
		            var url = config.url;

		            if (status == 401) {
		            	$location.path( "/login" );
		            } else {
		            	$rootScope.error = method + " on " + url + " failed with status " + status;
		            }

		            return $q.reject(response);
		        }

		        return function (promise) {
		            return promise.then(success, error);
		        };
		    };
		    $httpProvider.responseInterceptors.push(interceptor);

		} ]

	).run(function($rootScope, $http, $location, $cookieStore, LoginService) {

		/* Reset error when a new view is loaded */
		$rootScope.$on('$viewContentLoaded', function() {
			delete $rootScope.error;
		});

		$rootScope.hasRole = function(role) {

			if ($rootScope.user === undefined) {
				return false;
			}

			if ($rootScope.user.roles[role] === undefined) {
				return false;
			}

			return $rootScope.user.roles[role];
		};



		$rootScope.logout = function() {
			delete $rootScope.user;
			delete $http.defaults.headers.common[xAuthTokenHeaderName];
			$cookieStore.remove('user');
			$location.path("/login");
		};

		 /* Try getting valid user from cookie or go to login page */
		var originalPath = $location.path();
		$location.path("/login");
		var user = $cookieStore.get('user');
		if (user !== undefined) {
			$rootScope.user = user;
			$http.defaults.headers.common[xAuthTokenHeaderName] = user.token;

			$location.path(originalPath);
		}

	});


function IndexController($scope, NewsService) {

	$scope.students = StudentsService.query();

	$scope.deleteEntry = function(student) {
		newsEntry.$remove(function() {
			$scope.students = NewsService.query();
		});
	};
}


function EditController($scope, $routeParams, $location, NewsService) {

	$scope.student = StudentsService.get({id: $routeParams.id});

	$scope.save = function() {
		$scope.student.$save(function() {
			$location.path('/');
		});
	};
}


function CreateController($scope, $location, NewsService) {

	$scope.newsEntry = new StudentsService();

	$scope.save = function() {
		$scope.newsEntry.$save(function() {
			$location.path('/');
		});
	};
}


function LoginController($scope, $rootScope, $location, $http, $cookieStore, LoginService) {

	$scope.login = function() {
		LoginService.authenticate($.param({username: $scope.username, password: $scope.password}), function(user) {
			$rootScope.user = user;
			$http.defaults.headers.common[ xAuthTokenHeaderName ] = user.token;
			$cookieStore.put('user', user);
			$location.path("/");
		});
	};
}


var services = angular.module('schoolify.services', ['ngResource']);

services.factory('LoginService', function($resource) {

	return $resource(':action', {},
			{
				authenticate: {
					method: 'POST',
					params: {'action' : 'authenticate'},
					headers : {'Content-Type': 'application/x-www-form-urlencoded'}
				}
			}
		);
});

services.factory('StudentsService', function($resource) {

	return $resource('students/:id', {id: '@id'});
});