package estevao.com.notes;

/**
 * Created by estevao on 08/11/17.
 */

public class Note {
    private String title;
    private String description;

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}