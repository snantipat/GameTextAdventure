package hunter.s.adventure.game;
import java.util.ArrayList;
public final class State extends Map implements StatesInfo{
    private int G;
    private int Xp;
    private final int StateAt;
    private int amountWave;
    private boolean waveFine;
    private boolean battle=true;
    private String wave_s[];
    private int hp;
    private int potion;
    private int miniBomb;
    ArrayList<Monster> Mons= new ArrayList();
    
    public State(int stateAt,Player p1){
        super(p1);
        this.StateAt=stateAt;
        decodeState(States[stateAt]);
        showPlace();
        
    }
    @Override
    public void showPlace(){
        if(waveFine){
            this.amountWave=this.wave_s.length;
            System.out.println(">State "+(StateAt+1));
        }else
            System.out.printf(">Load Waves fail!",StateAt+1);
    }
    public void decodeState(String raw){
        String waves[]=null;
        boolean notFail=true;
        String key="";
        String wave="";
        int index=0;
        int length;
        for(int i=raw.length()-1;i>=0&&notFail;i--){
            switch(raw.charAt(i)){
                case'0':case'1':case'2':case'3':case'4':
                case'5':case'6':case'7':case'8':case'9':
                    key+=raw.charAt(i);
                    wave+=raw.charAt(i);
                break;
                case'w':
                    length=tool.StringToNum(key,0);
                    waves=new String[length];
                    index=length-1;
                    key="";
                    wave="";
                break;
                case'm':
                    int index_m=tool.StringToNum(key,0);
                    if(index_m<0||index_m>MonstersInfo.NAME.length)
                        notFail=false;
                    key="";
                    wave+=raw.charAt(i);
                break;
                case'n':
                    if(index>=0)
                        waves[index]=wave;
                    else
                        notFail=false;
                    
                    wave="";
                    index-=1;
                    
                break;
                case'_':
                    wave+=raw.charAt(i);
                    key="";
                    break;
                case'e':
                    if(index==0)
                        waves[index]=wave;
                        
                    else
                        notFail=false;
                    key="";
                break;
                default:notFail=false;
            }
        }
        if(waves!=null&&notFail){
            this.wave_s=waves;
        }else
            notFail=false;
        this.waveFine=notFail;
    }
    public boolean wave(int waveAt,int hp){
        boolean pass=false;
        boolean inwave = true;
        
        String input;
        resetWave();
        addMonsWaveAt(waveAt);
        Monster mon;
        Player P1=super.player;
        System.out.println("[Wave "+(waveAt+1)+"]");
        while(inwave&&hp>0){
            
            System.out.println("< Your's turn >");
            for(int i=0;i<Mons.size();i++){
                mon=Mons.get(i);
                System.out.printf("\t(%d) %s hp<%d> atk<%d>\n"
                        + "",i+1,mon.getNAME(),mon.getHP(),mon.getATK());
                
            }
            System.out.println("\t\tPlayer [ "+P1.getNAME()+" ]"
                    + "\n hp<"+hp+"/"+P1.getHP()+">"
                    + "  atk <"+P1.getATK()+"> + <"
                    + P1.getWeaponDamage()+">"
                    + " weapon damages");
            System.out.println("Attack(a)\tUse Item(i)\tEscape(b)");
            boolean choosenull=true;
            boolean attack=false;
            boolean useitem=false;
            boolean endturn=false;
            while(choosenull){
                System.out.print("choose :");input=tool.enter.nextLine();
                switch(input){
                    case"a":attack=true;choosenull=false;break;
                    case"i":useitem=true;choosenull=false;break;
                    case"b":
                        this.battle=false;
                        inwave=false;
                        choosenull=false;
                        pass=false;
                        break;
                }
            }
            
            //your turn
            int counting=1;
            while(attack){
                while(Mons.size()>0&&counting<=P1.getWeaponType()){
                    System.out.println(">Attack");
                    for(int i=0;i<Mons.size();i++){
                        mon=Mons.get(i);
                        System.out.printf("\t(%d) %s hp<%d> atk<%d>\n",
                                i+1,mon.getNAME(),
                                mon.getHP(),mon.getATK());
                    }
                    System.out.print("attack counting at("+counting+"):");
                    input=tool.enter.nextLine();
                    if(tool.StringToNum(input)&&tool.getNum()>0
                            &&tool.getNum()<=Mons.size()){
                        
                        int monAt=tool.getNum()-1;
                        mon=Mons.get(monAt);
                            mon.takeDamages(-(P1.getATK()
                                    +P1.getWeaponDamage()));
                            System.out.println("\t[Player]"+P1.getNAME()
                                    + " attacked to [Monster]"+mon.getNAME()
                                    + " "+(P1.getATK()+P1.getWeaponDamage())
                                    +" damages");
                            counting+=1;
                        if(mon.getHP()<=0){
                            System.out.println("\t[Monster]"+mon.getNAME()
                                    + " was eliminated by [Player]"
                                    +P1.getNAME());
                            this.G+=mon.getGOLD();
                            this.Xp+=mon.getEXP();
                            Mons.remove(monAt);
                        }
                       tool.enterToContinue();
                        
                        endturn=true;
                        attack=false;
                    }else{
                        System.out.println("Monster at ("
                                +input+") dose not exist.");
                       tool.enterToContinue();
                        
                    }
                }
                
            }
            while(useitem){
                System.out.println(">Use item"
                        + "\n\t(1)heal potion "+P1.getPotion()+"X"
                        + "\n\t(2)mini bomb "+P1.getMiniBomb() +"X"
                        + "\n\nBack(b)");
                boolean select_null=true;
                while(select_null){
                    System.out.print("choose :");input=tool.enter.nextLine();
                    switch(input){
                        case"1":
                            if(P1.getPotion()>0){
                                usingPotion(-1);
                                System.out.println("[Player]"+P1.getNAME() 
                                        +" Healing +"+P1.getHeal()+" hp");
                                P1.setPotion(-1);
                                hp+=P1.getHeal();
                                if(hp>P1.getHP())
                                    hp=P1.getHP();
                            }else
                              System.out.println("- run out of heal potion -");
                            useitem=false;
                            select_null=false;
                           tool.enterToContinue();
                            
                        break;
                        case"2":
                            if(P1.getMiniBomb()>0){
                                for(int i = 0;i<Mons.size();i++){
                                    mon=Mons.get(i);
                                    mon.takeDamages(-P1.getExplotion());
                                    System.out.println("\t[Monster]"
                                            +mon.getNAME()
                                            +" taken "+P1.getExplotion()
                                            +" damages from explotion");
                                                                       
                                    if(mon.getHP()<0){
                                        System.out.println("\t[Monster]"
                                                +mon.getNAME()
                                            + " was eliminated by [Player]"
                                                +P1.getNAME()+"]");
                                        this.G+=mon.getGOLD();
                                        this.Xp+=mon.getEXP();
                                        Mons.remove(i);
                                    }
                                    
                                }
                                P1.setMiniBomb(-1);
                                usingMiniBomb(-1);
                                endturn=true;
                                useitem=false;
                            }else
                                System.out.println("- run out of mini bomb -");
                           tool.enterToContinue();
                            
                            select_null=false;
                        break;
                        case"b":
                            useitem=false;
                            select_null=false;
                        break;
                    }
                }
            }
            //monster's turn
            if(endturn&&Mons.size()>0&&hp>0){    
                System.out.println("< Monsters's Turn >");
                
                for(int i=0;i<Mons.size()&&endturn;i++){
                    mon=Mons.get(i);
                    if(mon.getCanHealing()){
                        if(Mons.size()>1){
                            for(int indexHeal=0;indexHeal<Mons.size();
                                    indexHeal++){
                                mon=Mons.get(indexHeal);
                                mon.takeDamages(hp/4);
                                if(indexHeal!=i)
                                    System.out.println("\t[Monster]"
                                            +mon.getNAME()
                                            +" healing +"+(hp/4)
                                            +" hp to [Monster]"
                                            +mon.getNAME());
                                else
                                    System.out.println("\t[Monster]"
                                            +mon.getNAME()
                                            +" heal +"+(hp/4)
                                            +" hp to it self");
                            }
                        }else{
                            mon.takeDamages(hp/4);
                            System.out.println("\t[Monster]"+mon.getNAME()
                                            +" heal +"+(hp/4)
                                            +" hp to it self");
                        }
                        
                    }else{
                        int damage=-mon.getATK();
                        hp+=damage;
                        System.out.println("\t[Monster]"+mon.getNAME()
                                + " attacked to [Player]"+P1.getNAME()
                                + " "+mon.getATK()+" damages");
                    }
                }
               
                
            }
            if(hp<=0){
                System.out.println("----------Defeat---------");
                    inwave=false;
            }
            if(Mons.isEmpty()){
                pass=true;
                inwave=false;    
            }
        }
        this.hp=hp;
        return pass;
    }
    public void Result(boolean won){
        Player P1=super.player;
        if(won){
            this.G+=100*(StateAt+1);
            this.Xp+=50*(StateAt+1);
            System.out.println(">STATE COMPLETE"
                    + "\n\t+ BONUS GOLD "+this.G
                    + "\n\t+ BONUS EXP "+this.Xp);
            
            
        }else
            System.out.println(">STATE FAIL");
        if(this.StateAt<9){
            System.out.println("\tExp +"+this.Xp
                +"\n\tGold +"+this.G);
            if(won){
                System.out.println("\tState "+(this.StateAt+1)+" Clear."
                        + "\n\tState "+(this.StateAt+2)+" Unlock.");
                P1.setState(won,StateAt+1);
            }
        }
        else{
            System.out.println("\tExp +"+this.Xp
                +"\n\tGold +"+this.G);
            if(won)        
                System.out.println("\tAll States Clear");
        }
       tool.enterToContinue();
        
        P1.setEXP(this.Xp);
        P1.setGOLD(this.G);
    }
    private void addMonsWaveAt(int i){
        String codeWave=wave_s[i];
        boolean codeFine=true;
        String key="";
        int amount=0;
        Monster mon;
        for(int runChar=0;runChar<codeWave.length()&&codeFine;runChar++){
            switch(codeWave.charAt(runChar)){
                case'0':case'1':case'2':case'3':case'4':
                case'5':case'6':case'7':case'8':case'9':
                    key+=codeWave.charAt(runChar);
                break;
                case'm':
                    int indexMon=tool.StringToNum(key,2);
                    if(indexMon==15){
                        
                        while(amount>0){
                            
                            mon =new Defender(indexMon);
                            this.Mons.add(mon);
                        amount-=1;
                        }
                        
                        
                    }else{
                        
                        while(amount>0){
                            mon =new Attacker(indexMon);
                            this.Mons.add(mon);
                        amount-=1;
                        }
                    }
                    
                    key="";
                break;
                case'_':
                    amount=tool.StringToNum(key,2);
                    key="";
                break;
                default:codeFine=false;
            }
        }
    }
    
    public int getAmountWave(){
        return this.amountWave;
    }
    public int getHp(){
        return this.hp;
    }
    public boolean getBattle(){
        return this.battle;
    }
    private void usingPotion(int used){
        this.potion+=used;
    }
    private void usingMiniBomb(int used){
        this.miniBomb+=used;
    }
    public int getUsedPotion(){
        return this.potion;
    }
    public int getUsedMiniBomb(){
        return this.miniBomb;
    }
    public int getXp(){
        return Xp;
    }
    public int getG(){
        return G;
    }
    public void resetWave(){
        this.miniBomb=0;
        this.potion=0;
    }
}