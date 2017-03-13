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
  View,
  StatusBar,
  ToolbarAndroid
} from 'react-native';
import TabbedViewPager from 'react-native-tabbed-view-pager-android'
export default class Example extends Component {

  constructor() {
    super()
    this.state = {
      tabNames: ['Beverages', 'Breakfast Cereals', 'Confectionary', 'Cooking Medium',
       'Dairy Products', 'Dessert', 'Health Care', 'Herbs', 'Ready To Cook', 'Ready To Eat', 'Snacks', 'Staples']
    }
  }
  render() {
    return (
      <View style={styles.container}>
        <StatusBar backgroundColor={"#006E60"} />
        <ToolbarAndroid style={styles.toolbar} titleColor={'white'} title='TabbedViewPager'/>
        <TabbedViewPager
          tabMode={"scrollable"}
          tabGravity={"center"}
          tabBackground={"#008B7D"}
          tabIndicatorColor={"#FFB90B"}
          tabIndicatorHeight={4}
          tabTextColor={"#ffffffa0"}
          tabSelectedTextColor={"#ffffff"}
          tabElevation={4}
          tabNames={this.state.tabNames}
          style={styles.viewPager}
          initialPage={0}
          onPageSelected={(event) => this.onPageSelected(event.nativeEvent.position)}
          onPageScrollStateChanged={(state) => this.onPageScrollStateChanged(state)}
          onPageScroll={(event) => this.onPageScroll(event.nativeEvent)}>
          {
            this.state.tabNames.map((tabName) => {
              return(
                <View style={styles.pageStyle} key={tabName}>
                  <Text>{tabName}</Text>
                </View>
              )
            })
          }
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
  },
  toolbar: {
    backgroundColor: '#008B7D',
    height: 56,
  },
});

AppRegistry.registerComponent('Example', () => Example);
