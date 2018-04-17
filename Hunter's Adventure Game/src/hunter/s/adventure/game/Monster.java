package hunter.s.adventure.game;

public abstract class Monster extends Character implements MonstersInfo{
    private boolean defender;
    public Monster(int i,boolean confirm){
        this(NAME[i],HP[i],ATK[i],XP[i],GOLD[i]);
        this.defender=confirm;
    }
    public Monster(String name,int hp,int atk,int exp,int gold){
        super(name,hp,atk,exp,gold);
    }
    public boolean getCanHealing(){
        return this.defender;
    }
    public abstract void takeDamages(int damage);
    
}
