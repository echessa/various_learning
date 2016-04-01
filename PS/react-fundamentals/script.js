var Hello = React.createClass({
  render: function() {
    return <div>Hello {this.props.name}</div>;
  }
});

ReactDOM.render(
  <Hello name="World" />,
  document.getElementById('container')
);





// var Hello = React.createClass({
//     render: function() {
//         return <div>
//                 <h1>Hello at {this.props.now}</h1>
//                 </div>;
//     }
// });
//
// React.renderedComponent(<Hello now={new Date().toString()} />,
//     document.getElementById('container'));
