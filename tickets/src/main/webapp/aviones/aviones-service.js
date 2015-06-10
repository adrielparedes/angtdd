var module =
  angular.module('avianca.aviones.services',[]);

  module.service('AvionesService',
  ['$http',function($http){

    this.findAll = function(){
        var avionesUrl=
          'http://localhost:8080/tickets/api/rest/aviones';
        return $http.get(avionesUrl);
    }

  }]);
