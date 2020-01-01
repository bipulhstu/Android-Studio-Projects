package bipul.bipulhstu.com.gridviewdemo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    private String[] countryNames;
    int[] flags = {R.drawable.af, R.drawable.am, R.drawable.az, R.drawable.bh,
            R.drawable.bd, R.drawable.bt, R.drawable.cn, R.drawable.in, R.drawable.jp,
            R.drawable.np, R.drawable.pk,R.drawable.af, R.drawable.am, R.drawable.az, R.drawable.bh,
            R.drawable.bd, R.drawable.bt, R.drawable.cn, R.drawable.in, R.drawable.jp,
            R.drawable.np, R.drawable.pk
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryNames = getResources().getStringArray(R.array.country_name);

        gridView = (GridView) findViewById(R.id.gridViewId);

        CustomAdapter adapter = new CustomAdapter(MainActivity.this, countryNames, flags);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String value = countryNames[position];
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            }
        });

    }


    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder;
        alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setIcon(R.drawable.question);
        alertDialogBuilder.setTitle(R.string.title_text);
        alertDialogBuilder.setMessage(R.string.message_text);
        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
