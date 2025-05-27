package view;

import model.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class FormularioClientes extends JFrame {
    private JTextField txtNome, txtEmail;
    private JTextArea areaClientes;
    private JButton btnSalvar;

    public FormularioClientes() {
        setTitle("Cadastro de Clientes");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        JPanel painelForm = new JPanel(new GridLayout(3, 2));
        painelForm.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painelForm.add(txtNome);
        painelForm.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        painelForm.add(txtEmail);

        btnSalvar = new JButton("Salvar");
        painelForm.add(btnSalvar);

        add(painelForm, BorderLayout.NORTH);

        areaClientes = new JTextArea();
        areaClientes.setEditable(false);
        add(new JScrollPane(areaClientes), BorderLayout.CENTER);

        setVisible(true);
    }

    public void setBtnSalvarListener(ActionListener l) {
        btnSalvar.addActionListener(l);
    }

    public String getNome() {
        return txtNome.getText();
    }

    public String getEmail() {
        return txtEmail.getText();
    }

    public void mostrarClientes(List<Cliente> clientes) {
        StringBuilder sb = new StringBuilder();
        for (Cliente c : clientes) {
            sb.append(c).append("\n");
        }
        areaClientes.setText(sb.toString());
    }

    public void limparCampos() {
        txtNome.setText("");
        txtEmail.setText("");
        txtNome.requestFocus();
    }

    public void showDialog(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Aviso", JOptionPane.WARNING_MESSAGE);
    }
}
