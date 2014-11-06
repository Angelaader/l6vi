package ee.ut.math.tvt.salessystem.ui.model;

import org.apache.log4j.Logger;

import ee.ut.math.tvt.salessystem.domain.data.AcceptedOrder;
import ee.ut.math.tvt.salessystem.ui.SalesSystemUI;

/**
 * Purchase history details model.
 */
public class HistoryTableModel extends SalesSystemTableModel<AcceptedOrder> {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(HistoryTableModel.class);
	
	public HistoryTableModel() {
		super(new String[] { "ID", "Date", "Time", "Total" });
	}

	@Override
	protected Object getColumnValue(AcceptedOrder order, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return order.getId();
		case 1:
			return order.getDateStamp();
		case 2:
			return order.getTimeStamp();
		case 3:
			return order.getTotal();
		}
		throw new IllegalArgumentException("Column index out of range");
	}

	@Override
	public String toString() {
		final StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < headers.length; i++)
			buffer.append(headers[i] + "\t");
		buffer.append("\n");

		for (final AcceptedOrder item : rows) {
			buffer.append(item.getId() + "\t");
			buffer.append(item.getDateStamp() + "\t");
			buffer.append(item.getTimeStamp() + "\t");
			buffer.append(item.getTotal() + "\t");
			buffer.append("\n");
		}

		return buffer.toString();
	}
	
    /**
     * Add new StockItem to table.
     */
    public void addItem(final AcceptedOrder order) {
        /**
         * XXX In case such stockItem already exists increase the quantity of the
         * existing stock.
         */
        
        rows.add(order);
        log.debug("Added order with ID " + order.getId() + " and total of " + order.getTotal());
        fireTableDataChanged();
    }
}
