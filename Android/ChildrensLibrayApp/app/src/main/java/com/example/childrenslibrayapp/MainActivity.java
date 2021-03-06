package com.example.childrenslibrayapp;

import android.content.Intent;
import android.os.Bundle;

import com.example.childrenslibrayapp.mockdata.Datos;
import com.example.childrenslibrayapp.mockdata.ObjectReader;
import com.example.childrenslibrayapp.objects.Book;
import com.example.childrenslibrayapp.objects.User;

import com.example.childrenslibrayapp.searches.Busqueda;
import com.example.childrenslibrayapp.structures.DynamicArray;
import com.example.childrenslibrayapp.structures.SinglyLinkedList;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    static Datos datos = Datos.getInstance();


    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent busquedalibro = new Intent(view.getContext(), Busqueda.class);
                startActivity(busquedalibro);
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


;
        SinglyLinkedList <Book> allBooksList = new SinglyLinkedList<Book>();
        SinglyLinkedList <User> allUsersList = new SinglyLinkedList<User>();

        DynamicArray<Book> allBooksArray = new DynamicArray<>();
        DynamicArray<User> allUsersArray = new DynamicArray<>();



        generateData();

        final RatingBar rb= (RatingBar) findViewById(R.id.ratingBar2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    public void InfoLIbro(View view) {
        Intent infolibro = new Intent(this, Libro.class);
        startActivity(infolibro);
    }

    public void generateData(){
        ObjectReader oG = new ObjectReader(this);
        //DynamicArray<Book> books = new DynamicArray<Book>();
        //DynamicArray<User> user = new DynamicArray<User>();

        oG.readBooks(datos.getAllBooksArray());
        oG.readBooks(datos.getAllBooksList());
        //oG.readUsers(datos.getAllUsersArray());
        //oG.readUsers(datos.getAllUsersList());
    }

}
