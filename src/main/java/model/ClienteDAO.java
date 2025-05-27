package model;

import java.util.List;

public interface ClienteDAO {
    void salvar(Cliente cliente);
    List<Cliente> obterClientes();
}
