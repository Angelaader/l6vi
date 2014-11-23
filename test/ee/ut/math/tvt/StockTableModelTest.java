package ee.ut.math.tvt.salessystem.ui.model;

import static org.junit.Assert.*;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.StockTableModel;

import org.junit.Before;
import org.junit.Test;

public class StockTableModelTest {

	private StockTableModel model;
	private StockItem stock;
	private SoldItem sold;
	
	@Before
	public void setUp(){
		stock = new StockItem(34L, "Henry Westons", "siider", 43.0, 8);
		sold = new SoldItem(stock, 15);
		
		model = new StockTableModel();
		model.addItem(stock);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValidateNameUniqueness(){
		StockItem item = new StockItem(20L, "Henry Westons", "siider", 40.0, 30);
		model.addItem(item);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testHasEnoughInStock(){
		model.removeItem(sold);
	}
	
	@Test
	public void testGetItemByIdWhenItemExists(){
		assertEquals(model.getItemById(34L).getId(), new Long(34L));
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testGetItemByIdWhenThrowsException(){
		model.getItemById(120L);
	}

}
