package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "addr_id")
	Integer id;
	String city;
	String state;
	String country;
	String area;
	String houseNo;
	String street;
	String district;
	@ManyToOne
	@JoinColumn(name="user_id")
	User user=new User();
}
