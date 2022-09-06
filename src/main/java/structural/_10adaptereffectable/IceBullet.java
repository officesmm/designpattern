package structural._10adaptereffectable;

public class IceBullet extends Bullet implements Effectable {
    private float frozenTime;

    @Override
    public void applyEffect(int playerLevel) {
        switch (playerLevel) {
            case 1:
                frozenTime = 0.8f;
                setDmg(1);
                break;
            case 2:
                frozenTime = 1.2f;
                setDmg(2);
                break;
        }
    }

    @Override
    public String receiveEffect() {
        System.out.println("hit dps " + getDmg());
        System.out.println("freezing time " + frozenTime);
        return null;
    }
}

