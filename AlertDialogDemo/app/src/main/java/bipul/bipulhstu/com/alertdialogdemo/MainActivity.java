package bipul.bipulhstu.com.alertdialogdemo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    private Button exitButton;
    private AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exitButton = (Button) findViewById(R.id.buttonId);
        exitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        ////setting a title
        alertDialogBuilder.setTitle(R.string.title_text);
        //message
        alertDialogBuilder.setMessage(R.string.message_text);
        ///for setting icon
        alertDialogBuilder.setIcon(R.drawable.question);
        ///set positive button
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ///exit
                finish();

            }
        });


        ///set negative button
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(MainActivity.this, "You have clicked on no button", Toast.LENGTH_SHORT).show();
                //or cancel it
                dialog.cancel();

            }
        });

        alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "You have clicked on cancel button", Toast.LENGTH_SHORT).show();

            }
        });
        ///create alert dialog object
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();



    }
}
