package id.sch.smktelkom_mlg.project.xiirpl306162636.aplikasisuborganisasi;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class RegisterActivity extends AppCompatActivity {
    public static final String KEY_NAMA = "nama";
    public static final String KEY_KELAS = "kelas";
    public static final String KEY_JK = "jenis_kelamin";
    public static final String KEY_SUBORGAN = "suborgan";
    private static final String Input_URL = "http://suborgan.16mb.com/daftar.php";
    EditText etNama, etKelas;
    RadioGroup rgJK;
    CheckBox cbbasket, cbmac, cbmedsan, cbpalwaga, cbpaskibra, cbpustel;
    Button btnRegister;
    TextView tvhasil, tvhasil2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        findViewById(R.id.buttonSiswa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, RegistrasiActivity.class));
            }
        });

        etNama = (EditText) findViewById(R.id.etNama);
        etKelas = (EditText) findViewById(R.id.etKelas);
        btnRegister = (Button) findViewById(R.id.buttonSiswa);
        rgJK = (RadioGroup) findViewById(R.id.rgJk);
        cbbasket = (CheckBox) findViewById(R.id.cbbasket);
        cbmac = (CheckBox) findViewById(R.id.cbmac);
        cbmedsan = (CheckBox) findViewById(R.id.cbmedsan);
        cbpalwaga = (CheckBox) findViewById(R.id.cbpalwaga);
        cbpaskibra = (CheckBox) findViewById(R.id.cbpaskibra);
        cbpustel = (CheckBox) findViewById(R.id.cbpustel);
        tvhasil2 = (TextView) findViewById(R.id.tvhasil2);
        tvhasil = (TextView) findViewById(R.id.tvhasil);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                jKel();
                register();
            }
        });
    }

    private void check() {
        String hasil = "";
        if (cbbasket.isChecked()) {
            hasil += cbbasket.getText();

        }
        if (cbmac.isChecked()) {
            hasil += cbmac.getText();

        }
        if (cbmedsan.isChecked()) {
            hasil += cbmedsan.getText();

        }
        if (cbpalwaga.isChecked()) {
            hasil += cbpalwaga.getText();

        }
        if (cbpaskibra.isChecked()) {
            hasil += cbpaskibra.getText();

        }
        if (cbpustel.isChecked()) {
            hasil += cbpustel.getText();

        }
        tvhasil.setText(hasil);
    }

    private void jKel() {
        String hasil = null;
        if (rgJK.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton) findViewById(rgJK.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
            tvhasil2.setText(hasil);
        }

    }

    private void register() {
        final String nama = etNama.getText().toString().trim();
        final String kelas = etKelas.getText().toString().trim();
        final String jKelamin = tvhasil2.getText().toString().trim();
        final String suborgan = tvhasil.getText().toString().trim();


        class Register extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Toast.makeText(RegisterActivity.this, s, Toast.LENGTH_LONG).show();

            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String, String> params = new HashMap<>();
                params.put(KEY_NAMA, nama);
                params.put(KEY_KELAS, kelas);
                params.put(KEY_JK, jKelamin);
                params.put(KEY_SUBORGAN, suborgan);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Input_URL, params);
                return res;
            }
        }

        Register register = new Register();
        register.execute();
    }

    public class RequestHandler {
        public String sendPostRequest(String requestURL,
                                      HashMap<String, String> postDataParams) {
            //Creating a URL
            URL url;

            //StringBuilder object to store the message retrieved from the server
            StringBuilder sb = new StringBuilder();
            try {
                //Initializing Url
                url = new URL(requestURL);

                //Creating an httmlurl connection
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                //Configuring connection properties
                conn.setReadTimeout(15000);
                conn.setConnectTimeout(15000);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                //Creating an output stream
                OutputStream os = conn.getOutputStream();

                //Writing parameters to the request
                //We are using a method getPostDataString which is defined below
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(getPostDataString(postDataParams));

                writer.flush();
                writer.close();
                os.close();
                int responseCode = conn.getResponseCode();

                if (responseCode == HttpsURLConnection.HTTP_OK) {

                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    sb = new StringBuilder();
                    String response;
                    //Reading server response
                    while ((response = br.readLine()) != null) {
                        sb.append(response);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return sb.toString();
        }

        private String getPostDataString(HashMap<String, String> params) throws UnsupportedEncodingException {
            StringBuilder result = new StringBuilder();
            boolean first = true;
            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (first)
                    first = false;
                else
                    result.append("&");

                result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            }

            return result.toString();
        }
    }
}
