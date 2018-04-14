package hunter.s.adventure.game;
import java.util.ArrayList;
public class State extends Map implements StatesInfo{
    int G;
    int Xp;
    int StateAt;
    int amountWave;
    int amountMon;
    boolean waveFine;
    boolean battle=true;
    String waves[];
    Player player;
    int hp;
    int potion;
    int miniBomb;
    boolean waveNotDone;
    char con_num[]={'0','1','2','3','4','5','6','7','8','9'};
    ArrayList<Monster> Mons= new ArrayList();
    State(int stateAt){
        this.StateAt=stateAt;
        decodeState(States[stateAt]);
        
        if(waveFine){
            for(int i=0;i<waves.length;i++)
                System.out.println(waves[i]);
            this.amountWave=this.waves.length;
            System.out.println(">State "+(stateAt+1));
        }else
            System.out.printf(">Load Waves fail!",stateAt);
    }
    State(){
        super();
    }
    int chooseState(){
        int i=0;
        return i;
    }
    int getXp(){
        return Xp;
    }
    int getG(){
        return G;
    }
    int setState(boolean[] states_p){
        int stateAt=0;
        return stateAt;
    }
    
    public void decodeState(String raw){
        String waves[]=null;
        //em0_2nm0_3nm0_3nm1_1w4 <
        boolean notFail=true;
        String key="";
        String wave="";
        int index=0;
        int length=0;
        for(int i=raw.length()-1;i>=0&&notFail;i--){
            switch(raw.charAt(i)){
                case'0':case'1':case'2':case'3':case'4':
                case'5':case'6':case'7':case'8':case'9':
                    key+=raw.charAt(i);
                    wave+=raw.charAt(i);
                break;
                case'w':
                    length=StringToNum(key,0);
                    waves=new String[length];
                    index=length-1;
                    key="";
                    wave="";
                break;
                case'm':
                    int index_m=StringToNum(key,0);
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
            this.waves=waves;
        }else
            notFail=false;
        this.waveFine=notFail;
    }
    public boolean wave(int waveAt,int hp,Player player){
        boolean pass=true;
        boolean inwave = true;
        Tools_pack tool=new Tools_pack();
        String input;
        resetWave(player);
        addMonsWaveAt(waveAt);
        Monster mon;
        System.out.println("[Wave "+(waveAt+1)+"]");
        while(inwave){
            boolean endturn=false;
            System.out.println("< Your's turn >");
            for(int i=0;i<Mons.size();i++){
                mon=Mons.get(i);
                System.out.printf("\t(%d) %s hp<%d> atk<%d>\n",i+1,mon.getName(),
                        mon.gethp(),mon.getAtk());
                
            }
            System.out.println("\t\tPlayer [ "+player.getName()+" ]"
                            + "\n\t     hp<"+hp+"/"+player.getHp()+">"
                            + "  atk <"+player.getAtk()+">");
            System.out.println("Attack(a)\tUse Item(i)\tSurrender(b)");
            boolean choosenull=true;
            boolean attack=false;
            boolean useitem=false;
            
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
            
            int counting=player.getWeaponType();
            //your turn
            while(attack){
                while(counting>0&&Mons.size()>0){
                    System.out.println(">Attack");
                    for(int i=0;i<Mons.size();i++){
                        mon=Mons.get(i);
                        System.out.printf("\t(%d) %s hp<%d> atk<%d>\n",i+1,mon.getName(),
                                mon.gethp(),mon.getAtk());
                    }
                    System.out.print("attack:");input=tool.enter.nextLine();
                    if(tool.StringToNum(input)&&tool.getNum()>0&&tool.getNum()<=Mons.size()){
                        int monAt=tool.getNum()-1;
                        mon=Mons.get(monAt);
                        mon.takeDamages(-(player.getAtk()+player.getWeaponDamage()));
                        System.out.println("\t[Player]"+player.getName()
                                + " attacked to [Monster]"+mon.getName()
                                + " "+(player.getAtk()+player.getWeaponDamage())+" damages");
                        if(mon.gethp()<0){
                            System.out.println("\t[Monster]"+mon.getName()
                                    + " was eliminated by [Player]"+player.getName());
                            this.G+=mon.getGold();
                            this.Xp+=mon.getExp();
                            Mons.remove(monAt);
                        }
                        counting-=1;
                        if(counting>0){
                            System.out.println("weapon effected! you can attack "
                                    + counting);
                            if(counting>1)
                                System.out.println(" times.");
                            else
                                System.out.println(" time.");
                        }   
                                
                    }else
                        System.out.println("Monster at ("+input+") dose not exist.");
                }
                endturn=true;
                attack=false;
                
            }
            while(useitem){
                System.out.println(">Use item"
                        + "\n\t(1)heal potion "+player.getPotion()+"X"
                        + "\n\t(2)mini bomb "+player.getMiniBomb() +"X"
                        + "\n\nBack(b)");
                boolean select_null=true;
                while(select_null){
                    System.out.print("choose :");input=tool.enter.nextLine();
                    switch(input){
                        case"1":
                            if(player.getPotion()>0){
                                usingPotion(-1);
                                System.out.println("[Player]"+player.getName() 
                                        +" Healing +"+player.getHeal()+" hp");
                                endturn=true;
                                player.setPotion(-1);
                                hp+=player.getHeal();
                                if(hp>player.getHp())
                                    hp=player.getHp();
                            }else
                                System.out.println("- run out of heal potion -");
                            select_null=false;
                        break;
                        case"2":
                            if(player.getMiniBomb()>0){
                                for(int i = 0;i<Mons.size();i++){
                                    mon=Mons.get(i);
                                    mon.takeDamages(-player.getExplotion());
                                    System.out.println("\t[Monster]"+mon.getName()
                                            +" taken "+player.getExplotion()
                                            +" damages from explotion");
                                                                       
                                    if(mon.gethp()<0){
                                        System.out.println("\t[Monster]"+mon.getName()
                                            + " was eliminated by [Player]"+player.getName()+"]");
                                        this.G+=mon.getGold();
                                        this.Xp+=mon.getExp();
                                        Mons.remove(i);
                                    }
                                }
                                player.setMiniBomb(-1);
                                usingMiniBomb(-1);
                                endturn=true;
                                useitem=false;
                            }else
                                System.out.println("- run out of mini bomb -");
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
            if(endturn&&Mons.size()>0){    
                System.out.println("< Monsters's Turn >");
                
                for(int i=0;i<Mons.size()&&endturn;i++){
                    mon=Mons.get(i);
                    if(mon.getAtk()==0){
                        if(Mons.size()>1){
                            for(int indexHeal=0;indexHeal<Mons.size();indexHeal++){
                                mon=Mons.get(indexHeal);
                                mon.takeDamages(hp/4);
                                if(indexHeal!=i)
                                    System.out.println("\t[Monster]"+mon.getName()
                                            +" healing +"+(hp/4)
                                            +" hp to [Monster]"+mon.getName());
                                else
                                    System.out.println("\t[Monster]"+mon.getName()
                                            +" heal +"+(hp/4)
                                            +" hp to it self");
                            }
                        }else{
                            mon.takeDamages(hp/4);
                            System.out.println("\t[Monster]"+mon.getName()
                                            +" heal +"+(hp/4)
                                            +" hp to it self");
                        }
                    }else{
                        int damage=-mon.getAtk();
                        hp+=damage;
                        System.out.println("\t[Monster]"+mon.getName()
                                + " attacked to [Player]"+player.getName()
                                + " "+mon.getAtk()+" damages");
                    }
                }
                if(hp<0){
                    pass=false;
                    inwave=waveNotDone=false;
                }
            }
            if(Mons.isEmpty()){
                inwave=this.waveNotDone=false;    
            }
        }
        this.hp=hp;
        return pass;
    }
    public void Result(boolean won){
        if(won)
            System.out.println(">STATE COMPLETE");
        else
            System.out.println(">STATE FAIL");
        if(this.StateAt<9){
            System.out.println("\tExp +"+this.Xp
                +"\n\tGold +"+this.G);
            if(won)
                System.out.println(">\tState "+(this.StateAt+2)+"Clear");
        }
        else{
            System.out.println("\tExp +"+this.Xp
                +"\n\tGold +"+this.G);
            if(won)        
                System.out.println("\tAll States Clear");
        }
    }
    private void addMonsWaveAt(int i){
        String codeWave=waves[i];
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
                    int indexMon=StringToNum(key,2);
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
                    amount=StringToNum(key,2);
                    key="";
                break;
                default:codeFine=false;
            }
        }
    }
    public int StringToNum(String num,int type){
        int number=0;
        int digit=1;
        String key_temp="";
        if(type==2){
            for(int i=num.length()-1;i>=0;i--){
                key_temp+=num.charAt(i);
            }
            num=key_temp;
        }
        
            for(int i=num.length()-1;i>=0;i--){
                boolean numIsNull=true;
                for(int j=0;j<con_num.length&&numIsNull;j++){
                    if(num.charAt(i)==con_num[j]){
                        number+=j*digit;digit*=10;numIsNull=false;
                    }
                }
            
            }
        
        return number;
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
    public void resetWave(Player p1){
        this.player=p1;
        this.miniBomb=0;
        this.potion=0;
        this.player=player;
        this.waveNotDone=true;
    }
}
