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
			System.out.println("無法計算面積!");
			return -1;
		}
	}
	
	public void showInfo() {
		try {
			System.out.println("三邊為 " + x + ", "+ y + ", " + z);
			isValid();
			if(x>y && x>z) {
				System.out.println("底邊為" + x + "的三角形");
			}
			else if(y>x && y>z) {
				System.out.println("底邊為" + y + "的三角形");
			}
			else {
				System.out.println("底邊為" + z + "的三角形");
			}
		}catch(GetAreaException e) {
			System.out.println("無法成為三角形!");
		}
	}
	
	private void isValid() throws GetAreaException {
		if(!((x+y > z) && (y+z > x) && (x+z) > y))
			throw new GetAreaException();
	}
}
