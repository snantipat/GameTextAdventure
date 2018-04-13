package hunter.s.adventure.game;

public abstract class Monster extends Character implements MonstersInfo{
    int Gold;
    int Exp;
    int Atk;
    int Hp;
    String name;
    
    Monster(int i){
        this.name=NAME[i];
        this.Atk=ATK[i];
        this.Hp=HP[i];
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
    public int getHp(){
        return this.Hp;
    }
    public int getAtk(){
        return this.Atk;
    }
    public String getName(){
        return this.name;
    }
}
