package id.sch.smktelkom_mlg.project.xiirpl306162636.aplikasisuborganisasi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class UserProfile extends AppCompatActivity {
    public static final String KEY_SUB = "sub";
    TextView tv;
    private String sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        tv = (TextView) findViewById(R.id.sub);

        findViewById(R.id.imageViewbasket).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("TSBC(Basket)");
                sub = tv.getText().toString();
                Intent intent = new Intent(UserProfile.this, TampilActivity.class);
                intent.putExtra(KEY_SUB, sub);
                startActivity(intent);
            }
        });

        findViewById(R.id.imageViewmac).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("mac");
                sub = tv.getText().toString();
                Intent intent = new Intent(UserProfile.this, TampilActivity.class);
                intent.putExtra(KEY_SUB, sub);
                startActivity(intent);
            }
        });

        findViewById(R.id.imageViewmedsan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("memo");
                sub = tv.getText().toString();
                Intent intent = new Intent(UserProfile.this, TampilActivity.class);
                intent.putExtra(KEY_SUB, sub);
                startActivity(intent);
            }
        });

        findViewById(R.id.imageViewpalwaga).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("palwaga");
                sub = tv.getText().toString();
                Intent intent = new Intent(UserProfile.this, TampilActivity.class);
                intent.putExtra(KEY_SUB, sub);
                startActivity(intent);
            }
        });

        findViewById(R.id.imageViewpaskibra).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("paskibra");
                sub = tv.getText().toString();
                Intent intent = new Intent(UserProfile.this, TampilActivity.class);
                intent.putExtra(KEY_SUB, sub);
                startActivity(intent);
            }
        });

        findViewById(R.id.imageViewperpus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("perpus");
                sub = tv.getText().toString();
                Intent intent = new Intent(UserProfile.this, TampilActivity.class);
                intent.putExtra(KEY_SUB, sub);
                startActivity(intent);
            }
        });
    }
}

