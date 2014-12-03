package com.csipro.temarioandroid;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ExpandableListAdapter extends BaseExpandableListAdapter  {
	private Activity context;
    private Map<String, List<String>> coleccionTemas;
    private List<String> listTemas;
 
    public ExpandableListAdapter(Activity context, List<String> listTemas,
            Map<String, List<String>> coleccionTemas) {
        this.context = context;
        this.coleccionTemas = coleccionTemas;
        this.listTemas = listTemas;
    }
 
    public Object getChild(int groupPosition, int childPosition) {
        return coleccionTemas.get(listTemas.get(groupPosition)).get(childPosition);
    }
 
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }
     
     
    public View getChildView(final int groupPosition, final int childPosition,
            boolean isLastChild, View convertView, ViewGroup parent) {
        final String laptop = (String) getChild(groupPosition, childPosition);
        LayoutInflater inflater = context.getLayoutInflater();
         
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.subtemas_item, null);
        }
         
        TextView item = (TextView) convertView.findViewById(R.id.subtema);

         
        item.setText(laptop);
        return convertView;
    }
 
    public int getChildrenCount(int groupPosition) {
        return coleccionTemas.get(listTemas.get(groupPosition)).size();
    }
 
    public Object getGroup(int groupPosition) {
        return listTemas.get(groupPosition);
    }
 
    public int getGroupCount() {
        return listTemas.size();
    }
 
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }
 
    public View getGroupView(int groupPosition, boolean isExpanded,
            View convertView, ViewGroup parent) {
        String laptopName = (String) getGroup(groupPosition);
        
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.temas_item,
                    null);
        }
        TextView item = (TextView) convertView.findViewById(R.id.temas);
        ImageView image = (ImageView) convertView.findViewById(R.id.expandableIcon);
     
        	int imageResourceId = isExpanded ? R.drawable.ic_arrow_down : R.drawable.ic_arrow_right;
        	image.setImageResource(imageResourceId);
            image.setVisibility(View.VISIBLE);
    
        
        item.setText(laptopName);
        

        return convertView;
    }
 
    public boolean hasStableIds() {
        return true;
    }
 
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
