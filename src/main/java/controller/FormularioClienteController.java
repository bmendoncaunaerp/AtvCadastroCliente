package controller;

import model.Cliente;
import model.ClienteDAO;
import model.ClienteDAOImpl;
import view.FormularioClientes;

import java.util.List;

public class FormularioClienteController {

    FormularioClientes view = new FormularioClientes();
    ClienteDAO clienteDAO = new ClienteDAOImpl();

    public FormularioClienteController() {
        view.setBtnSalvarListener(e -> {
            String nome = view.getNome();
            String email = view.getEmail();
            onCadastroClicked(nome, email);
        });

        List<Cliente> clientes = clienteDAO.obterClientes();
        view.mostrarClientes(clientes);
    }

    void onCadastroClicked(String nome, String email) {
        try {
            if (nome.isEmpty() || email.isEmpty()) {
                throw new IllegalArgumentException("Preencha todos os campos.");
            }

            Cliente cliente = new Cliente(nome, email);

            clienteDAO.salvar(cliente);
            List<Cliente> clientes = clienteDAO.obterClientes();
            view.mostrarClientes(clientes);
            view.limparCampos();

        } catch (IllegalArgumentException ex) {
            view.showDialog(ex.getMessage());
        } catch (Exception ex) {
            view.showDialog(ex.getMessage());
        }
    }
}
