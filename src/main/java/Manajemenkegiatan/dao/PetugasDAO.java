package Manajemenkegiatan.dao;

import Model.Petugas;
import java.util.List;

public interface PetugasDAO {
    List<Petugas> getAllPetugas();
    void tambahPetugas(Petugas petugas);
}