package model;

import java.util.List;

public interface ClienteDAO {
    void salvar(Cliente cliente);
    Cliente obterPorId(int id);
    List<Cliente> obterTodos();
}
