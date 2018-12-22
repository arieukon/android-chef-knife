package com.arieukon.app.samples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.arieukon.app.R;

import arieukon.com.chefknifelibrary.MyToast;
import arieukon.com.chefknifelibrary.customDialog.AlertDialog;
import arieukon.com.chefknifelibrary.customDialog.ConfirmationDialog;
import arieukon.com.chefknifelibrary.utils.Connectivity;

public class SampleDialogActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAlert;
    private Button btnAlertWithListener;
    private Button btnConfirmation;
    private Button btnConfirmationWithListener;
    private Button btnCheckConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_dialog);

        initView();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnAlert = findViewById(R.id.btn_alert);
        btnAlertWithListener = findViewById(R.id.btn_alert_with_listener);
        btnConfirmation = findViewById(R.id.btn_confirmation);
        btnConfirmationWithListener = findViewById(R.id.btn_confirmation_with_listener);
        btnCheckConnection = findViewById(R.id.btn_check_connection);

        btnAlert.setOnClickListener(this);
        btnAlertWithListener.setOnClickListener(this);
        btnConfirmation.setOnClickListener(this);
        btnConfirmationWithListener.setOnClickListener(this);
        btnCheckConnection.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == btnAlert.getId()) {
            showAlertDialog();
        } else if (id == btnAlertWithListener.getId()) {
            showAlertWithListenerDialog();
        } else if (id == btnConfirmation.getId()) {
            showConfirmationDialog();
        } else if (id == btnConfirmationWithListener.getId()) {
            showConfirmationWithListenerDialog();
        } else if(id==btnCheckConnection.getId()){
            checkInternetConnection();
        }
    }

    private void showAlertDialog() {
        AlertDialog dialog = new AlertDialog(SampleDialogActivity.this);
        dialog.setTitle("Hi Broo...");
        dialog.setMessage("Welcome home");
        dialog.setButton("[x] Close");
        dialog.setCancelable(false);
        dialog.show();
    }

    private void showAlertWithListenerDialog() {
        AlertDialog dialog = new AlertDialog(SampleDialogActivity.this);
        dialog.setTitle("Hi Broo...");
        dialog.setMessage("Welcome home");dialog.setButton("[x] Close");
        dialog.setCancelable(false);
        dialog.setLayout(R.layout.dialog_alert);

        //Show dialog with dissmiss listener
        dialog.show(new AlertDialog.OnDialogDismissListener() {
            @Override
            public void onDismiss() {
                MyToast.show(SampleDialogActivity.this, "Do something here");
            }
        });
    }

    private void showConfirmationDialog() {
        ConfirmationDialog dialog = new ConfirmationDialog(SampleDialogActivity.this);
        dialog.setTitle("Hi Broo...");
        dialog.setMessage("Are you sure?");
        dialog.setPositiveButton("100%");
        dialog.setNegativeButton("No No No");
        dialog.setCancelable(false);
        dialog.show();
    }

    private void showConfirmationWithListenerDialog() {
        ConfirmationDialog dialog = new ConfirmationDialog(SampleDialogActivity.this);
        dialog.setTitle("Hi Broo...");
        dialog.setMessage("Are you sure?");
        dialog.setPositiveButton("100%");
        dialog.setNegativeButton("No No No");
        dialog.setCancelable(false);
        dialog.setLayout(R.layout.dialog_confirmation);

        dialog.show(new ConfirmationDialog.OnButtonClickListener() {
            @Override
            public void onPositiveClicked() {
                MyToast.show(SampleDialogActivity.this, "I say YES");
            }

            @Override
            public void onNegativeClicked() {
                MyToast.show(SampleDialogActivity.this, "I say NO");
            }
        });
    }

    private void checkInternetConnection() {
        Connectivity connectivity = new Connectivity(this);
        connectivity.setMessage("Please check your internet connection!!!");
        connectivity.setLayout(R.layout.dialog_alert);
        connectivity.checkConnection(new Connectivity.OnRetryListener() {
            @Override
            public void onConnected() {
                MyToast.show(SampleDialogActivity.this, "Get data..");
            }

            @Override
            public void onRetry() {
                checkInternetConnection();
            }
        });
    }
}
