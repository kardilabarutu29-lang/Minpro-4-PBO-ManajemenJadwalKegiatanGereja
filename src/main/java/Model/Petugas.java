package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "petugas")
public class Petugas {

    @Id
    @Column(name = "id_petugas")
    private String id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "peran")
    private String peran;

    @Column(name = "no_hp")
    private String noHp;


    public Petugas() {
    }

    public Petugas(String id, String nama, String peran, String noHp) {
        this.id = id;
        this.nama = nama;
        this.peran = peran;
        this.noHp = noHp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public String getPeran() {
        return peran;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setPeran(String peran) {
        this.peran = peran;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }
}