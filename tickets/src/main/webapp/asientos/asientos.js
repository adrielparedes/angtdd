var module =
  angular.module("avianca.asientos.controllers",[]);

  module.controller('AsientosController',
    ['$scope','AsientosService','$routeParams',
    function($scope,AsientosService,$routeParams){

      $scope.refresh = function(){
        $scope.avionId = $routeParams.id;
        var promise = AsientosService.findAll($scope.avionId);
        promise
          .success(function(data,status,header,config){
            console.log(data);
            $scope.asientos = data;
          })
          .error(function(data,status,header,config){
            console.error(data);
          });
      }

      $scope.liberar = function(asientoId){
        AsientosService.liberar($scope.avionId,asientoId).then(function(){
          $scope.refresh();
        });
      }

      $scope.ocupar = function(asientoId){
        AsientosService.ocupar($scope.avionId,asientoId).then(function(){
          $scope.refresh();
        });
      }




    }]);
