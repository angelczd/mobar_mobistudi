package czd.mobistudi.activity;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.transition.Explode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import czd.mobistudi.R;

public class LoginActivity extends AppCompatActivity {


    private EditText etUsername;
    private EditText etPassword;
    private Button btGo;
    private CardView cv;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_password);
        btGo = (Button) findViewById(R.id.bt_go);
        cv = (CardView) findViewById(R.id.cv);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            @TargetApi(Build.VERSION_CODES.LOLLIPOP) //api21
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setSharedElementEnterTransition(null);
                    getWindow().setEnterTransition(null);

                    ActivityOptions options =
                            ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, fab, fab.getTransitionName());
                    startActivity(new Intent(LoginActivity.this, RegisterActivity.class), options.toBundle());
                } else {
                    startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                }
            }
        });

        btGo.setOnClickListener(new View.OnClickListener() {
            @Override
            @TargetApi(Build.VERSION_CODES.LOLLIPOP) //api21
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Explode explode = new Explode();
                    explode.setDuration(500);
                    getWindow().setExitTransition(explode);
                    getWindow().setEnterTransition(explode);

                    ActivityOptionsCompat optionsCompat =
                            ActivityOptionsCompat.makeSceneTransitionAnimation(LoginActivity.this);
                    startActivity(new Intent(LoginActivity.this, MainActivity.class), optionsCompat.toBundle());
                } else {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
            }
        });
    }
}
