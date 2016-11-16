package id.sch.smktelkom_mlg.project.xiirpl306162636.aplikasisuborganisasi.model;

import java.io.Serializable;

/**
 * Created by SMK Telkom SP Malang on 15/11/2016.
 */
public class Suborgan implements Serializable {
    public String judul;
    public String deskripsi;
    public String detail;
    public String lokasi;
    public String foto;

    public Suborgan(String judul, String deskripsi, String detail, String lokasi, String foto) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.detail = detail;
        this.lokasi = lokasi;
        this.foto = foto;
    }


}