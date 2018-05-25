package cl.ubiobio.serviciodesaludbio_bio;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMayorActivity extends AppCompatActivity implements View.OnClickListener {

    private Button cambiarj;
    private SharedPreferences sharedPre;
    private SharedPreferences.Editor editorSP;
    private int MODO_JOVEN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mayor);
        sharedPre = getSharedPreferences(getString(R.string.sharedPreID), MODE_PRIVATE);
        editorSP = sharedPre.edit();
        cambiarj = findViewById(R.id.cambiar_a_joven);
        cambiarj.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        editorSP.putInt("MODO",MODO_JOVEN);
        editorSP.commit();
        Intent cambiarj = new Intent(MainMayorActivity.this, MainJovenActivity.class);
        startActivity(cambiarj);
        finish();
    }
}
