package study.线程;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/4 11:00
 */

public class Student implements Cloneable {
    private int id;
    private String name;
    private Book book;
    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(int id, String name, Book book) {
        this.id = id;
        this.name = name;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //浅拷贝
//        return super.clone();
        Student student=(Student)super.clone();
        student.setBook((Book)student.getBook().clone());
        return student;
    }

}
