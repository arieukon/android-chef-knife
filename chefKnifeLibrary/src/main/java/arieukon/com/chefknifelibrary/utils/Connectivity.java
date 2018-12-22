package arieukon.com.chefknifelibrary.utils;

import android.content.Context;
import android.net.ConnectivityManager;

import arieukon.com.chefknifelibrary.MyToast;
import arieukon.com.chefknifelibrary.R;
import arieukon.com.chefknifelibrary.customDialog.AlertDialog;


/**
 * Created by macaris on 9/14/16.
 */
public class Connectivity {

    private Context mContext;
    public OnRetryListener mRetryListener;

    private String message = "";
    private int layout = R.layout.dialog_alert_chef_knife;

    public Connectivity(Context context) {
        mContext = context;
    }

    public static boolean isNetworkAvailable(Context context) {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        boolean isConnected = connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
        if (!isConnected) {
            AlertDialog dialog = new AlertDialog(context);
            dialog.setTitle(context.getString(R.string.msg_check_your_internet_connection));
            dialog.setCancelable(false);
            dialog.setLayout(R.layout.dialog_alert_chef_knife);
            dialog.show();
        }
        return isConnected;
    }

    public void checkConnection(OnRetryListener onRetryListener) {
        mRetryListener = onRetryListener;

        final ConnectivityManager connectivityManager = ((ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE));
        boolean isConnected = connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
        if (!isConnected) {
            final AlertDialog dialog = new AlertDialog(mContext);
            dialog.setCancelable(true);
            dialog.setLayout(layout);

            if(message.equals("")){
                dialog.setTitle(mContext.getString(R.string.msg_check_your_internet_connection));
            } else {
                dialog.setTitle(message);
            }

            dialog.show(new AlertDialog.OnDialogDismissListener() {
                @Override
                public void onDismiss() {
                    if (mRetryListener != null) {
                        mRetryListener.onRetry();
                    }
                }
            });
        } else {
            if (mRetryListener != null) {
                mRetryListener.onConnected();
            }
        }
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public interface OnRetryListener {
        void onConnected();
        void onRetry();
    }
}