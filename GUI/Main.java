package ExampleGSC;

public class Main {
    public static void main(String[] args) {

        CoverPage coverpage = new CoverPage();
        System.out.println(dbase.getAllFNB());
        System.out.println(dbase.delFNB("Coca-Cola"));
        dbase.updFNB("Potato Chips", "f_price", "100");
        dbase.addFNB("Ice Cream", "chill out with our brand new ice cream!", 34);
        System.out.println(dbase.getAllFNB());



        System.out.println("-!DONE!-");
    }

    //public static void sequence(){}
}
