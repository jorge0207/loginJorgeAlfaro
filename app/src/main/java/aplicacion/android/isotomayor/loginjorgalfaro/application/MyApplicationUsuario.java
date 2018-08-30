package aplicacion.android.isotomayor.loginjorgalfaro.application;

import android.app.Application;

import java.util.concurrent.atomic.AtomicInteger;

import aplicacion.android.isotomayor.loginjorgalfaro.models.alumno;
import aplicacion.android.isotomayor.loginjorgalfaro.models.usuario;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class MyApplicationUsuario extends Application {

    public static AtomicInteger usuarioID = new AtomicInteger();

    @Override
    public void onCreate() {
        super.onCreate();
        // initialize Realm
        Realm.init(getApplicationContext());

        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
        Realm realm = Realm.getInstance(config);
        usuarioID = setAtomicId(realm, usuario.class);


        realm.close();
    }

    private <T extends RealmObject> AtomicInteger setAtomicId(Realm realm, Class<T> anyClass) {
        RealmResults<T> results = (RealmResults<T>) realm.where(anyClass).findAll();
        return (results.size() > 0) ? new AtomicInteger(results.max("id").intValue()) : new AtomicInteger();
    }
}
