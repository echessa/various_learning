import React, { Component } from 'react';
import {
  AppRegistry,
  View,
  StyleSheet
} from 'react-native';

import Header from './src/components/Header';
import AlbumList from './src/components/AlbumList';

export default class albums extends Component {
  render() {
    return (
      <View style={styles.container}>
        <Header headerText="Albums" />
        <AlbumList />
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#FFFFFF',
  }
});

AppRegistry.registerComponent('albums', () => albums);
