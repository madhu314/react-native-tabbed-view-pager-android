package is.uncommon.rn.widgets;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
//Source: react-native/ReactAndroid/src/main/java/com/facebook/react/views/viewpager/PageScrollEvent.java

/* package */ class PageScrollEvent extends Event<PageScrollEvent> {

  public static final String EVENT_NAME = "topPageScroll";

  private final int mPosition;
  private final float mOffset;

  protected PageScrollEvent(int viewTag, int position, float offset) {
    super(viewTag);
    mPosition = position;

    // folly::toJson default options don't support serialize NaN or Infinite value
    mOffset = (Float.isInfinite(offset) || Float.isNaN(offset))
        ? 0.0f : offset;
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
    eventData.putDouble("offset", mOffset);
    return eventData;
  }
}