package structural._17proxy;

public class _MainProxy {
    public static void main(String[] args)
    {
        OfficeInternetAccess access = new ProxyInternetAccess("Ashwani Rajput");
        access.grantInternetAccess();
    }
}
