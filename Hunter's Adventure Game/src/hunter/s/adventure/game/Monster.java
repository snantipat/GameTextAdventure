package hunter.s.adventure.game;

public abstract class Monster extends Character implements MonstersInfo{
    Monster(int i){
        super(NAME[i],HP[i],ATK[i],XP[i],GOLD[i]);
    }
    public abstract void takeDamages(int damage);
}
