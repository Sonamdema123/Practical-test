public class BSTTest{
	public static void main(String[] args)
	{
		BST<String, Integer> obj = new BST<String, Integer>();

        obj.put("Ada",1);
        obj.put("Ballerina",3);
        System.out.println(obj.get("Ada"));
        obj.put("Html",5);
        obj.put("Java",7);
        System.out.println(obj.get("Java"));
        System.out.println(obj.size());
        System.out.println(obj.min());
        System.out.println(obj.floor("Ballerina"));
        System.out.println(obj.select(3));
        obj.put("Java",8);
        obj.put("Dart",9);
        System.out.println(obj.get("Java"));
        System.out.println(obj.size());
        
    }
}