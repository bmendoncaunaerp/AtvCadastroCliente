package controller;

import model.Cliente;
import model.ClienteSQLite;
import view.FormularioClientes;

import javax.swing.*;

public class FormularioClienteController {

    FormularioClientes view = new FormularioClientes();
    ClienteDAO clienteDAO = new ClienteSQLite();

    FormularioClienteController() {
        view.setBtnSalvarListener(e -> onCadastroClicked());
    }

    void onCadastroClicked(String nome, String email) {
        try {
            if (nome.isEmpty() || email.isEmpty()) {
                throw new IllegalArgumentException("Preencha todos os campos.");
            }

            Cliente cliente = new Cliente(nome, email);

            clienteDAO.salvar(cliente);
            view.updatePainel();

        } catch (IllegalArgumentException ex) {
            view.showDialog(ex.getMessage());
        } catch (Exception ex) {
            view.showDialog(ex.getMessage());
        }
    }

}
