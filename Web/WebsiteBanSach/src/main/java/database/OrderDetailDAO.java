package database;

import java.util.ArrayList;
import java.util.List;

import model.modelOrder;
import model.modelOrderDetail;
public class OrderDetailDAO implements interfaceDAO<modelOrderDetail>{
        private List<modelOrderDetail> list;
        

        public OrderDetailDAO() {
                this.list = new ArrayList<modelOrderDetail>();
        }

        @Override
        public int insert(modelOrderDetail t) {
                // TODO Auto-generated method stub
                if (selectByID(t) == null) {
                        this.list.add(t);
                        return 1;
                } else
                        return 0;

        }

        @Override
        public int delete(modelOrderDetail t) {
                // TODO Auto-generated method stub
                modelOrderDetail orderDetailDeleted = selectByID(t);
                if (orderDetailDeleted != null) {
                        this.list.remove(orderDetailDeleted);
                        return 1;
                } else
                        return 0;

        }

        //Xóa chi tiết đơn hàng dựa trên đơn hàng
        public int deleteOrder(modelOrder t) {
                // TODO Auto-generated method stub
                for (modelOrderDetail modelOrderDetail : list) {
                        if(t.getOrderId() == modelOrderDetail.getOrderDetailId())
                        {
                                this.list.remove(modelOrderDetail);
                                return 1;
                        } 
                }
                return 0;
        }

        @Override
        public int update(modelOrderDetail t) {
                // TODO Auto-generated method stub
                modelOrderDetail orderDetailUpdate = selectByID(t);
                if (orderDetailUpdate != null) {
                        this.list.remove(orderDetailUpdate);
                        this.list.add(t);
                        return 1;
                } else
                        return 0;
        }

        @Override
        public ArrayList<modelOrderDetail> selectAll() {
                // TODO Auto-generated method stub
                return (ArrayList<modelOrderDetail>) this.list;

        }

        @Override
        public modelOrderDetail selectByID(modelOrderDetail t) {
                // TODO Auto-generated method stub
                for (modelOrderDetail modelOrderDetail : list) {
                        if (modelOrderDetail.getOrderDetailId() == t.getOrderDetailId())
                                return modelOrderDetail;
                }
                return null;
        }
}
