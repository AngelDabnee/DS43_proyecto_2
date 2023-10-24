package AngelDabnee.dados.models

import kotlin.random.Random

data class Dead (private val cara :Int){
    fun roll(): Int{
        return Random.nextInt(1,cara+1)
    }


}