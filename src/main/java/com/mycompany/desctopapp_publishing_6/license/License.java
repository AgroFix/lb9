package com.mycompany.desctopapp_publishing_6.license;

 import javax.persistence.*;

@Entity
 @Table(name ="licenses")
public class License {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

 @Column(length =45, nullable = false, name = "kind")
  private String kind;

 @Column(length =45, nullable = false, name = "ddline")
  private String ddline;

private boolean enabled;
 public Integer getId() {
  return id;
 }

 public void setId(Integer id) {
  this.id = id;
 }

 public String getKind() {
  return kind;
 }

 public void setKind(String kind) {
  this.kind = kind;
 }

 public String getDdline() {
  return ddline;
 }

 public void setDdline(String ddline) {
  this.ddline = ddline;
 }

 @Override
 public String toString() {
  return "License{" +
          "id=" + id +
          ", kind='" + kind + '\'' +
          ", ddline='" + ddline + '\'' +
          '}';
 }

 public boolean isEnabled() {
  return enabled;
 }

 public void setEnabled(boolean enabled) {
  this.enabled = enabled;
 }
}
