/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View
} from 'react-native';
import TabbedViewPager from 'react-native-tabbed-view-pager-android'
export default class Example extends Component {
  render() {
    return (
      <View style={styles.container}>
        <TabbedViewPager
          tabMode={"scrollable"}
          tabGravity={"center"}
          tabBackground={"red"}
          tabIndicatorColor={"blue"}
          tabIndicatorHeight={4}
          tabTextColor={"yellow"}
          tabSelectedTextColor={"white"}
          tabElevation={4}
          tabNames={["First", "Second", "Third", "Fourth", "Fifth", "Sixth", "Seventh", "Eighth"]}
          style={styles.viewPager}
          initialPage={0}
          onPageSelected={(event) => this.onPageSelected(event.nativeEvent.position)}
          onPageScrollStateChanged={(state) => this.onPageScrollStateChanged(state)}
          onPageScroll={(event) => this.onPageScroll(event.nativeEvent)}>
          <View style={styles.pageStyle}>
            <Text>First page</Text>
          </View>
          <View style={styles.pageStyle}>
            <Text>Second page</Text>
          </View>
          <View style={styles.pageStyle}>
            <Text>Third Page</Text>
          </View>
          <View style={styles.pageStyle}>
            <Text>Fourth page</Text>
          </View>
          <View style={styles.pageStyle}>
            <Text>Fifth page</Text>
          </View>
          <View style={styles.pageStyle}>
            <Text>Sixth page</Text>
          </View>
          <View style={styles.pageStyle}>
            <Text>Seventh page</Text>
          </View>
          <View style={styles.pageStyle}>
            <Text>Eigth page</Text>
          </View>
        </TabbedViewPager>
      </View>
    );
  }

  onPageSelected(position) {
    console.log("Page position is:" + position)
  }

  onPageScroll(event) {
   console.log("Page scroll event:" + JSON.stringify(event)) 
  }

  onPageScrollStateChanged(state) {
   console.log("Page scroll state change event:" + state)  
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1
  },
  pageStyle: {
    alignItems: 'center',
    padding: 20,
    justifyContent: 'center'
  },
  viewPager: {
    flex: 1,
    backgroundColor: '#F5FCFF',
  }
});

AppRegistry.registerComponent('Example', () => Example);
