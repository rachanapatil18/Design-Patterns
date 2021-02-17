package ocp.specification.classes;

import java.util.List;
import java.util.stream.Stream;

public class ProductFilter {

	public Stream<Product> filterByColor(List<Product> products, Color color){
		return products.stream().filter(p -> p.color == color);
	}
	
	public Stream<Product> filterBySize(List<Product> products, Size size){
		return products.stream().filter(p -> p.size == size);
	}
	
	public Stream<Product> filterBySizeAndColor(
			List<Product> products,
			Size size,
			Color color){
		return  products.stream().filter(p-> p.size == size && p.color == color);
	}
}
// below interface and classes are being used when implementation is open and closed for modification
interface Specification<T>{
	boolean isSatisfied(T item);
}
interface Filter<T>{
	Stream<T> filter(List<T> items, Specification<T> spec); 
}
class BetterFilter implements Filter<Product>{

	@Override
	public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
		return items.stream().filter(p -> spec.isSatisfied(p));
	}
}

class ColorSpecification implements Specification<Product>{

	private Color color;
	
	public ColorSpecification(Color color) {
		this.color = color; 	
	}
	@Override
	public boolean isSatisfied(Product item) {
		return item.color == color ;
	}
}

class SizeSpecification implements Specification<Product>{

	private Size size;
	
	public SizeSpecification(Size size) {
		this.size = size; 	
	}
	@Override
	public boolean isSatisfied(Product item) {
		return item.size == size ;
	}
}

class AndSpecification<T> implements Specification<T>{

	private Specification<T> first, second;
	
	public AndSpecification(Specification<T> first, Specification<T> second) {
		this.first = first;
		this.second = second;
	}
	@Override
	public boolean isSatisfied(T item) {
		return first.isSatisfied(item) && second.isSatisfied(item);
	}
	
}

/////////////////////////////////////////////////////////////