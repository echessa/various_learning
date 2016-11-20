var React = require('react');
var ReactDOM = require('react-dom');
var Greeter = require('Greeter');

var firstName = 'Joyce';
var message = 'This is from a component';

ReactDOM.render(
    <Greeter name={firstName} message={message}/>,
    document.getElementById('app')
);
