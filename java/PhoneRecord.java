public class PhoneRecord {
    private String name;
    private String phone;
    public PhoneRecord(String s1, String s2) {
        name = s1;
        phone = s2;
    }
    public String toString() {
        return name + " " + phone;
    }
    public String getName( ) {
        return name;
    }
    public String getPhone( ) {
        return phone;
    }
}