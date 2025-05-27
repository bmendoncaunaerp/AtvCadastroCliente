package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {

    private final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    @Override
    public void salvar(Cliente cliente) {
        List<Cliente> clientes = null;

        try (Session session = factory.openSession()) {
            Transaction tx = null;

            try {
                tx = session.beginTransaction();
                session.persist(cliente);
                tx.commit();

            } catch (Exception e) {
                if (tx != null) tx.rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Cliente> obterClientes() {
        List<Cliente> clientes = null;

        try (Session session = factory.openSession()) {
            clientes = session.createQuery("from Cliente", Cliente.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return clientes;
    }
}
