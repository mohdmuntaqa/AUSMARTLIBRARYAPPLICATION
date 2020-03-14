package com.demotxt.myapp.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ArrayList<Book> lstBook = new ArrayList<>();
    private SearchView searchView;
    RecyclerView myrv;
    RecyclerViewAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView = (SearchView) findViewById(R.id.searchView);
        myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        setData();
    }

    private void setData() {
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myAdapter = new RecyclerViewAdapter(this,lstBook);
        myrv.setAdapter(myAdapter);

        lstBook.add(new Book("Programming","Keshav Patel","Categorie Book","An Introduction to Java Programming",R.drawable.java,"Android.pdf"));
        lstBook.add(new Book("Operating System","Peter B. Galvin","Categorie Book","OPERATING System concepts",R.drawable.operating,"OS.pdf"));
        lstBook.add(new Book("Python","Paul Jones","Categorie Book","A Step by Step guide to Python Programming",R.drawable.python,"Android.pdf"));
        lstBook.add(new Book("Accounting","Weil Francis","Categorie Book","Financial Accounting: An Introduction to Concepts",R.drawable.accountbook,"accounting.pdf"));
        lstBook.add(new Book("C++ Programming","Mike McGrath","Categorie Book","C++ Programming in Easy Steps",R.drawable.cprogram,"C++.pdf"));
        lstBook.add(new Book("Software Engineering","Ian Sommerville","Categorie Book","Software Engineering, Global Edition",R.drawable.softeng,"Android.pdf"));
        lstBook.add(new Book("Android Programming","O' Reilly","Categorie Book","Basics of Andriod Programming",R.drawable.android,"Android2.pdf"));
        lstBook.add(new Book("Statistics","Allan G. Bluman","Categorie Book","Statics: A step by step approach",R.drawable.stat,"Statistics.pdf"));
        lstBook.add(new Book("Thomas Calculus","Joel hass","Categorie Book","Pre calculus for elementary learning",R.drawable.calculus,"Android.pdf"));
        lstBook.add(new Book("Computer Organization","William Stallings","Categorie Book","Computer Organization: Designing for performance",R.drawable.computer,"computer.pdf"));
        lstBook.add(new Book("Logic Design","Roth Kinney","Categorie Book","Logic Design: International Edition",R.drawable.logic,"logic.pdf"));
        lstBook.add(new Book("Discrete Mathematics","Kenneth Rosen","Categorie Book","Global Edition",R.drawable.discrete,"discrete.pdf"));
        myAdapter.notifyDataSetChanged();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                myAdapter.getFilter().filter(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                myAdapter.getFilter().filter(s);
                return false;
            }
        });
    }
}
