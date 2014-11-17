package ee.ut.math.tvt.salessystem.domain.data;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StockItemTest {

private StockItem stock;
	
	@Before
	public void setUp() {
		stock = new StockItem(3L,"Ale","jee", 66.6);
	}
	
	@Test
	public void testClone() {
		StockItem one = (StockItem) stock.clone();
		assertTrue(stock.equals(one));
	}
	
	@Test
	public void testGetColumn() {
		assertEquals((Double)(stock.getColumn(3)), 66.6, 0.001);
	}
	
	@Test(expected = RuntimeException.class)
	public void testGetInvalidColumn() {
		stock.getColumn(10);
	}

}
