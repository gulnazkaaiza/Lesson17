import java.io.Serializable;


public class Book implements Serializable {
        public static final long serialVersionUID = 1L;
        private String nameBook;
        private  String nameAuthor;
        private int bookYear;

        public Book(String nameBook, String nameAuthor, int bookYear) {
            this.nameBook = nameBook;
            this.nameAuthor = nameAuthor;
            this.bookYear = bookYear;
        }


       public String getNameBook() {
            return nameBook;
        }

        public void setNameBook(String nameBook) {
           this.nameBook = nameBook;
        }


        public String getNameAuthor() {
            return nameAuthor;
        }

        public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
        }

        public int getBookYear() {
        return bookYear;
        }

        public void setBookYear(int bookYear) {
        this.bookYear = bookYear;
        }


        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder(" Книга {");
            sb.append("название:  '").append(nameBook).append('\'');
            sb.append(", автор: '").append(nameAuthor).append('\'');
            sb.append(", год издания: ").append(bookYear);
            sb.append('}');
            return sb.toString();
        }
    }
