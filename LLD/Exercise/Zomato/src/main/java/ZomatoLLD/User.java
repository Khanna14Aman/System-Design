package ZomatoLLD;

public class User {
    private final String name;
    private final String address;
    private final Cart cart;
    private final String phoneNumber;

    public User(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.cart = new Cart();
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Cart getCart() {
        return cart;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
