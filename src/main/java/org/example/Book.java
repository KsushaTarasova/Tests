package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Book {
    private String title;
    private String author;
    private int pages;
    private Connection connection;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }
    public Book(Connection connection) {
        this.connection = connection;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isLongBook() {
        return pages > 300;
    }

    public String getDescription() {
        return "Book: " + title + " by " + author + " has " + pages + " pages.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pages == book.pages && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, pages);
    }

    public String readFile(String filePath) throws IOException {
        return Files.readString(Paths.get(filePath));
    }

    public void writeFile(String filePath, String content) throws IOException {
        Files.writeString(Paths.get(filePath), content);
    }

    public Map<String, Integer> addToCollection (Map<String, Integer> input){
        return new HashMap<>(input);
    }

    public boolean isPalindrome(String text){
        String s = text.replaceAll("\\s+", "").toLowerCase();
        StringBuilder reversed = new StringBuilder(s).reverse();
        return s.contentEquals(reversed);
    }

    public List<String> getAllBooks() throws SQLException {
        List<String> books = new ArrayList<>();
        String sql = "select name from books";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                books.add(rs.getString("name"));
            }
        }
        return books;
    }

}
