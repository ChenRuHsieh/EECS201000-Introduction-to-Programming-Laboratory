package node;

import java.awt.Color;

import data.Define;

public class WallNode extends Node{
	public WallNode(int x, int y) {
		super(x, y);
		super.setColor(Define.colorWall);
	}
}
