package com.bitspilani.library.infoBits;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

public class LibRes extends homepage {

    //    DrawerLayout drawerlayout;
//    NavigationView navigationView;
//    MenuItem cat;
    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_resources);
        toolbar = (Toolbar) findViewById(R.id.nav_toolbar);
//        drawerlayout = (DrawerLayout)findViewById(R.id.drawer_layout);
//        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                spinner.setVisibility(View.VISIBLE);
            }
        });
//        navigationView.setNavigationItemSelectedListener(this);
//        navigationView.setItemIconTintList(null);
        spinner = (ProgressBar) findViewById(R.id.progressBarRes);
//        cat = navigationView.getMenu().getItem(0);
//        cat.setChecked(true);
//        View v = findViewById(R.id.libricons);
//        Integer[] icons = new Integer[]{R.id.od, R.id.opac, R.id.eb, R.id.ir};
//        Integer[] dimens = getDimens();
//        Integer height = (dimens[0] / 2 - getCorrectPixels(60)) / 2, width = (dimens[1] - getCorrectPixels(36 * (icons.length / 2))) / 2;
//        Integer dim = Math.min(height, width);
//        for (int i = 0; i < icons.length; i++) {
//            ImageView img = (ImageView) v.findViewById(icons[i]);
//            img.setMinimumHeight(dim);
//            img.setMinimumWidth(dim);
//        }
//        View navHeader = navigationView.getHeaderView(0);
//        ((TextView) navHeader.findViewById(R.id.brand)).setText(name);
//        ((TextView) navHeader.findViewById(R.id.email)).setText(email);
//        File profilepic = new File(dir, avatar);
//        try {
//            fileInput = new FileInputStream(profilepic);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        if(fileInput == null){
//            ((ImageView) navHeader.findViewById(R.id.profile)).setImageResource(R.mipmap.logo);
//        }else{
//            ((ImageView) navHeader.findViewById(R.id.profile)).setImageBitmap(BitmapFactory.decodeStream(fileInput));
//            setToolBarAvatar(profilepic);
//        }
//        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerlayout,toolbar,R.string.drawer_open,R.string.drawer_close);
//        drawerlayout.setDrawerListener(actionBarDrawerToggle);
//        actionBarDrawerToggle.syncState();
    }

    @Override
    protected void onResume() {
        super.onResume();
        spinner.setVisibility(View.INVISIBLE);
    }
//
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        super.onNavigationItemSelected(item);
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return false;
//    }

    public void onClickOD(View view) {
        spinner.setVisibility(View.VISIBLE);
        Intent i = new Intent(LibRes.this, OnlineDb.class);
        startActivity(i);
    }

    public void onClickOPAC(View view) {
        if (user.isEmpty()) {
            LogInToast();
        } else {
            spinner.setVisibility(View.VISIBLE);
            Intent browserIntent = new Intent(this, CustomWebView.class).putExtra("url", "http://libcatalog.bits-pilani.ac.in/");

            //new Intent(homepage.this,LoadBooks.class).putExtra("url","http://172.21.1.37");
            startActivity(browserIntent);
        }
    }

    public void onClickEB(View view) {
        spinner.setVisibility(View.VISIBLE);
        Intent i = new Intent(LibRes.this, ebooks.class);
        startActivity(i);
    }

    public void onClickQP(View view) {
        Intent browserIntent = new Intent(this, CustomWebView.class).putExtra("url", "http://library.bits-pilani.ac.in/Question_Papers/question_paper.php");
        startActivity(browserIntent);
    }

    public void onClickNDL(View view) {
        Intent browserIntent = new Intent(this, CustomWebView.class).putExtra("url", "https://ndl.iitkgp.ac.in/index.php");
        startActivity(browserIntent);
    }

    public void onClickShodhG(View view) {
        Intent browserIntent = new Intent(this, CustomWebView.class).putExtra("url", "https://shodhganga.inflibnet.ac.in");
        startActivity(browserIntent);
    }

    public void onClickRefMT(View view) {
        Intent browserIntent = new Intent(this, CustomWebView.class).putExtra("url", "http://library.bits-pilani.ac.in/services/reference_management_tools.php");
        startActivity(browserIntent);
    }

    public void onClickVLAB(View view) {
        Intent browserIntent = new Intent(this, CustomWebView.class).putExtra("url", "https://www.vlab.co.in/");
        startActivity(browserIntent);
    }

    public void onClickSwayamP(View view) {
        Intent browserIntent = new Intent(this, CustomWebView.class).putExtra("url", "https://www.swayamprabha.gov.in/");
        startActivity(browserIntent);
    }

    public void onClickIR(View view) {
        spinner.setVisibility(View.VISIBLE);
        Intent i = new Intent(this, InstitutionalRepo.class);
        startActivity(i);
    }

    public void onClickDOT(View view) {

    }
}
