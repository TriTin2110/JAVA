package database;

import java.util.ArrayList;
import java.util.List;

import model.modelBook;

public class BookDAO implements interfaceDAO<modelBook> {
        private List<modelBook> list;

        public BookDAO() {
                this.list = new ArrayList<modelBook>();
        }

        @Override
        public int insert(modelBook t) {
                // TODO Auto-generated method stub
                if (selectByID(t) == null)
                {
                        this.list.add(t);
                        return 1;
                }
                else
                        return 0;
                        
        }

        @Override
        public int delete(modelBook t) {
                // TODO Auto-generated method stub
                modelBook bookDeleted = selectByID(t);
                if(bookDeleted != null)
                {
                        this.list.remove(bookDeleted);
                        return 1;
                }
                else
                        return 0;

        }

        @Override
        public int update(modelBook t) {
                // TODO Auto-generated method stub
                modelBook bookDeleted = selectByID(t);
                if (bookDeleted != null) {
                        this.list.remove(bookDeleted);
                        this.list.add(t);
                        return 1;
                } else
                        return 0;
        }

        @Override
        public ArrayList<modelBook> selectAll() {
                // TODO Auto-generated method stub
                return (ArrayList<modelBook>) this.list;

        }

        @Override
        public modelBook selectByID(modelBook t) {
                // TODO Auto-generated method stub
                for (modelBook modelBook : list) {
                        if (modelBook.getBookId() == t.getBookId())
                                return modelBook;
                }
                return null;
        }
}
