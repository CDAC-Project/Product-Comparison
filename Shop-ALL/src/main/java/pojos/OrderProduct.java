package pojos;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "OrderProduct")
public class OrderProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer orderProductId;
	int quatity;
	@OneToOne
	@JoinColumn(name="order_id")
	Product product;
	@ManyToMany
	List<Order> orders=new ArrayList<>();
}
