package ejemplo.servicioandroid;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import ejemplo.servicioandroid.R;

/**
 * Created by Angelus on 23/11/2016.
 */
public class ServicioReproductor extends Service {

    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(getBaseContext(),"Servicio Creado",Toast.LENGTH_SHORT).show();
        mediaPlayer=MediaPlayer.create(this, R.raw.badtothebone);
        mediaPlayer.setLooping(false);
        //crear el listener para cuando la cancion finaliza
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                //reproducir la nueva cancion
            }
        });
    }

    @Override
    public void onStart(Intent intent, int startId) {
        Toast.makeText(getBaseContext(),"Servicio Iniciado",Toast.LENGTH_SHORT).show();
        mediaPlayer.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getBaseContext(),"Servicio Detenido",Toast.LENGTH_SHORT).show();
        mediaPlayer.stop();
    }
}
