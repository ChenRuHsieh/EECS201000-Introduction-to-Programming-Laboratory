package node;

import data.Define;

public class CaveNode extends Node{
	private CaveNode exitCave;
	public CaveNode(int x, int y) {
		super(x, y);
		super.setColor(Define.colorCave);
	}
	public CaveNode getExitCave() {
		return exitCave;
	}
	public void setExitCave(CaveNode newExitCave) {
		this.exitCave = newExitCave;
	}
}
