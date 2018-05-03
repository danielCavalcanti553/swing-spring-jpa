package com.springjframe.example.service;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjframe.example.model.Cliente;
import com.springjframe.example.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRep;
	
	
	public List<Cliente> listaDeClientes(){
		return clienteRep.findAll();
	}
	
	public void cadastrar(Cliente obj) {
		clienteRep.save(obj);
	}
	
	
	
	public JTable getTable() {
		
		JTable table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("NOME");
		model.addColumn("TELEFONE");
		
		for(Cliente cliente : listaDeClientes()){
			model.addRow(
				new Object[] {
					cliente.getId(),cliente.getNome(),cliente.getTelefone()});
		}
		table.setModel(model);
		return table;
	}
}
