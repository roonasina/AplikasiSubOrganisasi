package id.sch.smktelkom_mlg.project.xiirpl306162636.aplikasisuborganisasi;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import id.sch.smktelkom_mlg.project.xiirpl306162636.aplikasisuborganisasi.model.Suborgan;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Suborgan suborgan = (Suborgan) getIntent().getSerializableExtra(SiswaActivity.SUBORGAN);
        setTitle(suborgan.judul);
        ImageView ivFoto = (ImageView) findViewById(R.id.imageFoto);
        ivFoto.setImageURI(Uri.parse(suborgan.foto));
        TextView tvDeskripsi = (TextView) findViewById(R.id.place_detail);
        tvDeskripsi.setText(suborgan.deskripsi + "\n\n" + suborgan.detail);
        TextView tvLokasi = (TextView) findViewById(R.id.place_location);
        tvLokasi.setText(suborgan.lokasi);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
