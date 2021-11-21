package com.mycompany.desctopapp_publishing_6.author;

 import javax.persistence.*;

@Entity
 @Table(name ="authors")
public class Author {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false, unique = true, length = 45)
  private String age;

 @Column(length =45, nullable = false, name = "first_name")
  private String firstName;

 @Column(length =45, nullable = false, name = "last_name")
  private String lastName;

private boolean enabled;
 public Integer getId() {
  return id;
 }

 public void setId(Integer id) {
  this.id = id;
 }

 public String getAge() {
  return age;
 }

 public void setAge(String age) {
  this.age = age;
 }

 public String getFirstName() {
  return firstName;
 }

 public void setFirstName(String firstName) {
  this.firstName = firstName;
 }

 public String getLastName() {
  return lastName;
 }

 public void setLastName(String lastName) {
  this.lastName = lastName;
 }

 @Override
 public String toString() {
  return "Author{" +
          "id=" + id +
          ", age='" + age + '\'' +
          ", firstName='" + firstName + '\'' +
          ", lastName='" + lastName + '\'' +
          '}';
 }

 public boolean isEnabled() {
  return enabled;
 }

 public void setEnabled(boolean enabled) {
  this.enabled = enabled;
 }
}
