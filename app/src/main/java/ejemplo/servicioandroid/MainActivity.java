package ejemplo.servicioandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/***
 * Esta clase executa un servicio que reproduce canciones
 *
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Variable de boton inicio para comenzar la reproduccion
     */
    private Button btnInicio;

    private Button btnDetener;

    private Button btnSig;

    /**
     * Medoto que crea una actividad
     * @param savedInstanceState recive parametros de inicio
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInicio=(Button) findViewById(R.id.btnInicio);
        btnDetener=(Button) findViewById(R.id.btnDetener);
        btnSig=(Button) findViewById(R.id.btnSig);
        btnInicio.setOnClickListener(listener);
        btnSig.setOnClickListener(listener);
        btnDetener.setOnClickListener(listener);
    }

    /**
     * Listener para recibir los eventos del mouse
     * Este listener sirver para crear la reproducion del servicio
     * 1.-...
     * 2.-...
     * 3.-...
     */
    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnInicio:
                    startService(new Intent(getBaseContext(),ServicioReproductor.class));
                    break;
                case  R.id.btnDetener:
                    stopService(new Intent(getBaseContext(),ServicioReproductor.class));
                    break;
                case R.id.btnSig:
                    // Otras actividades
                    break;
            }
        }
    };
}
