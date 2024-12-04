package org.makermainds.jcoaching.resturantapp.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.makermainds.jcoaching.resturantapp.ResturantApp;
import org.makermainds.jcoaching.resturantapp.controller.MenuImporter;
import org.makermainds.jcoaching.resturantapp.controller.order.OrderManager;
import org.makermainds.jcoaching.resturantapp.controller.order.OrderProcessor;
import org.makermainds.jcoaching.resturantapp.model.Client;
import org.makermainds.jcoaching.resturantapp.model.Menu;
import org.makermainds.jcoaching.resturantapp.model.Resturant;
import org.makermainds.jcoaching.resturantapp.model.enums.Location;
import org.makermainds.jcoaching.resturantapp.model.order.Order;
import org.makermainds.jcoaching.resturantapp.model.order.OrderItem;
import org.makermainds.jcoaching.resturantapp.model.order.OrderItemSize;
import org.makermainds.jcoaching.resturantapp.model.product.Product;



public class ResturantAppGui {

	private static final String MENU_FILE_PATH = "/menu-file.txt";
	private JFrame frame;
	private JTable menuTable;
	private DefaultTableModel menuTableDefaultModel;
	private JTable orderItemTable;
	private DefaultTableModel orderItemTableModel = new DefaultTableModel();
	private JComboBox<String> orderItemSizeSelector;
	private JTextField quantityTextField;
	private JTextField inputNameTextField;
	private JTextField inputPhoneNumberTextField;
	private JRadioButton kosovoRadioButton;
	private JRadioButton germanyRadioButton;
	private JLabel invoiceLabel;
	
	

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResturantAppGui window = new ResturantAppGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ResturantAppGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.getContentPane().add(createOrderItemInputPanel());
		frame.getContentPane().add(createOrderPanel());
		frame.getContentPane().add(createOrderrButton());
		frame.getContentPane().add(createDeleteButton());
		frame.getContentPane().add(createInvoiceTabelPanel());
		frame.getContentPane().add(createRefreshButton());
		
	
	}
	private JPanel createOrderItemInputPanel() {
		JPanel inputOrderItemPanel = new JPanel();
		inputOrderItemPanel.setLayout(null);
		inputOrderItemPanel.setBounds(10, 10, 320, 350);
		inputOrderItemPanel.add(createOrderItemSizeSelector());
		inputOrderItemPanel.add(createQuantityInputLabel());
		inputOrderItemPanel.add(createQuantityTextField());
		inputOrderItemPanel.add(createAddButton());
		inputOrderItemPanel.add(createMenuTableScrollPane());
		
		
		return inputOrderItemPanel;
	}
	
	private JLabel createQuantityInputLabel() {
		JLabel quantityLabel = new JLabel("Quantity: ");
		quantityLabel.setBounds(10, 60, 100, 30);
		return quantityLabel;
		
		
	}
     private JTextField createQuantityTextField() {
	quantityTextField= new JTextField();
	quantityTextField.setBounds(70, 60, 100, 30);
	return quantityTextField;
	
}
     private JComboBox<String> createOrderItemSizeSelector(){
    	 orderItemSizeSelector = new JComboBox<String>();
    	 orderItemSizeSelector.setBounds(10, 10, 200, 30);
    	 for(OrderItemSize orderItemSize : OrderItemSize.values()) {
    		 orderItemSizeSelector.addItem(orderItemSize.name());
    	 }
    	 
    	 return orderItemSizeSelector;
    	 
     }
	
	private JScrollPane createMenuTableScrollPane() {
		
	    menuTableDefaultModel  = prepareMenuDataForTable();
		menuTable = new JTable(menuTableDefaultModel);
		
		JScrollPane scrollPane = new JScrollPane(menuTable);
		scrollPane.setBorder(BorderFactory.createTitledBorder("Resturant Menu"));
		scrollPane.setBounds(10, 100, 300, 250);
		return scrollPane;
	}
	private DefaultTableModel prepareMenuDataForTable() {
		
		DefaultTableModel menuTableModel = new DefaultTableModel();
		
		String[][] menuArray = createMenuArray();
		String[] tableHeader = {"ID", "Name" , "Price"};
		menuTableModel.setDataVector(menuArray, tableHeader);
		
		
		return menuTableModel;
	}

	private String[][] createMenuArray() {
		
		MenuImporter menuImporter = new MenuImporter();
		
		Menu menu = menuImporter.importMenu(MENU_FILE_PATH);
		
		
		HashMap<Integer, Product> menuItems = menu.getMenuItems();
		String[][] menuArray = new String[menuItems.size()][3];
		
		int i = 0;
		for(Entry<Integer, Product> menuItem : menuItems.entrySet()) {
			
			Product product = menuItem.getValue();
			
			menuArray[i][0] = Integer.toString(product.getProductId());
			menuArray[i][1] = product.getName();
			menuArray[i][2] = Double.toString(product.getPrice());
			i++;
		}
	
			
		return menuArray;
	}
	
	private JScrollPane createOrderItemTableScrollPane() {
		
		
		
		createOrderItemDataForTable();
		orderItemTable = new JTable(orderItemTableModel);
		JScrollPane jScrollPane = new JScrollPane(orderItemTable);
	
		
		//jScrollPane.add(orderItemTable);
		jScrollPane.setBorder(BorderFactory.createTitledBorder("Order Items"));
		jScrollPane.setBounds(10, 100, 400, 250);
		
		return jScrollPane;
		
	}
	private JPanel createOrderPanel() {
		JPanel orderPanel = new JPanel();
		orderPanel.setLayout(null);
		orderPanel.setBounds(370, 10, 450 , 350);
		orderPanel.add(createInputNameLabel());
		orderPanel.add(createNameInputTextField());
		orderPanel.add(createPhoneNumberInputTextField());
		orderPanel.add(createInputPhoneLabel());
		orderPanel.add(createOrderItemTableScrollPane());
		createRadioButtons(orderPanel);
		
		return orderPanel;
	}
	
	private JLabel createInputNameLabel() {
		JLabel inputNameLabel = new JLabel("Name: ");
		inputNameLabel.setBounds(10, 10, 100, 30);
		return inputNameLabel;
	}
	
	private JLabel createInputPhoneLabel() {
		JLabel inputPhoneNrLabel = new JLabel("TabelID: ");
		inputPhoneNrLabel.setBounds(10, 60, 100, 30);
		return inputPhoneNrLabel;
	}
	
	private JTextField createNameInputTextField() {
		inputNameTextField = new JTextField();
		inputNameTextField.setBounds(100, 10, 150, 30);
		return  inputNameTextField;
	}
	private JTextField createPhoneNumberInputTextField() {
		inputPhoneNumberTextField = new JTextField();
		inputPhoneNumberTextField.setBounds(100, 60, 150, 30);
		return inputPhoneNumberTextField;
	}

	private void createOrderItemDataForTable() {
		
		//orderItemTableModel = new DefaultTableModel();
		
		String[] columnNames = {"Id", "Name", "Price", "Quantity", " Item Size"};
		orderItemTableModel.setDataVector(null, columnNames);
	}

	private void createRadioButtons(JPanel contentPanel) {
		
		ButtonGroup locationButtonGroup = new ButtonGroup();
		
		kosovoRadioButton = new JRadioButton("Kosovo");
		germanyRadioButton = new JRadioButton("Germany");
		kosovoRadioButton.setBounds(300, 10, 100, 30);
		germanyRadioButton.setBounds(300, 50, 100, 30);
		
		kosovoRadioButton.setSelected(true);
		locationButtonGroup.add(kosovoRadioButton);
		locationButtonGroup.add(germanyRadioButton);
		
		contentPanel.add(kosovoRadioButton);
		contentPanel.add(germanyRadioButton);
		
	}
	
	private JButton createAddButton() {
		JButton addButton  = new JButton("Add");
		addButton.setBounds(190, 60, 60, 30);
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			 int selectedRow = menuTable.getSelectedRow();
			 if(selectedRow != -1 && isQuantityValid()) {
				 String[] orderItemData = new String[5];
				 orderItemData[0] = menuTable.getValueAt(selectedRow, 0).toString();
				 orderItemData[1] = menuTable.getValueAt(selectedRow, 1).toString();
				 orderItemData[2] = menuTable.getValueAt(selectedRow, 2).toString();
				 orderItemData[3] = quantityTextField.getText();
				 orderItemData[4] = (String) orderItemSizeSelector.getSelectedItem();
			 
			orderItemTableModel.addRow(orderItemData);
			quantityTextField.setText("");
			orderItemSizeSelector.setSelectedIndex(0);
			menuTable.clearSelection();
			
			 }
			 else {
				 JOptionPane.showMessageDialog(frame, "Please select a row to add");
				 
			 }
			}
		});
		
		
		return addButton;
	}
	
	private JButton createOrderrButton() {
		JButton order = new JButton("Order");
		order.setBounds(380, 400, 100, 40);
		order.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Resturant resturant = new Resturant("Route 66", " te heroinat, Prishtine");
				Client client = new Client(inputNameTextField.getText(), inputPhoneNumberTextField.getText());
			    OrderManager orderManager = new OrderManager();
			    Order order = new Order();
			    for(int i = 0; i < orderItemTableModel.getRowCount(); i++) {
			    	
			    	int id = Integer.valueOf(orderItemTableModel.getValueAt(i, 0).toString());
			    	String productName = orderItemTableModel.getValueAt(i, 1).toString();
			    	double productPrice = Double.valueOf(orderItemTableModel.getValueAt(i, 2).toString());
			    	Product product = new Product(id, productName, productPrice);
			    	int quantity = Integer.valueOf(orderItemTableModel.getValueAt(i, 3).toString());
			        OrderItemSize orderItemSize = getOrderItemSize(orderItemTableModel.getValueAt(i, 4).toString());
			       
			    	OrderItem orderItem = new OrderItem(product, quantity, orderItemSize);
			    	order.getOrderItems().add(orderItem);
			    	
			    }
			    
			    orderManager.getOrders().add(order);
			    OrderProcessor orderProcessor = new OrderProcessor();
			    orderProcessor.processOrder(client, resturant, order, Location.GERMANY);
				invoiceLabel.setText(orderProcessor.processOrder(client,resturant,order,getLocation()));
			}
			

		});
		
		return order;
	}
	

	private OrderItemSize getOrderItemSize(String string) {
		switch (string) {
			
		case "SMALL":
			return OrderItemSize.SMALL;
		case "MEDIUM":
			return OrderItemSize.MEDIUM;
		case "LARGE":
			return OrderItemSize.LARGE;
		case "XXL":
			return OrderItemSize.XXL;
			default:
				throw new IllegalArgumentException("Unexpected value: " + string);
	}
	
	}
	private Location getLocation() {
		if(kosovoRadioButton.isSelected()) {
			return Location.KOSOVO;
			 
		} else {
			return Location.GERMANY;
		}
	}
	
	private boolean isQuantityValid() {
		if(quantityTextField.getText().isBlank()) {
			JOptionPane.showMessageDialog(frame, "Please provide the quantity");
			return false;
		} else {
			if(quantityTextField.getText().matches("(0-9)")) {
				JOptionPane.showMessageDialog(frame, "The text in quantity field nuts contain only numbers.");
			}
			return true;
		}
	}
	
	private JButton createDeleteButton() {
		JButton deleteButton = new JButton("Delete");
		deleteButton.setBounds(510, 400, 100, 40);
		deleteButton.addActionListener(new ActionListent() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = orderItemTable.getSelectedRow();
				if(selectedRow == -1) {
					JOptionPane.showMessageDialog(deleteButton, "Select any row to delete");
					
				} else {
					orderItemTableModel.removeRow(selectedRow);
				}
				
			}
		});
		
		return deleteButton;
	}
	
	private JPanel createInvoiceTabelPanel() {
		JPanel invoicePanel = new JPanel();
		invoicePanel.setLayout(null);
		invoicePanel.setBounds(830, 10, 320, 350);
		invoicePanel.setBorder(BorderFactory.createTitledBorder("Invoice"));
		invoicePanel.add(createInvoiceLabelScrollPane());
		return invoicePanel;
	}
	
	private JScrollPane createInvoiceLabelScrollPane() {
		invoiceLabel = new JLabel("The invoice will be printed here.");
		JScrollPane invoiceScrollPane = new JScrollPane(invoiceLabel);
		invoiceLabel.setBounds(20, 40, 250, 310);
		invoiceScrollPane.setBounds(10, 20, 300, 320);
		return invoiceScrollPane;
		
	}
	
	   private JButton createRefreshButton() {
		JButton refreshButton = new JButton("Refresh");
		refreshButton.setBounds(900, 400, 100, 40);
		refreshButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				inputNameTextField.setText("");
				inputPhoneNumberTextField.setText("");
				invoiceLabel.setText("The invoice will be printed here.");
				createOrderItemDataForTable();
			}
		});
		
		return refreshButton;
	}
}
