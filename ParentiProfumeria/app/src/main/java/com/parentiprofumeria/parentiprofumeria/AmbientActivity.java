package com.parentiprofumeria.parentiprofumeria;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import static maes.tech.intentanim.CustomIntent.customType;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class AmbientActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    private WebView webView;
    BottomNavigationView bottomNavigationView;
    SwipeRefreshLayout mySwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambient);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerId);
        navigationView = (NavigationView) findViewById(R.id.navigationId);

        navigationView.setNavigationItemSelectedListener(this);
        webView = (WebView) findViewById(R.id.webViewId);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationId);
        navigationView.setItemIconTintList(null);
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.aboutUsBottomMenuId:
                        menuItem.setChecked(true);
                        startActivity(new Intent(AmbientActivity.this, AboutUsActivity.class));
                        customType(AmbientActivity.this,"left-to-right");
                        break;

                    case R.id.contactUsButtomMenuId:
                        menuItem.setChecked(true);
                        startActivity(new Intent(AmbientActivity.this, ContactUsActivity.class));
                        customType(AmbientActivity.this,"left-to-right");
                        break;
                    case R.id.notificationBottomMenuId:
                        menuItem.setChecked(true);
                        startActivity(new Intent(AmbientActivity.this, NotificationActivity.class));
                        customType(AmbientActivity.this,"left-to-right");
                        break;
                }
                return false;
            }
        });


        //make all menu item deselect
        //bottomNavigationView.getMenu().setGroupCheckable(0, false, true);

        //android:theme="@style/AppTheme.NoActionBar"
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.parentiprofumeria.com/ambienti-1");

        mySwipeRefreshLayout = (SwipeRefreshLayout)this.findViewById(R.id.swipeRefressher);

        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        webView.reload();
                        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
                        // This is important as it forces webview to load from the instead of reloading from cache

                        webView .loadUrl("https://www.parentiprofumeria.com/ambienti-1");
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
            startActivity(new Intent(AmbientActivity.this, HomeActivity.class));
            customType(AmbientActivity.this,"right-to-left");
            finish();
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
        if(menuItem.getItemId() == R.id.ambientiMenuId){
            drawerLayout.closeDrawers();
        }
        if(menuItem.getItemId()==R.id.profumiMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(AmbientActivity.this, ProfumiActivity.class));
            customType(AmbientActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.makeupMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(AmbientActivity.this, MakeupActivity.class));
            customType(AmbientActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.creamMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(AmbientActivity.this, CreamActivity.class));
            customType(AmbientActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.barbaMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(AmbientActivity.this, BarbaActivity.class));
            customType(AmbientActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.shoppingCartMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(AmbientActivity.this, ShoppingCartActivity.class));
            customType(AmbientActivity.this,"left-to-right");
            finish();

        }
        if(menuItem.getItemId()==R.id.newsMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(AmbientActivity.this, NewsActivity.class));
            customType(AmbientActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.loginMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(AmbientActivity.this, LoginActivity.class));
            customType(AmbientActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.registrationMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(AmbientActivity.this, RegistrationActivity.class));
            customType(AmbientActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.forgetPasswordMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(AmbientActivity.this, ForgetPasswordActivity.class));
            customType(AmbientActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.homeMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(AmbientActivity.this, HomeActivity.class));
            customType(AmbientActivity.this,"right-to-left");
            finish();
        }


        return true;
    }
}
