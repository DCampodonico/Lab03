package dam.isi.frsf.utn.edu.ar.lab03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.Arrays;
import java.util.List;

public class CrearOfertaActivity extends AppCompatActivity implements Button.OnClickListener{

    EditText etOferta, etHoras, etMaxPorHora;
    RadioButton rbDolar, rbEuro, rbLibra, rbPesoArg, rbReal;
    DatePicker dpFechaFin;
    CheckBox chkEnIngles;
    Spinner sTrabajo, sCategoria;
    List<Trabajo> trabajos;
    List<Categoria> categorias;
    ArrayAdapter<Trabajo> adaptadorTrabajo;
    ArrayAdapter<Categoria> adaptadorCategoria;
    ImageView itemBanderaDolar, itemBanderaEuro, itemBanderaPeso, itemBanderaLibra, itemBanderaReal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_oferta);
        setParametros();

        sTrabajo.setAdapter(adaptadorTrabajo);
        sCategoria.setAdapter(adaptadorCategoria);
        itemBanderaDolar.setImageResource(R.mipmap.ic_bandera_us);
        itemBanderaEuro.setImageResource(R.mipmap.ic_bandera_eu);
        itemBanderaPeso.setImageResource(R.mipmap.ic_bandera_ar);
        itemBanderaLibra.setImageResource(R.mipmap.ic_bandera_uk);
        itemBanderaReal.setImageResource(R.mipmap.ic_bandera_br);
    }

    private void setParametros() {
        etOferta = (EditText) findViewById(R.id.etOferta);
        etHoras = (EditText) findViewById(R.id.etHoras);
        etMaxPorHora = (EditText) findViewById(R.id.etMaxPorHora);
        rbDolar = (RadioButton) findViewById(R.id.rbDolar);
        rbEuro = (RadioButton) findViewById(R.id.rbEuro);
        rbLibra = (RadioButton) findViewById(R.id.rbLibra);
        rbPesoArg = (RadioButton) findViewById(R.id.rbPesoArg);
        rbReal = (RadioButton) findViewById(R.id.rbReal);
        dpFechaFin = (DatePicker) findViewById(R.id.dpFechaFin);
        chkEnIngles = (CheckBox) findViewById(R.id.chkEnIngles);
        sTrabajo = (Spinner) findViewById(R.id.sTrabajo);
        sCategoria = (Spinner) findViewById(R.id.sCategoria);
        trabajos = Arrays.asList(Trabajo.TRABAJOS_MOCK);
        categorias = Arrays.asList(Categoria.CATEGORIAS_MOCK);
        adaptadorTrabajo = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, trabajos);
        adaptadorCategoria = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, categorias);
        itemBanderaDolar = (ImageView) findViewById(R.id.itemBanderaDolar);
        itemBanderaEuro = (ImageView) findViewById(R.id.itemBanderaEuro);
        itemBanderaPeso = (ImageView) findViewById(R.id.itemBanderaPeso);
        itemBanderaLibra = (ImageView) findViewById(R.id.itemBanderaLibra);
        itemBanderaReal = (ImageView) findViewById(R.id.itemBanderaReal);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bGuardar:
                guardarOferta();
                break;
            default:
        }
    }

    private void guardarOferta() {
        //TODO guardar oferta
    }
}
