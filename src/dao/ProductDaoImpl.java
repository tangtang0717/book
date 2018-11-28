package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Product;

public class ProductDaoImpl {
	
	/*
	 * 添加商品方法
	 */
	public boolean addProduct(Product p){
		try{
			Connection con=BaseDao.getCon();
			PreparedStatement pstm=con.prepareStatement("insert into product(name,description,listimg,price,discountprice) values(?,?,?,?,?)");
			pstm.setString(1, p.getName());
			pstm.setString(2, p.getDescription());
			pstm.setString(3, p.getListimg());
			pstm.setInt(4, p.getPrice());
			pstm.setInt(5, p.getDiscountprice());
			int rs = pstm.executeUpdate();
			if(rs>0){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
		
	/*
	 * 修改商品方法
	 */
	public boolean updateProduct(Product product){
		try{
			Connection con=BaseDao.getCon();
			PreparedStatement pstm=con.prepareStatement("update product set name=?,description=?,price=?,discountprice=? where id=?");
			pstm.setString(1, product.getName());
			pstm.setString(2, product.getDescription());
			pstm.setInt(3, product.getPrice());
			pstm.setInt(4, product.getDiscountprice());
            pstm.setInt(5, product.getId());
            int rs = pstm.executeUpdate();
            System.out.println(rs);
            if(rs>0){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	/*
	 * 删除商品方法<根据id>
	 */
	public boolean deleteProductByid(int id){
		try{
			Connection con=BaseDao.getCon();
			PreparedStatement pstm=con.prepareStatement("delete from product where id=?");
			pstm.setInt(1, id);
			int rs=pstm.executeUpdate();
			if(rs>0){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	/*
	 * 验证该商品是否存�?<根据id>
	 */
	public boolean isExist(int id){
		return findProductById(id)==null?false:true;
	}
	/*
	 * 验证该商品是否存�?<根据name>
	 */
	public boolean isExist(String name){
		return findProductByName(name)==null?false:true;
	}
	/*
	 * 根据id查询相应商品
	 */
	public Product findProductById(int id){
		try{
			Connection con=BaseDao.getCon();
			PreparedStatement pstm=con.prepareStatement("select * from product where id=?");
			pstm.setInt(1, id);
			ResultSet rs=pstm.executeQuery();
			Product p=null;
			while(rs.next()){
				p=new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setDescription(rs.getString(3));
				p.setListimg(rs.getString(4));
				p.setPrice(rs.getInt(5));
				p.setDiscountprice(rs.getInt(6));
			}
			return p;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	/*
	 * 根据name查询相应商品
	 */
	public Product findProductByName(String name){
		try{
			Connection con=BaseDao.getCon();
			PreparedStatement pstm=con.prepareStatement("select * from product where name=?");
			pstm.setString(1, name);
			ResultSet rs=pstm.executeQuery();
			Product p=null;
			while(rs.next()){
				p=new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setDescription(rs.getString(3));
				p.setListimg(rs.getString(4));
				p.setPrice(rs.getInt(5));
				p.setDiscountprice(rs.getInt(6));
			}
			return p;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * 查询全部商品的方�?
	 */
	public List<Product> findAll(){
		try{
			List<Product> list=new ArrayList<Product>();
			Connection con=BaseDao.getCon();
			PreparedStatement pstm=con.prepareStatement("select * from product");
			ResultSet rs=pstm.executeQuery();
			Product p=null;
			while(rs.next()){
				p=new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setDescription(rs.getString(3));
				p.setListimg(rs.getString(4));
				p.setPrice(rs.getInt(5));
				p.setDiscountprice(rs.getInt(6));
				list.add(p);
				System.out.println(p);
			}
			
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/*
	 * 统计商品总数
	 * @return
	 */
	public int findCountByPage(){
		try{
			Connection con=BaseDao.getCon();
			PreparedStatement pstm=con.prepareStatement("select count(id) from product");
			ResultSet rs=pstm.executeQuery();
			int count=0;
			while(rs.next()){
				count=rs.getInt(1);
			}
			return count;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
		
	}
	
	/*
	 * 分页查询数据
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<Product> findByPage(int pageNum, int pageSize){
		try{
			List<Product> list=new ArrayList<Product>();
			Connection con=BaseDao.getCon();
			PreparedStatement pstm=con.prepareStatement("select * from product limit ?,?");
			pstm.setInt(1, (pageNum-1)*pageSize);
			pstm.setInt(2, pageSize);
			ResultSet rs=pstm.executeQuery();
			Product p=null;
			while(rs.next()){
				p=new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setDescription(rs.getString(3));
				p.setListimg(rs.getString(4));
				p.setPrice(rs.getInt(5));
				p.setDiscountprice(rs.getInt(6));
				list.add(p);
				System.out.println(p);
			}
			
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
