import java.util.Scanner;

/**
 * Sum
 */
public class Sum {

    public static void main(String[] args) {
        char chucai;
        Scanner scanner = new Scanner(System.in);
        do
        {
            System.out.print("Hay nhap 1 chu cai bat ky: ");
            chucai = scanner.next().charAt(0);
        }while(chucai<'a'||chucai>'z');
        if(chucai=='u'||chucai=='e'||chucai=='o'||chucai=='a'||chucai=='i')
            System.out.println("Chu cai ma ban vua nhap vao la 1 nguyen am");
        else
            System.out.println("Chu cai ban vua nhap vao la 1 phu am");
        scanner.close();
    }
}