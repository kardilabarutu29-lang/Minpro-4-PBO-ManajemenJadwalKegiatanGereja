package controller;

import Manajemenkegiatan.dao.KegiatanDAO;
import Manajemenkegiatan.dao.KegiatanDAOImpl;
import Model.Petugas;
import Manajemenkegiatan.dao.PetugasDAO;
import Manajemenkegiatan.dao.PetugasDAOImpl;
import Model.Kegiatan;
import Model.Tempat;
import java.util.List;

public class ManajemenKegiatan {

    private final PetugasDAO petugasDAO = new PetugasDAOImpl();
    private final KegiatanDAO KegiatanDAO = new KegiatanDAOImpl();

    
    public void tampilPetugas() {
        List<Petugas> list = petugasDAO.getAllPetugas();
        if (list.isEmpty()) {
            System.out.println("Data petugas kosong.");
        } else {
            System.out.println("--------------------------------------------------");
            System.out.println("ID \t| NAMA \t\t| PERAN \t| NO HP");
            System.out.println("--------------------------------------------------");
            for (Petugas p : list) {
                System.out.println(p.getId() + " \t| " + p.getNama() + " \t| " + p.getPeran() + " \t| " + p.getNoHp());
            }
            System.out.println("--------------------------------------------------");
        }
    }


    public void tambahPetugas(String id, String nama, String peran, String noHp) {
        Petugas p = new Petugas(id, nama, peran, noHp);
        petugasDAO.tambahPetugas(p);
        System.out.println("Petugas berhasil disimpan menggunakan Hibernate ORM!");
    }

    public boolean idTempatAda(String id) {
        List<Tempat> list = KegiatanDAO.getAllTempat();
        for (Tempat t : list) {
            if (t.getId().equalsIgnoreCase(id)) return true;
        }
        return false;
    }

    public boolean idPetugasAda(String id) {
        List<Petugas> list = petugasDAO.getAllPetugas();
        for (Petugas p : list) {
            if (p.getId().equalsIgnoreCase(id)) return true;
        }
        return false; 
    }

    public boolean idKegiatanAda(String id) {
        List<Kegiatan> list = KegiatanDAO.getAllKegiatan();
        for (Kegiatan k : list) {
            if (k.getId().equalsIgnoreCase(id)) return true;
        }
        return false;
    }

    public boolean hapusPetugas(String id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void tampilTempat() {
        List<Tempat> list = KegiatanDAO.getAllTempat();
        if (list.isEmpty()) {
            System.out.println("Data tempat kosong.");
        } else {
            System.out.println("--------------------------------------------------");
            System.out.println("ID \t| NAMA TEMPAT \t| LOKASI \t| KAPASITAS");
            System.out.println("--------------------------------------------------");
            for (Tempat t : list) {
                System.out.println(t.getId() + " \t| " + t.getNama() + " \t| " + t.getLokasi() + " \t| " + t.getKapasitas());
            }
            System.out.println("--------------------------------------------------");
        } 
    }

    public void tambahTempat(String id, String nama, String lokasi, int kapasitas) {
        Tempat t = new Tempat(id, nama, lokasi, kapasitas);
        KegiatanDAO.addTempat(t);
        System.out.println("Tempat berhasil ditambahkan!");
    }

    public boolean editTempat(String id, String nama, String lokasi, int kapasitas) {
        return true;
    }

    public boolean hapusTempat(String id) {
        return true; 
    }

    public boolean editPetugas(String id, String nama, String peran, String noHp) {
        Petugas p = new Petugas(id, nama, peran, noHp);
        petugasDAO.tambahPetugas(p);
        return true;
    }

    public boolean hapusKegiatan(String id) {
        return KegiatanDAO.deleteKegiatan(id);
    }

    public boolean editKegiatan(String id, String nama, String tanggal, String jam, String kategori, String deskripsi) {
        return true;
    }

    public void tambahKegiatan(Kegiatan kegiatan) {
        KegiatanDAO.addKegiatan(kegiatan);
        System.out.println("Kegiatan berhasil ditambahkan!");
    }

    public void tampilKegiatan() {
        List<Kegiatan> list = KegiatanDAO.getAllKegiatan();
        if (list.isEmpty()) {
            System.out.println("Data kegiatan kosong.");
        } else {
            System.out.println("--------------------------------------------------");
            System.out.println("ID \t| NAMA KEGIATAN \t| TANGGAL \t| JAM");
            System.out.println("--------------------------------------------------");
            for (Kegiatan k : list) {
                System.out.println(k.getId() + " \t| " + k.getNama() + " \t| " + k.getTanggal() + " \t| " + k.getJam());
            }
            System.out.println("--------------------------------------------------");
        }
    }
}