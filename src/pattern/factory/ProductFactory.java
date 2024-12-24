package pattern.factory;

public class ProductFactory {
    public Product createProduct(String type) {
        if ("ProductA".equals(type))
            return new ProductA();
        if ("ProductB".equals(type))
            return new ProductB();

        return null;
    }
}
