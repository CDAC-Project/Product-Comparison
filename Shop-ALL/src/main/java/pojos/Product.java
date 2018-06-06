package pojos;

import javax.persistence.*;

@Entity
@Table(name = "Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	Integer product_id;
	String modelNo;
	String product_name;
	String brand;

	@ManyToOne
	@JoinColumn(name = "category_id")
	Category category;

	@ManyToOne
	@JoinColumn(name = "subcategory_id")
	SubCategory subCategory;
	double price;

	public Product() {

	}

	public Product(Integer product_id, String modelNo, String product_name, String brand, Category category,
			SubCategory subCategory, double price) {
		super();
		this.product_id = product_id;
		this.modelNo = modelNo;
		this.product_name = product_name;
		this.brand = brand;
		this.category = category;
		this.subCategory = subCategory;
		this.price = price;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", modelNo=" + modelNo + ", product_name=" + product_name
				+ ", brand=" + brand + ", category=" + category + ", subCategory=" + subCategory + ", price=" + price
				+ "]";
	}

}
