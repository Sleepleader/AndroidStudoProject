package com.example.zuoye;
public class SearchResult {
    private String type;
    private String field1;
    private String field2;
    private String field3;

    public SearchResult(String type, String field1, String field2, String field3) {
        this.type = type;
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    // Getters and setters for the fields
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getField1() { return field1; }
    public void setField1(String field1) { this.field1 = field1; }

    public String getField2() { return field2; }
    public void setField2(String field2) { this.field2 = field2; }

    public String getField3() { return field3; }
    public void setField3(String field3) { this.field3 = field3; }
}