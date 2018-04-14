package hunter.s.adventure.game;
public class Player extends Character{
    private final String name;
    private boolean states[]={true,false,false,false,false,
                              false,false,false,false,false};
    private int Gold;
    private int Exp;
    private int StateClear;
    private int WeaponType=0;
    private int potion;
    private int minibomb;
    private int Weapondamage;
    Player(){
        super();
        this.name=null;
    }
    Player(String n,int weapon){
        this.potion= 4;
        this.name= n;
        this.states[0]=true;
        this.WeaponType=weapon;
    }
    public void setpotion(int potion){
    
    }
    public int getpotion(){
        return this.potion;
    }
    public String getName(){
        return name;
    }
    public void setWeaponType(int type){
        
    }
    public int getWeaponType(){
        return this.WeaponType;
    }
    public void setWeaponDamage(int damage){
    
    }
    public int getWeaponDamage(){
        return this.Weapondamage;
    }
    void setState(boolean state,int i){
        this.states[i]=state;   
    }
    public boolean getState(int i){
        return this.states[i];
    }
    boolean[] getStates(){
        return this.states;
    }
    private void setStateClear(boolean states[]){
        int stateClear=0;
        for(int i=0;i<states.length;i++){
            if(states[i])
                stateClear++;
        }
        this.StateClear=stateClear;
    }
    public int getStateClear(){
        setStateClear(this.states);
        return this.StateClear;
    }
    public void setGold(int g){
        this.Gold+=g;
    }
    public void setExp(int xp){
        this.Exp+=xp;
    }
    public int getGold(){
        return this.Gold;
    }
    public int getExp(){
        return this.Exp;
    }
}
