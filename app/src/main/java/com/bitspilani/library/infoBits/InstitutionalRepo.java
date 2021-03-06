package com.bitspilani.library.infoBits;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class InstitutionalRepo extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institutional_repo);
        toolbar = (Toolbar) findViewById(R.id.nav_toolbar2);
        toolbar.setTitle("Institutional Repository");
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    public void onClickDSpace(View view) {
//        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://dspace.bits-pilani.ac.in:8080/xmlui/"));
        Intent browserIntent = new Intent(this, CustomWebView.class).putExtra("url", "http://dspace.bits-pilani.ac.in:8080/xmlui/").putExtra("title", "DSpace");

//         = new Intent(this, CustomWebView.class).putExtra("url", "");

        //new Intent(homepage.this,LoadBooks.class).putExtra("url","http://172.21.1.37");
        startActivity(browserIntent);

    }

    public void onClickEPrints(View view) {

        Intent browserIntent = new Intent(this, CustomWebView.class).putExtra("url", "http://eprints.bits-pilani.ac.in/").putExtra("title", "Notice").putExtra("title", "ePrints");

        //new Intent(homepage.this,LoadBooks.class).putExtra("url","http://172.21.1.37");
        startActivity(browserIntent);

    }

}