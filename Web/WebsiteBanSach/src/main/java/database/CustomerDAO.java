package database;

import java.util.ArrayList;
import java.util.List;

import model.modelCustomer;

public class CustomerDAO implements interfaceDAO<modelCustomer> {
        private List<modelCustomer> list;
        

        public CustomerDAO() {
                this.list = new ArrayList<modelCustomer>();
        }

        @Override
        public int insert(modelCustomer t) {
                // TODO Auto-generated method stub
                if (selectByID(t) == null) {
                        this.list.add(t);
                        return 1;
                } else
                        return 0;

        }

        @Override
        public int delete(modelCustomer t) {
                // TODO Auto-generated method stub
                modelCustomer customerDeleted = selectByID(t);
                if (customerDeleted != null) {
                        this.list.remove(customerDeleted);
                        return 1;
                } else
                        return 0;

        }

        @Override
        public int update(modelCustomer t) {
                // TODO Auto-generated method stub
                modelCustomer customerUpdate = selectByID(t);
                if (customerUpdate != null) {
                        this.list.remove(customerUpdate);
                        this.list.add(t);
                        return 1;
                } else
                        return 0;
        }

        @Override
        public ArrayList<modelCustomer> selectAll() {
                // TODO Auto-generated method stub
                return (ArrayList<modelCustomer>) this.list;

        }

        @Override
        public modelCustomer selectByID(modelCustomer t) {
                // TODO Auto-generated method stub
                for (modelCustomer modelCustomer : list) {
                        if (modelCustomer.getCustomerId() == t.getCustomerId())
                                return modelCustomer;
                }
                return null;
        }
}
