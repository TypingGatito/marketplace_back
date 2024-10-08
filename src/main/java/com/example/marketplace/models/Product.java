package com.example.marketplace.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Column(name = "price")
    private int price;

    @Column(name = "city")
    private String city;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,
    mappedBy = "product")
    private List<Image> images = new ArrayList<>();

    private Long previewImageId;

    private LocalDateTime timeOfCreation;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn
    private User user;

    @PrePersist
    private void init() {
        timeOfCreation = LocalDateTime.now();
    }

    public void addImage(Image image) {
        image.setProduct(this);
        images.add(image);
    }

    @Override
    public String toString() {
        String imagesId = this.getImages().stream()
                .map(Image::getId)
                .toString();
        String usersId = this.getUser().getUsername();
        return "Product(id=" + this.getId() + ", title=" + this.getTitle() + ", description=" + this.getDescription() + ", price=" + this.getPrice() + ", city=" + this.getCity() + ", images=" + imagesId + ", previewImageId=" + this.getPreviewImageId() + ", timeOfCreation=" + this.getTimeOfCreation() + ", userToEdit=" + usersId+ ")";
    }

}
