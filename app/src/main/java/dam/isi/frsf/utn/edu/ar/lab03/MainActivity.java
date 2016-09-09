/*
 * Copyright (c) 2016 Daniel Campodonico; Emiliano Gioria; Lucas Moretti.
 * This file is part of Lab01c2016.
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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener{

    ListView listaOfertas;
    OfertaAdapter adaptadorListaOfertas;
    List<Trabajo> ofertas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargarParametros();

        listaOfertas.setAdapter(adaptadorListaOfertas);
        registerForContextMenu(listaOfertas);
    }

    private void cargarParametros() {
        ofertas = new ArrayList<Trabajo>();
        listaOfertas = (ListView) findViewById(R.id.listaOfertas);
        adaptadorListaOfertas = new OfertaAdapter(this,ofertas);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuToolbarMain, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menuCrearOferta:
                Toast.makeText(this,"Llamar pantalla crear ofertas",Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info;

        switch (item.getItemId()){
            case R.id.menuPostularseOferta:
                //TODO postularse oferta
                info = (AdapterView.AdapterContextMenuInfo) item;
                Toast.makeText(this,"Hacer postularse oferta",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuCompartirOferta:
                //TODO compartir oferta
                info = (AdapterView.AdapterContextMenuInfo) item;
                Toast.makeText(this,"Hacer compartir oferta",Toast.LENGTH_SHORT).show();
                break;
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
                inflater.inflate(R.menu.menuOfertaMain, menu);
                break;
            default:
        }
    }

    @Override
    public boolean onLongClick(View view) {
        Toast.makeText(getApplicationContext(),"Hola",Toast.LENGTH_SHORT).show();
        return false;
    }
}
