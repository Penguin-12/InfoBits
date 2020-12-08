package com.bitspilani.library.infoBits;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class downloadable_links extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    private String[] values;
    private String[] links;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.downloadable_links);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String reference = bundle.getString("reference");
        toolbar = (Toolbar) findViewById(R.id.toolbar1);
        //setSupportActionBar(toolbar1);
        toolbar.setTitle(reference);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
//                spinner.setVisibility(View.VISIBLE);
            }
        });
//        File profilepic = new File(dir, avatar);
//        try {
//            fileInput = new FileInputStream(profilepic);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        if(fileInput != null){
//            setToolBarAvatar(profilepic);
//        }
        listView = (ListView) findViewById(R.id.listView);
        switch (reference) {
            case "Pearson e-Books":
                values = new String[]{
                        "Biology",
                        "Chemistry",
                        "Computer Science",
                        "Electrical and Electronic Engineering",
                        "Humanities and Social Sciences",
                        "Management"
                };
                links = new String[]{
                        "http://library.bits-pilani.ac.in/pdf/pearson_e-books/Biology.pdf",
                        "http://library.bits-pilani.ac.in/pdf/pearson_e-books/Chemistry.pdf",
                        "http://library.bits-pilani.ac.in/pdf/pearson_e-books/Computer_Science.pdf",
                        "http://library.bits-pilani.ac.in/pdf/pearson_e-books/Electrical_and_Electronic_Engineering.pdf",
                        "http://library.bits-pilani.ac.in/pdf/pearson_e-books/Humanities_and_Social_Sciences.pdf",
                        "http://library.bits-pilani.ac.in/pdf/pearson_e-books/Management.pdf"
                };
                break;
            case "Elsevier e-Books":
                values = new String[]{

                        "Chemical Engineering",
                        "Chemistry",
                        "Mathematics",
                        "Pharmacology, Toxicology and Pharmaceutical Science",
                        "Computer Science and Information Systems"

                };
                links = new String[]{
                        "http://library.bits-pilani.ac.in/pdf/Elsevier_e-books/Chemical_Engineering.pdf",
                        "http://library.bits-pilani.ac.in/pdf/Elsevier_e-books/Chemistry.pdf",
                        "http://library.bits-pilani.ac.in/pdf/Elsevier_e-books/Mathematics.pdf",
                        "http://library.bits-pilani.ac.in/pdf/Elsevier_e-books/Pharmacology.pdf",
                        "http://library.bits-pilani.ac.in/pdf/Elsevier_e-books/CS-IS.pdf"
                };
//                toolbar.setLogo(R.mipmap.science_direct1);
                break;
            case "Question Papers":
                values = new String[] {"CLICK HERE", "iPhone", "WindowsMobile",
                        "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                        "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
                        "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
                        "Android", "iPhone", "WindowsMobile" };

                links = new String[] {"http://www.intechopen.com/books", "iPhone", "WindowsMobile",
                        "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                        "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
                        "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
                        "Android", "iPhone", "WindowsMobile" };

                break;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if(i<values.length){
          //  Uri uri = Uri.parse(links[i]);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(links[i]));
            startActivity(intent);
        }
    }

}
