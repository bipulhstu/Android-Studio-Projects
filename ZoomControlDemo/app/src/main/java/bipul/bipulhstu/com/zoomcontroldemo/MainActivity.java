package bipul.bipulhstu.com.zoomcontroldemo;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ZoomControls;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private ZoomControls zoomControls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageViewId);
        zoomControls = (ZoomControls) findViewById(R.id.zoomControlId);


        zoomControls.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Zoom in", Toast.LENGTH_SHORT).show();
             float x = imageView.getScaleX();
             float y = imageView.getScaleY();

             imageView.setScaleX((float)x+1);
             imageView.setScaleY((float)y+1);
            }

        });
        zoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Zoom out", Toast.LENGTH_SHORT).show();
             float x = imageView.getScaleX();
             float y = imageView.getScaleY();

             imageView.setScaleX((float)x-1);
             imageView.setScaleY((float)y-1);
            }

        });


    }
}
