package itcast.micorservice.entity;

public class OrderDetail {
    private String orderDetailId;
    private Item item;

    public OrderDetail(String orderDetailId, Item item) {
        this.orderDetailId = orderDetailId;
        this.item = item;
    }

    public String getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
