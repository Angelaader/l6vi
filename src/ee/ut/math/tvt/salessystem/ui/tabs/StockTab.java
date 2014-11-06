package ee.ut.math.tvt.salessystem.ui.tabs;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;



public class StockTab {
	private Long id;

	private JTextField descriptionField;
    private JTextField quantityField;
    private JTextField nameField;
    private JTextField priceField;
    private JTextField idField;
  private JButton addItem;
  private JTextField descriptionLabel;
  private SalesSystemModel model;
  public StockTab(SalesSystemModel model) {
    this.model = model;
  }
  // warehouse stock tab - consists of a menu and a table
  public Component draw() {
    JPanel panel = new JPanel();
    panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    GridBagLayout gb = new GridBagLayout();
    GridBagConstraints gc = new GridBagConstraints();
    panel.setLayout(gb);
    gc.fill = GridBagConstraints.HORIZONTAL;
    gc.anchor = GridBagConstraints.NORTH;
    gc.gridwidth = GridBagConstraints.REMAINDER;
    gc.weightx = 1.0d;
    gc.weighty = 0d;
    panel.add(drawStockMenuPane(), gc);
    gc.weighty = 1.0;
    gc.fill = GridBagConstraints.BOTH;
    panel.add(drawStockMainPane(), gc);
    return panel;
  }
  // warehouse menu
  private Component drawStockMenuPane() {
    JPanel panel = new JPanel();
    GridBagConstraints gc = new GridBagConstraints();
    GridBagLayout gb = new GridBagLayout();
    panel.setLayout(gb);
    gc.anchor = GridBagConstraints.NORTHWEST;
	gc.weightx = 0;
	addItem = createAddButton();
	gc.gridwidth = GridBagConstraints.RELATIVE;
	gc.weightx = 1.0;
	panel.add(addItem, gc);
	panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	return panel;
}

// Creates the button "Add"
private JButton createAddButton() {
	JButton b = new JButton("Add");
	b.addActionListener(new ActionListener() {	
		public void actionPerformed(ActionEvent e) {
			AddButtonClicked();
			JFrame f1 = new JFrame();
			Container contentPane = f1.getContentPane();
			final GridBagConstraints gc = new GridBagConstraints();
			
			JButton addNewProductButton = new JButton("Add new Product");
			

			JButton cancelButton = new JButton("Cancel");
			
			JLabel idLabel = new JLabel("Id,");
			JLabel nameLabel = new JLabel("Name,");
			final JLabel descriptionLabel = new JLabel("Description,");
			JLabel priceLabel = new JLabel("Price,");
			JLabel quantityLabel = new JLabel("Quantity,");
			
			f1.getContentPane().add(cancelButton);
			f1.getContentPane().add(addNewProductButton);
			f1.getContentPane().add(idLabel);
			f1.getContentPane().add(nameLabel);
			f1.getContentPane().add(priceLabel);
			f1.getContentPane().add(quantityLabel);
			
			idField= new JTextField(10);
			
			f1.add(idField );
			//descriptionField = new JTextField(10);
			//descriptionField.setEditable(true);
			
			
			//f1.add(descriptionField);

	        quantityField = new JTextField(10);
	        f1.getContentPane().add(quantityField);
	        
	        nameField = new JTextField(10);
	       
	        
	        	        
	        nameField.setEditable(true);
	        
	        
	       f1.add( nameField);
	        priceField = new JTextField(10);
	        priceField.setEditable(true);
	      
	        
	        f1.add(priceField );

	        
	       
	        
	        
	       
	        
			f1.setSize(900,300);
			f1.setVisible(true);
			GridBagLayout gb = new GridBagLayout();    
			
			gc.fill = GridBagConstraints.HORIZONTAL;
			gc.anchor = GridBagConstraints.NORTH;
			gc.gridwidth = GridBagConstraints.REMAINDER;
			gc.fill = GridBagConstraints.BOTH;  
			f1.setLayout(gb);    
			
			addNewProductButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					final StockItem newProduct = new StockItem(Long.parseLong(idField.getText()),
							nameField.getText(), 
							descriptionLabel.getText(), 
							Double.parseDouble(priceField.getText()),
							Integer.parseInt(quantityField.getText())
							);
					//model.getDomainController().addStock(newProduct);
					model.getWarehouseTableModel().addItem(newProduct);
					
					confirmTransaction(true);
				}

				private void confirmTransaction(boolean b) {
					// TODO Auto-generated method stub
					
				}
				
			});
			
		}

		private void AddButtonClicked() {
			// TODO Auto-generated method stub
		}
	});
	return b;
}

  // table of the wareshouse stock
  private Component drawStockMainPane() {
    JPanel panel = new JPanel();
    JTable table = new JTable(model.getWarehouseTableModel());
    JTableHeader header = table.getTableHeader();
    header.setReorderingAllowed(false);
    JScrollPane scrollPane = new JScrollPane(table);
    GridBagConstraints gc = new GridBagConstraints();
    GridBagLayout gb = new GridBagLayout();
    gc.fill = GridBagConstraints.BOTH;
    gc.weightx = 1.0;
    gc.weighty = 1.0;
    
   
    panel.setLayout(gb);
    panel.add(scrollPane, gc);
    panel.setBorder(BorderFactory.createTitledBorder("Warehouse status"));
    return panel;
  }
}
