package is.uncommon.rn.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.react.bridge.ReactContext;

/**
 * Created by madhu on 08/03/17.
 */

public class TabbedViewPager extends LinearLayout {
  private ReactViewPager reactViewPager = null;
  private TabLayout tabLayout = null;

  public TabbedViewPager(Context context) {
    super(context);
  }

  public TabbedViewPager(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public TabbedViewPager(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public TabbedViewPager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
  }

  void setup(ReactContext reactContext) {
    this.setOrientation(VERTICAL);
    this.reactViewPager = new ReactViewPager(reactContext);
    this.tabLayout = new TabLayout(reactContext);
    this.tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    LayoutParams viewPagerParams =
        new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,
            1);

    LayoutParams tabParams =
        new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    this.addView(tabLayout, tabParams);
    this.addView(reactViewPager, viewPagerParams);
    tabLayout.setupWithViewPager(reactViewPager);
  }

  public void handleViewDropped() {

  }

  public void setScrollEnabled(boolean value) {
    this.reactViewPager.setScrollEnabled(value);
  }

  public void setCurrentItemFromJs(int anInt, boolean b) {
    this.reactViewPager.setCurrentItemFromJs(anInt, b);
  }

  public void addViewToAdapter(View child, int index) {
    this.reactViewPager.addViewToAdapter(child, index);
  }

  public int getViewCountInAdapter() {
    return this.reactViewPager.getViewCountInAdapter();
  }

  public View getViewFromAdapter(int index) {
    return this.reactViewPager.getViewFromAdapter(index);
  }

  public void removeViewFromAdapter(int index) {
    this.reactViewPager.removeViewFromAdapter(index);
  }

  public void setPageMargin(int i) {
    this.reactViewPager.setPageMargin(i);
  }

  public void setTabMode(String tabMode) {
    if ("scrollable".equalsIgnoreCase(tabMode)) {
      tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    } else {
      tabLayout.setTabMode(TabLayout.MODE_FIXED);
    }
  }

  public void setTabGravity(String tabGravity) {
    if ("center".equalsIgnoreCase(tabGravity)) {
      tabLayout.setTabMode(TabLayout.GRAVITY_CENTER);
    } else {
      tabLayout.setTabMode(TabLayout.GRAVITY_FILL);
    }
  }

  public void setTabBackgroundColor(int tabBackgroundColor) {
    tabLayout.setBackgroundColor(tabBackgroundColor);
  }

  public void setTabIndicatorColor(int tabIndicatorColor) {
    tabLayout.setSelectedTabIndicatorColor(tabIndicatorColor);
  }

  public void setTabIndicatorHeight(float height) {
    tabLayout.setSelectedTabIndicatorHeight((int) height);
  }

  public void setTabSelectedTextColor(int tabSelectedTextColor) {
    ColorStateList stateList = tabLayout.getTabTextColors();
    int normalColor = stateList.getColorForState(EMPTY_STATE_SET, tabSelectedTextColor);
    tabLayout.setTabTextColors(normalColor, tabSelectedTextColor);
  }

  public void setTabTextColor(int tabTextColor) {
    ColorStateList stateList = tabLayout.getTabTextColors();
    int selectedColor = stateList.getColorForState(SELECTED_STATE_SET, tabTextColor);
    tabLayout.setTabTextColors(tabTextColor, selectedColor);
  }

  public void setTabNames(String[] names) {
    reactViewPager.setPageNames(names);
  }
}
