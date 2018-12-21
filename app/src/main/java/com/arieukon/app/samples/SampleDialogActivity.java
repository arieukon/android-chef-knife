package com.arieukon.app.samples;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.arieukon.app.R;

import arieukon.com.chefknifelibrary.MyToast;
import arieukon.com.chefknifelibrary.customDialog.AlertDialog;

public class SampleDialogActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAlert;

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

        btnAlert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id==btnAlert.getId()){
            showAlertDialog();
        }
    }

    private void showAlertDialog() {
        final AlertDialog dialog = new  AlertDialog(SampleDialogActivity.this);
        dialog.setTitle("Hi Broo...");
        dialog.setMessage("Apa kabar ma bro?\n Kalau bisa besok kita ketemu");
        dialog.setButton("[x] Close");
        dialog.setCancelable(true);
        dialog.setLayout(R.layout.dialog_alert);

        //Show dialog without dissmiss listener
        //dialog.show();

        //Show dialog with dissmiss listener
        dialog.show(new AlertDialog.OnDialogDismissListener() {
            @Override
            public void onDismiss() {
                dialog.dismiss();
                MyToast.show(SampleDialogActivity.this, "Wow thanks you so much dude");
            }
        });
    }
}
