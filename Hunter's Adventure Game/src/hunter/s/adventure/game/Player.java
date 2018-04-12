package hunter.s.adventure.game;
public class Player extends Character{
    private final String name;
    private boolean states[]={true,false,false,false,false,
                              false,false,false,false,false};
    private int Gold;
    private int Exp;
    private int StateClear;
    private int WeaponType=0;
    Player(){
        super();
        this.name=null;
    }
    Player(String n,int weapon){
        this.name= n;
        this.states[0]=true;
        this.WeaponType=weapon;
    }
    public String getName(){
        return name;
    }
    public void setWeaponType(int type){
        
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
