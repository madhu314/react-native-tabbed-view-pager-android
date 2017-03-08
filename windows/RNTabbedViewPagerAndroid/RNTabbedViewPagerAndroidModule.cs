using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Com.Reactlibrary.RNTabbedViewPagerAndroid
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNTabbedViewPagerAndroidModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNTabbedViewPagerAndroidModule"/>.
        /// </summary>
        internal RNTabbedViewPagerAndroidModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNTabbedViewPagerAndroid";
            }
        }
    }
}
