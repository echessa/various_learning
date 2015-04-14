/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 */
'use strict';

var React = require('react-native');
var {
    AppRegistry,
    TabBarIOS,
    Component
} = React;

var React = require('react-native');
var Welcome = require('./Welcome');
var More = require('./More');

class SimpleTabBar extends Component {

    constructor(props) {
        super(props);
        this.state = {
            selectedTab: 'welcome'
        };
    }

    render() {
    return (
        <TabBarIOS selectedTab={this.state.selectedTab}>
            <TabBarIOS.Item
            selected={this.state.selectedTab === 'welcome'}
            icon={{uri:'featured'}}
            onPress={() => {
                this.setState({
                selectedTab: 'welcome',
                });
            }}>
                <Welcome/>
            </TabBarIOS.Item>
            <TabBarIOS.Item
            selected={this.state.selectedTab === 'more'}
            icon={{uri:'search'}}
            onPress={() => {
                this.setState({
                selectedTab: 'more',
                });
            }}>
                <More/>
            </TabBarIOS.Item>
        </TabBarIOS>
        );
}
}

AppRegistry.registerComponent('SimpleTabBar', () => SimpleTabBar);
