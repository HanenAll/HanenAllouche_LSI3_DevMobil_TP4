package com.example.mesure_de_niveau_de_glycemie.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mesure_de_niveau_de_glycemie.R;
import com.example.mesure_de_niveau_de_glycemie.controller.Controller;


public class MainActivity extends AppCompatActivity {
    private EditText etValeur; //l’EditText qui comporte la valeur mesurée.
    private TextView tvAge , tvJeunez; //le TextView qui comporte le question de  l'age(tvAge)
    //le texteView qui comporte le question Est-ce que vous jeunez ? (tvJeunez)
    private SeekBar sbAge; // le SeekBar qui comporte l'age.
    private RadioButton rbIsFasting,rbIsNotFasting; // les 2 boutons qui repondent
    // au question:Est-ce que vous jeunez ?
    private Button btnConsulter; // le bouton de consultation
     private Controller controller= Controller.getInstance(); //instance de la classe Controller

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            /*cette methode est un listener sur le changement du seekbar , en fait lorsque
            l'utilisateur diminue ou augmente la valeur de seekbar, Le TextView, dont l’ID
            est “tvAge” affiche un message à l’utilisateur qui comporte : Votre âge + la valeur choisie
             et ça est fait par la methode onProgressChanged(..) qui est à l'interieure de la methode
              OnseekBarChangeListner() */
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("Information", "onProgressChanged " + progress);
                // affichage dans le Log de Android studio pour voir les changements détectés sur le SeekBar ..
                tvAge.setText("Votre âge : " + progress);
                // Mise à jour du TextView par la valeur : progress à chaque changement.
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        btnConsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Information", "button cliqué");
                int age;
                float valeurMesuree;
                boolean verifAge = false, verifValeur = false;
                if (sbAge.getProgress() != 0)
                    verifAge = true;
                else
                    Toast.makeText(MainActivity.this, "Veuillez saisir votre age !",

                            Toast.LENGTH_SHORT).show();

                if (!etValeur.getText().toString().isEmpty())
                    verifValeur = true;
                else
                    Toast.makeText(MainActivity.this, "Veuillez saisir votre valeur mesurée !",

                            Toast.LENGTH_LONG).show();

                if (verifAge && verifValeur) {
                    age = sbAge.getProgress();
                    valeurMesuree = Float.valueOf(etValeur.getText().toString());
                    //Flèche "User action" Vue --> Controller
                    controller.CreatePatient(age, valeurMesuree, rbIsFasting.isChecked());
                    //Flèche "Update" Controller --> vue
                    tvJeunez.setText(controller.getResponse());
                }
            }
        });
    }
    private void init(){
        /* dans cette methode on va initialiser les attributs de la classe MainActivity en
         recuperant leurs references dans la mise en page */
        etValeur=findViewById(R.id.etValeur); /*la methode findViewById permet de rechercher
        suivant son ID dans la mise en page associée à l’activité.*/
        tvAge=findViewById(R.id.tvAge);
        sbAge=findViewById(R.id.sbAge);
        tvJeunez=findViewById(R.id.tvJeunez);
        rbIsFasting=findViewById(R.id.rbOui);
        rbIsNotFasting=findViewById(R.id.rbNon);
        btnConsulter=findViewById(R.id.btnConsulter);

    }
}