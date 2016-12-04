package id.sch.smktelkom_mlg.project.xiirpl306162636.aplikasisuborganisasi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import id.sch.smktelkom_mlg.project.xiirpl306162636.aplikasisuborganisasi.adapter.TampilAdapter;
import id.sch.smktelkom_mlg.project.xiirpl306162636.aplikasisuborganisasi.model.Tampil;

public class TampilActivity extends AppCompatActivity {
    private static final String TAMPIL_URL = "http://suborgan.16mb.com/tampil.php";
    private static final String SUBORGAN = "suborgan";
    String json_string;
    JSONObject jsonObject;
    JSONArray jsonArray;
    TampilAdapter tampilAdapter;
    ListView listView;
    ProgressDialog progressDialog;
    private TextView textView;
    private String suborgan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil);

        textView = (TextView) findViewById(R.id.tvSub);
        Intent intent = getIntent();
        textView.setText(intent.getStringExtra(UserProfile.KEY_SUB));

        progressDialog = new ProgressDialog(TampilActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();

        tampilkan();
    }

    private void tampilkan() {
        suborgan = textView.getText().toString().trim();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, TAMPIL_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(TampilActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put(SUBORGAN, suborgan);
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String response) {
        progressDialog.dismiss();
        TextView textView = (TextView) findViewById(R.id.tvjson);
        textView.setText(response);
        json_string = response;
        prseJSON();
    }

    private void prseJSON() {
        listView = (ListView) findViewById(R.id.listView);
        tampilAdapter = new TampilAdapter(this, R.layout.row_layout_tampil);
        listView.setAdapter(tampilAdapter);

        try {
            jsonObject = new JSONObject(json_string);
            jsonArray = jsonObject.getJSONArray("result");
            int count = 0;
            String nama, kelas;
            while (count < jsonArray.length()) {
                JSONObject JO = jsonArray.getJSONObject(count);
                nama = JO.getString("nama");
                kelas = JO.getString("kelas");
                Tampil tampil = new Tampil(nama, kelas);
                tampilAdapter.add(tampil);
                count++;

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
