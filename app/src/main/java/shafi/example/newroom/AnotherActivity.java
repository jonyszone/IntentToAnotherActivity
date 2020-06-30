package shafi.example.newroom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {
    private TextView textView;
    private Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        Bundle extra = getIntent().getExtras();
        textView = findViewById(R.id.anotherTV);
        backBtn = findViewById(R.id.backBtn);

        if( extra != null){
            String message = extra.getString("message");
            int value = extra.getInt("affectedNumber");
            textView.setText("Reason For This Activity: "+message+"Affected People: "+String.valueOf(value));
        }
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = getIntent();
                returnIntent.putExtra("returnData","Returning from AnotherActivity");
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });


    }
}