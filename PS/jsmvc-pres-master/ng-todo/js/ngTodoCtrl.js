ngTodo.controller('NgTodoCtrl', function NgTodoCtrl($scope) {
    $scope.todos = [
        { val: "A list item", completed: false },
        { val: "A new list item", completed: true },
        { val: "Another list item", completed: false },
        { val: "This list item", completed: false },
        { val: "This other list item", completed: true },
        { val: "Another new list item", completed: false }
    ];

    $scope.addNewTask = function() {
        $scope.todos.unshift({ completed: false, val: $scope.newTask });
        $scope.newTask = '';
    };

    $scope.clearCompleted = function() {
        $scope.todos = $scope.todos.filter(function(el, index) {
            return !el.completed;
        });
    };

    $scope.removeTodo = function(index) {
        $scope.todos.splice(index, 1);
    };
});
