package dao;

import java.util.List;

import entity.Product;


/**
 * <p>Title: ProductService</p>  
 * <p>Description: 调用数据访问层对象，把返回结果传递给Servlet</p>  
 * @author  王鹏�?  
 * @date  2018�?11�?13�?  
 */
public class ProductService {
	//实例化数据访问层对象
	ProductDaoImpl pd=new ProductDaoImpl();
	/*
	 * 验证查询商品方法<根据id>
	 */
	public Product findProductById(int id){
		Product p=pd.findProductById(id);
		return p;
	}
	/*
	 * 验证查询商品方法
	 */
	public List<Product> findAll() {
		List<Product> list=pd.findAll();
		return list;
	}
	/*
	 * 验证使用分页查询商品方法	
	 */
	public List<Product> findByPage(int pageNum, int pageSize){
		List<Product> list=pd.findByPage(pageNum, pageSize);
		return list;
	}
	/*
	 * 验证商品总数方法	
	 */
	public int findCountByPage(){
		int count=pd.findCountByPage();
		return count;
	}
	/*
	 * 验证商品添加方法	
	 */
	public boolean addProduct(Product p){
		if(!pd.isExist((p.getName()))){
			pd.addProduct(p);
			return true;
		}else{
			System.out.println("此商品已存在");
			return false;
		}
		
	}
	
	 /* 
	  * 验证商品修改方法	
	  */
	 
	public boolean updateProduct(Product p){
		if(pd.isExist(p.getId())){
			pd.updateProduct(p);
			return true;
		}else{
			return false;
		}
	}
	
	 /*
	  * * 验证商品删除方法	
	  */
	 
	public boolean deleteProduct(int id){
		if(pd.isExist(id)){
			pd.deleteProductByid(id);
			return true;
		}else{
			return false;
		}
	}
}
