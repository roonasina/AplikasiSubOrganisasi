package id.sch.smktelkom_mlg.project.xiirpl306162636.aplikasisuborganisasi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String REGISTER_URL = "http://172.26.2.152/project_android/register.php";
    private EditText etNama;
    private EditText etKelas;
    private RadioButton radioButtonL;
    private RadioButton radioButtonP;
    private CheckBox cbbasket, cbmac, cbmemo, cbpalwaga, cbpaskibra, cbpustel;
    private Button buttonDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        etNama = (EditText) findViewById(R.id.etNama);
        etKelas = (EditText) findViewById(R.id.etKelas);
        radioButtonL = (RadioButton) findViewById(R.id.radioButtonL);
        radioButtonP = (RadioButton) findViewById(R.id.radioButtonP);
        cbbasket = (CheckBox) findViewById(R.id.cbbasket);
        cbmac = (CheckBox) findViewById(R.id.cbmac);
        cbmemo = (CheckBox) findViewById(R.id.cbmemo);
        cbpalwaga = (CheckBox) findViewById(R.id.cbpalwaga);
        cbpaskibra = (CheckBox) findViewById(R.id.cbpaskibra);
        cbpustel = (CheckBox) findViewById(R.id.cbpustel);

        buttonDaftar = (Button) findViewById(R.id.buttonDaftar);
        buttonDaftar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == buttonDaftar) {
            registerUser();
        }
    }

    private void registerUser() {
        String name = etNama.getText().toString().trim().toLowerCase();
        String kelas = etKelas.getText().toString().trim().toLowerCase();
        String jk = radioButtonL.get

    }
}
