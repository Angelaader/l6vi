package ee.ut.math.tvt.salessystem.ui.tabs;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
	
	
    private JTextField idField;
  private JButton addItem;
  private JButton addNewProductButton;
  private Long id;

  private JTextField quantity;
  private JTextField nameField;
  private JTextField priceField;
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
			final JFrame f1 = new JFrame();
			Container contentPane = f1.getContentPane();
			JPanel c = new JPanel();
			c.setLayout(new GridLayout(2, 7));
			final GridBagConstraints gc = new GridBagConstraints();
			
			
			
		
			JButton cancel = new JButton("Cancel");
			cancel.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					f1.dispose();

				}
			});
			c.add(cancel);


			c.add( new JLabel("Id,"));
			final JTextField id = new JTextField();
			c.add(id);
			c.add(new JLabel("Name,"));
			final JTextField nameField = new JTextField();
			c.add(nameField);
			c.add(new JLabel("Price,"));
			final JTextField priceField = new JTextField();
			c.add(priceField);
			
			
			
			c.add(new JLabel("Description,"));
			final JTextField description = new JTextField();
			c.add(description);	
		
			c.add(new JLabel("Quantity"));
			final JTextField quantity = new JTextField();
			c.add(quantity);
			
			
			
			
			
			//f1.add(descriptionField);

	      
	        
			JButton addNewProductButton = new JButton("Add new Product");
			
			c.add(addNewProductButton);
			addNewProductButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					final StockItem newProduct = new StockItem(Long.parseLong(idField.getText()),
							nameField.getText(), 
							descriptionLabel.getText(), 
							Double.parseDouble(priceField.getText()),
							Integer.parseInt(quantity.getText())
							);
					
					model.getWarehouseTableModel().addItem(newProduct);
					f1.dispose();
					confirmTransaction(true);
					
					
				}
				
				
				private void confirmTransaction(boolean b) {
					// TODO Auto-generated method stub
					
				}
				
			});
	        
	       
	        
	        
	       f1.add(c);
	        
			f1.setSize(900,300);
			f1.setVisible(true);
			GridBagLayout gb = new GridBagLayout();    
			
			gc.fill = GridBagConstraints.HORIZONTAL;
			gc.anchor = GridBagConstraints.NORTH;
			gc.gridwidth = GridBagConstraints.REMAINDER;
			gc.fill = GridBagConstraints.BOTH;  
			f1.setLayout(gb);    
			
			
				
		
			
		}

		
	});
	return b;
}

  protected void AddButtonClicked() {
	// TODO Auto-generated method stub
	
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
  public void update() {
		model.getWarehouseTableModel();
	}
}
