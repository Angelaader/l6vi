package ee.ut.math.tvt.salessystem.ui.tabs;

import java.awt.Component;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JTable;

import ee.ut.math.tvt.salessystem.ui.model.PurchaseInfoTableModel;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;

/**
 * Encapsulates everything that has to do with the purchase tab (the tab
 * labelled "History" in the menu).
 */
public class HistoryTab {
	
	SalesSystemModel model;
	PurchaseInfoTableModel purchase;
	JTable soldItemTable;
	JTable purchasesTable;
	
    public HistoryTab(SalesSystemModel model) {
    	this.model = model;
    } 
    
    public Component draw() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        
        
        
        
        
        return panel;
    }
}