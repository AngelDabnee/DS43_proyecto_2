package AngelDabnee.dados

import AngelDabnee.dados.models.Dead
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Button
import android.widget.Toast
import org.w3c.dom.Text
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Variables de Controlador:
        var numDead = findViewById<EditText>(R.id.noDados)
        var numFace = findViewById<EditText>(R.id.noDeCaras)

        //variables para resultado
        var result = findViewById<TextView>(R.id.result)
        //variables de botones
        val btndead = findViewById<Button>(R.id.btnTirar)
        val btnAgain = findViewById<Button>(R.id.btnRepetir)

        //Prueba para tirar
        btndead.setOnClickListener {
            //sacamos el numero que escribe
            var numFaceText = numFace.text.toString()
            var numDeadText = numDead.text.toString()
            //creamos la condición para decir que necesitamos los campos llenos (validmaos)
            if(numFaceText.isNotEmpty() && numDeadText.isNotEmpty()){
                //guardamos cada valor del texto del texto que tomamos del usuario en una variable castiamos cada valor a su parte int para poder hacer las operaciones
                var numFaceInt = numFaceText.toInt()
                var numDeadInt = numDeadText.toInt()
                //ahora utilizamos la función que creamos en el modelo dead.kt pasandole el valor de numero de caras el cual nos devolverá un random
                var deadRoll = Dead(numFaceInt)
                var resultado = mutableListOf<String>()
                var totalEndFaces: Int = 0 //variable para acumular
                //creamos un recorrimiento para que cada valor que le pongamos en numero de dados, se multiplique por el número de caras.
                for(i in 1..numDeadInt){
                    val endFaces = deadRoll.roll()
                    val txtdead = "Dead Num:"
                    resultado.add(txtdead+(endFaces) +"\n")
                    totalEndFaces += endFaces
                }

                result.text = resultado.toString() + "\n" + "Total Face: " + totalEndFaces.toString()
            }else{
                result.text = "No pusiste numero"
            }
        }
    }
}