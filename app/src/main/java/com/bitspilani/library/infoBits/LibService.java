package com.bitspilani.library.infoBits;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;

public class LibService extends AppCompatActivity {

    //    DrawerLayout drawerlayout;
//    NavigationView navigationView;
//    MenuItem cat;
    private ProgressBar spinner;
    boolean isStudent = false;
    ConstraintLayout facultyServices;
    Toolbar toolbar;
    DrawerLayout drawerlayout;
    SharedPreferences login_info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lib_service);
        spinner = (ProgressBar) findViewById(R.id.progressBarService);

        login_info = getSharedPreferences("login_info", Context.MODE_PRIVATE);

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
//        if (user.isEmpty()) {
//            LogInToast();
//        } else {
        spinner.setVisibility(View.VISIBLE);
        Intent i = new Intent(LibService.this, lfmsAllItems.class);
        startActivity(i);
//        }
    }

    public void onClickIBB(View view) {
//        if (user.isEmpty()) {
//            LogInToast();
//        } else {
        spinner.setVisibility(View.VISIBLE);
        Intent i = new Intent(LibService.this, infoBitsBulletin.class);
        startActivity(i);
//        }
    }

    public void onClickConnWL(View view) {
//        if (user.isEmpty()) {
//            LogInToast();
//        } else {
        spinner.setVisibility(View.VISIBLE);
        if (isConnected()) {
            Intent i = new Intent(LibService.this, ConnectWithLibrary.class);
            startActivity(i);
        } else {
            spinner.setVisibility(View.INVISIBLE);
            Toast.makeText(this, "You need internet to access this feature", Toast.LENGTH_SHORT).show();
//            }
        }
    }

    public void onClickDNews(View view) {
//        if (user.isEmpty()) {
//            LogInToast();
//        } else {
        spinner.setVisibility(View.VISIBLE);
        Intent i = new Intent(LibService.this, DailyNews.class);
        startActivity(i);
//        }
    }

    public void onClickPeriodical(View view) {
//        if (user.isEmpty()) {
//            LogInToast();
//        } else {
        spinner.setVisibility(View.VISIBLE);
        Intent browserIntent = new Intent(this, CustomWebView.class).putExtra("url", "http://library.bits-pilani.ac.in/search/print_and_online_ejournals.php").putExtra("title", "Periodical Finder");
        startActivity(browserIntent);
//        }
    }

    public void onClickAskForArticles(View view) {
//        if (user.isEmpty()) {
//            LogInToast();
//        } else {
        spinner.setVisibility(View.VISIBLE);
        Intent browserIntent = new Intent(this, CustomWebView.class).putExtra("url", "http://library.bits-pilani.ac.in/services/articlerequest.php").putExtra("title", "Ask For Articles");
        startActivity(browserIntent);
//        }
    }

    public void onClickPCS(View view) {
//        if (user.isEmpty()) {
//            LogInToast();
//        } else {
        spinner.setVisibility(View.VISIBLE);
        Intent browserIntent = new Intent(this, CustomWebView.class).putExtra("url", "http://library.bits-pilani.ac.in/services/anti-plagiarism_software.php").putExtra("title", "Anti Plagiarism Software");
        startActivity(browserIntent);
//        }
    }

    public void onClickBAMD(View view) {
//        if (user.isEmpty()) {
//            LogInToast();
//        } else {
        spinner.setVisibility(View.VISIBLE);
        Intent browserIntent = new Intent(this, CustomWebView.class).putExtra("url", "http://library.bits-pilani.ac.in/services/books@mydesk.php").putExtra("title", "Books At My Desk");
        startActivity(browserIntent);
//        }
    }

    public boolean isConnected() {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        } else {
            Toast.makeText(LibService.this, "Not Connected to Internet!", Toast.LENGTH_LONG).show();
            return false;
        }
    }
}
