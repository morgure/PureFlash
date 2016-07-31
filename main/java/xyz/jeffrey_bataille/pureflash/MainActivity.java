package xyz.jeffrey_bataille.pureflash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //variable Graphic
    private Button btnFlash;

    //variable Flash
    private boolean isFlashOn = false;
    private Camera camera;
    private Parameters params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFlash = (Button) findViewById(R.id.flash);



        btnFlash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    if (!isFlashOn) {

                        //Flash Hardware
                        camera = Camera.open();
                        params = camera.getParameters();

                        //camera.startPreview();
                        params.setFlashMode(Parameters.FLASH_MODE_TORCH);
                        camera.setParameters(params);


                        //Flash Graphic
                        btnFlash.setBackgroundDrawable(getResources().getDrawable(R.drawable.light_on));

                        isFlashOn = true;
                    } else {
                        //Flash Hardware

                        params.setFlashMode(Parameters.FLASH_MODE_OFF);
                        camera.setParameters(params);
                        //camera.stopPreview();
                        camera.release();

                        //Flash Graphic
                        btnFlash.setBackgroundDrawable(getResources().getDrawable(R.drawable.light_off));

                        isFlashOn = false;

                    }

            }
        });
    }
}
