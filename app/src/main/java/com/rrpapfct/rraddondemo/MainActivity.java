package com.rrpapfct.rraddondemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView linkTextView;
    EditText txtId, txtChangelog, txtPublished_at;
    Button sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_Rraddon);
        setContentView(R.layout.activity_main);

        txtId = (EditText) findViewById(R.id.idInp);
        txtChangelog = (EditText) findViewById(R.id.changelogInp);
        txtPublished_at = (EditText) findViewById(R.id.published_atInp);
        sendBtn = (Button) findViewById(R.id.sendBtn);
        linkTextView = findViewById(R.id.txtLink);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
            }
        });
    }

    private void insertData() {
        final String id = txtId.getText().toString().trim();
        final String changelog = txtChangelog.getText().toString();
        final String published_at = txtPublished_at.getText().toString();

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("A publicar Changelog...");

        if(id.isEmpty()) {
            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Insira um ID!", Snackbar.LENGTH_LONG);
            snackbar.setAction("Entendido", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    snackbar.dismiss();
                }
            });
            snackbar.show();
            return;
        }
        else if(changelog.isEmpty()) {
            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Insira uma Changelog!", Snackbar.LENGTH_LONG);
            snackbar.setAction("Entendido", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    snackbar.dismiss();
                }
            });
            snackbar.show();
            return;
        }
        else if(published_at.isEmpty()) {
            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Insira a Data da Changelog!", Snackbar.LENGTH_LONG);
            snackbar.setAction("Entendido", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    snackbar.dismiss();
                }
            });
            snackbar.show();
            return;
        }else{
            Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "Esta é apenas a versão demo da aplicação!", Snackbar.LENGTH_LONG);
            snackbar.setAction("Entendido", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    snackbar.dismiss();
                }
            });
            snackbar.show();
            return;
        }
    }
}