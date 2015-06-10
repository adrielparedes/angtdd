var module = angular.module("avianca",[
  'ngRoute'
  ,'toaster'
  ,'avianca.aviones.controllers'
  ,'avianca.aviones.controllers'
  ,'avianca.asientos.controllers'
  ,'avianca.home.controllers'
  ,'avianca.aviones.services'
  ,'avianca.asientos.services'
  ,'avianca.menu.directives'
  ,'avianca.tabla.directives'
  ,'avianca.login.directives'
  ,'avianca.user.directives'
]);


module.config(['$routeProvider',
  function($routeProvider){

    $routeProvider.
      when('/',{
        templateUrl:'home/home.html',
        controller:'HomeController'
      }).
      when('/aviones',{
        templateUrl:'aviones/aviones.html',
        controller:'AvionesController'
      }).
      when('/aviones/:id/asientos',{
        templateUrl:'asientos/asientos.html',
        controller:'AsientosController'
      }).
      otherwise({redirectTo:'/'})





  }]);
