/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hunter.s.adventure.game;

/**
 *
 * @author Domekenji
 */
public class Attacker extends Monster{
    int hp;
    
    public Attacker(int index){
        super(index);
        this.hp=super.HP[index];
    }
    @Override
    public void takeDamages(int damage){
        this.hp+=damage;
    }
    public int gethp(){
        return this.hp;
    }
}
