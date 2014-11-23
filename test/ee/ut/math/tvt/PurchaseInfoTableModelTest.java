package ee.ut.math.tvt.salessystem.ui.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.NoSuchElementException;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.PurchaseInfoTableModel;

public class PurchaseInfoTableModelTest {

	private PurchaseInfoTableModel pm;
	private SoldItem item1;
	private SoldItem item2;
	
	@Before
	public void setUp(){
		pm = new PurchaseInfoTableModel();
		item1 = new SoldItem(new StockItem(3L,"e","3",10,7),2);
		item2 = new SoldItem(new StockItem(2L,"b","7",8,3),1);
	}
	
	
	@Test
	public void testGetItem(){
		pm.addItem(item1);
		pm.addItem(item2);
		assertEquals(item2, pm.getItemById(2L));
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testGetItemException(){
		pm.getItemById(7L);
	}

}
