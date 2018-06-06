package pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Category")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="category_id")
	Integer categoryId;
	String categoryName;
	@OneToMany(mappedBy="category",cascade=CascadeType.ALL)
	List<SubCategory> subCategories=new ArrayList<>();
	@OneToMany(mappedBy="category")
	List<Product> products=new ArrayList<>();
	public Category() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", subCategories="
				+ subCategories + ", products=" + products + "]";
	}
	public Category(Integer categoryId, String categoryName, List<SubCategory> subCategories, List<Product> products) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.subCategories = subCategories;
		this.products = products;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<SubCategory> getSubCategories() {
		return subCategories;
	}
	public void setSubCategories(List<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
