package com.springjframe.example.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springjframe.example.model.Cliente;
import com.springjframe.example.service.ClienteService;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@Component
public class NovoClientePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txNome;
	private JTextField txTelefone;

	@Autowired
	private ClienteService clienteService;
	
	public NovoClientePanel() {
		setLayout(null);
		
		JLabel lblCadastroDeClientes = new JLabel("CADASTRO DE CLIENTES");
		lblCadastroDeClientes.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCadastroDeClientes.setBounds(77, 28, 281, 24);
		add(lblCadastroDeClientes);
		
		txNome = new JTextField();
		txNome.setBounds(137, 76, 202, 24);
		add(txNome);
		txNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(58, 76, 69, 24);
		add(lblNome);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelefone.setBounds(58, 111, 69, 24);
		add(lblTelefone);
		
		txTelefone = new JTextField();
		txTelefone.setColumns(10);
		txTelefone.setBounds(137, 111, 202, 24);
		add(txTelefone);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Cliente obj = new Cliente();
				obj.setId(null);
				obj.setNome(txNome.getText());
				obj.setTelefone(txTelefone.getText());
				
				clienteService.cadastrar(obj);
				
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
			}
		});
		btnNewButton.setBounds(137, 146, 119, 30);
		add(btnNewButton);

	}
}
