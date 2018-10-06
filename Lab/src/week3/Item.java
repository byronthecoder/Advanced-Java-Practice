/** Item.java
*
* Part of lab class for COM6516
* Written by Mark Stevenson mark.stevenson@sheffield.ac.uk
* Based on code written by Steve Maddock and Richard Clayton
*
*/
package week3;

import java.lang.reflect.Field;

public class Item {
	  // instance fields//

    private final double price;
    private final String name;

    public Item(String n, double p) {
          name = n;
          price = p;
    }

    public String getName() { return name; }

    public double getPrice() { return price; }
	
    // using ukp to denote pounds sterling as unicode pound symbol
    // does not display properly in MS Command Window
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" = ukp").append(price)
                .append(", class type = ").append(this.getClass().getTypeName())
                .append(", object name = ").append(this.getName())
                .append(", instance fields = { ");

        Field[] fields = getClass().getDeclaredFields();
        for (Field field : fields) {
            sb.append(field.getName()).append("  ");
        }
        sb.append(" }");

        return sb.toString();
    }
		
	// equals method to be added here
    @Override
    public boolean equals(Object obj) {
        
    }
		




	public static void main( String[] args){
		String TESTNAME = "testObject";
		double TESTPRICE = 10.0;
		Item testObject = new Item(TESTNAME,TESTPRICE);
		System.out.println("Name:");
		System.out.println("Actual field " + testObject.getName());
		System.out.println("Expected " + TESTNAME);
		System.out.println("Price:");
		System.out.println("Actual field " + testObject.getPrice());
		System.out.println("Expected " + TESTPRICE);
	}
}
