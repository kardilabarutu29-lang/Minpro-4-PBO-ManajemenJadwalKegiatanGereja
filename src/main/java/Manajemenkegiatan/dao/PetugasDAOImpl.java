package Manajemenkegiatan.dao;

import Model.Petugas;
import config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class PetugasDAOImpl implements PetugasDAO {

    @Override
    public List<Petugas> getAllPetugas() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Petugas", Petugas.class).list();
        }
    }

    @Override
    public void tambahPetugas(Petugas petugas) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(petugas);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        }
    }
}