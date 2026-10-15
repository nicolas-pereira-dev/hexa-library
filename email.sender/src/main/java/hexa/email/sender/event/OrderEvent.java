package hexa.email.sender.event;

public class OrderEvent {
    private Long orderId;
    private String userFirstName;
    private String userEmail;

    public OrderEvent() {}

    public OrderEvent(Long orderId, String userFirstName, String userEmail) {
        this.orderId = orderId;
        this.userFirstName = userFirstName;
        this.userEmail = userEmail;
    }

    public Long getOrderId() {
        return orderId;
    }
    
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    
    public String getUserFirstName() {
        return userFirstName;
    }
    
    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }
    
    public String getUserEmail() {
        return userEmail;
    }
    
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
