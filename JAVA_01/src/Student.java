public class Test {
    private String student_id;
    private String student_name;
    private double result;
    private String student_rank;

    public Student()
    {
        this.student_id = "";
        this.student_name = "";
        this.result = 0;
        this.student_rank = "";
    }

    public student(String id, String name, double re, String rank)
    {
        this.result = re;
        this.student_id = id;
        this.student_name = name;
        if(result<5)
        this.student_rank = "Fail";
        else
        this.student_rank = "Pass";
    }

    public void setID(String id) {
        this.student_id = id;
    }

    public void setName(String name) {
        this.student_name = name;
    }

    public void setresult(double re) {
        this.student_result = re;
    }

    public String getID() {
        return this.student_id;
    }

    public String getName() {
        return this.student_name;
    }

    public String getLastName() {
        String xau[] = this.student_name.split("\\s");
        return xau[xau.length - 1];
    }

    public double getResult() {
        return this.student_result;
    }

    public String getRank() {
        return this.student_rank;
    }

    public String toString() {
        return "\nMa cua sinh vien la: " + this.student_id + "\nHo ten cua sinh vien la: " + this.student_name
                + "\nKet qua cua sinh vien la: " + this.student_result + "\nXep loai cua sinh vien la: "
                + this.student_rank;
    }

    public void xuat() {
        System.out.println("Ho ten cua sinh vien la: " + this.student_name);
        System.out.println("Ma cua sinh vien la: " + this.student_id);
        System.out.println("Ket qua cua sinh vien la: " + this.student_result);
        System.out.println("Xep loai cua sinh vien la: " + this.student_rank);
    }
}