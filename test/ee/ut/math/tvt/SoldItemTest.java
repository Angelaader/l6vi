package ee.ut.math.tvt.salessystem.domain.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SoldItemTest {
	private SoldItem sold;
	private SoldItem soldnon;
	private StockItem stock;
	
	@Before
	public void setUp(){
		stock = new StockItem(3L,"Ale", "jou", 1.0);
		sold = new SoldItem(stock, 8);
		soldnon = new SoldItem(stock, 0);
	}
	
	@Test
	public void testGetSum(){
		assertEquals(sold.getSum(), 8.0, 0.001);
		
	}
	
	@Test
	public void testGetSumWithZeroQuantity(){
		assertEquals(soldnon.getQuantity(), 0.0, 0.001);
	}
}
