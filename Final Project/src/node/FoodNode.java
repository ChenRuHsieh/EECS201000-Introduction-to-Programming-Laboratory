package node;

import java.awt.Color;

import data.Define;

public class FoodNode extends Node{
	public FoodNode(int x, int y) {
		super(x, y);
		super.setColor(Define.colorFood);
	}
}
