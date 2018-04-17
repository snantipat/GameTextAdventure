package hunter.s.adventure.game;
interface weaponname{
    String WEANAME[]={"Heavy Sword","Short Hand Sword","Huntsman Knife"};
    int WEADAM[]={60,30,20};
}
public class Player extends Character implements weaponname{
    private final String name;
    private boolean states[]={true,false,false,false,false,
                              false,false,false,false,false};
    private int Gold;
    private int Exp;
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
    private int Hp;
    private int Atk;
    private int heal;
    private int explotion;
    private String WeaponName;
    Player(){
        super();
        this.name=null;
    }
    Player(String n,int weapon){
        this.Gold=2000;
        this.potion= 4;
        this.name= n;
        this.states[0]=true;
        this.WeaponType=weapon;
        this.Hp=100;
        this.Atk=7;
        this.limit_potion=this.potion=3;
        this.heal=50;
        this.explotion=20;
        this.weaDamage=new int [3];
        this.weaDamage[0]=60;
        this.weaDamage[1]=30;
        this.weaDamage[2]=20;
        this.LevelWeapons=new int[3];
        this.LevelWeapons[0]=1;
        this.LevelWeapons[1]=1;
        this.LevelWeapons[2]=1;
        this.limit_minibomb=this.minibomb=1;
        switch(weapon){
            case 1:case 2:case 3: this.Weapondamage=WEADAM[weapon-1]; this.WeaponName=weaponname.WEANAME[weapon-1];break;

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
    public String getName(){
        return name;
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
