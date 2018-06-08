package pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer orderId;
	
	@Temporal(TemporalType.DATE)
	Date orderedDate;
	
	@OneToOne
	@JoinColumn(name="user_id")
	User user;
	
	@ManyToMany(mappedBy="orders")
	List<OrderProduct> orderedProducts=new ArrayList<>();
	
}
