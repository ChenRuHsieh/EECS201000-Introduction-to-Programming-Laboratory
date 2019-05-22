package node;

import java.awt.Color;

import data.Define;

public class Node {
	private int x;
	private int y;
	private static int size = Define.unit;
	private Color color;
	
	public Node(int x, int y, Color color) {
		if(x >= Define.width) {
			x -= Define.width;
		}
		else if(x < 0) {
			x += Define.width;
		}
		else if(y >= Define.heighth) {
			y -= Define.heighth;
		}
		else if(y < 0) {
			y += Define.heighth;
		}
		this.x     = x;
		this.y     = y;
		this.color = color;
	}
	public Node(int x, int y) {
		if(x >= Define.width) {
			x -= Define.width;
		}
		else if(x < 0) {
			x += Define.width;
		}
		else if(y >= Define.heighth) {
			y -= Define.heighth;
		}
		else if(y < 0) {
			y += Define.heighth;
		}
		this.x     = x;
		this.y     = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public Color getColor() {
		return color;
	}
	public int getSize() {
		return size;
	}
	public void setX(int newX) {
		if(newX >= Define.width) {
			newX -= (Define.width);
		}
		else if(newX < 0) {
			newX += (Define.width + Define.unit);
		}
		x = newX;
	}
	public void setY(int newY) {
		if(newY >= Define.heighth) {
			newY -= (Define.heighth);
		}
		else if(newY < 0) {
			newY += (Define.heighth + Define.unit);
		}
		y = newY;
	}
	public void setColor(Color newColor) {
		color = newColor;
	}
	public void setSize(int newSize) {
		size = newSize;
	}
}
