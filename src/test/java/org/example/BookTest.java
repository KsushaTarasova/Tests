package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    private Book book;

    @BeforeEach
    public void setup() {
        book = new Book("The Hobbit", "J.R.R. Tolkien", 310);
    }

    @Test
    public void testGetDescription() {
        assertEquals("Book: The Hobbit by J.R.R. Tolkien has 310 pages.", book.getDescription());
    }

    @Test
    public void testHashCode() {
        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", 310);
        Book book2 = new Book("The", "J.R.R", 310);
        assertEquals(book.hashCode(), book1.hashCode());
        assertNotEquals(book.hashCode(), book2.hashCode());
    }

    @Test
    public void testFileReadWrite() throws IOException {
        String filePath = "test.txt";
        book.writeFile(filePath, book.getDescription());

        String content = book.readFile(filePath);
        assertEquals(book.getDescription(), content);

        Files.delete(Paths.get(filePath));

    }

}
