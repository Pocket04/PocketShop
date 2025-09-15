package app.orders.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "order-table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ElementCollection
    private List<UUID> productsIds;

    @Column
    private UUID userId;

    public UUID getId() {
        return id;
    }

    public List<UUID> getProductsIds() {
        return productsIds;
    }

    public void setProductsIds(List<UUID> productsIds) {
        this.productsIds = productsIds;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
