package model;

import java.util.ArrayList;
import java.util.List;

public class ClienteSQLServer implements ClienteDAO {
    @Override
    public void salvar(Cliente cliente) {
        System.out.println("Salvou no SQL Server");
    }

    @Override
    public Cliente obterPorId(int id) {
        return new Cliente();
    }

    @Override
    public List<Cliente> obterTodos() {
        return new ArrayList<>();
    }
}
