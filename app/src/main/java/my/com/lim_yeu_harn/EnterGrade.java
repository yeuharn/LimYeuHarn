package my.com.lim_yeu_harn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EnterGrade extends AppCompatActivity {

    private int qualification;
    private Button mButtonSubmit;
    private EditText engGrade;
    private EditText malayGrade;
    private EditText mathGrade;
    private EditText sciGrade;
    private EditText phyGrade;
    private TextView result;
    private TextView info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_grade);

        qualification = getIntent().getExtras().getInt("qualification");

        result = (TextView)findViewById(R.id.textView_result);
        info = (TextView)findViewById(R.id.textView_info);

        engGrade = (EditText)findViewById(R.id.editText_English);
        malayGrade = (EditText)findViewById(R.id.editText_Malay);
        mathGrade = (EditText)findViewById(R.id.editText_Math);
        sciGrade = (EditText)findViewById(R.id.editText_Science);
        phyGrade = (EditText)findViewById(R.id.editText_Physics);

        mButtonSubmit = (Button)findViewById(R.id.button_submit);
        mButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get grade input
                char eng = engGrade.getText().toString().charAt(0);
                char malay = malayGrade.getText().toString().charAt(0);
                char math = mathGrade.getText().toString().charAt(0);
                char sci = sciGrade.getText().toString().charAt(0);
                char phy = phyGrade.getText().toString().charAt(0);

                int gradeC = 0;//number of grade above C
                int gradeB = 0;//number of grade above B

                if(eng <= 'C') {
                    gradeC++;
                    if (eng <= 'B') gradeB++;
                }
                if(math <= 'C') {
                    gradeC++;
                    if (math <= 'B') gradeB++;
                }
                if(malay <= 'C') {
                    gradeC++;
                    if (malay <= 'B') gradeB++;
                }
                if(sci <= 'C') {
                    gradeC++;
                    if (sci <= 'B') gradeB++;
                }
                if(phy <= 'C') {
                    gradeC++;
                    if (phy <= 'B') gradeB++;
                }

                boolean qualified = false;
                //if user choose SPM
                if(qualification == 0){
                    qualified = (gradeC >= 5) && (eng <= 'C') &&(malay <= 'C') && (math <= 'B');
                }
                //if user choose O Level
                else if(qualification == 1){
                    qualified = (gradeC >= 5) && (eng <= 'C') && (math <= 'C');
                }
                //if user choose UEC
                else if(qualification == 2){
                    qualified = (gradeB >= 3) && (eng <= 'C') && (math <= 'B');
                }

                //if user is meet entry requirement
                if(qualified){
                    result.setText(getString(R.string.qualified_message));
                    info.setText("");
                }
                else{
                    result.setText(getString(R.string.not_qualified_message));
                    info.setText("");
                }

                //if user get more than 3 but less than 5 grade C in SPM
                if(gradeC < 5 && gradeC > 3 && qualification == 0){
                    info.setText(getString(R.string.extra_info));
                }
            }
        });
    }
}
