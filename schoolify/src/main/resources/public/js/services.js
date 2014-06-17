	
	
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

services.factory("ClazzService",function($resource) {
	return $resource("/clazz/:id",{});
});