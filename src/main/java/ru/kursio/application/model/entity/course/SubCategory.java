package ru.kursio.application.model.entity.course;

import javax.persistence.*;

@Entity
@Table(name = "subcategory")
public class SubCategory {
    @Id
    @Column(name = "subcategory_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long subCategoryId;

    @Column(name = "subcategory_name", nullable = false)
    private String subCategoryName;

    public long getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(long subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }
}
