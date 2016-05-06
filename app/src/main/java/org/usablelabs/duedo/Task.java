package org.usablelabs.duedo;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.Date;
import java.util.List;

@Table(name = "Tasks")
public class Task extends Model {

    @Column(name = "title")
    public String title;

    @Column(name = "title1")
    public String title1;

    @Column(name = "title2")
    public String title2;

    @Column(name = "title3")
    public String title3;

    @Column(name = "title4")
    public String title4;

    @Column(name = "title5")
    public String title5;

    @Column(name = "title6")
    public String title6;

    @Column(name = "content")
    public String content;

    @Column(name = "content1")
    public String content1;

    @Column(name = "content2")
    public String content2;

    @Column(name = "content3")
    public String content3;

    @Column(name = "content4")
    public String content4;

    @Column(name = "content5")
    public String content5;

    @Column(name = "content6")
    public String content6;

    @Column(name = "expense")
    public String expense;

    @Column(name = "expense1")
    public String expense1;

    @Column(name = "expense2")
    public String expense2;

    @Column(name = "expense3")
    public String expense3;

    @Column(name = "expense4")
    public String expense4;

    @Column(name = "expense5")
    public String expense5;

    @Column(name = "expense6")
    public String expense6;

    @Column(name = "tv1")
    public String tv1;

    @Column(name = "tv2")
    public String tv2;

    @Column(name = "tv3")
    public String tv3;

    @Column(name = "date")
    public String date;

    @Column(name = "dueAt", index = true)
    public Date dueAt = null;

    @Column(name = "createdAt", index = true)
    public Date createdAt = null;

    @Column(name = "updatedAt", index = true)
    public Date updatedAt = null;

    public static List<Task> getAll() {
        return new Select().from(Task.class).orderBy("updatedAt DESC").execute();
    }

    public void saveWithTimestamp() {
        Date now = new Date();
        updatedAt = now;
        if (createdAt == null)
            createdAt = now;
        save();
    }

    @Override
    public String toString() {
        return this.tv3.toString();
    }

}
