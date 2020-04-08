package in.abhisheksaxena.intenttutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String username = "Test User";
    private String email = "test@user.com";
    private String emailContent = "This is email content.";

    Button explicitIntentButton;
    Button implicitIntentEmailButton;
    Button implicitIntentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView nameTextView = findViewById(R.id.name_textView);
        TextView emailTextView = findViewById(R.id.email_textView);

        explicitIntentButton = findViewById(R.id.explicit_intent_button);
        implicitIntentEmailButton = findViewById(R.id.implicit_intent_email_button);
        implicitIntentButton = findViewById(R.id.implicit_intent_button);


        nameTextView.setText(("Name: " + username));
        emailTextView.setText((("Email: "+ email)));

        //Step 1: Data which is to be sent to another activity (Step 2 & 3 in SecondActivity.java)
        explicitIntentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("name", username);
                intent.putExtra("email", email);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        implicitIntentEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, email);
                intent.putExtra(Intent.EXTRA_SUBJECT, "This is subject");
                intent.putExtra(Intent.EXTRA_TEXT, emailContent);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        implicitIntentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });


    }
}
