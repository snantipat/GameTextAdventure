package hunter.s.adventure.game;

public abstract class Monster extends Character implements MonstersInfo{
    private boolean attacker;
    public Monster(int i,boolean confirm){
        this(NAME[i],HP[i],ATK[i],XP[i],GOLD[i]);
        this.attacker=confirm;
    }
    public Monster(String name,int hp,int atk,int exp,int gold){
        super(name,hp,atk,exp,gold);
    }
    public boolean getAttacker(){
        return this.attacker;
    }
    public abstract void takeDamages(int damage);
    
}
