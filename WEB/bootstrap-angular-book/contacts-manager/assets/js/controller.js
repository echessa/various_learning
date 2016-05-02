function AppCtrl($scope) {
    $scope.clickHandler = function() {
        $scope.isHidden = !$scope.isHidden;
    };
}
