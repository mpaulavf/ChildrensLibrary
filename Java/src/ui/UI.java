package ui;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import java.io.*;
import java.time.*;
import java.util.*;

import businessLogic.*;
import data.*;


public class UI extends JFrame{

	private static final long serialVersionUID = -6789065573941301335L;
	
	private WorkersCommands vldWrkrs;
	private SearchEngine books;
	
	private JPanel mainPanel;
	private JPanel workersPanel;
	private JPanel childrensPanel;
	private JPanel addBookPanel;
	private JPanel addBookFromCodePanel;

	private JLabel lblWelcomeLabel;
	
	private JButton btnIncomeWorkers;
	private JButton btnIncomeChildren;
	private JButton btnExit;
	private JPanel searchPanel;
	
	
	public UI(TreeMap<String, String> vldWrkrs, TreeSet<Book> books) {
		setupMainPanel();
		this.pack();
		this.setSize(1000, 500);
		this.setLocationRelativeTo(null);
		this.setTitle("ChildrensLibrary");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void startComponents() {
		setupMainPanel();
		setupChildrensPanel();
		setupWorkersPanel();
	}
	
	public void setupMainPanel() {
		
		mainPanel = new JPanel();
		mainPanel.setBackground(new Color(163, 213, 209));
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		getContentPane().add(mainPanel);
		
		JPanel panelUp = new JPanel();
		mainPanel.add(panelUp, BorderLayout.NORTH);
		panelUp.setBackground(new Color(23, 146, 164));
		panelUp.setLayout(new BorderLayout(0, 0));
		
		lblWelcomeLabel = new JLabel("Bienvenido a la biblioteca infantil");
		lblWelcomeLabel.setBackground(new Color(174, 214, 241));
		lblWelcomeLabel.setFont(new Font("Forte", Font.BOLD, 40));
		lblWelcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelUp.add(lblWelcomeLabel, BorderLayout.NORTH);
		
		JPanel panelCenter = new JPanel();
		mainPanel.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setBackground(new Color(200, 229, 227));
		
		btnIncomeChildren = new JButton("Buscar un libro");
		btnIncomeChildren.setFont(new Font("Forte", Font.PLAIN, 20));
		btnIncomeChildren.setBackground(new Color(23, 146, 164));
		btnIncomeChildren.setBounds(364, 119, 270, 91);
		btnIncomeChildren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				remove(mainPanel);
				setupChildrensPanel();
				pack();
			}
		});
		panelCenter.setLayout(new BorderLayout(0, 0));
		panelCenter.setBorder( BorderFactory.createEmptyBorder(170,320,150,370) );
		panelCenter.add(btnIncomeChildren, BorderLayout.CENTER);
		
		JPanel panelDown = new JPanel();
		mainPanel.add(panelDown, BorderLayout.SOUTH);
		panelDown.setBackground(new Color(163, 213, 209));
		
		btnIncomeWorkers = new JButton("Ingreso para trabajadores");
		btnIncomeWorkers.setFont(new Font("Forte", Font.PLAIN, 15));
		btnIncomeWorkers.setBackground(new Color(23, 146, 164));
		btnIncomeWorkers.setHorizontalAlignment(SwingConstants.LEFT);
		btnIncomeWorkers.setVerticalAlignment(SwingConstants.BOTTOM);
		panelDown.add(btnIncomeWorkers);
		btnIncomeWorkers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				remove(mainPanel);
				setupWorkersPanel();
				pack();
			}
		});
		
		btnExit = new JButton("Salir");
		btnExit.setFont(new Font("Forte", Font.PLAIN, 15));
		btnExit.setBackground(new Color(23, 146, 164));
		btnExit.setHorizontalAlignment(SwingConstants.RIGHT);
		panelDown.add(btnExit);
	
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
	}

	public void setupChildrensPanel() {
		
		childrensPanel = new JPanel();
		childrensPanel.setSize(1000, 500);
		childrensPanel.setBackground(new Color(200, 229, 227));
		childrensPanel.setLayout(new BorderLayout(0,0));
		childrensPanel.setBorder(new EmptyBorder(100, 100, 70, 100));
		
		JButton btnBack = new JButton("Volver");
		btnBack.setForeground(new Color(49, 79, 79));
		btnBack.setFont(new Font("Cooper Black", Font.PLAIN, 13));
		childrensPanel.add(btnBack, BorderLayout.PAGE_END);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(childrensPanel);
				setupMainPanel();	
				pack();
			}
		});
		
		JTextField textField = new JTextField();
		textField.setText("Ingresa aqu� el nombre del libro o autor");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(30);
		childrensPanel.add(textField, BorderLayout.NORTH);
		
		JPanel searchOptionsPanel = new JPanel();
		searchOptionsPanel.setBackground(new Color(200, 229, 227));
		childrensPanel.add(searchOptionsPanel, BorderLayout.CENTER);
		searchOptionsPanel.setLayout(new BorderLayout(0,0));
		searchOptionsPanel.setBorder(new EmptyBorder(10, 10, 0, 10));
		
		JPanel chckBxPanel = new JPanel();
		chckBxPanel.setBackground(new Color(200, 229, 227));
		searchOptionsPanel.add(chckBxPanel, BorderLayout.CENTER);
		GridBagLayout grdBgLytPanel = new GridBagLayout();
		grdBgLytPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		grdBgLytPanel.rowHeights = new int[]{0, 0, 0, 0};
		grdBgLytPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		grdBgLytPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		chckBxPanel.setLayout(grdBgLytPanel);
		
		JCheckBox chckbxAventura = new JCheckBox("Aventura");
		chckbxAventura.setBackground(new Color(200, 229, 227));
		GridBagConstraints gbc_chckbxAv = new GridBagConstraints();
		gbc_chckbxAv.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxAv.gridx = 5;
		gbc_chckbxAv.gridy = 0;
		chckBxPanel.add(chckbxAventura, gbc_chckbxAv);
		
		JCheckBox chckbxAccin = new JCheckBox("Acci�n");
		chckbxAccin.setBackground(new Color(200, 229, 227));
		GridBagConstraints gbc_chckbxAc = new GridBagConstraints();
		gbc_chckbxAc.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxAc.gridx = 5;
		gbc_chckbxAc.gridy = 1;
		chckBxPanel.add(chckbxAccin, gbc_chckbxAc);
		
		JCheckBox chckbxCuento = new JCheckBox("Cuento");
		chckbxCuento.setBackground(new Color(200, 229, 227));
		GridBagConstraints gbc_chckbxC = new GridBagConstraints();
		gbc_chckbxC.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxC.gridx = 1;
		gbc_chckbxC.gridy = 0;
		chckBxPanel.add(chckbxCuento, gbc_chckbxC);
		
		JCheckBox chckbxDisney = new JCheckBox("Disney");
		chckbxDisney.setBackground(new Color(200, 229, 227));
		GridBagConstraints gbc_chckbxD = new GridBagConstraints();
		gbc_chckbxD.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxD.gridx = 5;
		gbc_chckbxD.gridy = 2;
		chckBxPanel.add(chckbxDisney, gbc_chckbxD);
		
		JCheckBox chckbxMitosYLeyendas = new JCheckBox("Mitos y leyendas");
		chckbxMitosYLeyendas.setBackground(new Color(200, 229, 227));
		GridBagConstraints gbc_chckbxMyl = new GridBagConstraints();
		gbc_chckbxMyl.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxMyl.gridx = 1;
		gbc_chckbxMyl.gridy = 2;
		chckBxPanel.add(chckbxMitosYLeyendas, gbc_chckbxMyl);
		
		JCheckBox chckbxFbula = new JCheckBox("F�bula");
		chckbxFbula.setBackground(new Color(200, 229, 227));
		GridBagConstraints gbc_chckbxF = new GridBagConstraints();
		gbc_chckbxF.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxF.gridx = 1;
		gbc_chckbxF.gridy = 1;
		chckBxPanel.add(chckbxFbula, gbc_chckbxF);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(200, 229, 227));
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscar.gridx = 3;
		gbc_btnBuscar.gridy = 1;
		chckBxPanel.add(btnBuscar, gbc_btnBuscar);
		btnBuscar.setForeground(new Color(49, 79, 79));
		btnBuscar.setFont(new Font("Cooper Black", Font.PLAIN, 13));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if ((chckbxFbula.isSelected() == false) &&
						(chckbxAccin.isSelected() == false) &&
						(chckbxAventura.isSelected() == false) &&
						(chckbxCuento.isSelected() == false) &&
						(chckbxDisney.isSelected() == false) &&
						(chckbxMitosYLeyendas.isSelected() == false) && 
						(textField.getText().isEmpty())) {
						childrensPanel.removeAll();
						remove(childrensPanel);
						setupMainPanel();
						JOptionPane.showMessageDialog(null, "No seleccionaste ninguna busqueda", "Aviso buscar libro", JOptionPane.WARNING_MESSAGE);
					}
					ArrayList<String> genres = new ArrayList<String>();
					if (chckbxFbula.isSelected()) genres.add(chckbxFbula.getText());
					if (chckbxAccin.isSelected()) genres.add(chckbxAccin.getText());
					if (chckbxAventura.isSelected()) genres.add(chckbxAventura.getText());
					if (chckbxCuento.isSelected()) genres.add(chckbxCuento.getText());
					if (chckbxDisney.isSelected()) genres.add(chckbxDisney.getText());
					if (chckbxMitosYLeyendas.isSelected()) genres.add(chckbxMitosYLeyendas.getText());
					Search search = new Search(textField.getText(), genres);
					childrensPanel.removeAll();
					remove(childrensPanel);
					setupSearchPanel(search);
					pack();
				} catch (Exception e1) {
					childrensPanel.removeAll();
					remove(childrensPanel);
					setupMainPanel();
					JOptionPane.showMessageDialog(null, "No hay libros disponibles", "Aviso buscar libro", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		getContentPane().add(childrensPanel);
		
	}
	
	protected void setupSearchPanel(Search search) {
		
		SearchEngine srchEn = new SearchEngine(search);
		
		searchPanel = new JPanel();
		searchPanel.setSize(1000, 500);
		searchPanel.setBackground(new Color(200, 229, 227));
		searchPanel.setLayout(new BorderLayout(0,0));
		
		JScrollPane scrllView = new JScrollPane();
		System.out.println(srchEn.getBooksByGenres().size());
		
		for(Book book: Core.getBooks()) {
			System.out.println(book.getGenre());
		}
		JList<JPanel> list = new JList<JPanel>();
		for (Book book: srchEn.getBooksByGenres()) {
			String genresString1 = "";
			for (String genre: search.getGenres()) {
				genresString1 = genresString1+ genre+ ",";
			}
			final String genresString = genresString1;
			JPanel tempPanel = new JPanel();
			tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.X_AXIS));
			JLabel tempLabel = new JLabel();
			//tempLabel.setIcon(new ImageIcon(book.getPicturePath()));
			tempLabel.setText("<html>T�tulo: "+book.getName()+"<BR>"
							+"Escrito por: "+book.getAuthorName()+"<BR>"
							+"G�nero(s): "+genresString+"</html>");
			tempPanel.add(tempLabel);
			JButton tempButton = new JButton("Mira este libro");
			tempPanel.add(tempButton);
			tempButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					/*
					JOptionPane showBook = new JOptionPane("<html>T�tulo: "+book.getName()+"<BR>"
															+"Escrito por: "+book.getAuthorName()+"<BR>"
															+"G�nero(s): "+genresString+"<BR>"
															+"</html>",
															JOptionPane.INFORMATION_MESSAGE,
															JOptionPane.DEFAULT_OPTION,											
															//new ImageIcon(book.getPicture()));
					JOptionPane.showMessageDialog(searchPanel, showBook.getMessage(), book.getName(), showBook.getMessageType(), showBook.getIcon()));
					
					 */
				}
			});


			list.add(tempPanel);
			
			JButton btnSelec = new JButton("Seleccionar este libro");
			tempPanel.add(btnSelec);
			btnSelec.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LocalDate today = LocalDate.now();
					User user = new User(today, null);
					String temp = user.plusTwoWeeks(today);
					int dialogButton = JOptionPane.YES_NO_OPTION;
					JOptionPane.showConfirmDialog(null, temp, "Aviso de tiempo del libro", dialogButton);
		            if(dialogButton == JOptionPane.YES_OPTION) {
		                System.exit(0);
		                if(dialogButton == JOptionPane.NO_OPTION) {
		                	remove(searchPanel);
		                	setupSearchPanel(search);
		                	pack();
		              	}
		            }
				}
			});
			
			JButton btnAgain = new JButton("Volver a buscar");
			tempPanel.add(btnAgain);
			btnAgain.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					remove(tempPanel);
					remove(searchPanel);
					setupChildrensPanel();
					pack();
				}
			});
			
		}
		scrllView.add(list);
		
		getContentPane().add(searchPanel);
		
	}

	public void setupWorkersPanel() {

		workersPanel = new JPanel();
		workersPanel.setBackground(new Color(246, 245, 245));
		workersPanel.setLayout(new GridLayout(10,1));

		JLabel lblIn = new JLabel("Ingresar al sistema");
		lblIn.setFont(new Font("Tahoma",Font.PLAIN,25));
		this.workersPanel.add(lblIn);

		JLabel lblId = new JLabel("Id del trabajador");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		this.workersPanel.add(lblId);
		final JTextField txtId = new JTextField();
		txtId.setColumns(25);
		this.workersPanel.add(txtId);

		JLabel lblContrasena = new JLabel("Contrase�a");
		lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 13));
		this.workersPanel.add(lblContrasena);
		final JPasswordField jpf = new JPasswordField(20);
		jpf.setEchoChar('*');
		this.workersPanel.add(jpf);		

		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnIngresar.setBackground(new Color(145, 196, 112));
		this.workersPanel.add(btnIngresar);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vldWrkrs = new WorkersCommands();
				String pw = "";
				for (char x : jpf.getPassword()) {
					pw = pw + x;
				}
				final String fpw = pw;
				Worker w = new Worker(txtId.getText(), fpw);
				try {
					if(vldWrkrs.login(txtId.getText(), w.getPassword())) {
						remove(workersPanel);
						setupOptionsWorkerPanel(vldWrkrs);
						pack();
					}
				} catch (Exception e1) {
					txtId.setText("");
					jpf.setText("");
					JOptionPane.showMessageDialog(null, "Su usuario o contrase�a no corresponden al sistema", "Aviso trabajador", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		JButton btnBack = new JButton("Volver");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setBackground(new Color(239, 147, 146));
		this.workersPanel.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(workersPanel);
				setupMainPanel();	
				pack();
			}
		});
	
		this.getContentPane().add(workersPanel);
		
	}
	
	protected void setupOptionsWorkerPanel(WorkersCommands wrkrsCmd) {
		
		JPanel optionsWorkersPanel = new JPanel();
		optionsWorkersPanel.setBackground(new Color(246, 245, 245));
		optionsWorkersPanel.setLayout(new GridLayout(5, 1));
		
		JButton btnAddInfo = new JButton("Agregar un libro con c�digo");
		btnAddInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAddInfo.setBackground(new Color(163, 213, 209));
		btnAddInfo.setVerticalAlignment(SwingConstants.CENTER);
		optionsWorkersPanel.add(btnAddInfo);
		btnAddInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(optionsWorkersPanel);
				setupAddBookFromCode(wrkrsCmd);
				pack();
			}
		});
		
		
		JButton btnAddBook = new JButton("Agregar nuevo libro");
		btnAddBook.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAddBook.setBackground(new Color(145, 196, 112));
		btnAddBook.setVerticalAlignment(SwingConstants.CENTER);
		optionsWorkersPanel.add(btnAddBook);
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(optionsWorkersPanel);
				setupAddBook(wrkrsCmd);
				pack();
			}
		});
		
		JButton btnEnd = new JButton("Cerrar Sesi�n");
		btnEnd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEnd.setBackground(new Color(239, 147, 146));
		btnEnd.setVerticalAlignment(SwingConstants.CENTER);
		optionsWorkersPanel.add(btnEnd);
		btnEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(optionsWorkersPanel);
				setupMainPanel();
				pack();
			}
		}); 
		
		this.getContentPane().add(optionsWorkersPanel);
		
	}
	
	public void setupAddBookFromCode(WorkersCommands wrkrsCmd) {
			
		addBookFromCodePanel = new JPanel();
		addBookFromCodePanel.setBackground(new Color(246, 245, 245));
		addBookFromCodePanel.setLayout(new GridLayout(17,1));
		
		JLabel lblIn = new JLabel("Ingresar libro al sistema");
		lblIn.setFont(new Font("Tahoma",Font.PLAIN,25));
		addBookFromCodePanel.add(lblIn);

		addBookFromCodePanel.add(new JLabel("Codigo"));
		final JTextField txtCode = new JTextField();
		txtCode.setColumns(25);
		addBookFromCodePanel.add(txtCode);

		addBookFromCodePanel.add(new JLabel("Direcciones"));
		final JTextField txtDirection = new JTextField();
		txtDirection.setColumns(25);
		addBookFromCodePanel.add(txtDirection);
		
		JButton btnAddPic = new JButton("Cargar imagen del libro");
		btnAddPic.setBackground(new Color(232, 232, 231));
		addBookFromCodePanel.add(btnAddPic);
		JLabel lblPic = new JLabel();
		addBookFromCodePanel.add(lblPic);
		btnAddPic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc;
				FileNameExtensionFilter filterPic = new FileNameExtensionFilter("JPEG, JPG, & PNG", "jpeg", "jpg", "png");
				String temp;
				try {
					jfc = new JFileChooser();
					jfc.setFileFilter(filterPic);
	                int aux = jfc.showOpenDialog(null);
	                File picChoose = jfc.getSelectedFile();
	                temp = picChoose.getPath();
	                if(aux == JFileChooser.APPROVE_OPTION) {
	                	lblPic.setText(temp);
	                }
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "La imagen no fue encontrada", "Error imagen", JOptionPane.ERROR_MESSAGE);
                }
			}
		});

		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnIngresar.setBackground(new Color(145, 196, 112));
		addBookFromCodePanel.add(btnIngresar);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BufferedImage pic = null;
				try {
					if(lblPic.getText().isEmpty() == false) {
						ImageIcon tempPic = new ImageIcon(lblPic.getText());
		            	pic = new BufferedImage(tempPic.getIconWidth(), tempPic.getIconHeight(), BufferedImage.TYPE_INT_RGB);
					}
					LibraryFeedbackSimulator lFS = new LibraryFeedbackSimulator();
					File bookFile = lFS.askForBookFile(txtCode.getText());
					Book book = wrkrsCmd.infoBook(bookFile);
					System.out.println(book.getAuthorName());
					System.out.println(txtDirection.getText());
					//wrkrsCmd.addDirections(book, txtDirection.getText());
					//wrkrsCmd.addPicture(book, pic);
					Core.addBook(book);
				} catch (Exception e1) {
					txtCode.setText("");
					txtDirection.setText("");
					pic = null;
					JOptionPane.showMessageDialog(null, "Los datos ingresados del libro no son compatibles", "Error libro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton btnAnterior = new JButton("Volver al menu anterior");
		btnAnterior.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAnterior.setBackground(new Color(253, 253, 150));
		addBookFromCodePanel.add(btnAnterior);
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(addBookFromCodePanel);
				setupOptionsWorkerPanel(wrkrsCmd);
				pack();
			}
		});
		
		JButton btnBack = new JButton("Volver al menu principal");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setBackground(new Color(163, 213, 209));
		addBookFromCodePanel.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(addBookFromCodePanel);
				setupMainPanel();
				pack();
			}
		});
		
		JButton btnCloseAll = new JButton("Terminar");
		btnCloseAll.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCloseAll.setBackground(new Color(239, 147, 146));
		addBookFromCodePanel.add(btnCloseAll);
		btnCloseAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	
		getContentPane().add(addBookFromCodePanel);


	}

	public void setupAddBook(WorkersCommands wrkrsCmd) {
		
		addBookPanel = new JPanel();
		addBookPanel.setBackground(new Color(246, 245, 245));
		addBookPanel.setLayout(new GridLayout(17,1));
		
		JLabel lblIn = new JLabel("Ingresar libro al sistema");
		lblIn.setFont(new Font("Tahoma",Font.PLAIN,25));
		addBookPanel.add(lblIn);

		addBookPanel.add(new JLabel("Nombre"));
		final JTextField txtName = new JTextField();
		txtName.setColumns(25);
		addBookPanel.add(txtName);

		addBookPanel.add(new JLabel("Codigo"));
		final JTextField txtCode = new JTextField();
		txtCode.setColumns(25);
		addBookPanel.add(txtCode);
		
		addBookPanel.add(new JLabel("Nombre del autor"));
		final JTextField txtAuthorName = new JTextField();
		txtAuthorName.setColumns(25);
		addBookPanel.add(txtAuthorName);
		
		addBookPanel.add(new JLabel("Genero"));
		final JTextField txtGenre = new JTextField();
		txtGenre.setColumns(25);
		addBookPanel.add(txtGenre);
		ArrayList<String> genres = new ArrayList<String>();

		addBookPanel.add(new JLabel("Direcciones"));
		final JTextField txtDirection = new JTextField();
		txtDirection.setColumns(25);
		addBookPanel.add(txtDirection);
		
		JButton btnAddPic = new JButton("Cargar imagen del libro");
		btnAddPic.setBackground(new Color(232, 232, 231));
		addBookPanel.add(btnAddPic);
		JLabel lblPic = new JLabel();
		addBookPanel.add(lblPic);
		btnAddPic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc;
				FileNameExtensionFilter filterPic = new FileNameExtensionFilter("JPEG, JPG, & PNG", "jpeg", "jpg", "png");
				String temp;
				try {
					jfc = new JFileChooser();
					jfc.setFileFilter(filterPic);
	                	int aux = jfc.showOpenDialog(null);
		                File picChoose = jfc.getSelectedFile();
		                temp = picChoose.getPath();
		                if(aux == JFileChooser.APPROVE_OPTION) {
	                	lblPic.setText(temp);
	        		        }
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "La imagen no fue encontrada", "Error imagen", JOptionPane.ERROR_MESSAGE);
               	}
			}
		});

		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnIngresar.setBackground(new Color(145, 196, 112));
		addBookPanel.add(btnIngresar);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BufferedImage pic = null;
				try {
					if(lblPic.getText().isEmpty() == false) {
						ImageIcon tempPic = new ImageIcon(lblPic.getText());
		            	pic = new BufferedImage(tempPic.getIconWidth(), tempPic.getIconHeight(), BufferedImage.TYPE_INT_RGB);
					}
					/*
					Scanner aux = new Scanner(txtGenre.getText());
					aux.useDelimiter(",");
					while(aux.hasNext()) {
						String genre = aux.next().trim();
						genres.add(genre);
					}
					aux.close();

					 */
					//Book b = new Book(txtName.getText(), txtCode.getText(), txtAuthorName.getText());
					//books.everyBook.add(b);
				} catch (Exception e1) {
					txtName.setText("");
					txtCode.setText("");
					txtAuthorName.setText("");
					txtGenre.setText("");
					txtDirection.setText("");
					pic = null;
					JOptionPane.showMessageDialog(null, "Los datos ingresados del libro no son compatibles", "Error libro", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton btnAnterior = new JButton("Volver al menu anterior");
		btnAnterior.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAnterior.setBackground(new Color(253, 253, 150));
		addBookPanel.add(btnAnterior);
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(addBookFromCodePanel);
				setupOptionsWorkerPanel(wrkrsCmd);
				pack();
			}
		});
		
		
		JButton btnBack = new JButton("Volver al menu principal");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setBackground(new Color(163, 213, 209));
		addBookPanel.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove(addBookPanel);
				setupMainPanel();
				pack();
			}
		});
		
		JButton btnCloseAll = new JButton("Terminar");
		btnCloseAll.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCloseAll.setBackground(new Color(239, 147, 146));
		addBookPanel.add(btnCloseAll);
		btnCloseAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	
		getContentPane().add(addBookPanel);
	}

}