var React = require('react');
var {Link, IndexLink} = require('react-router');

var Nav = React.createClass({
    render: function() {
        return (
            <div>
                <h2>Nav component</h2>
                <IndexLink to="/" activeClassName="active">Get Weather</IndexLink>
                <Link to="/about" activeClassName="active">About</Link>
                <Link to="/examples" activeClassName="active">Examples</Link>
            </div>
        );
    }
});

module.exports = Nav;
