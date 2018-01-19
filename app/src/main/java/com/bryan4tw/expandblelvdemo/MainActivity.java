package com.bryan4tw.expandblelvdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;

    List<String> groups;
    Map<String, List<String>> childs;
    Map<String, List<String>> child_phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initdata();

        expandableListView = (ExpandableListView) findViewById(R.id.ExListView);

        expandableListAdapter = new myexpandableadapter(this, groups, childs, child_phone);

        expandableListView.setAdapter(expandableListAdapter);

    }

    private void initdata(){

        groups = new ArrayList<>();
        childs = new HashMap<>();
        child_phone = new HashMap<>();

        groups.add("City A");
        groups.add("City B");

        ArrayList A = new ArrayList();
        ArrayList B = new ArrayList();
        A.add("Howard");
        A.add("Bryan");
        A.add("COCO");

        B.add("Lima");
        B.add("Allen");
        B.add("Eric");
        B.add("joey");

        childs.put(groups.get(0), A);
        childs.put(groups.get(1), B);

        ArrayList a_p = new ArrayList();
        ArrayList b_p = new ArrayList();

        a_p.add("A11111");
        a_p.add("B11111");
        a_p.add("C11111");

        b_p.add("A22222");
        b_p.add("B22222");
        b_p.add("C22222");
        b_p.add("D22222");

        child_phone.put(groups.get(0), a_p);
        child_phone.put(groups.get(1), b_p);

    }
}
