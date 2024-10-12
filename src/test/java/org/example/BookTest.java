package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookTest {
    @Test
    public void testGetTitle(){
        Book book = new Book("The Hobbit", "J.R.R. Tolkien", 310);
        assertEquals("The Hobbit", book.getTitle());
    }
    @Test
    public void testSetTitle(){
        Book book = new Book("The Hobbit", "J.R.R. Tolkien", 310);
        book.setTitle("The Lord of the Rings");
        assertEquals("The Lord of the Rings", book.getTitle());
    }
    @Test
    public void testIsLongBook(){
        Book book = new Book("The Hobbit", "J.R.R. Tolkien", 310);
        assertTrue(book.isLongBook());
    }
    @Test
    public void testGetDescription() {
        Book book = new Book("The Hobbit", "J.R.R. Tolkien", 310);
        assertEquals("Book: The Hobbit by J.R.R. Tolkien has 310 pages.", book.getDescription());
    }
}
