package app.superesenou.ru.cinema;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import app.superesenou.ru.cinema.adapter.AdapterKinoAnons;
import app.superesenou.ru.cinema.api.ApiService;
import app.superesenou.ru.cinema.api.RetroClient;
import app.superesenou.ru.cinema.models.AnswerKinoAnons;
import app.superesenou.ru.cinema.models.AnswerKinoafisha;
import retrofit2.Callback;
import retrofit2.Response;


public class AnanasFragment extends Fragment {


    RecyclerView recyclerView;
    ArrayList<AnswerKinoAnons.Result>list = new ArrayList<>();
    AdapterKinoAnons adapter;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_ananas,container,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerAnons);

         AnansKino();

        return view;
    }


    public void AnansKino(){

        ApiService apiKino = RetroClient.getApiService();
        retrofit2.Call<AnswerKinoAnons> callKino = apiKino.GetDateKinoAnanos();
        callKino.enqueue(new Callback<AnswerKinoAnons>() {
            @Override
            public void onResponse(retrofit2.Call<AnswerKinoAnons> call, Response<AnswerKinoAnons> response) {
                list = response.body().getResults();
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
                adapter = new AdapterKinoAnons(getActivity(), list);
                recyclerView.setAdapter(adapter);


            }

            @Override
            public void onFailure(retrofit2.Call<AnswerKinoAnons> call, Throwable t) {

            }
        });

    }
}
