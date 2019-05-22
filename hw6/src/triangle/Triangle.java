package triangle;

class GetAreaException extends Exception{
	public GetAreaException() {}
	public GetAreaException(String msg) {
		super(msg);
	}
	
}

public class Triangle {
	public float x, y, z;
	
	public Triangle(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public float getArea(){
		float area;
		try {
			isValid();
			float s = (x + y + z) / 2;
			area = (float) Math.sqrt(s*(s-x)*(s-y)*(s-z));
			return area;
		}catch(GetAreaException e){
			System.out.println("�L�k�p�⭱�n!");
			return -1;
		}
	}
	
	public void showInfo() {
		try {
			System.out.println("�T�䬰 " + x + ", "+ y + ", " + z);
			isValid();
			if(x>y && x>z) {
				System.out.println("���䬰" + x + "���T����");
			}
			else if(y>x && y>z) {
				System.out.println("���䬰" + y + "���T����");
			}
			else {
				System.out.println("���䬰" + z + "���T����");
			}
		}catch(GetAreaException e) {
			System.out.println("�L�k�����T����!");
		}
	}
	
	private void isValid() throws GetAreaException {
		if(!((x+y > z) && (y+z > x) && (x+z) > y))
			throw new GetAreaException();
	}
}
