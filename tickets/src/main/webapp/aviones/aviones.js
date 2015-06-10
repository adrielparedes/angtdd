var module =
  angular.module("avianca.aviones.controllers",[]);

  module.controller('AvionesController',
    ['$scope','AvionesService','toaster',
    function($scope,AvionesService,toaster){

      $scope.refresh = function(){
          var promise = AvionesService.findAll();
          promise
            .success(function(data,status,header,config){
              console.log(data);
              $scope.aviones = data;
              toaster.pop('success', "Éxito!", "Se han encontrado: " +data.length+" aviones",0);
              toaster.pop('error', "Éxito!", "Se han encontrado: " +data.length+" aviones",0);
              toaster.pop('warning', "Éxito!", "Se han encontrado: " +data.length+" aviones",0);
              toaster.pop('info', "Éxito!", "Se han encontrado: " +data.length+" aviones",0);
            })
            .error(function(data,status,header,config){
              console.error(data);
            });
      }

    }]);
