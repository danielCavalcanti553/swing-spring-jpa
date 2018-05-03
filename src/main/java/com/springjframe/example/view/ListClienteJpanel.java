package com.springjframe.example.view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springjframe.example.service.ClienteService;

@Component
public class ListClienteJpanel extends JPanel  implements CommandLineRunner{

	private static final long serialVersionUID = 1L;

	DefaultTableModel model;
	JScrollPane scrollPane;
	JPanel panel;
	@Autowired
	private ClienteService clienteService;
	
	@Override
	public void run(String... args) throws Exception {
	
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				getNewTable();
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});

		setLayout(null);
		
		JLabel lblListaDeClientes = new JLabel("LISTA DE CLIENTES");
		lblListaDeClientes.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblListaDeClientes.setBounds(10, 21, 281, 24);
		add(lblListaDeClientes);
		
		panel = new JPanel();
		
		panel.setBounds(10, 56, 402, 155);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		
		scrollPane.setViewportView(clienteService.getTable());
	
		
	}
	
	void getNewTable() {
		scrollPane.setViewportView(clienteService.getTable());
	}

}
