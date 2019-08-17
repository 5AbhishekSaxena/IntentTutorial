package in.abhisheksaxena.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Map;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle bundle = getIntent().getBundleExtra("intent_data");

        TextView nameTextView = findViewById(R.id.name_textView);
        TextView emailTextView = findViewById(R.id.email_textView);

        if (bundle != null) {
            nameTextView.setText((getString(R.string.name_label) + " " + bundle.get("name")));
            emailTextView.setText((getString(R.string.email_label) + " " + bundle.get("email")));
        }else{
            nameTextView.setText((getString(R.string.name_label) + " null"));
            emailTextView.setText((getString(R.string.email_label) + " null"));
        }
    }
}
