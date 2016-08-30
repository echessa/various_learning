(function() {
    'use strict';

    var eventsApp = angular.module("eventsApp");

    var EventController = function($scope) {
        $scope.event = {
            name: 'Angular Boot Camp',
            date: '1/1/2013',
            time: '10:30 am',
            location: {
                address: 'Google Headquaters',
                city: 'Mountain View',
                province: 'CA'
            },
            imageUrl: 'img/angularjs-logo.png',
            sessions: [
                {
                    name: 'Directives Matserclass'
                },
                {
                    name: 'Scopes for fun and profit'
                },
                {
                    name: 'Well Behaved Controllers'
                }
            ]
        };
    };

    eventsApp.controller('EventController', EventController);

}());
