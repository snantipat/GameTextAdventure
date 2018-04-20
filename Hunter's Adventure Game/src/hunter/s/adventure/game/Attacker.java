package hunter.s.adventure.game;
public class Attacker extends Monster{
    public Attacker(int index){
        super(index,false);
    }
    @Override
    public void takeDamages(int damage){
        super.setHP(damage);
    }

}
