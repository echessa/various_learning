var React = require('react');

var GreeterForm = React.createClass({
    onFormSubmit: function(e) {
        e.preventDefault();

        var updates = {};
        var name = this.refs.name.value;
        var message = this.refs.message.value;

        if (typeof name === 'string' && name.length > 0) {
            this.refs.name.value = '';
            updates.name = name;
        }

        if (typeof message === 'string' && message.length > 0) {
            this.refs.message.value = '';
            updates.message = message;
        }

        this.props.onNewData(updates);
    },
    render: function() {
        return (
            <form onSubmit={this.onFormSubmit}>
                <div><input type="text" ref="name" placeholder="Enter name"/></div>
                <div><textarea rows="4" cols="50" ref="message" placeholder="Enter message"></textarea></div>
                <div><input type="submit" value="Submit"/></div>
            </form>
        );
    }
});

module.exports = GreeterForm;
