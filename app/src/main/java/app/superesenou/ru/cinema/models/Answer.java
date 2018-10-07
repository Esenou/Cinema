package app.superesenou.ru.cinema.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Answer {

    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public class Result{

        private ArrayList<Unmain> unmain;

        public ArrayList<Unmain> getUnmain() {
            return unmain;
        }

        public void setUnmain(ArrayList<Unmain> unmain) {
            this.unmain = unmain;
        }
    }


    public class Unmain{
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
       @SerializedName("phone")
        private String phone;
       @SerializedName("address")
        private String address;

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

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }


}
