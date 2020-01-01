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

public class ShoppingCartActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    private WebView webView;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerId);
        navigationView = (NavigationView) findViewById(R.id.navigationid);
        navigationView.setNavigationItemSelectedListener(this);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationId);


        //make all menu item deselect
        bottomNavigationView.getMenu().setGroupCheckable(0, false, true);

        webView = (WebView) findViewById(R.id.webViewId);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.parentiprofumeria.com/paginacarrello.php");



    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }
        else{
            startActivity(new Intent(ShoppingCartActivity.this, HomeActivity.class));
            customType(ShoppingCartActivity.this,"right-to-left");
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
            startActivity(new Intent(ShoppingCartActivity.this, ProfumiActivity.class));
            customType(ShoppingCartActivity.this,"right-to-left");
        }
        if(menuItem.getItemId()==R.id.makeupMenuId){
            startActivity(new Intent(ShoppingCartActivity.this, MakeupActivity.class));
            customType(ShoppingCartActivity.this,"right-to-left");
        }
        if(menuItem.getItemId()==R.id.creamMenuId){
            startActivity(new Intent(ShoppingCartActivity.this, CreamActivity.class));
            customType(ShoppingCartActivity.this,"right-to-left");
        }
        if(menuItem.getItemId()==R.id.barbaMenuId){
            startActivity(new Intent(ShoppingCartActivity.this, BarbaActivity.class));
            customType(ShoppingCartActivity.this,"right-to-left");
        }
        if(menuItem.getItemId()==R.id.ambientiMenuId){
            startActivity(new Intent(ShoppingCartActivity.this, AmbientActivity.class));
            customType(ShoppingCartActivity.this,"right-to-left");
        }
        if(menuItem.getItemId()==R.id.newsMenuId){
            startActivity(new Intent(ShoppingCartActivity.this, NewsActivity.class));
            customType(ShoppingCartActivity.this,"right-to-left");
        }
        if(menuItem.getItemId()==R.id.loginMenuId){
            startActivity(new Intent(ShoppingCartActivity.this, LoginActivity.class));
            customType(ShoppingCartActivity.this,"right-to-left");
        }
        if(menuItem.getItemId()==R.id.registrationMenuId){
            startActivity(new Intent(ShoppingCartActivity.this, RegistrationActivity.class));
            customType(ShoppingCartActivity.this,"right-to-left");
        }
        if(menuItem.getItemId()==R.id.forgetPasswordMenuId){
            startActivity(new Intent(ShoppingCartActivity.this, ForgetPasswordActivity.class));
            customType(ShoppingCartActivity.this,"right-to-left");
        }
        if(menuItem.getItemId()==R.id.homeMenuId){
            startActivity(new Intent(ShoppingCartActivity.this, HomeActivity.class));
            customType(ShoppingCartActivity.this,"right-to-left");
        }


        return true;
    }
}
