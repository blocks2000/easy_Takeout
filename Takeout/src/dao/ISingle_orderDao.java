package dao;

import java.util.List;

import bean.Order;
import bean.Single_order;

public interface ISingle_orderDao {
	//查询订单是否存在
	
		public Single_order queryIdOrder(String id);
		public boolean isExistById(String id) ;
		public boolean updateS_Order(String id,String quantity,String single_price); 
		public boolean isExist(String id);
		public int getTotalCount(); //查询总共的数据
		public boolean deleteAll();
			
		public boolean updateS_OrderById(String id,Single_order s_order);//根据id改内容
		
		public boolean deleteS_Order(String id);//根据名字删除

		public boolean addS_Order(Single_order s_order);//添加新订单
		public List<Single_order> queryS_Order(String order_id);//根据order_id查订单
		public Single_order queryS_OrderById(String id);

}
