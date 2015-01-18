package con.inspiron.tharun26.manusys.model;

/**
 * Created by tharun26 on 18/1/15.
 */
public class EventInformation {

    private String event_info_title;
    private int icon;

    public EventInformation(String event_info_title, int icon) {
        this.event_info_title = event_info_title;
        this.icon = icon;
    }

    public String getEvent_info_title() {
        return this.event_info_title;
    }

    public void setEvent_info_title(String event_info_title) {
        this.event_info_title = event_info_title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
