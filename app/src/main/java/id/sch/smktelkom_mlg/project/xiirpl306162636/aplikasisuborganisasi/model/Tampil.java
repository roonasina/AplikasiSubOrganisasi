package id.sch.smktelkom_mlg.project.xiirpl306162636.aplikasisuborganisasi.model;

/**
 * Created by SMK Telkom SP Malang on 04/12/2016.
 */
public class Tampil {
    private String nama, kelas;

    public Tampil(String nama, String kelas) {
        this.setNama(nama);
        this.setKelas(kelas);
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
