public class ConfectioneryShop {
    public static void main(String[] args){
        Snacks shop= new Snacks();
        System.out.println("Rafi------>");
        ConfectioneryItem Rafi1 = shop.boughtB("Mango juice",3);
        System.out.println(Rafi1);
        System.out.println();
        ConfectioneryItem Rafi2 = shop.boughtB("7up",5);
        System.out.println(Rafi2);
        System.out.println();
        ConfectioneryItem Rafi3 = shop.boughtBa("Burger",3);
        System.out.println(Rafi3);
        System.out.println();
        ConfectioneryItem Rafi4 = shop.boughtBa("Chop",2);
        System.out.println(Rafi4);
        System.out.println();
        System.out.println("Zarin------>");
        ConfectioneryItem Zarin1 = shop.boughtBa("Somucha",3);
        System.out.println(Zarin1);
        System.out.println();
        ConfectioneryItem Zarin2= shop.boughtB("Mango juice",17);
        System.out.println(Zarin2);
        System.out.println();
        ConfectioneryItem Zarin3 = shop.boughtB("Mango juice",3);
        System.out.println(Zarin3);
        System.out.println();
        ConfectioneryItem Zarin4 = shop.boughtBa("Plain cake",2);
        System.out.println(Zarin4);
        System.out.println();
        System.out.println("Sell for shop--->");
        System.out.println(shop);
    }
}