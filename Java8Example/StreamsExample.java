import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Non-Interference
		List<String> lst = new ArrayList(Arrays.asList("test5","test2","test3","horse"));
		Stream<String> streamLst= lst.stream();
		//Stream<String> streamLst= lst.parallelStream();
		lst.add("test1");
		streamLst.filter(str -> str.contains("test")).map(String::toUpperCase).sorted().forEach(System.out::println);
		
		//Collectors.joining
		List<String> lst2 = new ArrayList(Arrays.asList("sam","bibul","lohith","sri"));
		System.out.println(lst2.stream().sorted().collect(Collectors.joining(",", "[", "]")));
		
		//Comparator 
		Student std1= new Student("sai sriram",12,200);
		Student std2= new Student("bavi",20,300);
		Student std3= new Student("Akash",7,270);
		List<Student> stdLst = new ArrayList(Arrays.asList(std1,std2,std3));
		stdLst.stream().sorted(Comparator.comparing(Student::getAge)).map(Student::getName).forEach(System.out::println);
		
		//map - to transform the data
		//flat map - to flatten multi level stream
		stdLst.stream().map(std -> std.getName().split(" ")).flatMap(strArray -> Arrays.stream(strArray)).map(str->str.toUpperCase()).forEach(System.out::println);
		
		//peek - intermediate operation (with lambda expression as method reference)
		stdLst.stream().peek(System.out::println);
		
		List<Integer> lstInt = Arrays.asList(4,5,6,88,12,10);
		
		//FindFirst
		Optional<Integer> result = lstInt.stream().findFirst();
		if(result.isPresent()){
			System.out.println("findFirst: "+result.get());
		}else{
			System.out.println("not found");
		}
		
		//anyMatch
		boolean result1= lstInt.stream().anyMatch(n -> (n%2 == 0));
		System.out.println("anyMatch: "+result1);
		
		//allMatch
		boolean result2= lstInt.stream().allMatch(n -> (n%2 == 0));
		System.out.println("allMatch: "+result2);
		
		//noneMatch
		boolean result3= lstInt.stream().noneMatch(n -> (n%2 == 0));
		System.out.println("noneMatch: "+result3);
		
		//findAny
		Optional<Integer> result4= lstInt.stream().findAny();
		System.out.println("findAny: "+result4);
		
		//IntStream
		IntStream streamInt = IntStream.of(20,30,40,50,60);
		int intValMax=streamInt.max().getAsInt();
		int intValMin=streamInt.min().getAsInt();
		double intValAvg=streamInt.average().getAsDouble();
		int intValSum=streamInt.sum();
		System.out.println("intValMax:"+intValMax+" intValMin:"+intValMin+" intValAvg"+intValAvg+" intValSum:"+intValSum);
	}

}
