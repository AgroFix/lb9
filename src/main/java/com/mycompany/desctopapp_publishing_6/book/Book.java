package com.mycompany.desctopapp_publishing_6.book;

 import javax.persistence.*;

@Entity
 @Table(name ="books")
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

 @Column(length =45, nullable = false, name = "book_name")
  private String bookName;

 @Column(length =45, nullable = false, name = "year")
  private String year;

private boolean enabled;
 public Integer getId() {
  return id;
 }

 public void setId(Integer id) {
  this.id = id;
 }



 public String getBookName() {
  return bookName;
 }

 public void setBookName(String bookName) {
  this.bookName = bookName;
 }

 public String getYear() {
  return year;
 }

 public void setYear(String year) {
  this.year = year;
 }

 @Override
 public String toString() {
  return "Book{" +
          "id=" + id +
          ", bookName='" + bookName + '\'' +
          ", year='" + year + '\'' +
          '}';
 }

 public boolean isEnabled() {
  return enabled;
 }

 public void setEnabled(boolean enabled) {
  this.enabled = enabled;
 }
}
