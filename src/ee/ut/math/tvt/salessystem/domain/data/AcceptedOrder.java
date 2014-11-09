package ee.ut.math.tvt.salessystem.domain.data;

import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * Accepted order. 
 */
public class AcceptedOrder implements Cloneable, DisplayableItem {

    private Long id;
    private Date date;
    private float total;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
    
	public String getDateStamp() {
		String dateStamp = new SimpleDateFormat("dd.MM.yyyy").format(date);
		return dateStamp;
	}
	
	public String getTimeStamp() {
		String timeStamp = new SimpleDateFormat("HH:mm:ss").format(date);
		return timeStamp;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
}
