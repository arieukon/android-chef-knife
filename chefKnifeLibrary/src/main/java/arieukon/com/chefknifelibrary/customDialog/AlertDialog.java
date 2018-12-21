package arieukon.com.chefknifelibrary.customDialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import arieukon.com.chefknifelibrary.R;

public class AlertDialog {

    private Context mContext;

    private String title = "";
    private String message = "";
    private String button = "";
    private boolean cancelable = true;
    private int layout = R.layout.dialog_alert;

    private OnDialogDismissListener mDismissListener;

    private Dialog mDialog;

    public AlertDialog(Context context) {
        mContext = context;
    }

    public void setupDialog() {
        mDialog = new Dialog(mContext);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(layout);
        mDialog.setCancelable(cancelable);

        TextView tvTitle = (TextView) mDialog.findViewById(R.id.tv_title);
        TextView tvMessage = (TextView) mDialog.findViewById(R.id.tv_message);
        Button btnPrimary = (Button) mDialog.findViewById(R.id.btn_primary);

        tvTitle.setText(title);
        tvMessage.setText(message);

        if (!button.equals("")) {
            btnPrimary.setText(button);
        }

        if (title.equals("")) {
            tvTitle.setVisibility(View.GONE);
        }

        // if button is clicked, close the custom dialog
        btnPrimary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDismissListener != null) {
                    mDismissListener.onDismiss();
                }
                mDialog.dismiss();
            }
        });

        if (mDialog != null) {
            mDialog.show();
        }
    }

    public void show() {
        setupDialog();
    }

    public void dismiss(){
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }

    public void show(OnDialogDismissListener dismissListener) {
        mDismissListener = dismissListener;
        show();
    }



    //region Setter Getter

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public void setCancelable(boolean cancelable) {
        this.cancelable = cancelable;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public void setmDialog(Dialog mDialog) {
        this.mDialog = mDialog;
    }

    //endregion


    //region Interface

    /**
     * Dialog Dismiss Listener
     */
    public interface OnDialogDismissListener {
        void onDismiss();
    }

    //endregion

}
