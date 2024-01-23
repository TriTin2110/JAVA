package database;

import java.util.ArrayList;
import java.util.List;

import model.modelAuthor;

public class AuthorDAO implements interfaceDAO<modelAuthor> {
        private List<modelAuthor> list;
        

        public AuthorDAO() {
                this.list = new ArrayList<modelAuthor>();
        }

        @Override
        public int insert(modelAuthor t) {
                // TODO Auto-generated method stub
                if (selectByID(t) == null) {
                        this.list.add(t);
                        return 1;
                } else
                        return 0;

        }

        @Override
        public int delete(modelAuthor t) {
                // TODO Auto-generated method stub
                modelAuthor authorDeleted = selectByID(t);
                if (authorDeleted != null) {
                        this.list.remove(authorDeleted);
                        return 1;
                } else
                        return 0;

        }

        @Override
        public int update(modelAuthor t) {
                // TODO Auto-generated method stub
                modelAuthor authorUpdate = selectByID(t);
                if (authorUpdate != null) {
                        this.list.remove(authorUpdate);
                        this.list.add(t);
                        return 1;
                } else
                        return 0;
        }

        @Override
        public ArrayList<modelAuthor> selectAll() {
                // TODO Auto-generated method stub
                return (ArrayList<modelAuthor>) this.list;

        }

        @Override
        public modelAuthor selectByID(modelAuthor t) {
                // TODO Auto-generated method stub
                for (modelAuthor modelAuthor : list) {
                        if (modelAuthor.getAuthorId() == t.getAuthorId())
                                return modelAuthor;
                }
                return null;
        }
        
}
