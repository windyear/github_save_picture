//进行了测试修改
package com.example.listviewdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.os.Bundle;


public class MainActivity extends ActionBarActivity implements android.widget.AbsListView.OnScrollListener,OnItemClickListener {
    private ListView listview;
    private ArrayAdapter<String>arr_adp;
    private SimpleAdapter sim_adp;
    private List<Map<String, Object>>dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lview);
        listview=(ListView)findViewById(R.id.listView1);
        String[] arr_data={"科比","詹姆斯","杜兰特"};
        dataList=new ArrayList<Map<String,Object>>();
        arr_adp=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr_data);
        //listview.setAdapter(arr_adp);
        sim_adp=new SimpleAdapter(this, getData(), R.layout.item, new String[]{"pic","text"}, new int[]{R.id.pic,R.id.text});
        listview.setAdapter(sim_adp);	
        listview.setOnItemClickListener(this);
        listview.setOnScrollListener(this);
    }
    private List<Map<String, Object>> getData(){
    	for(int i=0;i<=20;i++){
    		Map<String, Object>map=new HashMap<String, Object>();
    		map.put("pic", R.drawable.ic_launcher);
    		map.put("text", "球星"+i+"号");
    		dataList.add(map);
    	}
    	return dataList;
    }
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		String text=listview.getItemAtPosition(position)+"";
		Toast tipsToast=Toast.makeText(this, "position+"+position+"text="+text, Toast.LENGTH_SHORT);
		tipsToast.show();
	}
	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		// TODO Auto-generated method stub
		switch (scrollState) {
		case SCROLL_STATE_FLING:
			Map<String, Object>map=new HashMap<String, Object>();
			map.put("pic",R.drawable.ic_launcher);
			map.put("text", "增加项");
			dataList.add(map);
			sim_adp.notifyDataSetChanged();
			break;

		default:
			break;
	}
	}
	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		// TODO Auto-generated method stub
		
	}
	
	
}
