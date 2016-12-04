package id.sch.smktelkom_mlg.project.xiirpl306162636.aplikasisuborganisasi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import id.sch.smktelkom_mlg.project.xiirpl306162636.aplikasisuborganisasi.R;
import id.sch.smktelkom_mlg.project.xiirpl306162636.aplikasisuborganisasi.model.Tampil;

/**
 * Created by SMK Telkom SP Malang on 04/12/2016.
 */
public class TampilAdapter extends ArrayAdapter {
    List list = new ArrayList();

    public TampilAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(Tampil object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        row = convertView;
        TampilHolder tampilHolder;
        if (row == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout_tampil, parent, false);
            tampilHolder = new TampilAdapter.TampilHolder();
            tampilHolder.tx_nama = (TextView) row.findViewById(R.id.nama);
            tampilHolder.tx_kelas = (TextView) row.findViewById(R.id.kelas);
            row.setTag(tampilHolder);
        } else {
            tampilHolder = (TampilAdapter.TampilHolder) row.getTag();
        }
        Tampil tampil = (Tampil) this.getItem(position);
        tampilHolder.tx_nama.setText(tampil.getNama());
        tampilHolder.tx_kelas.setText(tampil.getKelas());

        return row;
    }

    static class TampilHolder {
        TextView tx_nama, tx_kelas;
    }
}
