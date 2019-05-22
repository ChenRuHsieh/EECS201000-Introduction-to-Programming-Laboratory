package event;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimerTask;

import data.Define;
import node.CaveNode;
import node.FoodNode;
import node.SnakeNode;
import node.WallNode;

public class CreateEvent {
	public static void createCave(ArrayList<CaveNode> caveList) {
		//創造洞穴
		CaveNode entryNode = new CaveNode(Define.CaveEntry1X, Define.CaveEntry1Y);
		CaveNode exitNode = new CaveNode(Define.CaveExit1X, Define.CaveExit1Y);
		entryNode.setExitCave(exitNode);
		exitNode.setExitCave(entryNode);
		caveList.add(entryNode);
		caveList.add(exitNode);
		entryNode = new CaveNode(Define.CaveEntry2X, Define.CaveEntry2Y);
		exitNode = new CaveNode(Define.CaveExit2X, Define.CaveExit2Y);
		entryNode.setExitCave(exitNode);
		exitNode.setExitCave(entryNode);
		caveList.add(entryNode);
		caveList.add(exitNode);
	}
	public static SnakeNode createSnake(ArrayList<SnakeNode> player, int snakeStartX, int snakeStartY, Color color) {
		//創造蛇身 長度為2
		player.add(new SnakeNode(snakeStartX, snakeStartY, color));
		player.add(new SnakeNode(snakeStartX, snakeStartY + Define.unit));
		return player.get(0);
	}
	public static void createWall(ArrayList<SnakeNode> player, ArrayList<WallNode> wall) {
		Iterator<SnakeNode> itSnake = player.iterator();
		for(int i = 0; i < Define.amountWall; i++) {
			System.out.println("準備放置牆壁...");
			int r = (int) (Math.random() * Define.RAND_POS);
			int wallX = r *Define. unit;
			r = (int) (Math.random() * Define.RAND_POS);
			int wallY = r * Define.unit;
			boolean putWall = true;
			
			if(wallY < Define.unit*7 || wallY > Define.heighth - Define.unit*7 )
				putWall = false;
			
			while(itSnake.hasNext()) {
				SnakeNode snakeBody = itSnake.next();
				int snakeX = snakeBody.getX();
				int snakeY = snakeBody.getY();
				if((wallX <= snakeX + Define.unit*5) && (wallX >= snakeX - Define.unit*5) && (wallY <= snakeY + Define.unit*5) && (wallY >= snakeY - Define.unit*5)) 
					putWall = false;
			}
			if(putWall) {
				creatWallForm(wall, wallX, wallY);
				System.out.println("放置牆壁成功 x:" + wallX + " y:" + wallY);
			}
			else {
				System.out.println("放置牆壁失敗...蛇身重疊");
			}
		}
	}
	public static void createWall(ArrayList<SnakeNode> player1, ArrayList<SnakeNode> player2, ArrayList<WallNode> wall) {
		Iterator<SnakeNode> itSnake1 = player1.iterator();
		Iterator<SnakeNode> itSnake2 = player2.iterator();
		for(int i = 0; i < Define.amountWall; i++) {
			System.out.println("準備放置牆壁...");
			int r = (int) (Math.random() * Define.RAND_POS);
			int wallX = r *Define. unit;
			r = (int) (Math.random() * Define.RAND_POS);
			int wallY = r * Define.unit;
			boolean putWall = true;
			
			while(itSnake1.hasNext()) {
				SnakeNode snakeBody = itSnake1.next();
				int snakeX = snakeBody.getX();
				int snakeY = snakeBody.getY();
				if((wallX <= snakeX + Define.unit*5) && (wallX >= snakeX - Define.unit*5) && (wallY <= snakeY + Define.unit*5) && (wallY >= snakeY - Define.unit*5)) 
					putWall = false;
			}
			while(itSnake2.hasNext()) {
				SnakeNode snakeBody = itSnake2.next();
				int snakeX = snakeBody.getX();
				int snakeY = snakeBody.getY();
				if((wallX <= snakeX + Define.unit*5) && (wallX >= snakeX - Define.unit*5) && (wallY <= snakeY + Define.unit*5) && (wallY >= snakeY - Define.unit*5)) 
					putWall = false;
			}
			if(putWall) {
				creatWallForm(wall, wallX, wallY);
				System.out.println("放置牆壁成功 x:" + wallX + " y:" + wallY);
			}
			else {
				System.out.println("放置牆壁失敗...蛇身重疊");
			}
		}
	}
	private static void creatWallForm(ArrayList<WallNode> wall, int wallX, int wallY) {
		int form = (int) (Math.random() * Define.FormNum);
		switch(form) {
		case 1 :{
			// O
			// 0OOOO
			wall.add(new WallNode(wallX, wallY-Define.unit));
			for(int j = 0; j < 5; j++) {
				WallNode newWall = new WallNode(wallX+Define.unit*j, wallY);
				wall.add(newWall);
			}
			break;
		}
		case 2 :
			// O
			//O0O
			// O
			for(int i = -1; i <= 1; i++) {
				WallNode newWall = new WallNode(wallX, wallY+Define.unit*i);
				wall.add(newWall);
			}
			for(int j = -1; j <= 1; j++) {
				WallNode newWall = new WallNode(wallX+Define.unit*j, wallY);
				wall.add(newWall);
			}
			break;
		case 3 :
			//O
			//O
			//0
			//O
			//O
			for(int i = -2; i <= 2; i++) {
				WallNode newWall = new WallNode(wallX, wallY+Define.unit*i);
				wall.add(newWall);
			}
			break;
		case 4 :
			//OO0OO
			for(int j = -2; j <= 2; j++) {
				WallNode newWall = new WallNode(wallX+Define.unit*j, wallY);
				wall.add(newWall);
			}
			break;
		case 5 :
			//	  O
			//OOOO0
			wall.add(new WallNode(wallX, wallY-Define.unit));
			for(int j = 0; j < 5; j++) {
				WallNode newWall = new WallNode(wallX-Define.unit*j, wallY);
				wall.add(newWall);
			}
			break;
		case 6 :
			//O
			// O
			//  0
			//   O
			//    O
			for(int k = -2; k <= 2; k++) {
				WallNode newWall = new WallNode(wallX+Define.unit*k, wallY+Define.unit*k);
				wall.add(newWall);
			}
			break;
		case 7 :
			//    O
			// 	 O
			//  0
			// O
			//O
			for(int k = -2; k <= 2; k++) {
				WallNode newWall = new WallNode(wallX+Define.unit*k, wallY-Define.unit*k);
				wall.add(newWall);
			}
			break;
		case 8 :
			//O   O
			// O O
			//  0
			for(int i = -2; i <= 0; i++) {
				WallNode newWall = new WallNode(wallX+Define.unit*i, wallY+Define.unit*i);
				wall.add(newWall);
				newWall = new WallNode(wallX-Define.unit*i, wallY+Define.unit*i);
				wall.add(newWall);
			}
			break;
		case 9 :
			//  0
			// O O
			//O   O
			for(int i = 0; i <= 2; i++) {
				WallNode newWall = new WallNode(wallX+Define.unit*i, wallY+Define.unit*i);
				wall.add(newWall);
				newWall = new WallNode(wallX-Define.unit*i, wallY+Define.unit*i);
				wall.add(newWall);
			}
			break;
		default:
			WallNode newWall = new WallNode(wallX, wallY);
			wall.add(newWall);
			break;
		}
	}
	public static void createFood(ArrayList<SnakeNode> player, ArrayList<WallNode> wall, ArrayList<FoodNode> foodList) {
		Iterator<WallNode>  itWall  = wall.iterator();
		Iterator<SnakeNode> itSnake = player.iterator();
		Iterator<FoodNode> itFood = foodList.iterator();
		boolean putFood;
		
		while(true) {
			System.out.println("準備放置食物...");
			int r = (int) (Math.random() * Define.RAND_POS);
			int newFoodX = r * Define.unit;
			r = (int) (Math.random() * Define.RAND_POS);
			int newFoodY = r * Define.unit;
			putFood = true;
			//檢查是否重疊
			while(itWall.hasNext()) {
				WallNode wallnode = itWall.next();
				int wallX = wallnode.getX();
				int wallY = wallnode.getY();
				if((newFoodX == wallX) && (newFoodY == wallY)) {
					putFood = false;
					System.out.println("放置食物失敗...牆壁重疊");
				}
			}
			while(itSnake.hasNext()) {
				SnakeNode snakeBody = itSnake.next();
				int snakeX = snakeBody.getX();
				int snakeY = snakeBody.getY();
				if(newFoodX == snakeX && newFoodY == snakeY) {
					putFood = false;
					System.out.println("放置食物失敗...蛇身重疊");
				}
			}
			while(itSnake.hasNext()) {
				SnakeNode snakeBody = itSnake.next();
				int snakeX = snakeBody.getX();
				int snakeY = snakeBody.getY();
				if(newFoodX == snakeX && newFoodY == snakeY) {
					putFood = false;
					System.out.println("放置食物失敗...蛇身重疊");
				}
			}
			while(itFood.hasNext()) {
				FoodNode food = itFood.next();
				int foodX = food.getX();
				int foodY = food.getY();
				if(newFoodX == foodX && newFoodY == foodY) {
					putFood = false;
					System.out.println("放置食物失敗...蛇身重疊");
				}
			}
			if(putFood) {
				foodList.add(new FoodNode(newFoodX, newFoodY));
				System.out.println("放置食物成功 x:" + newFoodX + " y:" + newFoodY);
				break;
			}
		}
	}
	public static void createFood(ArrayList<SnakeNode> player1, ArrayList<SnakeNode> player2, ArrayList<WallNode> wall, ArrayList<FoodNode> food) {
		Iterator<WallNode>  itWall  = wall.iterator();
		Iterator<SnakeNode> itSnake1 = player1.iterator();
		Iterator<SnakeNode> itSnake2 = player2.iterator();
		boolean putFood;
		
		while(true) {
			System.out.println("準備放置食物...");
			int r = (int) (Math.random() * Define.RAND_POS);
			int foodX = r * Define.unit;
			r = (int) (Math.random() * Define.RAND_POS);
			int foodY = r * Define.unit;
			putFood = true;
			//檢查是否重疊
			while(itWall.hasNext()) {
				WallNode wallnode = itWall.next();
				int wallX = wallnode.getX();
				int wallY = wallnode.getY();
				if((foodX == wallX) && (foodY == wallY)) {
					putFood = false;
					System.out.println("放置食物失敗...牆壁重疊");
				}
			}
			while(itSnake1.hasNext()) {
				SnakeNode snakeBody = itSnake1.next();
				int snakeX = snakeBody.getX();
				int snakeY = snakeBody.getY();
				if(foodX == snakeX && foodY == snakeY) {
					putFood = false;
					System.out.println("放置食物失敗...蛇身重疊");
				}
			}
			while(itSnake2.hasNext()) {
				SnakeNode snakeBody = itSnake2.next();
				int snakeX = snakeBody.getX();
				int snakeY = snakeBody.getY();
				if(foodX == snakeX && foodY == snakeY) {
					putFood = false;
					System.out.println("放置食物失敗...蛇身重疊");
				}
			}
			if(putFood) {
				food.add(new FoodNode(foodX, foodY));
				System.out.println("放置食物成功 x:" + foodX + " y:" + foodY);
				break;
			}
		}
	}
	public static void snakeAdd(ArrayList<SnakeNode> player) {
		System.out.println("長出新身體...");
		int tailX = player.get(player.size()-1).getX();
		int tailY = player.get(player.size()-1).getY();
		SnakeNode newBody = new SnakeNode(tailX, tailY);
		player.add(newBody);
	}
}

class CreateFoodTask extends TimerTask{
	public CreateFoodTask() {
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}