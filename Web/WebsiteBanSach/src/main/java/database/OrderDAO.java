package database;

import java.util.ArrayList;
import java.util.List;

import model.modelOrder;

public class OrderDAO implements interfaceDAO<modelOrder> {
        private List<modelOrder> list;
        

        public OrderDAO() {
                this.list = new ArrayList<modelOrder>();
        }

        @Override
        public int insert(modelOrder t) {
                // TODO Auto-generated method stub
                if (selectByID(t) == null) {
                        this.list.add(t);
                        return 1;
                } else
                        return 0;

        }

        @Override
        public int delete(modelOrder t) {
                // TODO Auto-generated method stub
                modelOrder ortherDeleted = selectByID(t);
                if (ortherDeleted != null) {
                        //Xóa chi tiết đơn hàng
                        OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
                        orderDetailDAO.deleteOrder(ortherDeleted);
                        //Xóa đơn hàng
                        this.list.remove(ortherDeleted);
                        return 1;
                } else
                        return 0;

        }

        @Override
        public int update(modelOrder t) {
                // TODO Auto-generated method stub
                modelOrder ortherUpdate = selectByID(t);
                if (ortherUpdate != null) {
                        this.list.remove(ortherUpdate);
                        this.list.add(t);
                        return 1;
                } else
                        return 0;
        }

        @Override
        public ArrayList<modelOrder> selectAll() {
                // TODO Auto-generated method stub
                return (ArrayList<modelOrder>) this.list;

        }

        @Override
        public modelOrder selectByID(modelOrder t) {
                // TODO Auto-generated method stub
                for (modelOrder modelOrder : list) {
                        if (modelOrder.getOrderId() == t.getOrderId())
                                return modelOrder;
                }
                return null;
        }
}
