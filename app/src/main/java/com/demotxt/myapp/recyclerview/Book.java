package com.demotxt.myapp.recyclerview;

/**
 * Created by Aws on 28/01/2018.
 */

public class Book {

    private String Title;
    private String Category;
    private String Description;
    private String AuthorName;
    private String PDFAsset;
    private int Thumbnail;


    public Book() {
    }

    public Book(String title, String authorName, String category, String description, int thumbnail, String pdfAsset) {
        Title = title;
        Category = category;
        Description = description;
        Thumbnail = thumbnail;
        PDFAsset = pdfAsset;
        AuthorName = authorName;

    }

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }

    public String getTitle() {
        return Title;
    }

    public String getCategory() {
        return Category;
    }

    public String getDescription() {
        return Description;
    }

    public int getThumbnail() {
        return Thumbnail;
    }


    public void setTitle(String title) {
        Title = title;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }

    public String getPDFAsset() {
        return PDFAsset;
    }

    public void setPDFAsset(String PDFAsset) {
        this.PDFAsset = PDFAsset;
    }


}