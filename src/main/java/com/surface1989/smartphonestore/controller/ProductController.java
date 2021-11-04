package com.surface1989.smartphonestore.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.surface1989.smartphonestore.model.Configure;
import com.surface1989.smartphonestore.model.Manufacture;
import com.surface1989.smartphonestore.model.Product;
import com.surface1989.smartphonestore.service.ConfigureService;
import com.surface1989.smartphonestore.service.ManufactureService;
import com.surface1989.smartphonestore.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private ManufactureService manufactureService;
	@Autowired
	private ConfigureService configureService;

	@RequestMapping("")
	public String home(Model model, @RequestParam(name = "productId", required = false) Long productId) {
		ArrayList<Product> products = (ArrayList<Product>) productService.getAll();
		ArrayList<Manufacture> manufactures = (ArrayList<Manufacture>) manufactureService.getAll();
		Product product = new Product();
		Product productEdit;
		product.setConfigureOfProduct(new Configure());
		product.setProductManufacture(new Manufacture());
		if (productId != null) {
			productEdit = productService.getProductById(productId);
			model.addAttribute("productEdit", productEdit);
		}
		model.addAttribute("products", products);
		model.addAttribute("manufactures", manufactures);
		model.addAttribute("product", product);
		return "admin/home";
	}

	@RequestMapping(name = "", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") Product product, HttpServletRequest request)
			throws InterruptedException {
		System.out.println(product.getProductName());
		Manufacture manufacture = manufactureService
				.getManufactureById(product.getProductManufacture().getManufactureId());
		product.setProductManufacture(manufacture);
		productService.addProduct(product);
		MultipartFile productImage = product.getProductImage();

//		I can't fix error getRealPath() func return  path=E:\Erich-Spring\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\ wtpwebapps\SmartphoneStore\ 
//		String rootDirectory = request.getSession().getServletContext().getRealPath("/"); 
//		Path path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");
		String path = "E:\\Erich-Spring\\SmartphoneStore\\src\\main\\webapp\\WEB-INF\\resources\\images\\"
				+ product.getProductId() + ".png";
		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(path));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Product image saving failed", e);
			}
		}System.out.println("ahihi");
		Thread.sleep(5000);
		return "redirect:/products";
	}

	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") Long productId) {
		String pathString = "E:\\Erich-Spring\\SmartphoneStore\\src\\main\\webapp\\WEB-INF\\resources\\images\\"
				+ productId + ".png";
		Path path = Paths.get(pathString);
		if (Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		productService.deleteProduct(productId);
		return "redirect:/products";
	}

	
}
