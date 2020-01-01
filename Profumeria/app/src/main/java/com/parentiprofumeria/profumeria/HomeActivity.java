package com.parentiprofumeria.profumeria;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerId);
        navigationView = (NavigationView) findViewById(R.id.navigationid);
        navigationView.setNavigationItemSelectedListener(this);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationId);


        //make all menu item deselect
        bottomNavigationView.getMenu().setGroupCheckable(0, false, true);

        //android:theme="@style/AppTheme.NoActionBar"


        webView = (WebView) findViewById(R.id.webViewId);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://parentiprofumeria.com");



    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }
        else{
            super.onBackPressed(); ///here alert dialog
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
        if(menuItem.getItemId()==R.id.profumiMenuId){
            startActivity(new Intent(HomeActivity.this, ProfumiActivity.class));
            customType(HomeActivity.this,"left-to-right");
        }
        if(menuItem.getItemId()==R.id.makeupMenuId){
            startActivity(new Intent(HomeActivity.this, MakeupActivity.class));
            customType(HomeActivity.this,"left-to-right");
        }
        if(menuItem.getItemId()==R.id.creamMenuId){
            startActivity(new Intent(HomeActivity.this, CreamActivity.class));
            customType(HomeActivity.this,"left-to-right");
        }
        if(menuItem.getItemId()==R.id.barbaMenuId){
            startActivity(new Intent(HomeActivity.this, BarbaActivity.class));
            customType(HomeActivity.this,"left-to-right");
        }
        if(menuItem.getItemId()==R.id.ambientiMenuId){
            startActivity(new Intent(HomeActivity.this, AmbientActivity.class));
            customType(HomeActivity.this,"left-to-right");
        }
        if(menuItem.getItemId()==R.id.newsMenuId){
            startActivity(new Intent(HomeActivity.this, NewsActivity.class));
            customType(HomeActivity.this,"left-to-right");
        }
        if(menuItem.getItemId()==R.id.loginMenuId){
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
            customType(HomeActivity.this,"left-to-right");
        }
        if(menuItem.getItemId()==R.id.registrationMenuId){
            startActivity(new Intent(HomeActivity.this, RegistrationActivity.class));
            customType(HomeActivity.this,"left-to-right");
        }
        if(menuItem.getItemId()==R.id.forgetPasswordMenuId){
            startActivity(new Intent(HomeActivity.this, ForgetPasswordActivity.class));
            customType(HomeActivity.this,"left-to-right");
        }
        if(menuItem.getItemId()==R.id.shoppingCartMenuId){
            startActivity(new Intent(HomeActivity.this, ShoppingCartActivity.class));
            customType(HomeActivity.this,"left-to-right");
        }


        return true;
    }
}
