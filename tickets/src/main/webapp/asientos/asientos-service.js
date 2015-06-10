var module =
  angular.module('avianca.asientos.services',[]);

  module.service('AsientosService',
  ['$http',function($http){

    this.findAll = function(id){
        var asientosUrl=
          'http://localhost:8080/tickets/api/rest/aviones/'+id+'/asientos';
        return $http.get(asientosUrl);
    }

    this.ocupar = function(avionId,asientoId){
      var asientosUrl=
        'http://localhost:8080/tickets/api/rest/aviones/'+avionId+'/asientos/'+asientoId+'/ocupar';
      return $http.post(asientosUrl);
    }

    this.liberar = function(avionId,asientoId){
      var asientosUrl=
        'http://localhost:8080/tickets/api/rest/aviones/'+avionId+'/asientos/'+asientoId+'/liberar';
      return $http.post(asientosUrl);
    }

  }]);
