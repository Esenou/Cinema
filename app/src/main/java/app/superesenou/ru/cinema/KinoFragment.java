package app.superesenou.ru.cinema;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import app.superesenou.ru.cinema.adapter.AdapterKino;
import app.superesenou.ru.cinema.api.ApiService;
import app.superesenou.ru.cinema.api.RetroClient;
import app.superesenou.ru.cinema.models.AnswerKinoafisha;
import retrofit2.Callback;
import retrofit2.Response;


public class KinoFragment extends Fragment {

    ArrayList<AnswerKinoafisha.Result> listKino = new ArrayList<>();
    AdapterKino adapterKino;
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_kino,container,false);
        recyclerView= (RecyclerView)view.findViewById(R.id.recycler);
        afishKino();
        return view;
    }

    public void afishKino() {

        ApiService apiKino = RetroClient.getApiService();
        retrofit2.Call<AnswerKinoafisha> callKino = apiKino.GetDateKinoafisha();
        callKino.enqueue(new Callback<AnswerKinoafisha>() {
            @Override
            public void onResponse(retrofit2.Call<AnswerKinoafisha> call, Response<AnswerKinoafisha> response) {
                listKino = response.body().getResult();

                recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
                adapterKino = new AdapterKino(getActivity(), listKino);
                recyclerView.setAdapter(adapterKino);


            }

            @Override
            public void onFailure(retrofit2.Call<AnswerKinoafisha> call, Throwable t) {

            }
        });


    }
}
