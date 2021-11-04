package com.surface1989.smartphonestore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "Product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productId")
	private Long ProductId;

	@Column(name = "productName")
	private String productName;

	@ManyToOne
	@JoinColumn(name = "manufactureId")
	private Manufacture productManufacture;

	@OneToOne
	@JoinColumn(name = "configureId")
	private Configure configureOfProduct;

	@Column(name = "price")
	private Long productPrice;
	
	@Transient
	private MultipartFile productImage;
	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

	public Product() {
		super();
	}

	public Product(String productName, Manufacture productManufacture, Configure configureOfProduct,
			Long productPrice) {
		super();
		this.productName = productName;
		this.productManufacture = productManufacture;
		this.configureOfProduct = configureOfProduct;
		this.productPrice = productPrice;
	}

	public Long getProductId() {
		return ProductId;
	}

	public void setProductId(Long productId) {
		ProductId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Manufacture getProductManufacture() {
		return productManufacture;
	}

	public void setProductManufacture(Manufacture productManufacture) {
		this.productManufacture = productManufacture;
	}

	public Configure getConfigureOfProduct() {
		return configureOfProduct;
	}

	public void setConfigureOfProduct(Configure configureOfProduct) {
		this.configureOfProduct = configureOfProduct;
	}

	public Long getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Long productPrice) {
		this.productPrice = productPrice;
	}

}
