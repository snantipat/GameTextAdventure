package hunter.s.adventure.game;
public class Defender extends Monster{
    public Defender(int index){
        super(index,true);
    }
    @Override
    public void takeDamages(int damage){
        super.setHP(damage);
    }
}
