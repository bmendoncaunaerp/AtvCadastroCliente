package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ClienteSQLite implements ClienteDAO {

    @Override
    public void salvar(Cliente cliente) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();
        session.save(cliente);
        tx.commit();

        session.close();
    }

    @Override
    public Cliente obterPorId(int id){
        return new Cliente();
    }

    @Override
    public List<Cliente> obterTodos() {
        return new ArrayList<>();
    }

}
