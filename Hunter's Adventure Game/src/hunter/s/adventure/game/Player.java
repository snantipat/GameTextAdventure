package hunter.s.adventure.game;
public class Player extends Character{
    private final String name;
    private boolean states[]={true,false,false,false,false,
                              false,false,false,false,false};
    private int Gold;
    private int Exp;
    private int StateClear;
    private int WeaponType;
    private int potion;
    private int minibomb;
    private int limit_potion;
    private int limit_minibomb;
    private int Hp;
    private int Atk;
    Player(){
        super();
        this.name=null;
    }
    Player(String n,int weapon){
        this.name= n;
        this.states[0]=true;
        this.WeaponType=weapon;
        this.Hp=100;
        this.Atk=7;
        this.limit_potion=this.potion=3;
        this.limit_minibomb=this.minibomb=1;
    }
    public String getName(){
        return name;
    }
    public void setWeaponType(int type){
        
    }
    public int getWeaponType(){
        return this.WeaponType;
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
    public void setHp(int hp){
        this.Hp+=hp;
    }
    public void setAtk(int atk){
        this.Atk+=atk;
    }
    
    public void setPotion(int amount){
        this.potion+=amount;
    }
    public int getPotion(){
        return this.potion;
    }
    public void setMiniBomb(int amount){
        this.minibomb+=amount;
    }
    public void setLimitMiniBomb(int amount){
        this.minibomb+=amount;
    }
    public int getLimitMiniBomb(){
        return this.limit_minibomb;
       
    }
    public int getLimitPotion(){
        return this.limit_potion;
    }
    public void setLimitPotion(int amount){
        this.limit_potion+=amount;
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
}
