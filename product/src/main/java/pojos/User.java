package pojos;

import javax.persistence.*;

@Entity
@Table(name="User")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String user_id;
	
	@Column(length = 20)
	private String password;

}
