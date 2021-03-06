package details.hotel.app.fitiam.Customs.CustomFonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by ZingoHotels Tech on 10-12-2018.
 */

public class TextViewSFProDisplaySemibold extends TextView {

    public TextViewSFProDisplaySemibold(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public TextViewSFProDisplaySemibold(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewSFProDisplaySemibold(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/SF-Pro-Display-Semibold.otf");
            setTypeface(tf);
        }
    }
}