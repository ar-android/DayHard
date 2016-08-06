package id.dayhard.model;

/**
 * Created by ocittwo on 8/5/16.
 */
public class PeopleModel {

    public int img_people;
    public String title;
    public String sub_title;
    public String desc;
    public String date;

    public PeopleModel(int img_people, String title, String sub_title, String desc, String date) {
        this.img_people = img_people;
        this.title = title;
        this.sub_title = sub_title;
        this.desc = desc;
        this.date = date;
    }
}
