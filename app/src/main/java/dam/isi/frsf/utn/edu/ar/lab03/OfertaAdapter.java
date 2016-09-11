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

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class OfertaAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<Trabajo> items;

    public OfertaAdapter(Context context, List<Trabajo> items){
        super();
        this.items = items;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Trabajo getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return items.get(i).getId();
    }

    @Override
    public View getView(int i, View recicledView, ViewGroup viewGroup) {
        View row = recicledView;
        if(row == null){
            row = inflater.inflate(R.layout.item_oferta, viewGroup, false);
        }
        OfertaHolder holder = (OfertaHolder) row.getTag();
        if(holder == null){
            holder = new OfertaHolder(row);
            row.setTag(holder);
        }
        holder.cargarDatos(getItem(i));
        return row;
    }
}
