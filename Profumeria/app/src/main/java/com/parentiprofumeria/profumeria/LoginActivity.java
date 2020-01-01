package com.parentiprofumeria.profumeria;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerId);
        navigationView = (NavigationView) findViewById(R.id.navigationid);
        navigationView.setNavigationItemSelectedListener(this);
        webView = (WebView) findViewById(R.id.webViewId);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationId);


        //make all menu item deselect
        bottomNavigationView.getMenu().setGroupCheckable(0, false, true);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.parentiprofumeria.com/login-page.php");



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
        if(menuItem.getItemId()==R.id.profumiMenuId){
            startActivity(new Intent(LoginActivity.this, ProfumiActivity.class));
            customType(LoginActivity.this,"right-to-left");
        }
        if(menuItem.getItemId()==R.id.makeupMenuId){
            startActivity(new Intent(LoginActivity.this, MakeupActivity.class));
            customType(LoginActivity.this,"right-to-left");
        }
        if(menuItem.getItemId()==R.id.creamMenuId){
            startActivity(new Intent(LoginActivity.this, CreamActivity.class));
            customType(LoginActivity.this,"right-to-left");
        }
        if(menuItem.getItemId()==R.id.barbaMenuId){
            startActivity(new Intent(LoginActivity.this, BarbaActivity.class));
            customType(LoginActivity.this,"right-to-left");
        }
        if(menuItem.getItemId()==R.id.ambientiMenuId){
            startActivity(new Intent(LoginActivity.this, AmbientActivity.class));
            customType(LoginActivity.this,"right-to-left");
        }
        if(menuItem.getItemId()==R.id.newsMenuId){
            startActivity(new Intent(LoginActivity.this, NewsActivity.class));
            customType(LoginActivity.this,"right-to-left");
        }
        if(menuItem.getItemId()==R.id.homeMenuId){
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            customType(LoginActivity.this,"right-to-left");
        }
        if(menuItem.getItemId()==R.id.registrationMenuId){
            startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
            customType(LoginActivity.this,"left-to-right");
        }
        if(menuItem.getItemId()==R.id.forgetPasswordMenuId){
            startActivity(new Intent(LoginActivity.this, ForgetPasswordActivity.class));
            customType(LoginActivity.this,"left-to-right");
        }
        if(menuItem.getItemId()==R.id.shoppingCartMenuId){
            startActivity(new Intent(LoginActivity.this, ShoppingCartActivity.class));
            customType(LoginActivity.this,"left-to-right");
        }


        return true;
    }
}
