package pojos;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="subcategory")
public class SubCategory {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="subcategory_id")
	Integer subCategoryId;
	String subCategoryName;
	@ManyToOne
	@JoinColumn(name="category_id")
	Category category=new Category();
	@OneToMany(mappedBy="subCategory")
	List<Product> products=new ArrayList<>();
	public SubCategory() {
		// TODO Auto-generated constructor stub
	}
	public SubCategory(Integer subCategoryId, String subCategoryName, pojos.Category category, List<Product> products) {
		super();
		this.subCategoryId = subCategoryId;
		this.subCategoryName = subCategoryName;
		this.category = category;
		this.products = products;
	}
	public Integer getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(Integer subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	public String getSubCategoryName() {
		return subCategoryName;
	}
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "SubCategory [subCategoryId=" + subCategoryId + ", subCategoryName=" + subCategoryName + ", Category="
				+ category + ", products=" + products + "]";
	}

}
