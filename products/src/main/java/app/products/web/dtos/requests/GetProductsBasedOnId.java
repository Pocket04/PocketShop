package app.products.web.dtos.requests;

import java.util.List;
import java.util.UUID;

public class GetProductsBasedOnId {
    private List<UUID> ids;

    public List<UUID> getIds() {
        return ids;
    }

    public void setIds(List<UUID> ids) {
        this.ids = ids;
    }
}
