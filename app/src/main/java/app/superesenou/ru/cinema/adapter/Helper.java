package app.superesenou.ru.cinema.adapter;

public class Helper {
    public static String makeImageBetter(String url){
        url =url.replace("sm_","");
        return url;
    }
}
