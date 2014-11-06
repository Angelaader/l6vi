package ee.ut.math.tvt.salessystem.domain.service;

import java.util.List;

import org.hibernate.Session;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.util.HibernateUtil;

@SuppressWarnings("unchecked")
public class HibernateDataService {

	private Session session = HibernateUtil.currentSession();

	public List<StockItem> getStockItems() {
		List<StockItem> result = session.createQuery("from StockItem").list();
		return result;
	}
	
	public List<SoldItem> getSoldItems() {
		List<SoldItem> result = session.createQuery("from SoldItem").list();
		return result;
	}
	
	public void startSale() {
		session.beginTransaction();
		
	}
	
	public void endSale() {
		session.flush();
	}



}