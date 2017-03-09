package is.uncommon.rn.widgets;

import android.view.View;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;
import javax.annotation.Nullable;

/**
 * Created by madhu on 08/03/17.
 */
@ReactModule(name = TabbedViewPagerManager.REACT_CLASS) public class TabbedViewPagerManager
    extends ViewGroupManager<TabbedViewPager> {
  protected static final String REACT_CLASS = "TabbedViewPager";
  public static final int COMMAND_SET_PAGE = 1;
  public static final int COMMAND_SET_PAGE_WITHOUT_ANIMATION = 2;

  public TabbedViewPagerManager() {

  }

  @Override public String getName() {
    return REACT_CLASS;
  }

  @Override protected TabbedViewPager createViewInstance(ThemedReactContext reactContext) {
    TabbedViewPager viewPager = new TabbedViewPager(reactContext);
    viewPager.setup(reactContext);
    return viewPager;
  }

  @Override public void onDropViewInstance(TabbedViewPager view) {
    super.onDropViewInstance(view);
    view.handleViewDropped();
  }

  //tab properties -- start
  @ReactProp(name = "tabMode") public void setTabProperties(TabbedViewPager viewPager,
      String tabMode) {
    viewPager.setTabMode(tabMode);
  }

  @ReactProp(name = "tabGravity")
  public void setTabGravity(TabbedViewPager viewPager, String tabGravity) {
    viewPager.setTabGravity(tabGravity);
  }

  @ReactProp(name = "tabBackground")
  public void setTabBackground(TabbedViewPager viewPager, int tabBackgroundColor) {
    viewPager.setTabBackgroundColor(tabBackgroundColor);
  }

  @ReactProp(name = "tabIndicatorColor")
  public void setTabIndicatorColor(TabbedViewPager viewPager, int tabIndicatorColor) {
    viewPager.setTabIndicatorColor(tabIndicatorColor);
  }

  @ReactProp(name = "tabSelectedTextColor")
  public void setTabSelectedTextColor(TabbedViewPager viewPager, int tabSelectedTextColor) {
    viewPager.setTabSelectedTextColor(tabSelectedTextColor);
  }

  @ReactProp(name = "tabTextColor")
  public void setTabTextColor(TabbedViewPager viewPager, int tabTextColor) {
    viewPager.setTabTextColor(tabTextColor);
  }

  @ReactProp(name = "tabIndicatorHeight")
  public void setTabIndicatorHeight(TabbedViewPager viewPager, float tabIndicatorHeight) {
    viewPager.setTabIndicatorHeight(PixelUtil.toPixelFromDIP(tabIndicatorHeight));
  }

  @ReactProp(name = "tabElevation")
  public void setTabElevation(TabbedViewPager viewPager, float tabElevation) {
    viewPager.setTabElevation(PixelUtil.toPixelFromDIP(tabElevation));
  }

  @ReactProp(name = "tabNames")
  public void setTabNames(TabbedViewPager viewPager, ReadableArray readableArray) {
    String[] names = new String[readableArray.size()];
    for (int i = 0; i < readableArray.size(); i++) {
      names[i] = readableArray.getString(i);
    }
    viewPager.setTabNames(names);
  }

  //tab properties -- end

  @ReactProp(name = "scrollEnabled", defaultBoolean = true)
  public void setScrollEnabled(TabbedViewPager viewPager, boolean value) {
    viewPager.setScrollEnabled(value);
  }

  @Override public boolean needsCustomLayoutForChildren() {
    return true;
  }

  @Override public Map getExportedCustomDirectEventTypeConstants() {
    return MapBuilder.of(PageScrollEvent.EVENT_NAME,
        MapBuilder.of("registrationName", "onPageScroll"), PageScrollStateChangedEvent.EVENT_NAME,
        MapBuilder.of("registrationName", "onPageScrollStateChanged"), PageSelectedEvent.EVENT_NAME,
        MapBuilder.of("registrationName", "onPageSelected"));
  }

  @Override public Map<String, Integer> getCommandsMap() {
    return MapBuilder.of("setPage", COMMAND_SET_PAGE, "setPageWithoutAnimation",
        COMMAND_SET_PAGE_WITHOUT_ANIMATION);
  }

  @Override public void receiveCommand(TabbedViewPager viewPager, int commandType,
      @Nullable ReadableArray args) {
    Assertions.assertNotNull(viewPager);
    Assertions.assertNotNull(args);
    switch (commandType) {
      case COMMAND_SET_PAGE: {
        viewPager.setCurrentItemFromJs(args.getInt(0), true);
        return;
      }
      case COMMAND_SET_PAGE_WITHOUT_ANIMATION: {
        viewPager.setCurrentItemFromJs(args.getInt(0), false);
        return;
      }
      default:
        throw new IllegalArgumentException(
            String.format("Unsupported command %d received by %s.", commandType,
                getClass().getSimpleName()));
    }
  }

  @Override public void addView(TabbedViewPager parent, View child, int index) {
    parent.addViewToAdapter(child, index);
  }

  @Override public int getChildCount(TabbedViewPager parent) {
    return parent.getViewCountInAdapter();
  }

  @Override public View getChildAt(TabbedViewPager parent, int index) {
    return parent.getViewFromAdapter(index);
  }

  @Override public void removeViewAt(TabbedViewPager parent, int index) {
    parent.removeViewFromAdapter(index);
  }

  @ReactProp(name = "pageMargin", defaultFloat = 0)
  public void setPageMargin(TabbedViewPager pager, float margin) {
    pager.setPageMargin((int) PixelUtil.toPixelFromDIP(margin));
  }
}
