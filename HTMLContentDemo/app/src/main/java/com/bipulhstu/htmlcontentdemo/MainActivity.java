package com.bipulhstu.htmlcontentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.webkit.WebView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //private WebView webView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //webView = (WebView) findViewById(R.id.webViewId);
        textView = (TextView) findViewById(R.id.textViewId);
        String myText = "<h1>My Name is Bipul Islam</h1>\n"+
                "<h2>My name is Bipul Islam</h2>\n"+
                "<h3>My name is Bipul Islam</h3>\n"+
                "<h4>My name is Bipul Islam</h4>\n"+
                "<h5>My name is Bipul Islam</h5>\n"+
                "<h6>My name is Bipul Islam</h6>\n"+
                "<p>This is paragraph</p>\n"+
                "<p><u>Underline</u></p>\n"+
                "<p><b>Bold</b></p>\n"+
                "<p><i>Italic</i></p>\n"+
                "Ordered List\n"+
                "<ol>\n"+
                "<li>C</li>\n"+
                "<li>C++</li>\n"+
                "<li>Java</li>\n"+
                "<li>Python</li>\n"+
                "</ol>\n\n"+
                "(a+b)<sup>2</sup>=a<sup>2</sup>+2ab+b<sup>2</sup>";

        //webView.loadDataWithBaseURL(null, myText, "text/html", "utf-8", null);

        textView.setText(Html.fromHtml(myText));
    }
}
