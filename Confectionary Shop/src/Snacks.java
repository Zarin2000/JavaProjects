public class Snacks {
    private static double totalSell;
    private static double tCost1;
    private static double tCost2;
    private baverage[] bav;
    private bakery[] bak;
    private double cost;

    public Snacks() {
        this.tCost1 = 0;
        this.tCost2 = 0;
        this.cost=0;
        this.totalSell = 0;
        bav = new baverage[10];
        bak = new bakery[9];
        bstock();
        bastock();
    }
    public void bstock() {
        bav[0] = new baverage( "Mango juice",50,20);
        bav[1] = new baverage( "Apple juice ",40,20);
        bav[2] = new baverage( "Orange juice",60,30);
        bav[3] = new baverage("7up",60,100);
        bav[4] = new baverage("Pepsi",55,100);
        bav[5] = new baverage( "Coca cola",65,100);
        bav[6] = new baverage( "Fanta",50,80);
        bav[7] = new baverage("Mirinda",50,80);
        bav[8] = new baverage( "Coffee",20,200);
        bav[9] = new baverage("Tea",10,200);
    }

    public void bastock() {
        bak[0] = new bakery( "Pizza",60,20);
        bak[1] = new bakery( "Plain cake",100,30);
        bak[2] = new bakery( "Bread",40,40);
        bak[3] = new bakery("Butter bun",20,40);
        bak[4] = new bakery( "Fruit cake",200,10);
        bak[5] = new bakery("Burger",70,20);
        bak[6] = new bakery("Somucha",10,60);
        bak[7] = new bakery( "Shingara",10,60);
        bak[8] = new bakery("Chips",20,50);

    }

    public baverage boughtB(String code,int quant ) {
        baverage returnItem = new baverage("null", 0, 0);

        if (code == "Mango juice") {
            if (bav[0].getQuantity()<=0){
                System.out.println("Out of Stock and "+code+ " need in the stock");
            }
            else {
                tCost1 += bav[0].getPrice() * quant;
                cost = bav[0].getPrice() * quant;
                bav[0].subsQuantity(quant);
                returnItem = bav[0];
                System.out.println("For "+quant+" "+code+" "+bav[0].getPrice() + "*" + quant + "=" + cost+"TK");
            }
        } else if (code == "Apple juice ") {
            if (bav[1].getQuantity()<=0){
                System.out.println("Out of Stock and "+code+ " need in the stock");
            }
            else {
                tCost1 += bav[1].getPrice() * quant;
                cost = bav[1].getPrice() * quant;
                bav[1].subsQuantity(quant);
                returnItem = bav[1];
                System.out.println("For "+quant+" "+code+" "+bav[1].getPrice() + "*" + quant + "=" + cost+"TK");
            }
        } else if (code == "Orange juice") {
            if (bav[2].getQuantity()<=0){
                System.out.println("Out of Stock and "+code+ " need in the stock");
            }
            else {
                tCost1 += bav[2].getPrice() * quant;
                cost = bav[2].getPrice() * quant;
                bav[2].subsQuantity(quant);
                returnItem = bav[2];
                System.out.println("For "+quant+" "+code+" "+bav[2].getPrice() + "*" + quant + "=" + cost+"TK");
            }
        } else if (code == "7up") {
            if (bav[3].getQuantity()<=0){
                System.out.println("Out of Stock and "+code+ " need in the stock");
            }
            else {
                tCost1 += bav[3].getPrice() * quant;
                cost = bav[3].getPrice() * quant;
                bav[3].subsQuantity(quant);
                returnItem = bav[3];
                System.out.println("For "+quant+" "+code+" "+bav[3].getPrice() + "*" + quant + "=" + cost+"TK");
            }
        } else if (code == "Pepsi") {
            if (bav[4].getQuantity()<=0){
                System.out.println("Out of Stock and "+code+ " need in the stock");
            }
            else {
                tCost1 += bav[4].getPrice() * quant;
                cost = bav[4].getPrice() * quant;
                bav[4].subsQuantity(quant);
                returnItem = bav[4];
                System.out.println("For "+quant+" "+code+" "+bav[4].getPrice() + "*" + quant + "=" + cost+"TK");
            }
        } else if (code == "Coca cola") {
            if (bav[5].getQuantity()<=0){
                System.out.println("Out of Stock and "+code+ " need in the stock");
            }
            else {
                tCost1 += bav[5].getPrice() * quant;
                cost = bav[5].getPrice() * quant;
                bav[5].subsQuantity(quant);
                returnItem = bav[5];
                System.out.println("For "+quant+" "+code+" "+bav[5].getPrice() + "*" + quant + "=" + cost+"TK");
            }
        } else if (code == "Fanta") {
            if (bav[6].getQuantity()<=0){
                System.out.println("Out of Stock and "+code+ " need in the stock");
            }
            else {
                tCost1 += bav[6].getPrice() * quant;
                cost = bav[6].getPrice() * quant;
                bav[6].subsQuantity(quant);
                returnItem = bav[6];
                System.out.println("For "+quant+" "+code+" "+bav[6].getPrice() + "*" + quant + "=" + cost+"TK");
            }
        } else if (code == "Mirinda") {
            if (bav[7].getQuantity()<=0){
                System.out.println("Out of Stock and "+code+ " need in the stock");
            }
            else {
                tCost1 += bav[7].getPrice() * quant;
                cost = bav[7].getPrice() * quant;
                bav[7].subsQuantity(quant);
                returnItem = bav[7];
                System.out.println("For "+quant+" "+code+" "+bav[7].getPrice() + "*" + quant + "=" + cost+"TK");
            }
        } else if (code == "Coffee") {
            if (bav[8].getQuantity()<=0){
                System.out.println("Out of Stock and "+code+ " need in the stock");
            }
            else {
                tCost1 += bav[8].getPrice() * quant;
                cost = bav[8].getPrice() * quant;
                bav[8].subsQuantity(quant);
                returnItem = bav[8];
                System.out.println("For "+quant+" "+code+" "+bav[8].getPrice() + "*" + quant + "=" + cost+"TK");
            }
        } else if (code == "Tea") {
            if (bav[9].getQuantity()<=0){
                System.out.println("Out of Stock and "+code+ " need in the stock");
            }
            else {
                tCost1 += bav[9].getPrice() * quant;
                cost = bav[9].getPrice() * quant;
                bav[9].subsQuantity(quant);
                returnItem = bav[9];
                System.out.println("For "+quant+" "+code+" "+bav[9].getPrice() + "*" + quant + "=" + cost+"TK");
            }
        } else {
            System.out.println("Sorry!!! This item is not available here ");
        }
        return returnItem;
    }


    public bakery boughtBa(String code, int quant ) {
        bakery returnItem1 = new bakery("null", 0 ,0);

        if (code == "Pizza") {
            if (bav[0].getQuantity()<=0){
                System.out.println("Out of Stock and "+code+ " need in the stock");
            }
            else {
                tCost2 += bak[0].getPrice() * quant;
                cost = bak[0].getPrice() * quant;
                bak[0].subsQuantity(quant);
                returnItem1 = bak[0];
                System.out.println("For "+quant+" "+code+" "+bak[0].getPrice() + "*" + quant + "=" + cost+"TK");
            }
        }
        else if (code == "Plain cake") {
            if (bav[1].getQuantity()<=0){
                System.out.println("Out of Stock and "+code+ " need in the stock");
            }
            else {
                tCost2 += bak[1].getPrice() * quant;
                cost = bak[1].getPrice() * quant;
                bak[1].subsQuantity(quant);
                returnItem1 = bak[1];
                System.out.println("For "+quant+" "+code+" "+bak[1].getPrice() + "*" + quant + "=" + cost+"TK");
            }
        }

        else   if (code == "Bread") {
            if (bav[2].getQuantity()<=0){
                System.out.println("Out of Stock and "+code+ " need in the stock");
            }
            else {
                tCost2 += bak[2].getPrice() * quant;
                cost = bak[2].getPrice() * quant;
                bak[2].subsQuantity(quant);
                returnItem1 = bak[2];
                System.out.println("For "+quant+" "+code+" "+bak[2].getPrice() + "*" + quant + "=" + cost+"TK");
            }
        }
        else if (code == "Butter bun") {
            if (bav[3].getQuantity()<=0){
                System.out.println("Out of Stock and "+code+ " need in the stock");
            }
            else {
                tCost2 += bak[3].getPrice() * quant;
                cost = bak[3].getPrice() * quant;
                bak[3].subsQuantity(quant);
                returnItem1 = bak[3];
                System.out.println("For "+quant+" "+code+" "+bak[3].getPrice() + "*" + quant + "=" + cost+"TK");
            }
        }
        else if (code == "Fruit cake") {
            if (bav[4].getQuantity()<=0){
                System.out.println("Out of Stock and "+code+ " need in the stock");
            }
            else {
                tCost2 += bak[4].getPrice() * quant;
                cost = bak[4].getPrice() * quant;
                bak[4].subsQuantity(quant);
                returnItem1 = bak[4];
                System.out.println("For "+quant+" "+code+" "+bak[4].getPrice() + "*" + quant + "=" + cost+"TK");
            }
        }
        else if (code == "Burger") {
            if (bav[5].getQuantity()<=0){
                System.out.println("Out of Stock and "+code+ " need in the stock");
            }
            else {
                tCost2 += bak[5].getPrice() * quant;
                cost = bak[5].getPrice() * quant;
                bak[5].subsQuantity(quant);
                returnItem1 = bak[5];
                System.out.println("For "+quant+" "+code+" "+bak[5].getPrice() + "*" + quant + "=" + cost+"TK");
            }
        }
        else if (code == "Somucha") {
            if (bav[6].getQuantity()<=0){
                System.out.println("Out of Stock and "+code+ " need in the stock");
            }
            else {
                tCost2 += bak[6].getPrice() * quant;
                cost = bak[6].getPrice() * quant;
                bak[6].subsQuantity(quant);
                returnItem1 = bak[6];
                System.out.println("For "+quant+" "+code+" "+bak[6].getPrice() + "*" + quant + "=" + cost+"TK");
            }
        }
        else if (code == "Shingara") {
            if (bav[7].getQuantity()<=0){
                System.out.println("Out of Stock and "+code+ " need in the stock");
            }
            else {
                tCost2 += bak[7].getPrice() * quant;
                cost = bak[7].getPrice() * quant;
                bak[7].subsQuantity(quant);
                returnItem1 = bak[7];
                System.out.println("For "+quant+" "+code+" "+bak[7].getPrice() + "*" + quant + "=" + cost+"TK");
            }
        }
        else if (code == "Chips") {
            if (bav[8].getQuantity()<=0){
                System.out.println("Out of Stock and "+code+ " need in the stock");
            }
            else {
                tCost2 += bak[8].getPrice() * quant;
                cost = bak[8].getPrice() * quant;
                bak[8].subsQuantity(quant);
                returnItem1 = bak[8];
                System.out.println("For "+quant+" "+code+" "+bak[8].getPrice() + "*" + quant + "=" + cost+"TK");
            }
        } else {
            System.out.println("Sorry!!! This item is not available here ");
        }
        return returnItem1;
    }

    public static String getCost1() {
        return "Total sell for beverage items of the Shop: "+tCost1+"TK";
    }

    public static String getCost2() {
        return "Total sell for bakery items of the Shop: "+tCost2+"TK";
    }
    public double getCost() {
        return cost;
    }

    public static double getTotalSell() {
        return tCost1 + tCost2;
    }
    public String toString() {
        return getCost1() + " & " + getCost2() + "\nTotal sell of the shop: " + getTotalSell()+"Tk";
    }
}