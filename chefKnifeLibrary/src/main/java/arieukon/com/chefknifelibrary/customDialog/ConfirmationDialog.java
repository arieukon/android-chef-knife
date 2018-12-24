package arieukon.com.chefknifelibrary.customDialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import arieukon.com.chefknifelibrary.R;

public class ConfirmationDialog {

    private Context mContext;

    private String title = "";
    private String message = "";
    private String positiveButton = "";
    private String negativeButton = "";
    private boolean cancelable = true;
    private int layout = R.layout.dialog_confirmation_chef_knife;

    private OnButtonClickListener mButtonClickListener;

    private Dialog mDialog;

    public ConfirmationDialog(Context context) {
        mContext = context;
    }

    public void setupDialog() {
        mDialog = new Dialog(mContext);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        mDialog.setContentView(layout);
        mDialog.setCancelable(cancelable);

        TextView tvTitle = (TextView) mDialog.findViewById(R.id.tv_title);
        TextView tvMessage = (TextView) mDialog.findViewById(R.id.tv_message);
        Button btnPositive = (Button) mDialog.findViewById(R.id.btn_positive);
        Button btnNegative = (Button) mDialog.findViewById(R.id.btn_negative);

        if (title.equals("")) {
            tvTitle.setVisibility(View.GONE);
        }

        if (message.equals("")) {
            tvMessage.setVisibility(View.GONE);
        }

        if (!btnPositive.equals("")) {
            btnPositive.setText(positiveButton);
        }

        if (!btnNegative.equals("")) {
            btnNegative.setText(negativeButton);
        }

        tvTitle.setText(title);
        tvMessage.setText(message);

        // if positive button clicked
        btnPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mButtonClickListener != null) {
                    mButtonClickListener.onPositiveClicked();
                }
                mDialog.dismiss();
            }
        });

        // if negative button clicked
        btnNegative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mButtonClickListener != null) {
                    mButtonClickListener.onNegativeClicked();
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

    public void show(OnButtonClickListener buttonClickListener) {
        mButtonClickListener = buttonClickListener;
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

    public String getPositiveButton() {
        return positiveButton;
    }

    public void setPositiveButton(String positiveButton) {
        this.positiveButton = positiveButton;
    }

    public String getNegativeButton() {
        return negativeButton;
    }

    public void setNegativeButton(String negativeButton) {
        this.negativeButton = negativeButton;
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
    public interface OnButtonClickListener {
        void onPositiveClicked();
        void onNegativeClicked();
    }

    //endregion

}
