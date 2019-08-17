package in.abhisheksaxena.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private String username = "Test User";
    private String email = "test@user.com";
    private String emailContent = "This is email content.";

    Button explicitIntentButton;
    Button implicitIntentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView nameTextView = findViewById(R.id.name_textView);
        TextView emailTextView = findViewById(R.id.email_textView);

        explicitIntentButton = findViewById(R.id.explicit_intent_button);
        implicitIntentButton = findViewById(R.id.implicit_intent_button);


        nameTextView.setText((getString(R.string.name_label) + " " + username));
        emailTextView.setText((getString(R.string.email_label) + " " + email));

        explicitIntentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", username);
                bundle.putString("email", email);
                intent.putExtra("intent_data", bundle);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        implicitIntentButton.setOnClickListener(new View.OnClickListener() {
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



    }
}
