/**
 * Created by echessa on 4/21/15.
 */

'use strict';

var React = require('react-native');
var SearchResults = require('./SearchResults');
var {
    StyleSheet,
    View,
    Text,
    Component,
    TextInput,
    TouchableHighlight,
    ActivityIndicatorIOS
    } = React;

var styles = StyleSheet.create({
    container: {
        marginTop: 65,
        padding: 10,
        alignItems: 'center'
    },
    searchInput: {
//        height: 36,
//        padding: 4,
//        flex: 1,
//        fontSize: 18,
//        borderWidth: 1,
//        borderColor: '#48BBEC',
//        borderRadius: 8,
//        color: '#48BBEC',
//        alignSelf: 'stretch',
        height: 36,
        padding: 4,
        margin: 24,
        fontSize: 18,
        borderWidth: 1,
        flex: 1
    },
    button: {
        height: 36,
        flex: 1,
        flexDirection: 'row',
        backgroundColor: '#48BBEC',
        borderColor: '#48BBEC',
        borderWidth: 1,
        borderRadius: 8,
        marginBottom: 10,
        alignSelf: 'stretch',
        justifyContent: 'center'
//        height: 36,
//        backgroundColor: '#48BBEC',
//        borderColor: '#48BBEC',
//        borderWidth: 1,
//        borderRadius: 8,
//        marginBottom: 10,
//        alignSelf: 'stretch',
//        justifyContent: 'center'
    },
    buttonText: {
        fontSize: 18,
        color: 'white',
        alignSelf: 'center'
    }
});

class SearchBooks extends Component {

    constructor(props) {
        super(props);
        this.state = {
            bookAuthor: '',
            bookTitle: '',
            isLoading: false,
            errorMessage: ''
        };
    }


    render() {
    var spinner = this.state.isLoading ?
        ( <ActivityIndicatorIOS
        hidden='true'
        size='large'/> ) :
        ( <View/>);
    return (
        <View style={styles.container}>
            <Text>Search by book title and/or author</Text>
            <View>
                <Text>Book Title:</Text>
                <TextInput style={styles.searchInput} onChange={this.bookTitleInput.bind(this)}/>
            </View>
            <View>
                <Text>Author:</Text>
                <TextInput style={styles.searchInput} onChange={this.bookAuthorInput.bind(this)}/>
            </View>
            <TouchableHighlight style={styles.button}
                underlayColor='#99d9f4'
                onPress={this.searchBooks.bind(this)}>
                <Text style={styles.buttonText}>Search</Text>
            </TouchableHighlight>
            {spinner}
            <Text>{this.state.errorMessage}</Text>
        </View>
        );
}

    bookTitleInput(event) {
        this.setState({ bookTitle: event.nativeEvent.text });
    }

    bookAuthorInput(event) {
        this.setState({ bookAuthor: event.nativeEvent.text });
    }

    searchBooks() {
        this.fetchData();
    }

    fetchData() {

    this.setState({ isLoading: true });

    var baseURL = 'https://www.googleapis.com/books/v1/volumes?q=';
    if (this.state.bookAuthor !== '') {
        baseURL += encodeURIComponent('inauthor:' + this.state.bookAuthor);
    }
    if (this.state.bookTitle !== '') {
        baseURL += (this.state.bookAuthor === '') ? encodeURIComponent('intitle:' + this.state.bookTitle) : encodeURIComponent('+intitle:' + this.state.bookTitle);
    }

    console.log('URL: >>> ' + baseURL);
        fetch(baseURL)
        .then((response) => response.json())
        .then((responseData) => {
        this.setState({ isLoading: false});
            if (responseData.items) {

            this.props.navigator.push({
                title: 'Search Results',
                component: SearchResults,
                passProps: {books: responseData.items}
            });
    } else {
        this.setState({ errorMessage: 'No results found'});
    }
        })
.catch(error =>
this.setState({
    isLoading: false,
    errorMessage: error
}))
        .done();
    }

}

module.exports = SearchBooks;