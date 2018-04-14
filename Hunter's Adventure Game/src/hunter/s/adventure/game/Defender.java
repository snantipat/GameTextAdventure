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
public class Defender extends Monster{
    int hp;
    public Defender(int index){
        super(index);
        this.hp=super.getHP();
    }
    @Override
    public void takeDamages(int damage){
        this.hp+=damage;
    }
    @Override
    public int gethp(){
        return this.hp;
    }
}
