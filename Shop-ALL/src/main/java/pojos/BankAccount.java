package pojos;
import javax.persistence.*;

@Entity
@Table(name="dac_accts")
public class BankAccount {
	private Integer acctId;
	private String pin;
	private String type;
	private double balance;
	public BankAccount() {
		// TODO Auto-generated constructor stub
	}
	public BankAccount(String pin, String type, double balance) {
		super();
		this.pin = pin;
		this.type = type;
		this.balance = balance;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getAcctId() {
		return acctId;
	}
	public void setAcctId(Integer acctId) {
		this.acctId = acctId;
	}
	@Column(length=10)
	public String getPin() {
		return pin;
	}
	
	public void setPin(String pin) {
		this.pin = pin;
	}
	@Column(length=10)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Column(columnDefinition="double(6,1)")
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "BankAccount [acctId=" + acctId + ", type=" + type + ", balance=" + balance + "]";
	}
	

}
