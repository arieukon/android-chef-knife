package com.arieukon.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.arieukon.app.samples.SampleDialogActivity;

import arieukon.com.chefknifelibrary.MyToast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        MyToast.show(this, "Welcome home...");
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnDialog = findViewById(R.id.btn_dialog);

        btnDialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id==btnDialog.getId()){
            startActivity(new Intent(this, SampleDialogActivity.class));
        }
    }
}
