var module = angular.module('reserva', ['ngRoute','controllers'])

module.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/', {
        templateUrl: '',
        controller: ''
      }).
      otherwise({
        redirectTo: '/'
      });
  }]);
