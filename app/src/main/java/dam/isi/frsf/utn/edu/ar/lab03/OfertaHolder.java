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

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Emiliano on 08/09/2016.
 */
public class OfertaHolder {

    TextView itemTvCategoria, itemTvNombreOferta, itemTvHoras, itemTvMaxPesoHora, itemTvFechaFin;
    ImageView itemBandera;
    CheckBox itemCbIngles;

    public OfertaHolder(View oferta){
        itemTvCategoria = (TextView) oferta.findViewById(R.id.itemTvCategoria);
        itemTvNombreOferta = (TextView) oferta.findViewById(R.id.itemTvNombreOferta);
        itemTvHoras = (TextView) oferta.findViewById(R.id.itemTvHoras);
        itemTvMaxPesoHora = (TextView) oferta.findViewById(R.id.itemTvMaxPesoHora);
        itemTvFechaFin = (TextView) oferta.findViewById(R.id.itemTvFechaFin);
        itemBandera = (ImageView) oferta.findViewById(R.id.itemBandera);
        itemCbIngles = (CheckBox) oferta.findViewById(R.id.itemCbIngles);
    }

    public void cargarDatos(Trabajo datos) {
        itemTvNombreOferta.setText(datos.getCategoria().getDescripcion());
        itemTvNombreOferta.setText(datos.getCategoria().getDescripcion());
        itemTvNombreOferta.setText(datos.getCategoria().getDescripcion());
        itemTvNombreOferta.setText(datos.getCategoria().getDescripcion());
        itemTvNombreOferta.setText(datos.getCategoria().getDescripcion());
        itemTvNombreOferta.setText(datos.getCategoria().getDescripcion());
    }
}
