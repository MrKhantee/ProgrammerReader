package com.huangtao.programmerreader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.huangtao.programmerreader.domain.ArticleItem;




public class ArticleListAdapter extends BaseAdapter{

    private List<ArticleItem> articleItems;
    
    private LayoutInflater layoutInflater;
    
    private Context context;
    
    public ArticleListAdapter(Context context,List<ArticleItem> items)
    {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.articleItems = items;
    }
    
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return articleItems.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return articleItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        
        ViewHolder holder = null;
        
        if(convertView == null)
        {
            holder = new ViewHolder();
            convertView = this.layoutInflater.inflate(R.layout.layout_article, null);
            holder.titleView = (TextView)convertView.findViewById(R.id.tilte);
            holder.hostView = (TextView)convertView.findViewById(R.id.host);
            holder.imgView = (ImageView)convertView.findViewById(R.id.image_view);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder)convertView.getTag();
        }
        
        ArticleItem item = this.articleItems.get(position);
        
        holder.titleView.setText(item.getTitle());
        holder.hostView.setText(item.getHost());
        
        
        return convertView;
    }
    
    public final class ViewHolder
    {
        public TextView titleView;
        public TextView hostView;
        public ImageView imgView;
    }

}
