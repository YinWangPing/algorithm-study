package study.线程;

import java.util.Objects;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/4 21:05
 */

public class Book implements Cloneable{
    private int book_id;
    private String book_name;

    public Book(int book_id, String book_name) {
        this.book_id = book_id;
        this.book_name = book_name;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return book_id == book.book_id &&
                Objects.equals(book_name, book.book_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book_id, book_name);
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                '}';
    }
}
