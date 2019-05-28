package hunau.net;

public class Student {

    private int ID = -1;
    private String Name;
    private String Pwd;
    private String Sexy;
    private String Isused;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPwd() {
        return Pwd;
    }

    public void setPwd(String pwd) {
        Pwd = pwd;
    }

    public String getSexy() {
        return Sexy;
    }

    public void setSexy(String sexy) {
        Sexy = sexy;
    }

    public String getIsused() {
        return Isused;
    }

    public void setIsused(String isused) {
        Isused = isused;
    }

    @Override
    public String toString(){
        String result = "";
        result += "ID：" + this.ID + "，";
        result += "姓名：" + this.Name + "，";
        result += "密码：" + this.Pwd + "， ";
        result += "性别：" + this.Sexy + "，";
        if (Isused.equals("true"))
            result += "是否有效: " + " 是 "+",";
        else
            result += "是否有效: " + " 否 "+",";
        return result;
    }
}
