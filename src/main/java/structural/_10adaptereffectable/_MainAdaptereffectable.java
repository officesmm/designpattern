package structural._10adaptereffectable;

public class _MainAdaptereffectable {
    public static void main(String args[]) {
        // careting and releaseing bullet
        Effectable gun1 = new FireBullet();
        gun1.applyEffect(2);

        Effectable gun2= new IceBullet();
        gun2.applyEffect(2);

        // hitting bullet
        gun1.receiveEffect();
        gun2.receiveEffect();
    }
}
