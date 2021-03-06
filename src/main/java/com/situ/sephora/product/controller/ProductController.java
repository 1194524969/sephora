package com.situ.sephora.product.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.sephora.product.domain.Product;
import com.situ.sephora.product.service.ProductService;

@Controller
@RequestMapping("/admin")
public class ProductController implements Serializable {
	private static final long serialVersionUID = 1L;
	@Autowired
	private ProductService productService;

	@ResponseBody
	@RequestMapping("/goUpdateProduct")
	public Product goUpdateProduct(Product product) {
		return this.productService.getByProduct(product);
	}
	
	@ResponseBody
	@RequestMapping("/doSaveProduct")
	public Long saveProduct(Product product, HttpServletRequest request) {
		// 文件的根路径
		String realPath = request.getServletContext().getRealPath("/");
		return this.productService.save(product, realPath);
	}

	@ResponseBody
	@RequestMapping("/doUpdateProduct")
	public Integer doUpdateProduct(Product product,HttpServletRequest request) {
		// 文件的根路径
		String realPath = request.getServletContext().getRealPath("/");
		System.out.println(realPath);
		return this.productService.update(product, realPath);
	}

	@ResponseBody
	@RequestMapping("/doDelProduct")
	public Integer delProduct(Long rowId) {
		return this.productService.del(rowId);
	}

}
