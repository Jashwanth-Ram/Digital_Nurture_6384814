import java.lang.reflect.Array;
import java.util.Arrays;
/*
O(n): Linear time – typical for loops or linear search.
O(log n): Logarithmic – used in binary search, trees.
O(1): Constant – e.g., direct array access.
Binary search is faster than linear search on large sorted arrays.
Use it when data(Products) is sorted ,where products here are sorted by name.
 */
public class ProductSearch {

    public static void main(String[] args)
    {

        Product[] products= new Product[6];
        products[0] = new Product(1, "AppleMobile","Electronics");
        products[1] = new Product(2, "SamsungMobile","Electronics");
        products[2] = new Product(3, "Ipad","Electronics");
        products[3] = new Product(4, "Laptop","Electronics");
        products[4] = new Product(5, "Watch","Electronics");
        products[5] = new Product(6, "Shirts","Fashion");

        System.out.println("The Linear Search: ");

        Product found1 = linearSearch(products, "Ipad");
        System.out.println(found1 != null ? found1 : "Product not found");

        System.out.println("The Binary Search:");
        Arrays.sort(products);
        Product found2 = binarySearch(products, "Shirts");
        System.out.println(found2 != null ? found2 : "Product not found");



    }   
    public static Product linearSearch(Product[] products, String productName)
    {
        for(int i=0;i<products.length;i++)
        {
            if(products[i].productName.equalsIgnoreCase(productName))
            {
                return products[i];

            }
    }
    return null;
}

     public static Product binarySearch(Product[] products, String productName)
    {
        int l =0;
        int h  = products.length-1;
        while(l<=h)
        {
            int m = (l + h) / 2;

             int val = products[m].productName.compareToIgnoreCase(productName);

            if (val == 0) {
                return products[m];
            } else if (val < 0) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return null;


     }
}

