package hunter.s.adventure.game;
interface WeaponInfo{
    String WEANAME[]={"Heavy Sword","Short Hand Sword","Huntsman Knife"};
    int WEADAM[]={60,30,20};
}
public class Player extends Character implements WeaponInfo{
    private boolean states[]={true,false,false,false,false,
                              false,false,false,false,false};
    private int StateClear;
    private int WeaponType;
    private int potion;
    private int minibomb;
    private int Weapondamage;
    private int weaDamage[];
    private int LevelWeapons[];
    private int level_hp=1;
    private int level_atk=1;
    private int limit_potion;
    private int limit_minibomb;
    private int heal;
    private int explotion;
    private String WeaponName;
    Player(String n,int weapon){
        super(n,100,10,0,2000);
        this.potion= 4;
        this.states[0]=true;
        this.WeaponType=weapon;
        this.limit_potion=this.potion=3;
        this.heal=50;
        this.explotion=20;
        this.weaDamage=new int [3];
        this.weaDamage[0]=60;
        this.weaDamage[1]=30;
        this.weaDamage[2]=20;
        this.LevelWeapons=new int[3];
        this.LevelWeapons[0]=
        this.LevelWeapons[1]=
        this.LevelWeapons[2]=1;
        this.limit_minibomb=this.minibomb=1;
        switch(weapon){
            case 1:case 2:case 3: 
                this.Weapondamage=WEADAM[weapon-1]; 
                this.WeaponName=WEANAME[weapon-1];break;

        }
    }
    public void setLevelAtk(int amount){
    this.level_atk+=amount;
    }
    public void setLevelHp(int amount){
    this.level_hp+=amount;
    }
    public int getLevelAtk(){
    return this.level_atk;
    }
    public int getLevelHp(){
    return this.level_hp;
    }
    public int getWeaponDamType(int type){
        return this.weaDamage[type];
    }
    public void setWeaponType(int type){
        this.WeaponType=type;
        this.WeaponName=WEANAME[type-1];
        this.Weapondamage=weaDamage[type-1];
    }
    public int getLevelType(int index){
        return this.LevelWeapons[index];
    }
    public String getWeaponName(){
        return this.WeaponName;
    }
    public int getWeaponType(){
        return this.WeaponType;
    }
    public void Refill(){
        this.potion=limit_potion;
        this.minibomb=limit_minibomb;
    }
    public int getLevel(){
        return this.LevelWeapons[WeaponType-1];
    }
    public void UpgradeWeapon(){
        this.weaDamage[WeaponType-1]+=WEADAM[WeaponType-1];
        this.LevelWeapons[WeaponType-1]+=1;
        this.Weapondamage=weaDamage[WeaponType-1];
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
    public void setPotion(int amount){
        this.potion+=amount;
    }
    public int getPotion(){
        return this.potion;
    }
    public void setMiniBomb(int amount){
        this.minibomb+=amount;
    }
    public int getMiniBomb(){
        return this.minibomb;
    }
    public void setLimitMiniBomb(int amount){
        this.limit_minibomb+=amount;
    }
    public int getLimitMiniBomb(){
        return this.limit_minibomb;
    }
    public void setLimitPotion(int amount){
        this.limit_potion+=amount;
    }
    public int getLimitPotion(){
        return this.limit_potion;
    }
    void setHeal(int plus){
        this.heal+=plus;
    }
    void setExplotion(int plus){
        this.explotion+=plus;
    }
    int getHeal() {
        return this.heal;
    }
    int getExplotion(){
        return this.explotion;
    }
}
