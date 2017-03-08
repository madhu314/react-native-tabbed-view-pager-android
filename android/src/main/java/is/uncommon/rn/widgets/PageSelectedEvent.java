package is.uncommon.rn.widgets;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

//Source: react-native/ReactAndroid/src/main/java/com/facebook/react/views/viewpager/PageSelectedEvent.java
/* package */ class PageSelectedEvent extends Event<PageSelectedEvent> {

  public static final String EVENT_NAME = "topPageSelected";

  private final int mPosition;

  protected PageSelectedEvent(int viewTag, int position) {
    super(viewTag);
    mPosition = position;
  }

  @Override
  public String getEventName() {
    return EVENT_NAME;
  }

  @Override
  public void dispatch(RCTEventEmitter rctEventEmitter) {
    rctEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
  }

  private WritableMap serializeEventData() {
    WritableMap eventData = Arguments.createMap();
    eventData.putInt("position", mPosition);
    return eventData;
  }
}
