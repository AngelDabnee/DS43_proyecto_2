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

            if(numFaceText.isNotEmpty()){
                var numFaceInt = numFaceText.toInt()
                var deadRoll = Dead(numFaceInt)
                var endFaces = deadRoll.roll()
                result.text = endFaces.toString()
            }else{
                result.text = "No pusiste numero"
            }

        }
    }
}