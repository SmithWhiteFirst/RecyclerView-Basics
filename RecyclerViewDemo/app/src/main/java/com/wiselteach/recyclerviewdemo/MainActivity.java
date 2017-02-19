package com.wiselteach.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.Layout;

import java.util.ArrayList;

/*
 * Demo Code of Recycler View
 * Created on: 19th Feb, 2017
 * Author Name: Rajat Talesra
 * Company Name: WiseL
 * This code is for Android Monk Campus Program.
 */

/*
 * Recycler View is mainly used to show dynamic list of data.
 * Many applications including Whatsapp, Facebook, Gmail, etc. used RecyclerView
 *
 * RecyclerView mainly uses two main components LayoutManager and Adapter
 *
 * LayoutManger: Helps to arrange data in LinearLayout or GridLayout
 *
 * Adapter: Helps to connect our recycler view with the custom layout and display data on screen
 *
 * In this demo we will display students list with their names and mobile numbers.
 */

public class MainActivity extends AppCompatActivity {

    //TODO(6): Create arrayList for student names and ids.

    ArrayList<String> namesArrayList = new ArrayList<>();
    ArrayList<String> mobileArrayList = new ArrayList<>();

    //TODO(7): Declare below mentioned components.

    RecyclerView rvStudentsList;
    RecyclerView.LayoutManager rvLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO(10): Add data to arrayList
        namesArrayList.add("Student 1");
        namesArrayList.add("Student 2");
        namesArrayList.add("Student 3");
        namesArrayList.add("Student 4");
        namesArrayList.add("Student 5");
        namesArrayList.add("Student 6");
        namesArrayList.add("Student 7");
        namesArrayList.add("Student 8");
        namesArrayList.add("Student 9");
        namesArrayList.add("Student 10");

        mobileArrayList.add("8766986401");
        mobileArrayList.add("8766986402");
        mobileArrayList.add("8766986403");
        mobileArrayList.add("8766986404");
        mobileArrayList.add("8766986405");
        mobileArrayList.add("8766986406");
        mobileArrayList.add("8766986407");
        mobileArrayList.add("8766986408");
        mobileArrayList.add("8766986409");
        mobileArrayList.add("8766986410");

        //TODO(9): Connect UI elements with java objects.
        rvStudentsList = (RecyclerView) findViewById(R.id.rvStudents);


        //User this to display items vertically
        rvLayoutManager = new LinearLayoutManager(this);

        //User this to display items in Grid Layout with 2 columns
        //rvLayoutManager = new GridLayoutManager(this,2);

        //TODO(10): Attach layoutManager to recycler view
        rvStudentsList.setLayoutManager(rvLayoutManager);

        /*
         * Now we need to create one adapter, so that we can display data row wise
         * For this we will create our custom adapter, i.e. StudentAdapter.java
         */

        //TODO(11): Create new java class StudentAdapter.java

        //TODO(16): Pass data to our custom adapter
        StudentAdapter studentAdapter = new StudentAdapter(this,namesArrayList,mobileArrayList);

        //TODO(17): Attach studentAdapter to recycler view

        rvStudentsList.setAdapter(studentAdapter);

        //TODO(18): Run your app.

    }
}
