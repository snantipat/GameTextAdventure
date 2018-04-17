package hunter.s.adventure.game;
public abstract class Character {
    private int Hp;
    private int Atk;
    private int Gold;
    private int Exp;
    private final String Name;
    Character(String name,int hp,int atk,int exp,int gold){
        this.Name=name;
        this.Hp=hp;
        this.Atk=atk;
        this.Exp=exp;
        this.Gold=gold;
    }
    public int getHP(){
        return this.Hp;
    }
    public int getATK(){
        return this.Atk;
    }
    public int getEXP(){
        return this.Exp;
    }
    public int getGOLD(){
        return this.Gold;
    }
    public void setHP(int hp){
        this.Hp+=hp;
    }
    public void setATK(int atk){
        this.Atk+=atk;
    }
    public void setEXP(int exp){
        this.Exp+=exp;
    }
    public void setGOLD(int gold){
        this.Gold+=gold;
    }
    public String getNAME(){
        return this.Name;
    }
}
