package person;

public class Test {
	public static void introduce(Person p) {
		p.introduceSelf();
	}

	public static void main(String[] args) {
		
		
		System.out.println("���Student : ");
		Student s = new Student();
		s.introduceSelf();
		Employee e = new Employee();
		e.introduceSelf();
		Retired r = new Retired();
		r.introduceSelf();
		
		System.out.println("\n��q�� : ");
		Person[] people = new Person[3];
		people[0] = new Student();
		people[1] = new Employee();
		people[2] = new Retired();
		
		for(int i = 0; i < people.length ; i++)
		{
			System.out.println("people[" + i + "]");
			people[i].introduceSelf();
		}
		
		System.out.println("\n�ѼƤ� : ");
		introduce(people[0]);
		introduce(people[1]);
		introduce(people[2]);
	}
}
