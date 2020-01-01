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

public class MakeupActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    private WebView webView;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makeup);
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
        webView.loadUrl("https://www.parentiprofumeria.com/trucco-1");



    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }
        else{
            startActivity(new Intent(MakeupActivity.this, HomeActivity.class));
            customType(MakeupActivity.this,"right-to-left");
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
            startActivity(new Intent(MakeupActivity.this, ProfumiActivity.class));
            customType(MakeupActivity.this,"right-to-left");
        }
        if(menuItem.getItemId()==R.id.homeMenuId){
            startActivity(new Intent(MakeupActivity.this, HomeActivity.class));
            customType(MakeupActivity.this,"right-to-left");
        }
        if(menuItem.getItemId()==R.id.creamMenuId){
            startActivity(new Intent(MakeupActivity.this, CreamActivity.class));
            customType(MakeupActivity.this,"left-to-right");
        }
        if(menuItem.getItemId()==R.id.barbaMenuId){
            startActivity(new Intent(MakeupActivity.this, BarbaActivity.class));
            customType(MakeupActivity.this,"left-to-right");
        }
        if(menuItem.getItemId()==R.id.ambientiMenuId){
            startActivity(new Intent(MakeupActivity.this, AmbientActivity.class));
            customType(MakeupActivity.this,"left-to-right");
        }
        if(menuItem.getItemId()==R.id.newsMenuId){
            startActivity(new Intent(MakeupActivity.this, NewsActivity.class));
            customType(MakeupActivity.this,"left-to-right");
        }
        if(menuItem.getItemId()==R.id.loginMenuId){
            startActivity(new Intent(MakeupActivity.this, LoginActivity.class));
            customType(MakeupActivity.this,"left-to-right");
        }
        if(menuItem.getItemId()==R.id.registrationMenuId){
            startActivity(new Intent(MakeupActivity.this, RegistrationActivity.class));
            customType(MakeupActivity.this,"left-to-right");
        }
        if(menuItem.getItemId()==R.id.forgetPasswordMenuId){
            startActivity(new Intent(MakeupActivity.this, ForgetPasswordActivity.class));
            customType(MakeupActivity.this,"left-to-right");
        }
        if(menuItem.getItemId()==R.id.shoppingCartMenuId){
            startActivity(new Intent(MakeupActivity.this, ShoppingCartActivity.class));
            customType(MakeupActivity.this,"left-to-right");
        }


        return true;
    }
}
