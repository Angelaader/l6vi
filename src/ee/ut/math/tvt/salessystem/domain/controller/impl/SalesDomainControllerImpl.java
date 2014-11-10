package ee.ut.math.tvt.salessystem.domain.controller.impl;

import java.util.List;

import org.hibernate.Session;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import ee.ut.math.tvt.salessystem.domain.controller.SalesDomainController;
import ee.ut.math.tvt.salessystem.domain.data.AcceptedOrder;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.domain.exception.VerificationFailedException;
import ee.ut.math.tvt.salessystem.domain.service.HibernateDataService;
import ee.ut.math.tvt.salessystem.util.HibernateUtil;

/**
 * Implementation of the sales domain controller.
 */
public class SalesDomainControllerImpl implements SalesDomainController {
	public void submitCurrentPurchase(List<SoldItem> goods)
			throws VerificationFailedException, ParseException {		

	}

	public void cancelCurrentPurchase() throws VerificationFailedException {
		// XXX - Cancel current purchase
	}

	public void startNewPurchase() throws VerificationFailedException {
		// XXX - Start new purchase
	}

	public void endSession() {
		HibernateUtil.closeSession();
	}

	public List<StockItem> loadWarehouseState() {
		// XXX mock implementation
		HibernateDataService hib = new HibernateDataService();
		List<StockItem> dataset = hib.getStockItems();
		return dataset;
	}
	
	public List<AcceptedOrder> loadHistoryState() {
		// XXX mock implementation
		HibernateDataService hib = new HibernateDataService();
		List<AcceptedOrder> dataset = hib.getAcceptedOrders();
		return dataset;
	}
}