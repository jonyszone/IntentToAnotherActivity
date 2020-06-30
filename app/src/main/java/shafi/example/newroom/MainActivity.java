package shafi.example.newroom;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   private Button button, button2;
   private TextView textView;
   private final int RESULT_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       button = findViewById(R.id.buttonBtn);
       button2 = findViewById(R.id.takeMeToAnotherActivity);
       textView =  findViewById(R.id.textViewTV);


       textView.setVisibility(View.INVISIBLE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(R.string.my_name);
                textView.setVisibility(View.VISIBLE);
                System.out.println("Worked!");
            }

        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnotherActivity.class);
                intent.putExtra("message","THis is another avtivity, Comes from MainACtivity");
                intent.putExtra("affectedNumber", 135);
               // startActivity(intent);
                startActivityForResult(intent, RESULT_CODE);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RESULT_CODE){
            String result = data.getStringExtra("returnData");
            Toast.makeText(MainActivity.this, result,Toast.LENGTH_LONG).show();
        }
    }


}