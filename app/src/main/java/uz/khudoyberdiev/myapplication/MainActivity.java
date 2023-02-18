package uz.khudoyberdiev.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button vibrate_btn = findViewById(R.id.vibrate_btn);

        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        final long [] pattern = {2000, 1000};

        vibrate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (vibrate_btn.getText().toString().equals("Start")){
                    int repeat = 0;
                    vibrator.vibrate(pattern, repeat);
                    Toast.makeText(MainActivity.this, "Started", Toast.LENGTH_SHORT).show();
                    vibrate_btn.setText("Stop");
                }else{
                    vibrate_btn.setText("Start");
                    Toast.makeText(MainActivity.this, "Canseled", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}