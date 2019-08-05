package my.com.lim_yeu_harn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Button mSPMButton;
    private Button mOLevelButton;
    private Button mUECButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSPMButton = (Button) findViewById(R.id.button_SPM);
        mSPMButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchEnterGrade(0);
            }
        });

        mOLevelButton = (Button) findViewById(R.id.button_Olevel);
        mOLevelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchEnterGrade(1);
            }
        });

        mUECButton = (Button) findViewById(R.id.button_UEC);
        mUECButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchEnterGrade(2);
            }
        });
    }

    private void launchEnterGrade(int choice){
        Intent intent = new Intent(this, EnterGrade.class);
        intent.putExtra("qualification", choice);
        startActivity(intent);
    }
}
