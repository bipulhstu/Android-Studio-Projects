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

public class RegistrationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    private WebView webView;
    BottomNavigationView bottomNavigationView;
    SwipeRefreshLayout mySwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
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
                        startActivity(new Intent(RegistrationActivity.this, AboutUsActivity.class));
                        customType(RegistrationActivity.this,"left-to-right");
                        break;

                    case R.id.contactUsButtomMenuId:
                        menuItem.setChecked(true);
                        startActivity(new Intent(RegistrationActivity.this, ContactUsActivity.class));
                        customType(RegistrationActivity.this,"left-to-right");
                        break;
                    case R.id.notificationBottomMenuId:
                        menuItem.setChecked(true);
                        startActivity(new Intent(RegistrationActivity.this, NotificationActivity.class));
                        customType(RegistrationActivity.this,"left-to-right");
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
        webView.loadUrl("https://www.parentiprofumeria.com/paginaregistrazione.php");

        mySwipeRefreshLayout = (SwipeRefreshLayout)this.findViewById(R.id.swipeRefressher);

        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        webView.reload();
                        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
// This is important as it forces webview to load from the instead of reloading from cache

                        webView .loadUrl("https://www.parentiprofumeria.com/paginaregistrazione.php");
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
            startActivity(new Intent(RegistrationActivity.this, HomeActivity.class));
            customType(RegistrationActivity.this,"right-to-left");
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
        if(menuItem.getItemId() == R.id.registrationMenuId){
            drawerLayout.closeDrawers();
        }
        if(menuItem.getItemId()==R.id.profumiMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(RegistrationActivity.this, ProfumiActivity.class));
            customType(RegistrationActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.makeupMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(RegistrationActivity.this, MakeupActivity.class));
            customType(RegistrationActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.creamMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(RegistrationActivity.this, CreamActivity.class));
            customType(RegistrationActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.barbaMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(RegistrationActivity.this, BarbaActivity.class));
            customType(RegistrationActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.ambientiMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(RegistrationActivity.this, AmbientActivity.class));
            customType(RegistrationActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.newsMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(RegistrationActivity.this, NewsActivity.class));
            customType(RegistrationActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.loginMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
            customType(RegistrationActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.homeMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(RegistrationActivity.this, HomeActivity.class));
            customType(RegistrationActivity.this,"right-to-left");
            finish();
        }
        if(menuItem.getItemId()==R.id.forgetPasswordMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(RegistrationActivity.this, ForgetPasswordActivity.class));
            customType(RegistrationActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.shoppingCartMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(RegistrationActivity.this, ShoppingCartActivity.class));
            customType(RegistrationActivity.this,"left-to-right");
            finish();
        }


        return true;
    }
}
