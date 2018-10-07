package app.superesenou.ru.cinema.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AnswerKinoAnons {

    public ArrayList<Result> getResults() {
        return result;
    }

    public void setResults(ArrayList<Result> results) {
        this.result = results;
    }
    @SerializedName("result")
    private ArrayList<Result> result;

    public class Result{
    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;
    @SerializedName("image")
    private String image;
    @SerializedName("countries")
    private String countries;
    @SerializedName("actors")
    private String actors;
    @SerializedName("rejisser")
    private String rejisser;
    @SerializedName("before")
    private String before;
    @SerializedName("entered")
    private String entered;
    @SerializedName("age_limit")
    private String age_limit;

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

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getRejisser() {
        return rejisser;
    }

    public void setRejisser(String rejisser) {
        this.rejisser = rejisser;
    }

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    public String getEntered() {
        return entered;
    }

    public void setEntered(String entered) {
        this.entered = entered;
    }

    public String getAge_limit() {
        return age_limit;
    }

    public void setAge_limit(String age_limit) {
        this.age_limit = age_limit;
    }
}

}
