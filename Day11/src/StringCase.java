import java.util.Arrays;

public class StringCase {
	public static void main(String[] args) {
		String animals = "dog,cat,bear";
		
		String[] arr = animals.split(",");
		System.out.println(Arrays.toString(arr));

	}
}
