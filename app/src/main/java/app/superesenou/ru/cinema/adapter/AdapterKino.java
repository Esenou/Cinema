package app.superesenou.ru.cinema.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import app.superesenou.ru.cinema.Main3Activity;
import app.superesenou.ru.cinema.R;
import app.superesenou.ru.cinema.models.AnswerKinoafisha;

public class AdapterKino extends RecyclerView.Adapter<AdapterKino.ViewHolder> {

    Context context;
    List<AnswerKinoafisha.Result> contact;
    List<AnswerKinoafisha.Result.Sessions> contactTwo;
    private LayoutInflater layoutInflater;

    public AdapterKino(Context context, ArrayList<AnswerKinoafisha.Result> list) {
        this.context=context;
        this.contact=list;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_kino, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        AnswerKinoafisha.Result vh = contact.get(position);
         contactTwo=vh.getSessions();
         //AnswerKinoafisha.Result.Sessions vhTwo = contactTwo.get(position);

        char  b[]=new char[vh.getImage().length()];
        char a = 0;
        for(int i=0;i<vh.getImage().length();i++){

            if(i==27 && i==28){
               continue;
            }else {
                b[i] =vh.getImage().charAt(i);
            }
        }
        String str = String.valueOf(b);
        Picasso.get().load("https://kinoafisha.ua/" + str).into(holder.imagekino);
        holder.txtNameKino.setText(vh.getName());



    }
    @Override
    public int getItemCount() {
        return contact.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imagekino;
        TextView txtNameKino;

        public ViewHolder(View itemView) {
            super(itemView);
            imagekino=(ImageView)itemView.findViewById(R.id.imageView);
            txtNameKino=(TextView)itemView.findViewById(R.id.txtNameKino);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position=getAdapterPosition();
                    AnswerKinoafisha.Result vh =contact.get(position);

                  //  Toast.makeText(context,"item "+position,Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(context,Main3Activity.class);
                    Bundle bundle=new Bundle();
                    bundle.putString("esen",new Gson().toJson(vh));
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });

        }
    }


}
