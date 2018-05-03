package com.springjframe.example;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import com.springjframe.example.view.ListClienteJpanel;
import com.springjframe.example.view.NovoClientePanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SpringBootApplication
public class Application extends JFrame implements CommandLineRunner {
	
	public Application() {
	}
	
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	@Autowired
	private NovoClientePanel novoClientePanel;
	
	@Autowired
	private ListClienteJpanel listClienteJpanel;	

	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).headless(false).run(args);
	}
	
	public void init() {
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 getNovoCadastro();
			}
		});
		mnCadastro.add(mntmCliente);
		
		JMenu mnRelatrio = new JMenu("Relatório");
		menuBar.add(mnRelatrio);
		
		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getListCliente();
			}
		});
		mnRelatrio.add(mntmClientes);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);
	}




	@Override
	public void run(String... arg0) throws Exception {
		init();
	}
	
	public void getNovoCadastro() {
		
		setContentPane(novoClientePanel);
		revalidate();
		repaint();
	}
	
	public void getListCliente() {
		
		setContentPane(listClienteJpanel);
		revalidate();
		repaint();
	}

}
