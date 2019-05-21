package ru.kursio.application.model.entity.course;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long categoryId;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "category_subcategory", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "subcategory_id"))
    private List<SubCategory> subcategories;

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<SubCategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<SubCategory> subcategories) {
        this.subcategories = subcategories;
    }
}
