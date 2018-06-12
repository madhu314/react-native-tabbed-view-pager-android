package is.uncommon.rn.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.react.bridge.ReactContext;
import android.graphics.Typeface;
import android.widget.TextView;
import android.content.res.AssetManager;
/**
 * Created by madhu on 08/03/17.
 */

public class TabbedViewPager extends LinearLayout {
  private ReactViewPager reactViewPager = null;
  private TabLayout tabLayout = null;
  private String fontName =  null;
  private boolean upperCase = true;
  

  public TabbedViewPager(Context context) {
    super(context);	
  }
  /*Updated by Ashok*/
  @Override
  protected void onLayout(boolean changed, int l, int t, int r, int b) {
	 
		super.onLayout(changed,l,t,r,b);		
		final ViewGroup tabStrip = (ViewGroup)getChildAt(0);
		final int tabCount = tabStrip.getChildCount();
		ViewGroup tabView;
		int tabChildCount;
		View tabViewChild;
		Typeface fontFace = null;
		
				
		for(int i=0; i<tabCount; i++){		
		
        tabView = (ViewGroup)tabStrip.getChildAt(i);
        tabChildCount = tabView.getChildCount();		
		
        for(int j=0; j<tabChildCount; j++){			
           tabViewChild = (((LinearLayout)((LinearLayout)tabView).getChildAt(j)).getChildAt(1));			
            if(tabViewChild instanceof TextView){
			if(this.fontName != null) {				
			if (fontFace == null) {			
                fontFace = Typeface.createFromAsset(getContext().getApplicationContext().getAssets(), "fonts/" + this.fontName); 
			}				
                ((TextView) tabViewChild).setTypeface(fontFace);
					}
		((TextView) tabViewChild).setAllCaps(this.upperCase);
            }
        }
		
		tabView.measure(
        View.MeasureSpec.makeMeasureSpec(tabView.getMeasuredWidth(), View.MeasureSpec.EXACTLY),
        View.MeasureSpec.makeMeasureSpec(tabView.getMeasuredHeight(), View.MeasureSpec.EXACTLY));
		tabView.layout(tabView.getLeft(), tabView.getTop(), tabView.getRight(), tabView.getBottom());
    }	
  }
  
  /*Updated by Ashok*/

  public TabbedViewPager(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public TabbedViewPager(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, R.style.tab_text);
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public TabbedViewPager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, R.style.tab_text);
  }

  void setup(ReactContext reactContext) {
    this.setOrientation(VERTICAL);
    this.reactViewPager = new ReactViewPager(reactContext);
    this.reactViewPager.setParentIdCallback(new ReactViewPager.ParentIdCallback() {
      @Override public int getParentId() {
        return getId();
      }
    });
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

  public void setTabElevation(float elevation) {
    ViewCompat.setElevation(tabLayout, elevation);
  }
  
  public void setFontName(String value) {
    this.fontName = value;
  }
  
  public void setTextUpperCase(boolean value) {
    this.upperCase = value;
  }
  
  
}
