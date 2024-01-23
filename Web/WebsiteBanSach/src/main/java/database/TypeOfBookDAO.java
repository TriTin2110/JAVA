package database;

import java.util.ArrayList;
import java.util.List;

import model.modelTypeOfBook;

public class TypeOfBookDAO implements interfaceDAO<modelTypeOfBook>{
        private List<modelTypeOfBook> list;
        

        public TypeOfBookDAO() {
                this.list = new ArrayList<modelTypeOfBook>();
        }

        @Override
        public int insert(modelTypeOfBook t) {
                // TODO Auto-generated method stub
                if (selectByID(t) == null) {
                        this.list.add(t);
                        return 1;
                } else
                        return 0;

        }

        @Override
        public int delete(modelTypeOfBook t) {
                // TODO Auto-generated method stub
                modelTypeOfBook typeOfBookDeleted = selectByID(t);
                if (typeOfBookDeleted != null) {
                        this.list.remove(typeOfBookDeleted);
                        return 1;
                } else
                        return 0;

        }

        @Override
        public int update(modelTypeOfBook t) {
                // TODO Auto-generated method stub
                modelTypeOfBook typeOfBookUpdate = selectByID(t);
                if (typeOfBookUpdate != null) {
                        this.list.remove(typeOfBookUpdate);
                        this.list.add(t);
                        return 1;
                } else
                        return 0;
        }

        @Override
        public ArrayList<modelTypeOfBook> selectAll() {
                // TODO Auto-generated method stub
                return (ArrayList<modelTypeOfBook>) this.list;

        }

        @Override
        public modelTypeOfBook selectByID(modelTypeOfBook t) {
                // TODO Auto-generated method stub
                for (modelTypeOfBook modelTypeOfBook : list) {
                        if (modelTypeOfBook.getTypeID() == t.getTypeID())
                                return modelTypeOfBook;
                }
                return null;
        }
}
