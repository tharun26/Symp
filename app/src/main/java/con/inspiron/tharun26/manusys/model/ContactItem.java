package con.inspiron.tharun26.manusys.model;

/**
 * Created by tharun26 on 20/1/15.
 */
public class ContactItem {

   String designation,contact1,contact2;
   int icon1,icon2;

    public ContactItem(String designation,String contact1,String contact2, int icon1, int icon2) {
        this.designation = designation;
        this.contact1 = contact1;
        this.contact2 = contact2;
        this.icon2 = icon2;
        this.icon1 = icon1;
    }



    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getContact1() {
        return contact1;
    }

    public void setContact1(String contact1) {
        this.contact1 = contact1;
    }

    public String getContact2() {
        return contact2;
    }

    public void setContact2(String contact2) {
        this.contact2 = contact2;
    }

    public int getIcon2() {
        return icon2;
    }

    public void setIcon2(int icon2) {
        this.icon2 = icon2;
    }

    public int getIcon1() {
        return icon1;
    }

    public void setIcon1(int icon1) {
        this.icon1 = icon1;
    }
}
