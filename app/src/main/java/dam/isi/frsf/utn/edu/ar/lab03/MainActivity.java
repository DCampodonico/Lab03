/*
 * Copyright (c) 2016 Daniel Campodonico; Emiliano Gioria; Lucas Moretti.
 * This file is part of Lab03.
 *
 * Lab03 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Lab03 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Lab03.  If not, see <http://www.gnu.org/licenses/>.
 */

package dam.isi.frsf.utn.edu.ar.lab03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listaOfertas;
    private OfertaAdapter adaptadorListaOfertas;
    private List<Trabajo> ofertas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargarParametros();

        listaOfertas.setAdapter(adaptadorListaOfertas);
        registerForContextMenu(listaOfertas);
    }

    private void cargarParametros() {
        ofertas = new ArrayList<>();
        listaOfertas = (ListView) findViewById(R.id.listaOfertas);
        adaptadorListaOfertas = new OfertaAdapter(this,ofertas);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menuCrearOferta:
                Intent intent = new Intent(this,CrearOfertaActivity.class);
                startActivityForResult(intent,0);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        MenuInflater inflater = getMenuInflater();

        switch (v.getId()){
            case R.id.listaOfertas:
                menu.setHeaderTitle(getResources().getString(R.string.menu_titulo_acciones));
                inflater.inflate(R.menu.menu_oferta_main, menu);
                break;
            default:
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info;

        switch (item.getItemId()){
            case R.id.menuPostularseOferta:
                info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                Toast.makeText(this,getResources().getString(R.string.postulacion_registrada) + ": \"" + ofertas.get(info.position) + "\".",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuCompartirOferta:
                info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                Trabajo trabajoSeleccionado = ofertas.get(info.position);

                Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.postularse_oferta));
                intent.putExtra(Intent.EXTRA_TEXT,getResources().getString(R.string.postularme_oferta) + ": " + trabajoSeleccionado.getDescripcion() + ".");
                startActivity(Intent.createChooser(intent,getResources().getString(R.string.postularse_oferta)));
                break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(data != null){
            Trabajo trabajo = (Trabajo) data.getSerializableExtra("resultado");
            ofertas.add(trabajo);
            adaptadorListaOfertas.notifyDataSetChanged();
        }
    }
}
