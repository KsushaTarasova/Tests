package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {
    @Test
    public void testGetTitle(){
        Book book = new Book("The Hobbit", "J.R.R. Tolkien", 310);
        assertEquals("The Hobbit", book.getTitle());
    }
}
