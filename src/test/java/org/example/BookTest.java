package org.example;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class BookTest {
    private Book book, bookDB;
    private Connection connection;


    @BeforeEach
    public void setup() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        book = new Book("The Hobbit", "J.R.R. Tolkien", 310);
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres", "70262057113233Kk");
        bookDB = new Book(connection);
    }

    @AfterEach
    void close() throws SQLException {
        connection.close();
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

    @Test
    public void testAddToCollection() {
        HashMap<String, Integer> input = new HashMap<>();
        input.put("Tolkien", 1000);
        input.put("King", 500);
        input.put("Bronte", 600);

        Map<String, Integer> result = book.addToCollection(input);

        assertEquals(1000, result.get("Tolkien").intValue());
        assertEquals(500, result.get("King").intValue());
        assertEquals(600, result.get("Bronte").intValue());
    }

    @ParameterizedTest
    @CsvSource({
            "'madam', true",
            "'racecar', true",
            "'hello', false",
            "'A man a plan a canal Panama', true"
    })
    public void testIsPalindrome(String input, boolean expected) {
        assertEquals(expected, book.isPalindrome(input));
    }

    @Test
    public void testGetAllBooks() throws SQLException {
        List<String> books = bookDB.getAllBooks();
        assertEquals(3, books.size());
        assertTrue(books.contains("It"));
        assertTrue(books.contains("Harry Potter"));
    }

}
