package com.bryan4tw.expandblelvdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

/**
 * Created by dsall on 2018/1/19.
 */

public class myexpandableadapter extends BaseExpandableListAdapter{

    Context context;
    List<String> groups;
    Map<String, List<String>> childs;
    Map<String, List<String>> child_phone;
    public myexpandableadapter(Context context, List<String> groups, Map<String, List<String>> childs, Map<String, List<String>> child_phone) {
        this.context = context;
        this.groups = groups;
        this.childs = childs;
        this.child_phone = child_phone;
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childs.get(groups.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childs.get(groups.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String group = (String) getGroup(groupPosition);

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.group, null);
        }
        TextView grouptv = (TextView) convertView.findViewById(R.id.GroupTV);
        grouptv.setText(group);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String names = (String) getChild(groupPosition, childPosition);
        final String phone = (String) child_phone.get(groups.get(groupPosition)).get(childPosition);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child, null);
        }
        final TextView nametv = (TextView) convertView.findViewById(R.id.NameTV);
        nametv.setText(names);
        nametv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Click " + nametv.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        final TextView phonetv = (TextView) convertView.findViewById(R.id.PhoneTV);
        phonetv.setText(phone);
        phonetv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Click " + phonetv.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
