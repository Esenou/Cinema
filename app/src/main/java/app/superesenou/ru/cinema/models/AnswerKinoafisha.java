package app.superesenou.ru.cinema.models;

import android.support.v7.widget.RecyclerView;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AnswerKinoafisha {


    public ArrayList<Result> getResult() {
        return result;
    }
    public void setResult(ArrayList<Result> result) {
        this.result = result;
    }

    private ArrayList<Result> result;

    public class Result  {
             @SerializedName("id")
             private String id;
             @SerializedName("name")
             private String name;
             @SerializedName("url")
             private String url;
             @SerializedName("image")
             private String image;
             @SerializedName("vote")
             private String vote;
             @SerializedName("count_vote")
             private String count_vote;
             @SerializedName("countries")
             private String countries;
             @SerializedName("premier_ua")
             private String premier_ua;
             @SerializedName("sessions")
             private ArrayList<Sessions> sessions;
             @SerializedName("age_limit")
             private String age_limit;
             @SerializedName("actors")
             private String actors;
             @SerializedName("rejisser")
             private String rejisser;

        public String getRejisser() {
            return rejisser;
        }

        public void setRejisser(String rejisser) {
            this.rejisser = rejisser;
        }

        public String getActors() {
            return actors;
        }

        public void setActors(String actors) {
            this.actors = actors;
        }

        public String getAge_limit() {
            return age_limit;
        }

        public void setAge_limit(String age_limit) {
            this.age_limit = age_limit;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getVote() {
            return vote;
        }

        public void setVote(String vote) {
            this.vote = vote;
        }

        public String getCount_vote() {
            return count_vote;
        }

        public void setCount_vote(String count_vote) {
            this.count_vote = count_vote;
        }

        public String getCountries() {
            return countries;
        }

        public void setCountries(String countries) {
            this.countries = countries;
        }

        public String getPremier_ua() {
            return premier_ua;
        }

        public void setPremier_ua(String premier_ua) {
            this.premier_ua = premier_ua;
        }

        public ArrayList<Sessions> getSessions() {
            return sessions;
        }

        public void setSessions(ArrayList<Sessions> sessions) {
            this.sessions = sessions;
        }

        public class Sessions {
            @SerializedName("k_name")
            private String k_name;
            @SerializedName("k_addr")
            private String k_addr;
            @SerializedName("k_url")
            private String k_url;
            @SerializedName("h_name")
            private String h_name;


            public String getK_name() {
                return k_name;
            }

            public void setK_name(String k_name) {
                this.k_name = k_name;
            }

            public String getK_addr() {
                return k_addr;
            }

            public void setK_addr(String k_addr) {
                this.k_addr = k_addr;
            }

            public String getK_url() {
                return k_url;
            }

            public void setK_url(String k_url) {
                this.k_url = k_url;
            }



            public String getH_name() {
                return h_name;
            }

            public void setH_name(String h_name) {
                this.h_name = h_name;
            }
        }

    }



}
