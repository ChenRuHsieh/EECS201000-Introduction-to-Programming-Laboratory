package snake;

import java.util.*;

import data.Define;
import node.SnakeNode;

public class Player {
	private ArrayList<SnakeNode> snakeList;
	private int dir = Define.stop;
	private int score = 0;
	private boolean inCave;
	private int inCaveTime;
	public Player() {
		snakeList = new ArrayList<SnakeNode>();
	}
	public int getDir() {
		return dir;
	}
	public void setDir(int newDir) {
		dir = newDir;
	}
	public int getScore() {
		return score;
	}
	public void addScore(int add) {
		score += add;
	}
	public void setScore(int newScore) {
		score = newScore;
	}
	public ArrayList<SnakeNode> getSnake(){
		return snakeList;
	}
	public void enterCave() {
		inCave = true;
	}
	public void exitCave() {
		inCave = false;
	}
	public boolean isInCave() {
		return inCave;
	}
	public void setInCaveTime() {
		inCaveTime = 0;
	}
	public void addInCaveTime(int time) {
		inCaveTime += time;
	}
	public int getInCaveTime() {
		return inCaveTime;
	}
}
