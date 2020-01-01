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

public class LoginActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    private WebView webView;
    BottomNavigationView bottomNavigationView;
    SwipeRefreshLayout mySwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
                        startActivity(new Intent(LoginActivity.this, AboutUsActivity.class));
                        customType(LoginActivity.this,"left-to-right");
                        break;

                    case R.id.contactUsButtomMenuId:
                        startActivity(new Intent(LoginActivity.this, ContactUsActivity.class));
                        customType(LoginActivity.this,"left-to-right");
                        break;
                    case R.id.notificationBottomMenuId:
                        startActivity(new Intent(LoginActivity.this, NotificationActivity.class));
                        customType(LoginActivity.this,"left-to-right");
                        break;
                }
                return false;
            }
        });


        //make all menu item deselect
        //bottomNavigationView.getMenu().setGroupCheckable(0, false, true);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.parentiprofumeria.com/login-page.php");

        mySwipeRefreshLayout = (SwipeRefreshLayout)this.findViewById(R.id.swipeRefressher);

        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        webView.reload();
                        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
// This is important as it forces webview to load from the instead of reloading from cache

                        webView .loadUrl("https://www.parentiprofumeria.com/login-page.php");
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
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            customType(LoginActivity.this,"right-to-left");
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
        if(menuItem.getItemId() == R.id.loginMenuId){
            drawerLayout.closeDrawers();
        }
        if(menuItem.getItemId()==R.id.profumiMenuId){
            startActivity(new Intent(LoginActivity.this, ProfumiActivity.class));
            customType(LoginActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.makeupMenuId){
            startActivity(new Intent(LoginActivity.this, MakeupActivity.class));
            customType(LoginActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.creamMenuId){
            startActivity(new Intent(LoginActivity.this, CreamActivity.class));
            customType(LoginActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.barbaMenuId){
            startActivity(new Intent(LoginActivity.this, BarbaActivity.class));
            customType(LoginActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.ambientiMenuId){
            startActivity(new Intent(LoginActivity.this, AmbientActivity.class));
            customType(LoginActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.newsMenuId){
            startActivity(new Intent(LoginActivity.this, NewsActivity.class));
            customType(LoginActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.homeMenuId){
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            customType(LoginActivity.this,"right-to-left");
            finish();
        }
        if(menuItem.getItemId()==R.id.registrationMenuId){
            startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
            customType(LoginActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.forgetPasswordMenuId){
            startActivity(new Intent(LoginActivity.this, ForgetPasswordActivity.class));
            customType(LoginActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.shoppingCartMenuId){
            startActivity(new Intent(LoginActivity.this, ShoppingCartActivity.class));
            customType(LoginActivity.this,"left-to-right");
            finish();
        }


        return true;
    }
}

