package Manajemenkegiatan.dao;

import Model.Kegiatan;
import Model.KegiatanIbadah;
import Model.KegiatanSosial;
import Model.Petugas;
import Model.Tempat;
import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class KegiatanDAOImpl implements KegiatanDAO {

    @Override
    public List<Kegiatan> getAllKegiatan() {
        List<Kegiatan> list = new ArrayList<>();
        String sql = "SELECT * FROM kegiatan";

        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String kategori = rs.getString("kategori");
                Kegiatan k;
                if (kategori.equalsIgnoreCase("Ibadah")) {
                    k = new KegiatanIbadah(
                            rs.getString("id"), rs.getString("nama"),
                            rs.getString("tanggal"), rs.getString("jam"),
                            kategori, rs.getString("deskripsi"),
                            rs.getString("id_petugas"), rs.getString("id_tempat")
                    );
                } else {
                    k = new KegiatanSosial(
                            rs.getString("id"), rs.getString("nama"),
                            rs.getString("tanggal"), rs.getString("jam"),
                            kategori, rs.getString("deskripsi"),
                            rs.getString("id_petugas"), rs.getString("id_tempat")
                    );
                }
                list.add(k);
            }
        } catch (SQLException e) {
            System.err.println("Error get all kegiatan: " + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean addKegiatan(Kegiatan k) {
        String sql = "INSERT INTO kegiatan VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, k.getId());
            ps.setString(2, k.getNama());
            ps.setString(3, k.getTanggal());
            ps.setString(4, k.getJam());
            ps.setString(5, k.getKategori());
            ps.setString(6, k.getDeskripsi());
            ps.setString(7, k.getIdPetugas());
            ps.setString(8, k.getIdTempat());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean updateKegiatan(Kegiatan k) {
        String sql = "UPDATE kegiatan SET nama=?, tanggal=?, jam=?, kategori=?, deskripsi=? WHERE id=?";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, k.getNama());
            ps.setString(2, k.getTanggal());
            ps.setString(3, k.getJam());
            ps.setString(4, k.getKategori());
            ps.setString(5, k.getDeskripsi());
            ps.setString(6, k.getId());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean deleteKegiatan(String id) {
        String sql = "DELETE FROM kegiatan WHERE id=?";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public List<Petugas> getAllPetugas() {
        List<Petugas> list = new ArrayList<>();
        String sql = "SELECT * FROM petugas";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Petugas(
                        rs.getString("id"), rs.getString("nama"),
                        rs.getString("peran"), rs.getString("no_hp")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error get all petugas: " + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean addPetugas(Petugas p) {
        String sql = "INSERT INTO petugas VALUES (?, ?, ?, ?)";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getId());
            ps.setString(2, p.getNama());
            ps.setString(3, p.getPeran());
            ps.setString(4, p.getNoHp());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public List<Tempat> getAllTempat() {
        List<Tempat> list = new ArrayList<>();
        String sql = "SELECT * FROM tempat";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Tempat(
                        rs.getString("id"), rs.getString("nama"),
                        rs.getString("lokasi"), rs.getInt("kapasitas")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error get all tempat: " + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean addTempat(Tempat t) {
        String sql = "INSERT INTO tempat VALUES (?, ?, ?, ?)";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, t.getId());
            ps.setString(2, t.getNama());
            ps.setString(3, t.getLokasi());
            ps.setInt(4, t.getKapasitas());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }
}
