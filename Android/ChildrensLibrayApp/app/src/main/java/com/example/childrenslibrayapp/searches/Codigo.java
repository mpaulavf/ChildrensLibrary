package com.example.childrenslibrayapp.searches;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.childrenslibrayapp.Listado;
import com.example.childrenslibrayapp.R;
import com.example.childrenslibrayapp.mockdata.Datos;
import com.example.childrenslibrayapp.objects.Book;
import com.example.childrenslibrayapp.objects.Search;
import com.example.childrenslibrayapp.structures.DynamicArray;

//genera un crash al presionar buscar

public class Codigo extends AppCompatActivity {
    public static final String EXTRA_SEARCH_TYPE = "com.example.childrenslibrayapp.SEARCH_TYPE";


    SearchEngine search = new SearchEngine(this);
    Button bt_codExactoArray, bt_codRangoArray, bt_codExactoBST, bt_codRangoBST, bt_codExactoList, bt_codRangoList;
    EditText codigoExacto, codigoRango1, codigoRango2;
    Search dc;

    Datos datos = Datos.getInstance();

    DynamicArray<Book> allBooksArray = datos.getAllBooksArray();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codigo);

        bt_codExactoArray = (Button)findViewById(R.id.bt_busCodExactoArray);
        bt_codRangoArray = (Button)findViewById(R.id.bt_busCodRangoArray);

//        bt_codExactoList = (Button)findViewById(R.id.bt_busCodExactoList);
//        bt_codRangoList = (Button)findViewById(R.id.bt_busCodRangoList);

//        bt_codExactoBST = (Button)findViewById(R.id.bt_busCodExactoBST);
//        bt_codRangoBST = (Button)findViewById(R.id.bt_busCodRangoBST);

        codigoExacto = (EditText)findViewById(R.id.et_busCodExacto);
        codigoRango1 = (EditText)findViewById(R.id.et_busCodRan1);
        codigoRango2 = (EditText)findViewById(R.id.et_busCodRan2);

        final Intent listadoIntent = new Intent(this, Listado.class);

        Bundle extras = new Bundle();
        extras.putString(EXTRA_SEARCH_TYPE,"Codigo");


        listadoIntent.putExtras(extras);

        datos.setByAuthorArray(new DynamicArray<Book>());



        bt_codExactoArray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cod = codigoExacto.getText().toString();
                dc = new Search("", "Codigo");
                if(!cod.isEmpty()){
                    dc.setTempSearch(cod);
                    Toast.makeText(getApplicationContext(), cod, Toast.LENGTH_SHORT).show();
                    try {
                        search.arraySearchBy(dc);
                        startActivity(listadoIntent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //Toast.makeText(getApplicationContext(), "Se acciona el metodo buscar", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Por favor introduzca su actividad", Toast.LENGTH_SHORT).show();
                }
            }
        });

        /*bt_codExactoList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cod = codigoExacto.getText().toString();
                dc = new Search("", "Codigo");
                if(!cod.isEmpty()){
                    dc.setTempSearch(cod);
                    Toast.makeText(getApplicationContext(), cod, Toast.LENGTH_SHORT).show();
                    try {
                        search.listSearchBy(dc); //queda colgada el app
                        startActivity(listadoIntent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //Toast.makeText(getApplicationContext(), "Se acciona el metodo buscar", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Por favor introduzca su actividad", Toast.LENGTH_SHORT).show();
                }
            }
        });*/

        /*bt_codExactoBST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cod = codigoExacto.getText().toString();
                dc = new Search("", "Codigo");
                if(!cod.isEmpty()){
                    dc.setTempSearch(cod);
                    Toast.makeText(getApplicationContext(), cod, Toast.LENGTH_SHORT).show();
                    try {
                        search.BSTSearchBy(dc); //no retorna nada :/
                        startActivity(listadoIntent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //Toast.makeText(getApplicationContext(), "Se acciona el metodo buscar", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Por favor introduzca su actividad", Toast.LENGTH_SHORT).show();
                }
            }
        });*/

        bt_codRangoArray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String from = codigoRango1.getText().toString();
                String to = codigoRango2.getText().toString();
                if(!from.isEmpty()&&!to.isEmpty()){
                    Toast.makeText(getApplicationContext(), "de" + from + "a" + to, Toast.LENGTH_SHORT).show();
                    try {
                        arraySearchRange(Integer.parseInt(from), Integer.parseInt(to));
                        startActivity(listadoIntent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }else{
                    Toast.makeText(getApplicationContext(), "Por favor introduzca su actividad", Toast.LENGTH_SHORT).show();
                }
            }
        });


        /*bt_codRangoBST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String from = codigoRango1.getText().toString();
                String to = codigoRango2.getText().toString();
                if(!from.isEmpty()&&!to.isEmpty()){
                    Toast.makeText(getApplicationContext(), "de" + from + "a" + to, Toast.LENGTH_SHORT).show();
                    try {
                        arraySearchRange(Integer.parseInt(from), Integer.parseInt(to));
                        startActivity(listadoIntent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Por favor introduzca su actividad", Toast.LENGTH_SHORT).show();
                }
            }
        });*/
    }

    private void arraySearchRange (int min, int max) throws Exception {

        DynamicArray<Book> rangeResults = new DynamicArray<>();
        for(int i =0; i<allBooksArray.getSize();i++){
            String code = allBooksArray.getVal(i).getCode();
            int intCode = Integer.parseInt(code);
            if(allBooksArray.getVal(i + 1) != null){
                if(intCode>=min && intCode<=max){
                    rangeResults.pushBack(allBooksArray.getVal(i));
                }
            }

        }

        datos.setByCodeArray(rangeResults);
    }
}
