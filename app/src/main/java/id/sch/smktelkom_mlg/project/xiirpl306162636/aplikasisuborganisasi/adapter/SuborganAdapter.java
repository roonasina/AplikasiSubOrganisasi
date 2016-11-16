package id.sch.smktelkom_mlg.project.xiirpl306162636.aplikasisuborganisasi.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl306162636.aplikasisuborganisasi.R;
import id.sch.smktelkom_mlg.project.xiirpl306162636.aplikasisuborganisasi.model.Suborgan;


public class SuborganAdapter extends RecyclerView.Adapter<SuborganAdapter.ViewHolder> {

    ArrayList<Suborgan> suborganList;
    ISuborganAdapter mISuborganAdapter;

    public SuborganAdapter(Context context, ArrayList<Suborgan> suborganList) {
        this.suborganList = suborganList;
        mISuborganAdapter = (ISuborganAdapter) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Suborgan suborgan = suborganList.get(position);
        holder.tvJudul.setText(suborgan.judul);
        holder.ivFoto.setImageURI(Uri.parse(suborgan.foto));

    }

    @Override
    public int getItemCount() {
        if (suborganList != null)
            return suborganList.size();
        return 0;
    }

    public interface ISuborganAdapter {
        void doClick(int pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvJudul;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageView);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mISuborganAdapter.doClick(getAdapterPosition());
                }
            });
        }
    }
}
