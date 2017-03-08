package is.uncommon.rn.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
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
    this.reactViewPager = new ReactViewPager(reactContext);
    this.addView(reactViewPager, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.MATCH_PARENT));
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
}
