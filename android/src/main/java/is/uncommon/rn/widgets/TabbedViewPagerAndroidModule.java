package is.uncommon.rn.widgets;

import android.widget.Toast;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class TabbedViewPagerAndroidModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public TabbedViewPagerAndroidModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override public String getName() {
    return "TabbedViewPagerAndroid";
  }

  @ReactMethod public void sayHello() {
    Toast.makeText(reactContext, "Hey there", Toast.LENGTH_SHORT).show();
  }
}