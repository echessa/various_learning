React.createElement('div', {className: 'ui items'},
  'Hello, friend! I am a basic React component.'
)


<div className='ui items'>
  Hello, friend! I am a basic React component.
</div>


React.createElement('div', {className: 'ui items'},
React.createElement('p', null, 'Hello, friend! I am a basic React component.')
)



<div className='ui items'>
  <p>
    Hello, friend! I am a basic React component.
  </p>
</div>


ReactDOM.render([what], [where]);


// Using Props

// When the up-vote button on each one of the Product components is clicked, 
// we expect it to update the votes attribute for that Product, increasing it by one.
// But the Product component can’t modify its votes. this.props is immutable.
// While the child can read its props, it can’t modify them. A child does not own its props.
// In our app, the parent component ProductList owns the props given to Product. 
// React favors the idea of one-way data flow. This means that data changes come from the “top” of 
// the app and are propagated “downwards” through its various components.


// Handling Click UpVote Event

// 1. Create handleProductUpVote function in ProductList

class ProductList extends React.Component {
  handleProductUpVote(productId) {
    console.log(productId + ' was upvoted.');
}

// 2. Next, we’ll pass this function down as a prop to each Product component. 
// We’ll name the prop onVote:

// Note that we pass prop in ProductList which is the parent to Product

const productComponents = products.map((product) => (
      <Product
			key={'product-' + product.id}
			id={product.id}
			title={product.title} description={product.description} url={product.url}
			votes={product.votes} submitterAvatarUrl={product.submitterAvatarUrl} 
			productImageUrl={product.productImageUrl} 
			onVote={this.handleProductUpVote}
		/> ));

// 3. We can now access this function inside Product via this.props.onVote.
// Let’s write a function inside Product that calls this new prop-function. We’ll name the function
// handleUpVote():

// Inside `Product`
handleUpVote() {
    this.props.onVote(this.props.id);
}


// We invoke the prop-function this.props.onVote with the id of the product.
// Now, we just need to call this function every time the user clicks the caret icon.

// Inside `render` for Product` 
<div className='middle aligned content'>
  <div className='header'>
    <a onClick={this.handleUpVote}>
      <i className='large caret up icon' />
    </a>
    {this.props.votes}
  </div>

// 4. Binding custom component methods

// we want this inside handleUpVote() to reference the component, just like it does inside render()
// For the render() function, React binds this to the component for us.
// React specifies a default set of special API methods. render() is one such method.
// As we’ll see at the end of the chapter, componentDidMount() is another.

// So, any time we define our own custom component methods,
// we have to manually bind this to the component ourselves

class Product extends React.Component {
  constructor(props) {
    super(props);
    this.handleUpVote = this.handleUpVote.bind(this);
}


// constructor() is a special function in a JavaScript class.
// JavaScript invokes constructor() whenever an object is created via a class.
// React invokes constructor() first thing when initializing our component.
// React invokes constructor() with the component’s props.

class MyReactComponent extends React.Component { constructor(props) {
super(props); // always call this first
    // custom method bindings here
this.someFunction = this.someFunction.bind(this); }
}


// 1. User clicks the up-vote icon.
// 2. ReactinvokesProductcomponent’shandleUpVote
// 3. handleUpVote invokes its prop onVote. This function lives inside the parent ProductList and
// logs a message to the console.


// Using State

// Whereas props are immutable and owned by a component’s parent, state is owned by the component. 
// this.state is private to the component and as we’ll see can be updated with this.setState().
// Critically, when the state or props of a component update, the component will re-render itself.
// Every React component is rendered as a function of its this.props and this.state. 
// This rendering is deterministic.
// This means that given a set of props and a set of state, a React component will always render a single way
// Because we are mutating the data for our products (the number of votes), 
// we should consider this data to be stateful.
// ProductList will be the owner of this state. It will then pass this state down as props to Product.
// When adding state to a component, the first thing we do is define what the initial state should look like
// Because constructor() is called when initializing our component,
// it’s the best place to define our initial state
// In React components, state is an object. The shape of our ProductList state object will look like this:


class ProductList extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      products: [],
}; }
  componentDidMount() {
    this.setState({ products: Seed.products });
}

