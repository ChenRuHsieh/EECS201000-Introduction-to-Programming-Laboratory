package node;

import java.awt.*;

import data.Define;

public class SnakeNode extends Node{
	private static int nodeNum = 0;
	public int number;
	private boolean inCave;
	public SnakeNode(int x, int y, Color color) {
		super(x, y, color);
		number = nodeNum;
		nodeNum++;
	}
	public SnakeNode(int x, int y) {
		super(x, y);
		super.setColor(Define.colorBody);
		number = nodeNum;
		nodeNum++;
	}
	public String toString() {
		return new String("SnakeNode No." + number);
	}
}
