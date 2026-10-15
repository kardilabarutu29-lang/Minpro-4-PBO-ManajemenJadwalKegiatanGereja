package Manajemenkegiatan.dao;

import Model.Kegiatan;
import Model.Petugas;
import Model.Tempat;
import java.util.List;

public interface KegiatanDAO {
    List<Kegiatan> getAllKegiatan();
    boolean addKegiatan(Kegiatan kegiatan);
    boolean updateKegiatan(Kegiatan kegiatan);
    boolean deleteKegiatan(String id);

    List<Petugas> getAllPetugas();
    boolean addPetugas(Petugas petugas);

    List<Tempat> getAllTempat();
    boolean addTempat(Tempat tempat);
}