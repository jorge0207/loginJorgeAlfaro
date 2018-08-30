package aplicacion.android.isotomayor.loginjorgalfaro.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import aplicacion.android.isotomayor.loginjorgalfaro.R;
import aplicacion.android.isotomayor.loginjorgalfaro.adapters.MyAdapters;
import aplicacion.android.isotomayor.loginjorgalfaro.models.alumno;
import aplicacion.android.isotomayor.loginjorgalfaro.models.usuario;
import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private MyAdapters adapter;

    private Realm realm;
    private RealmResults<alumno> people;
    private RealmResults<usuario> usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();
        listView = (ListView) findViewById(R.id.listView);

        people = getAllPeople();
        people.addChangeListener(this);

        usuario = getAllUsuario();
        usuario.addChangeListener(this);

        adapter = new MyAdapters(people, R.layout.list_item_view, this);

        listView.setAdapter(adapter);
    }

    //@Override
    public void onChange(RealmResults<alumno> element) {
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        realm.removeAllChangeListeners();
        realm.close();
        super.onDestroy();
    }

    private RealmResults<alumno> getAllPeople() {
        return realm.where(alumno.class).findAll();
    }
    private RealmResults<usuario> getAllUsuario() { return realm.where(usuario.class).findAll();
    }

    private void addPeople() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                //  Toast.makeText(getApplicationContext(),"hola",Toast.LENGTH_SHORT).show();

                alumno p1 = new alumno("Jorge", "12345678-2",22,"Genaro Gallo",112123,"Ingeniero");
                alumno p2 = new alumno("Luis", "21345678-3",21,"Pedro Prado",150541,"Trabajador");
                alumno p3 = new alumno("Rodrigo", "312345678-4",20,"Colo colo",205488,"Secretario");
                alumno p4 = new alumno("Fabrizio", "412345678-5",19,"Galvario",350648,"Tesorero");
                alumno p5 = new alumno("Camilo", "512345678-6",18,"Lincoyan",641234,"Presidente");


                realm.copyToRealmOrUpdate(p1);
                realm.copyToRealmOrUpdate(p2);
                realm.copyToRealmOrUpdate(p3);
                realm.copyToRealmOrUpdate(p4);
                realm.copyToRealmOrUpdate(p5);

                people = getAllPeople();
            }
        });
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                //  Toast.makeText(getApplicationContext(),"hola",Toast.LENGTH_SHORT).show();

                usuario p1 = new  usuario("Jorge", "123456");
                usuario p2 = new  usuario("Luis", "234567");
                usuario p3 = new  usuario("Rodrigo", "345678");
                usuario p4 = new  usuario("Fabrizio", "456789");
                usuario p5 = new  usuario("Camilo", "567894");


                realm.copyToRealmOrUpdate(p1);
                realm.copyToRealmOrUpdate(p2);
                realm.copyToRealmOrUpdate(p3);
                realm.copyToRealmOrUpdate(p4);
                realm.copyToRealmOrUpdate(p5);

                usuario = getAllUsuario();
    }
    }
}
}