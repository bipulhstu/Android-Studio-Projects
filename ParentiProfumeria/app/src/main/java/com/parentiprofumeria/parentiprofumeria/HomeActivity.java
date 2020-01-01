package com.parentiprofumeria.parentiprofumeria;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import static maes.tech.intentanim.CustomIntent.customType;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    private WebView webView;
    BottomNavigationView bottomNavigationView;
    SwipeRefreshLayout mySwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);



        drawerLayout = (DrawerLayout) findViewById(R.id.drawerId);
        navigationView = (NavigationView) findViewById(R.id.navigationId);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);

        /*toggle =new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationId);
        bottomNavigationView.setItemIconTintList(null);




        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.aboutUsBottomMenuId:
                        menuItem.setChecked(true);
                        startActivity(new Intent(HomeActivity.this, AboutUsActivity.class));
                        customType(HomeActivity.this,"left-to-right");
                        break;

                    case R.id.contactUsButtomMenuId:
                        menuItem.setChecked(true);
                        startActivity(new Intent(HomeActivity.this, ContactUsActivity.class));
                        customType(HomeActivity.this,"left-to-right");
                        break;
                    case R.id.notificationBottomMenuId:
                        menuItem.setChecked(true);
                        startActivity(new Intent(HomeActivity.this, NotificationActivity.class));
                        customType(HomeActivity.this,"left-to-right");
                        break;
                }
                return false;
            }
        });


        //make all menu item deselect
        //bottomNavigationView.getMenu().setGroupCheckable(0, true, true);



        webView = (WebView) findViewById(R.id.webViewId);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.parentiprofumeria.com");

        mySwipeRefreshLayout = (SwipeRefreshLayout)this.findViewById(R.id.swipeRefressher);

        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        webView.reload();
                        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
                        // This is important as it forces webview to load from the instead of reloading from cache

                        webView .loadUrl("https://www.parentiprofumeria.com");
                        mySwipeRefreshLayout.setRefreshing(false);

                    }

                }
        );




    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }
        else{
            //super.onBackPressed(); ///here alert dialog
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(HomeActivity.this);
            alertDialogBuilder.setIcon(R.drawable.logo);
            alertDialogBuilder.setTitle(R.string.alert_title_text);
            alertDialogBuilder.setMessage(R.string.alert_message_text);
            alertDialogBuilder.setCancelable(false);

            alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //exit
                    finish();
                }
            });
            alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //cancel
                    dialog.cancel();
                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        if(menuItem.getItemId() == R.id.homeMenuId){
            drawerLayout.closeDrawers();
        }

        if(menuItem.getItemId()==R.id.profumiMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(HomeActivity.this, ProfumiActivity.class));
            customType(HomeActivity.this,"left-to-right");
            finish();

        }
        if(menuItem.getItemId()==R.id.makeupMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(HomeActivity.this, MakeupActivity.class));
            customType(HomeActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.creamMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(HomeActivity.this, CreamActivity.class));
            customType(HomeActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.barbaMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(HomeActivity.this, BarbaActivity.class));
            customType(HomeActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.ambientiMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(HomeActivity.this, AmbientActivity.class));
            customType(HomeActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.newsMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(HomeActivity.this, NewsActivity.class));
            customType(HomeActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.loginMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            customType(HomeActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.registrationMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(HomeActivity.this, RegistrationActivity.class));
            customType(HomeActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.forgetPasswordMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(HomeActivity.this, ForgetPasswordActivity.class));
            customType(HomeActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.shoppingCartMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(HomeActivity.this, ShoppingCartActivity.class));
            customType(HomeActivity.this,"left-to-right");
            finish();
        }



        return true;
    }

}

