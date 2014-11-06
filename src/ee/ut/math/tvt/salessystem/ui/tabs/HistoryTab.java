package ee.ut.math.tvt.salessystem.ui.tabs;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ee.ut.math.tvt.salessystem.ui.model.HistoryTableModel;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;

/**
 * Encapsulates everything that has to do with the purchase tab (the tab
 * labelled "History" in the menu).
 */
public class HistoryTab {
	
	SalesSystemModel model;
	HistoryTableModel order;
	JTable soldItemTable;
	JTable purchasesTable;
	
    public HistoryTab(SalesSystemModel model) {
    	this.model = model;
    } 
    
    public Component draw() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        
        JTable table = new JTable(model.getCurrentHistoryTableModel());
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane, getHistoryScrollPaneConstraints());        
        
        return panel;
    }
    
    private GridBagConstraints getHistoryScrollPaneConstraints() {
        GridBagConstraints gc = new GridBagConstraints();

        gc.fill = GridBagConstraints.BOTH;
        gc.weightx = 1.0;
        gc.weighty = 1.0;

        return gc;
    }
    
}