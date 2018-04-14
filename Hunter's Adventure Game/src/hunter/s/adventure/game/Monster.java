package hunter.s.adventure.game;

public abstract class Monster extends Character implements MonstersInfo{
    private int Gold;
    private int Exp;
    private int Atk;
    private String name;
    
    Monster(int i){
        this.name=NAME[i];
        this.Atk=ATK[i];
        this.Exp=XP[i];
        this.Gold=GOLD[i];
    }
    Monster(){
        
    }
    public int getGold(){
        return this.Gold;
    }
    public int getExp(){
        return this.Exp;
    }
    public int getAtk(){
        return this.Atk;
    }
    public String getName(){
        return this.name;
    }
    public abstract int gethp();
    public abstract void takeDamages(int damage);
}
