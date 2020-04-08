package in.abhisheksaxena.intenttutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView nameTextView = findViewById(R.id.name_textView);
        TextView emailTextView = findViewById(R.id.email_textView);


        // Step 2: check whether the intent has the required key/values in extras or not
        if (getIntent().hasExtra("name")) {
            // Step 3: receive the values from the intent

            String name = getIntent().getStringExtra("name");
            nameTextView.setText(("Name: " + name));
        }
        if (getIntent().hasExtra("email")) {
            String email = getIntent().getStringExtra("email");
            emailTextView.setText(("Email: " + email));
        }
    }
}
