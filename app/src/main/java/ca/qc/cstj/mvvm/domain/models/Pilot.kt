package ca.qc.cstj.mvvm.domain.models

import ca.qc.cstj.mvvm.core.Constants
import kotlin.random.Random

data class Pilot(var name: String, var life:Int, var cube: Int = 0) {

    var shield = 10
    var energy = 15

    private var _experience: Int = 0
    val level: Int get(){
        return _experience / Constants.EXPERIENCE_PER_LEVEL
    }

    fun fly(revolution: Int, isTraining: Boolean){
        if(!isTraining) {
            _experience += revolution* Random.nextInt(1,2*level+1)
            shield -= Random.nextInt(2)
            life -= Random.nextInt(0,2)
            cube += Random.nextInt(0,2*level)
        }
        energy -= Random.nextInt(1,5)
    }
    fun canFly():Boolean{
        return life > 0 && energy > 0
    }

    fun recharge(){
        //todo: Add Microtransaction
        energy = Random.nextInt(0,10)
        life = 10
    }
}