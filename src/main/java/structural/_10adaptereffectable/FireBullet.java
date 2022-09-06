package structural._10adaptereffectable;

public class FireBullet extends Bullet implements Effectable {
    private float burnArea;

    @Override
    public void applyEffect(int playerLevel) {
        switch (playerLevel){
            case 1:
                burnArea = 2.0f;
                setDmg(1);
                break;
            case 2:
                burnArea = 3.0f;
                setDmg(2);
                break;
        }
    }

    @Override
    public String receiveEffect() {
        System.out.println("hit dps " + getDmg());
        System.out.println("hit area " + burnArea);
        return null;
    }
}
