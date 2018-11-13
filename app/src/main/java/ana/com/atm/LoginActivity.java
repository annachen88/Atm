package ana.com.atm;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText u;
    EditText p;
    String user;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        u = findViewById(R.id.userId);
        p = findViewById(R.id.passWord);
        String userId = getSharedPreferences("atm", MODE_PRIVATE).getString("USERID", "");
       // userId.getString("USERID", "");
        u.setText(userId);
    }

    public void login(View view) {
        user = u.getText().toString();
        password = p.getText().toString();
        if ("jack".equals(user) && "1234".equals(password)) {
            setResult(RESULT_OK);
            getSharedPreferences("atm", MODE_PRIVATE).edit().putString("USERID", user).apply();

            finish();
        }

    }
}
