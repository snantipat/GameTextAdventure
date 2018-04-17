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
    public Attacker(int index){
        super(index);
    }
    @Override
    public void takeDamages(int damage){
        super.setHP(damage);
    }

}
