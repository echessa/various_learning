// TODO: bower install --save angular
// TODO: bower install --save ui-router
// TODO: 04_05

angular.module("MailboxApp", ['ui.router'])
.config(function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("/inbox");
    $stateProvider.state("inbox", {
        url: "/inbox",
        templateUrl: "partials/inbox.html",
        controller: function($scope) {
            // console.log("Inbox.")
            $scope.messages = [];
        }
    });
});
