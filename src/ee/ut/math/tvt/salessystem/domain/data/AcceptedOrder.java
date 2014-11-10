package ee.ut.math.tvt.salessystem.domain.data;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Accepted order.
 */
@Entity
@Table(name = "acceptedorder")
public class AcceptedOrder implements Cloneable, DisplayableItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "date")
	private Date date;
	@Column(name = "total")
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

	public Object getColumn(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return id;
		case 1:
			return date;
		case 2:
			return total;
		default:
			throw new RuntimeException("invalid column!");
		}

	}
}
