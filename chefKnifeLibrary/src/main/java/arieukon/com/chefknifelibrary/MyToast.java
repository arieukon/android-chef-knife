package arieukon.com.chefknifelibrary;

import android.content.Context;
import android.widget.Toast;

public class MyToast {

    public static void show(Context context, String message) {
        android.widget.Toast.makeText(context, message, android.widget.Toast.LENGTH_SHORT).show();
    }

    /**
     * @param context
     * @param message
     * @param type = [ MyToast.LENGTH_LONG or  MyToast.LENGTH_SHORT]
     */
    public static void show(Context context, String message, int type) {
        android.widget.Toast.makeText(context, message, type).show();
    }
}