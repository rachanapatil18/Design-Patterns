package ocp.specification.classes;

import java.util.ArrayList;
import java.util.List;

public class OCPDemo {

	public static void main(String[] args) {
		
		
		Product apple = new Product("Apple", Color.GREEN, Size.SMALL);
		Product tree = new Product("Tree", Color.GREEN, Size.LARGE);
		
		Product house = new Product("House", Color.BLUE, Size.LARGE);
		
		List<Product> products = new ArrayList<>(); 
				//List.of(apple, tree, house);
		products.add(apple);
		products.add(tree);
		products.add(house);
		
		ProductFilter pf = new ProductFilter();
		System.out.println("Green Products (old): ");
		pf.filterByColor(products, Color.GREEN)
						.forEach(p-> System.out.println(
								" - "+p.name +" -is green "));
		
		BetterFilter betterFilter = new BetterFilter();
		System.out.println("Green Products (new): ");
		betterFilter.filter(products, new ColorSpecification(Color.GREEN))
						.forEach(p-> System.out.println(" - "+p.name +" - is Green"));
		
		System.out.println("Large Blue Items : ");
		betterFilter.filter(products, 
					new AndSpecification<>(
							new ColorSpecification(Color.BLUE),
							new SizeSpecification(Size.LARGE)))
							.forEach(p->System.out.println("- "+p.name + " - is Large and Blue"));
		
	}

}
