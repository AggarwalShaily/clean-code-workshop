package com.movierental;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    private Customer customer = new Customer("Customer_Name");

    @Test
    public void test() {
    }

    @Test
    public void shouldGenerateTextStatement() {
        customer.addRental(new Rental(new Movie("Movie 1",Movie.REGULAR),1));
        customer.addRental(new Rental(new Movie("Movie 2",Movie.CHILDRENS),1));
        customer.addRental(new Rental(new Movie("Movie 3",Movie.NEW_RELEASE),1));

        String str = "Rental Record for Customer_Name\n" +
                "\tMovie 1\t2.0\n" +
                "\tMovie 2\t1.5\n" +
                "\tMovie 3\t3.0\n" +
                "Amount owed is 6.5\n" +
                "You earned 3 frequent renter points";
        assertEquals(str, customer.statement());
    }

    @Test
    public void shouldGenerateHtmlStatement() {
        customer.addRental(new Rental(new Movie("Movie 1",Movie.REGULAR),1));
        customer.addRental(new Rental(new Movie("Movie 2",Movie.CHILDRENS),1));
        customer.addRental(new Rental(new Movie("Movie 3",Movie.NEW_RELEASE),1));

        String str = "<h1>Rental Record for <b>Customer_Name</b></h1><br/>" +
                "Movie 12.0<br/>" +
                "Movie 21.5<br/>" +
                "Movie 33.0<br/>" +
                "Amount owed is <b>6.5</b><br/>" +
                "You earned <b>3</b> frequent renter points";
        assertEquals(str, customer.htmlStatement());
    }

    @Test
    public void singleLoopVsMultiple() {
        for (int j = 0; j < 100; j++) {

            //single loop
            int x = 0, y = 0, z = 0;
            long l = System.currentTimeMillis();
            for (int i = 0; i < 100000000; i++) {
                x++;
                y++;
                z++;
            }
            l = System.currentTimeMillis() - l;


            //multiple loops doing the same thing
            int a = 0, b = 0, c = 0;
            long m = System.currentTimeMillis();
            for (int i = 0; i < 100000000; i++) {
                a++;
            }
            for (int i = 0; i < 100000000; i++) {
                b++;
            }
            for (int i = 0; i < 100000000; i++) {
                c++;
            }
            m = System.currentTimeMillis() - m;
            System.out.println(String.format("%d,%d", l, m));

        }
    }

}