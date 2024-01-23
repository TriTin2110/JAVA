package model;

import java.sql.Date;

public class modelAuthor {
        private String authorId, authorName, authorDescription;
        private Date birthday;

        

        public modelAuthor() {
        }

        public modelAuthor(String authorId, String authorName, String authorDescription, Date birthday) {
                this.authorId = authorId;
                this.authorName = authorName;
                this.authorDescription = authorDescription;
                this.birthday = birthday;
        }

        public String getAuthorId() {
                return authorId;
        }

        public void setAuthorId(String authorId) {
                this.authorId = authorId;
        }

        public String getAuthorName() {
                return authorName;
        }

        public void setAuthorName(String authorName) {
                this.authorName = authorName;
        }

        public String getAuthorDescription() {
                return authorDescription;
        }

        public void setAuthorDescription(String authorDescription) {
                this.authorDescription = authorDescription;
        }

        public Date getBirthday() {
                return birthday;
        }

        public void setBirthday(Date birthday) {
                this.birthday = birthday;
        }

        
}
