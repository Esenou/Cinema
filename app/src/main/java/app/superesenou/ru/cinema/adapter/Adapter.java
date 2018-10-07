package app.superesenou.ru.cinema.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.List;

import app.superesenou.ru.cinema.Main2Activity;
import app.superesenou.ru.cinema.R;
import app.superesenou.ru.cinema.models.Answer;
import app.superesenou.ru.cinema.models.AnswerKinoafisha;

public class Adapter extends ArrayAdapter<Answer.Unmain> {

    Context context;
    List<Answer.Unmain> contact;
    private LayoutInflater layoutInflater;
    public static String NameKino=new String();


    public Adapter(Context context, ArrayList<Answer.Unmain> list) {
        super(context, 0, list);
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        contact = list;

    }



    public Answer.Unmain getItem(int position) {
        return contact.get(position);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if(convertView==null){
            View view=layoutInflater.inflate(R.layout.row_item_main,parent,false);
            vh=ViewHolder.create((RelativeLayout)view);
            view.setTag(vh);
        }
        else {
            vh=(ViewHolder) convertView.getTag();
        }

        Answer.Unmain item=getItem(position);
        vh.txtMain.setText(Html.fromHtml(item.getName()));
        vh.txtAdres.setText("Aдрес: "+item.getAddress());
        vh.txtNumber.setText("Телефон: "+item.getPhone());
        vh.txtVote.setText(item.getCount_vote());
        vh.txtUrl.setText("https://kinoafisha.ua/"+item.getUrl());




       Picasso.get().load("https://kinoafisha.ua/"+item.getImage()).into(vh.imgMain);



        return  vh.relativeLayout;

    }

    private static class ViewHolder{
        public final ImageView imgMain;
        public final TextView txtMain,txtAdres,txtNumber,txtVote,txtUrl;

        public final RelativeLayout relativeLayout;

        private ViewHolder(ImageView imgMain, TextView txtMain, TextView txtAdres, TextView txtNumber, TextView txtVote, TextView txtUrl, RelativeLayout relativeLayout) {
            this.imgMain = imgMain;
            this.txtMain = txtMain;
            this.txtAdres = txtAdres;
            this.txtNumber = txtNumber;
            this.txtVote = txtVote;
            this.txtUrl = txtUrl;
            this.relativeLayout = relativeLayout;
        }

        public static ViewHolder create(RelativeLayout relativeLayout){
            ImageView imgMain=(ImageView)relativeLayout.findViewById(R.id.imgMain);
            TextView txtMain=(TextView)relativeLayout.findViewById(R.id.txtMain);
            TextView txtAdres=(TextView)relativeLayout.findViewById(R.id.txtAdres);
            TextView txtNumber=(TextView) relativeLayout.findViewById(R.id.txtNumber);
            TextView txtVote=(TextView) relativeLayout.findViewById(R.id.txtVote);
            TextView txtUrl=(TextView) relativeLayout.findViewById(R.id.txtUrl);

            return new ViewHolder(imgMain, txtMain, txtAdres, txtNumber, txtVote, txtUrl, relativeLayout);
        }
    }

}
