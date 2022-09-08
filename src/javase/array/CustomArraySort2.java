package javase.array;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.Comparator;

public class CustomArraySort2 {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("AA", 100);
        books[1] = new Book("BBB", 50);
        books[2] = new Book("DDDDD", 110);
        books[3] = new Book("CCCC ", 90);

        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book b1 = (Book) o1;
                Book b2 = (Book) o2;
                double diffVal = b2.getPrice() - b1.getPrice();
                if (diffVal > 0)
                    return -1;
                else if (diffVal < 0)
                    return 1;
                else
                    return 0;

            }
        });

        System.out.println(Arrays.toString(books));
    }

}

class Book {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}