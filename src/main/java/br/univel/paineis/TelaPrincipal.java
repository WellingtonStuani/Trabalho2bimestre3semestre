package br.univel.paineis;

import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class TelaPrincipal extends JFrame {

	
	private static final long serialVersionUID = 6580160254551557120L;

	private JPanel contentPane;

	private TelaImportacao importacao;
	private TelaCliente cadastroCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();

					
					frame.setVisible(true);

					
					frame.setSize(800, 600);

					
					frame.setLocationRelativeTo(null);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Cadastro");
		menuBar.add(mnNewMenu);

		JMenuItem mntmImportao = new JMenuItem("Cliente");
		mntmImportao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				

				if (cadastroCliente == null) {
					cadastroCliente = new TelaCliente();
				}

			}
		});
		mnNewMenu.add(mntmImportao);

		JMenu mnImportao = new JMenu("Importa\u00E7\u00E3o");
		menuBar.add(mnImportao);

		JMenuItem mntmImportarDados = new JMenuItem("Importar Dados");
		mntmImportarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			

				if (importacao == null) {
					importacao = new TelaImportacao();
					
				}

			}
		});
		mnImportao.add(mntmImportarDados);

		JMenu mnOramento = new JMenu("Or\u00E7amento");
		menuBar.add(mnOramento);

		JMenuItem mntmAdicionarOramento = new JMenuItem("Adcionar Or\u00E7amento");
		mnOramento.add(mntmAdicionarOramento);

		JMenuItem mntmPesquisarOramentos = new JMenuItem("Pesquisar Or\u00E7amentos");
		mnOramento.add(mntmPesquisarOramentos);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0 };
		gbl_contentPane.rowHeights = new int[] { 0 };
		gbl_contentPane.columnWeights = new double[] { Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);
	}
	
}
