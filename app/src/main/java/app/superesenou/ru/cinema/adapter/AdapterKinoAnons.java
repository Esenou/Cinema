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
import app.superesenou.ru.cinema.Main4Activity;
import app.superesenou.ru.cinema.R;
import app.superesenou.ru.cinema.models.AnswerKinoAnons;
import app.superesenou.ru.cinema.models.AnswerKinoafisha;

public class AdapterKinoAnons extends RecyclerView.Adapter<AdapterKinoAnons.ViewHolder> {

    Context context;
    List<AnswerKinoAnons.Result> contact;
    public AdapterKinoAnons(Context activity, ArrayList<AnswerKinoAnons.Result> list) {
        context=activity;
        this.contact=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_anos_kino,parent,false);
        return new AdapterKinoAnons.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        AnswerKinoAnons.Result vh=contact.get(position);
        Helper url=new Helper();

        Picasso.get().load("https://kinoafisha.ua/" + url.makeImageBetter(vh.getImage())).into(holder.imageView);
        holder.txtName.setText(vh.getName());

    }

    @Override
    public int getItemCount() {
        return contact.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView,imgAnons;
        TextView txtName;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.imageViewAnons);
            txtName=(TextView)itemView.findViewById(R.id.txtNameKinoAnons);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position=getAdapterPosition();
                    AnswerKinoAnons.Result vh =contact.get(position);

                 //   Toast.makeText(context,"item "+position,Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(context,Main4Activity.class);
                    Bundle bundle=new Bundle();
                    bundle.putString("esen",new Gson().toJson(vh));
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });

        }
    }
}