render() {
		const products = this.state.products.sort((a, b) => (
			b.votes - a.votes
		));

// Technically, because we don’t supply ProductList any props, we don’t need to propagate the props argument to super(). 
// But it’s a good habit to get into and helps avoid odd bugs in the future


// This is wrong
// However, this is invalid. The only time we can modify the state in this manner is in constructor().
// For all state modifications after the initial state, React provides components the method this.setState().
// Never modify state outside of this.setState(). 
// This function has important hooks around state modification that we would be bypassing.

class ProductList extends React.Component { // ...
  // Is this valid ?
componentDidMount() { 
	this.state = Seed.products;
}
// ...
}


// Updating state and immutability

// Specifically, we want to increment the votes property on a product when the user votes for it.
// We just discussed that we can only make state modifications using this.setState(). 
// So while a component can update its state, we should treat the this.state object as immutable.
// Part of the reason this is bad practice is because setState() is actually asynchronous.
// There is no guarantee when React will update the state and re-render our component.

// On the surface, it might appear as though we’ve treated this.state as immutable. However, the
// push() method modifies the original array:

console.log(this.state.nums); // [ 1, 2, 3 ] 
this.state.nums.push(4);
console.log(this.state.nums); // [ 1, 2, 3, 4] <-- Uh-oh!

const nextNums = this.state.nums;
nextNums.push(4);
console.log(nextNums);
// [ 1, 2, 3, 4] 
console.log(this.state.nums); //[1,2,3,4] <--Nope!

// Instead, we can use Array’s concat(). concat() creates a new array that contains the elements
// of the array it was called on followed by the elements passed in as arguments.
// With concat(), we can avoid mutating state:

console.log(this.state.nums);
// [ 1, 2, 3 ]
const nextNums = this.state.nums.concat(4);
console.log(nextNums);
// [ 1, 2, 3, 4] 
console.log(this.state.nums);
// [ 1, 2, 3 ] <-- Unmodified!


// Inside `ProductList`
// Invalid handleProductUpVote(productId) {
const products = this.state.products;
 products.forEach((product) => {
	if (product.id === productId) { 
		product.votes = product.votes + 1;
} });
this.setState({ products: products, }); }


// First, we use map() to traverse the products array. Importantly, map() returns a new array as opposed
// to modifying the array this.state.products.

// Next, we check if the current product matches productId.
// If it does, we create a new object, copying over the properties from the original product object.
// We then overwrite the votes property on our new product object.
// We set it to the incremented vote count. We do this using Object’s assign() method
// If the current product is not the one specified by productId, we return it unmodified:

// Inside `ProductList`
  handleProductUpVote(productId) {
    const nextProducts = this.state.products.map((product) => {
      if (product.id === productId) {
        return Object.assign({}, product, {
          votes: product.votes + 1,
});
} else {
        return product;
      }
    });
    this.setState({
      products: nextProducts,
    });
}

// While we’re creating a new array, the variable product here still references the product object sitting
// on the original array in state. Therefore, if we make changes to it we’ll be modifying the object in state.
// So we use Object.assign() to clone the original into a new object and then modify 
// the votes property on that new object.

// Our custom component method handleProductUpVote() is now referencing this.
// We need to add a bind() call like the one we have for handleUpVote() in Product:

this.handleProductUpVote = this.handleProductUpVote.bind(this);


// Refactoring with the Babel plugin
// transform-class-properties

// Because the community is still adopting this feature,
// we expose you to both class component styles throughout the book.
// We’re able to access this feature using Babel’s library of plugins and presets.

// Refactoring Product

// Inside Product, we defined the custom component method handleUpVote.
// As we discussed, because handleUpVote is not part of the standard React component API,
// React does not bind this inside the method to our component.
// So we had to perform a manual binding trick inside constructor:

class Product extends React.Component { constructor(props) {
    super(props);
    this.handleUpVote = this.handleUpVote.bind(this);
  }
  handleUpVote() {
    this.props.onVote(this.props.id);
} render() {

// With the transform-class-properties plugin, we can write handleUpVote as an arrow function.
// This will ensure this inside the function is bound to the component, as expected:

class Product extends React.Component {
  handleUpVote = () => (
    this.props.onVote(this.props.id)
);

// Using this feature, we can drop constructor(). There is no need for the manual binding call.
// Note that methods that are part of the standard React API, like render(),
// will remain as class methods. If we write a custom component 
// method in which we want this bound to the component, we write it as an arrow function.	

// Refactoring ProductList

class ProductList extends React.Component { 
	constructor(props) {
		super(props);
		this.state = { products: [],};
		this.handleProductUpVote = this.handleProductUpVote.bind(this); 
}

// We can give the same treatment to handleProductUpVote inside ProductList. In addition, property
// initializers give us an alternative way to define the initial state of a component.
// Before, we used constructor() in ProductList to both bind handleProductUpVote
// to the compo- nent and define the component’s initial state:

// With property initializers, we no longer need to use constructor.
// Instead, we can define the initial state like this:

// And, if we define handleProductUpVote as an arrow function, this will be bound to the component as desired:

class ProductList extends React.Component {
	state = {
		products: [],
	}
}

// In sum, we can use property initializers to make two refactors to our React components

// 1. We can use arrow functions for custom component methods (and avoid having to bind this)
// 2. We can define the initial state outside of constructor()






