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

public class ProfumiActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    private WebView webView;
    BottomNavigationView bottomNavigationView;
    SwipeRefreshLayout mySwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profumi);
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
                        startActivity(new Intent(ProfumiActivity.this, AboutUsActivity.class));
                        customType(ProfumiActivity.this,"left-to-right");
                        break;

                    case R.id.contactUsButtomMenuId:
                        menuItem.setChecked(true);
                        startActivity(new Intent(ProfumiActivity.this, ContactUsActivity.class));
                        customType(ProfumiActivity.this,"left-to-right");
                        break;
                    case R.id.notificationBottomMenuId:
                        menuItem.setChecked(true);
                        startActivity(new Intent(ProfumiActivity.this, NotificationActivity.class));
                        customType(ProfumiActivity.this,"left-to-right");
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
        webView.loadUrl("https://www.parentiprofumeria.com/profumo-1");

        mySwipeRefreshLayout = (SwipeRefreshLayout)this.findViewById(R.id.swipeRefressher);

        mySwipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        webView.reload();
                        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
// This is important as it forces webview to load from the instead of reloading from cache

                        webView .loadUrl("https://www.parentiprofumeria.com/profumo-1");
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
            startActivity(new Intent(ProfumiActivity.this, HomeActivity.class));
            customType(ProfumiActivity.this,"right-to-left");
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
        if(menuItem.getItemId() == R.id.profumiMenuId){
            drawerLayout.closeDrawers();
        }
        if(menuItem.getItemId()==R.id.homeMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(ProfumiActivity.this, HomeActivity.class));
            customType(ProfumiActivity.this,"right-to-left");
            finish();
        }
        if(menuItem.getItemId()==R.id.makeupMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(ProfumiActivity.this, MakeupActivity.class));
            customType(ProfumiActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.creamMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(ProfumiActivity.this, CreamActivity.class));
            customType(ProfumiActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.barbaMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(ProfumiActivity.this, BarbaActivity.class));
            customType(ProfumiActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.ambientiMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(ProfumiActivity.this, AmbientActivity.class));
            customType(ProfumiActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.newsMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(ProfumiActivity.this, NewsActivity.class));
            customType(ProfumiActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.loginMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(ProfumiActivity.this, LoginActivity.class));
            customType(ProfumiActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.registrationMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(ProfumiActivity.this, RegistrationActivity.class));
            customType(ProfumiActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.forgetPasswordMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(ProfumiActivity.this, ForgetPasswordActivity.class));
            customType(ProfumiActivity.this,"left-to-right");
            finish();
        }
        if(menuItem.getItemId()==R.id.shoppingCartMenuId){
            menuItem.setChecked(true);
            startActivity(new Intent(ProfumiActivity.this, ShoppingCartActivity.class));
            customType(ProfumiActivity.this,"left-to-right");
            finish();
        }


        return true;
    }
}
