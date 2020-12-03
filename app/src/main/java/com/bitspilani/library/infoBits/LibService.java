package com.bitspilani.library.infoBits;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LibService extends homepage {

    //    DrawerLayout drawerlayout;
//    NavigationView navigationView;
//    MenuItem cat;
    private ProgressBar spinner;
    boolean isStudent = false;
    ConstraintLayout facultyServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lib_service);
        if (login_info.getString("category", "").equals("Student"))
            isStudent = true;
        facultyServices = (ConstraintLayout) findViewById(R.id.facultyServices);
        if (!isStudent)
            facultyServices.setVisibility(View.VISIBLE);
        toolbar = (Toolbar) findViewById(R.id.nav_toolbar);
        drawerlayout = (DrawerLayout) findViewById(R.id.drawer_layout);

//        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner.setVisibility(View.VISIBLE);
                finish();
            }
        });
        spinner = (ProgressBar) findViewById(R.id.progressBarService);
//        navigationView.setNavigationItemSelectedListener(this);
//        navigationView.setItemIconTintList(null);
//        cat = navigationView.getMenu().getItem(0);
//        cat.setChecked(true);

//        View v = findViewById(R.id.libricons);
//        Integer[] icons = new Integer[]{R.id.imgbt_info, R.id.imgbt_news, R.id.imgbt_service4, R.id.imgbt_service5};
//        Integer[] dimens = getDimens();
//        Integer height = (dimens[0] / 2 - getCorrectPixels(48)) / 2, width = (dimens[1] - getCorrectPixels(36 * (icons.length / 2))) / 2;
//        Integer dim = Math.min(height, width);
//        for (int i = 0; i < icons.length; i++) {
//            ImageView img = (ImageView) v.findViewById(icons[i]);
//            img.setMinimumHeight(dim);
//            img.setMinimumWidth(dim);
//        }
//        View navHeader = navigationView.getHeaderView(0);
//        ((TextView) navHeader.findViewById(R.id.brand)).setText(name);
//        ((TextView) navHeader.findViewById(R.id.email)).setText(email);
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

    public void onClickLF(View view) {
        if (user.isEmpty()) {
            LogInToast();
        } else {
            spinner.setVisibility(View.VISIBLE);
            Intent i = new Intent(LibService.this, lfmsAllItems.class);
            startActivity(i);
        }
    }

    public void onClickIBB(View view) {
        if (user.isEmpty()) {
            LogInToast();
        } else {
            spinner.setVisibility(View.VISIBLE);
            Intent i = new Intent(LibService.this, infoBitsBulletin.class);
            startActivity(i);
        }
    }

    public void onClickConnWL(View view) {
        if (user.isEmpty()) {
            LogInToast();
        } else {
            spinner.setVisibility(View.VISIBLE);
            if (isConnected()) {
                Intent i = new Intent(LibService.this, ConnectWithLibrary.class);
                startActivity(i);
            } else {
                spinner.setVisibility(View.INVISIBLE);
                Toast.makeText(this, "You need internet to access this feature", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void onClickDNews(View view) {
        if (user.isEmpty()) {
            LogInToast();
        } else {
            spinner.setVisibility(View.VISIBLE);
            Intent i = new Intent(LibService.this, DailyNews.class);
            startActivity(i);
        }
    }

    public void onClickPeriodical(View view) {
        if (user.isEmpty()) {
            LogInToast();
        } else {
            spinner.setVisibility(View.VISIBLE);
            Intent browserIntent = new Intent(this, CustomWebView.class).putExtra("url", "http://library.bits-pilani.ac.in/search/print_and_online_ejournals.php");
            startActivity(browserIntent);
        }
    }

    public void onClickAskForArticles(View view) {
        if (user.isEmpty()) {
            LogInToast();
        } else {
            spinner.setVisibility(View.VISIBLE);
            Intent browserIntent = new Intent(this, CustomWebView.class).putExtra("url", "http://library.bits-pilani.ac.in/services/articlerequest.php");
            startActivity(browserIntent);
        }
    }

    public void onClickPCS(View view) {
        if (user.isEmpty()) {
            LogInToast();
        } else {
            spinner.setVisibility(View.VISIBLE);
            Intent browserIntent = new Intent(this, CustomWebView.class).putExtra("url", "http://library.bits-pilani.ac.in/services/anti-plagiarism_software.php");
            startActivity(browserIntent);
        }
    }

    public void onClickBAMD(View view) {
        if (user.isEmpty()) {
            LogInToast();
        } else {
            spinner.setVisibility(View.VISIBLE);
            Intent browserIntent = new Intent(this, CustomWebView.class).putExtra("url", "http://library.bits-pilani.ac.in/services/books@mydesk.php");
            startActivity(browserIntent);
        }
    }
}
