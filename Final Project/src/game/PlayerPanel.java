package game;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.Border;

import data.Define;
import event.CreateEvent;
import node.CaveNode;
import node.FoodNode;
import node.SnakeNode;
import node.WallNode;
import snake.Player;


public class PlayerPanel extends JPanel
implements ActionListener{
	private int DELAY = 10;
	private Timer gameTimer;
	private Border blackline = BorderFactory.createLineBorder(Color.black);
	private int refresh;
	private int repaintTime;
	Player p1, p2;
	SnakeNode snakeHeadP1, snakeHeadP2;
	ArrayList<CaveNode>  caveList;
	ArrayList<WallNode>  wallList;
	ArrayList<FoodNode>  foodList;
	int needPutFood, putBufferTime;
	int state, mode;
	
	JButton startSingle, startMuti, returnMenu, exit;
	JLabel Title;
	public PlayerPanel() {
		addKeyListener(new PlayerKey());
	    setBackground(Define.colorBackground);
	    setFocusable(true);
	    setDoubleBuffered(true);
	    setPreferredSize(new Dimension(Define.width + Define.scorewidth, Define.heighth));
	    setBorder(blackline);
	    setLayout(null);
		gameTimer = new Timer(DELAY, this);
	    gameTimer.setActionCommand(Define.strTimer);
	    //initMainMenu();
	}
	public void initMainMenu() {
		state = Define.menuState;
		mode = Define.nobody;
		refresh = 0;
		repaintTime = 100;
		
		Title = new JLabel("Greedy Snake");
		Title.setBounds(Define.TitleX, Define.TitleY, Define.TitleWidth, Define.TitleHeighth);
		Title.setFont(new Font("Helvetica", Font.BOLD, 32));
		add(Title);
		startSingle = new JButton("單人模式");
		startSingle.setActionCommand(Define.strStartOne);
		startSingle.addActionListener(this);
		startSingle.setBounds(Define.BTX, Define.BTY, Define.BTWidth, Define.BTHeighth);
		add(startSingle);
		startMuti = new JButton("雙人模式");
		startMuti.setActionCommand(Define.strStartTwo);
		startMuti.addActionListener(this);
		startMuti.setBounds(Define.BTX, Define.BTY + Define.BTHeighth + Define.BTdis, Define.BTWidth, Define.BTHeighth);
		add(startMuti);
		exit = new JButton("離開");
		exit.setActionCommand(Define.strExit);
		exit.addActionListener(this);
		exit.setBounds(Define.BTX, Define.BTY + Define.BTHeighth*2 + Define.BTdis*2, Define.BTWidth, Define.BTHeighth);
		add(exit);
		gameTimer.stop();
	}
	public void initSingleGame() {
		state = Define.gameState;
		mode = Define.singleMode;
		needPutFood = 0; 
		putBufferTime = 0;
		refresh = 0;
	    p1 = new Player();
		p1.setDir(Define.right);
		wallList  = new ArrayList<WallNode>();
		foodList  = new ArrayList<FoodNode>();
		caveList  = new ArrayList<CaveNode>();
		CreateEvent.createCave(caveList);
		snakeHeadP1 = CreateEvent.createSnake(p1.getSnake(), Define.P1StartX, Define.P1StartY, Define.colorHeadP1);
		CreateEvent.createWall(p1.getSnake(), wallList);
		CreateEvent.createFood(p1.getSnake(), wallList, foodList);
	    gameTimer.start();
	}
	public void initMutiGame() {
		state = Define.gameState;
		mode = Define.mutiMode;
		needPutFood = 0; 
		putBufferTime = 0;
		refresh = 0;
		p1 = new Player();
	    p2 = new Player();
	    p1.setDir(Define.right);
	    p2.setDir(Define.right);
	    //snakeList = new ArrayList<SnakeNode>();
		wallList  = new ArrayList<WallNode>();
		foodList  = new ArrayList<FoodNode>();
		caveList  = new ArrayList<CaveNode>();
		CreateEvent.createCave(caveList);
		snakeHeadP1 = CreateEvent.createSnake(p1.getSnake(), Define.P1StartX, Define.P1StartY, Define.colorHeadP1);
		snakeHeadP2 = CreateEvent.createSnake(p2.getSnake(), Define.P2StartX, Define.P2StartY, Define.colorHeadP2);
		CreateEvent.createWall(p1.getSnake(), p2.getSnake(), wallList);
		CreateEvent.createFood(p1.getSnake(), p2.getSnake(), wallList, foodList);
		CreateEvent.createFood(p1.getSnake(), p2.getSnake(), wallList, foodList);
		gameTimer = new Timer(DELAY, this);
		gameTimer.setActionCommand(Define.strTimer);
	    gameTimer.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    if(state == Define.menuState) {
	    	initMainMenu();
	    }
	    else {
	    	doDrawingGame(g);
	    }
	}
	
	
	private void doDrawingGame(Graphics g) {   
	    if (state == Define.gameState || state == Define.gamePauseState) {
	    	//g.setColor(Color.BLACK);
	    	//g.drawRect(0, 0, Define.width, Define.heighth);
	    	for(CaveNode cave : caveList) {
	    		g.setColor(cave.getColor());
	    		g.fillRect(cave.getX(), cave.getY(), Define.unit, Define.unit);
	    	}
	    	for(WallNode wall : wallList) {
	    		g.setColor(Color.BLACK);
	    		g.drawRect(wall.getX(), wall.getY(), Define.unit, Define.unit);
	    		g.setColor(wall.getColor());
	    		g.fillRect(wall.getX(), wall.getY(), Define.unit, Define.unit);
	    	}
			//System.out.println("牆壁繪製完成...");
	    	for(FoodNode food : foodList) {
	    		g.setColor(Color.BLACK);
	    		g.drawArc(food.getX(), food.getY(), Define.unit, Define.unit, 0, 360);
	    		g.setColor(food.getColor());
	    		g.fillArc(food.getX(), food.getY(), Define.unit, Define.unit, 0, 360);
	    	}
			//System.out.println("食物繪製完成...");
	    	for(int i = 1; i < p1.getSnake().size(); i++) {
	    		SnakeNode snake = p1.getSnake().get(i);
    			g.setColor(Color.BLACK);
        		g.drawRect(snake.getX(), snake.getY(), Define.unit, Define.unit);
        		g.setColor(snake.getColor());
        		g.fillRect(snake.getX(), snake.getY(), Define.unit, Define.unit);
    		
	    	}
			//System.out.println("P1蛇身繪製完成...");
	    	if(mode == Define.mutiMode) {
		    	for(int i = 1; i < p2.getSnake().size(); i++) {
		    		SnakeNode snake = p2.getSnake().get(i);
	    			g.setColor(Color.BLACK);
	        		g.drawRect(snake.getX(), snake.getY(), Define.unit, Define.unit);
	        		g.setColor(snake.getColor());
	        		g.fillRect(snake.getX(), snake.getY(), Define.unit, Define.unit);
	    		
		    	}
	    	}
	    	g.setColor(Color.BLACK);
			g.drawArc(snakeHeadP1.getX(), snakeHeadP1.getY(), Define.unit, Define.unit, 0, 360);
	    	g.setColor(snakeHeadP1.getColor());
	    	g.fillArc(snakeHeadP1.getX(), snakeHeadP1.getY(), Define.unit, Define.unit, 0, 360);
	    	
	    	if(mode == Define.mutiMode) {
	    		g.setColor(Color.BLACK);
				g.drawArc(snakeHeadP2.getX(), snakeHeadP2.getY(), Define.unit, Define.unit, 0, 360);
		    	g.setColor(snakeHeadP2.getColor());
		    	g.fillArc(snakeHeadP2.getX(), snakeHeadP2.getY(), Define.unit, Define.unit, 0, 360);
	    	}
	    	if(state == Define.gamePauseState) {
	    		String msg = "Pause";
	    	    Font small = new Font("Helvetica", Font.BOLD, 14);
	    	    FontMetrics metr = getFontMetrics(small);
	    	
	    	    g.setColor(Color.white);
	    	    g.setFont(small);
	    	    g.drawString(msg, (Define.width - metr.stringWidth(msg)) / 2, Define.heighth / 2);
	    	    
	    	    returnMenu = new JButton("回到主介面");
	    	    returnMenu.setActionCommand(Define.strReturnMenu);
	    	    returnMenu.addActionListener(this);
	    	    returnMenu.setBounds(Define.BTX, Define.BTY + Define.BTHeighth + Define.BTdis*5, Define.BTWidth, Define.BTHeighth);
	    	    add(returnMenu);
	    	}
	    	Toolkit.getDefaultToolkit().sync();
	    } 
	    else if(state == Define.gameOverState) {
	        gameOver(g);
	    }
	}
	
	private void gameOver(Graphics g) {
	    
	    String msg = "Game Over";
	    Font small = new Font("Helvetica", Font.BOLD, 14);
	    FontMetrics metr = getFontMetrics(small);
	
	    g.setColor(Color.white);
	    g.setFont(small);
	    g.drawString(msg, (Define.width - metr.stringWidth(msg)) / 2, Define.heighth / 2);
	    String strScore1 = "P1 Score : " + p1.getScore();
	    g.drawString(strScore1, (Define.width - metr.stringWidth(msg))/ 2, 50 / 2 + Define.unit*5);
	    if(mode == Define.mutiMode) {
		    String strScore2 = "P2 Score : " + p2.getScore();
		    g.drawString(strScore2, (Define.width - metr.stringWidth(msg))/ 2, 75/ 2 + Define.unit*7);
	    }
	    returnMenu = new JButton("回到主介面");
	    returnMenu.setActionCommand(Define.strReturnMenu);
	    returnMenu.addActionListener(this);
	    returnMenu.setBounds(Define.BTX, Define.BTY + Define.BTHeighth + Define.BTdis*3, Define.BTWidth, Define.BTHeighth);
	    add(returnMenu);
	    exit = new JButton("離開");
		exit.setActionCommand(Define.strExit);
		exit.addActionListener(this);
		exit.setBounds(Define.BTX, Define.BTY + Define.BTHeighth*2 + Define.BTdis*4, Define.BTWidth, Define.BTHeighth);
		add(exit);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String command = arg0.getActionCommand();
		//System.out.println("Refresh : " + refresh);
		//System.out.println("Command : " + command);
		if(command.equals(Define.strReturnMenu)) {
			removeAll();
			initMainMenu();
		}
		else if(command.equals(Define.strStartOne)) {
			removeAll();
			initSingleGame();
		}
		else if(command.equals(Define.strStartTwo)) {
			removeAll();
			initMutiGame();
		}
		else if(command.equals(Define.strExit)) {
			System.exit(0);
		}
		else if(command.equals(Define.strTimer)){
			if(state == Define.gamePauseState) {
				System.out.print("");
			}
			else {
				if(state == Define.gameState) {
					removeAll();
					if (refresh==repaintTime && mode==Define.singleMode) {
						checkCave(p1, caveList);
						checkApple(p1, wallList, foodList);
						checkCollision(p1, wallList);
						if(!p1.isInCave()) {
							move(p1);
						}
						else {
							if(p1.getInCaveTime() >= Define.needInCaveTime) {
								move(p1);
								p1.exitCave();
							}
							else {
								p1.addInCaveTime(repaintTime);
							}
						}
						refresh = 0;
						int repaintTimeTmp = (repaintTime>Define.fastRepaint) ? Define.slowRepaint - p1.getScore()*3 : Define.fastRepaint;
						repaintTime = (repaintTimeTmp / 10) * 10;
					}
					else if (refresh==repaintTime && mode==Define.mutiMode) {
						checkCave(p1, p2, caveList);
						checkApple(p1, wallList, foodList);
						checkCollision(p1, p2, wallList);
						checkApple(p2, wallList, foodList);
						checkCollision(p2, p1, wallList);
						if(!p1.isInCave()) {
							move(p1);
						}
						else {
							if(p1.getInCaveTime() >= Define.needInCaveTime) {
								move(p1);
								p1.exitCave();
							}
							else {
								p1.addInCaveTime(repaintTime);
							}
						}
						if(!p2.isInCave()) {
							move(p2);
						}
						else {
							if(p2.getInCaveTime() >= Define.needInCaveTime) {
								move(p2);
								p2.exitCave();
							}
							else {
								p2.addInCaveTime(repaintTime);
							}
						}
						refresh = 0;
						int score = p1.getScore() + p2.getScore();
						int repaintTimeTmp =(repaintTime>Define.fastRepaint) ? Define.slowRepaint - score : Define.fastRepaint;
						repaintTime = (repaintTimeTmp / 10) * 10;
					}
					
					refresh+=DELAY;
				}
				
				if(needPutFood > 0) {
					if(putBufferTime == 2000) {
						putBufferTime = 0;
						needPutFood--;
						if(mode == Define.singleMode)
							CreateEvent.createFood(p1.getSnake(), wallList, foodList);
						else if(mode == Define.mutiMode)
							CreateEvent.createFood(p1.getSnake(), p2.getSnake(), wallList, foodList);
					}
					else {
						putBufferTime += DELAY;
					}
				}
			}
		}
		repaint();
	}
	
	private void checkCave(Player player, ArrayList<CaveNode> caveList) {
		SnakeNode headP1 = player.getSnake().get(0);
		int headP1X = headP1.getX();
		int headP1Y = headP1.getY();
		for(CaveNode cave : caveList) {
			int caveX = cave.getX();
			int caveY = cave.getY();
			if(caveX==headP1X && caveY==headP1Y && !player.isInCave()) {
				player.enterCave();
				player.setInCaveTime();
				headP1.setX(cave.getExitCave().getX());
				headP1.setY(cave.getExitCave().getY());
			}
		}
	}
	
	private void checkCave(Player p1, Player p2, ArrayList<CaveNode> caveList) {
		SnakeNode headP1 = p1.getSnake().get(0);
		SnakeNode headP2 = p2.getSnake().get(0);
		int headP1X = headP1.getX();
		int headP1Y = headP1.getY();
		int headP2X = headP2.getX();
		int headP2Y = headP2.getY();
		for(CaveNode cave : caveList) {
			int caveX = cave.getX();
			int caveY = cave.getY();
			if(caveX==headP1X && caveY==headP1Y && !p1.isInCave()) {
				p1.enterCave();
				p1.setInCaveTime();
				headP1.setX(cave.getExitCave().getX());
				headP1.setY(cave.getExitCave().getY());
			}
			if(caveX==headP2X && caveY==headP2Y && !p2.isInCave()) {
				p2.enterCave();
				p2.setInCaveTime();
				headP2.setX(cave.getExitCave().getX());
				headP2.setY(cave.getExitCave().getY());
			}
		}
	}
	
	private void checkCollision(Player player, ArrayList<WallNode> wallList2) {
		boolean occur = false;
		SnakeNode snakeHead = player.getSnake().get(0);
		int headX = snakeHead.getX();
		int headY = snakeHead.getY();
		ArrayList<SnakeNode> snakeList = player.getSnake();
		//撞到身體
		for(int i = 1; i < snakeList.size(); i++) {
			SnakeNode body = snakeList.get(i);
			int bodyX = body.getX();
			int bodyY = body.getY();
			if(bodyX == headX && bodyY == headY) {
				occur = true;
				System.out.println("撞到身體...");
			}
		}
		//撞到牆壁
		for(int i = 0; i < wallList.size(); i++) {
			WallNode wall = wallList.get(i);
			int wallX = wall.getX();
			int wallY = wall.getY();
			if(wallX == headX && wallY == headY) {
				occur = true;
				System.out.println("撞到牆壁...");
			}
		}
		if(occur) {
			state = Define.gameOverState;
		}
	}
	private void checkApple(Player player, ArrayList<WallNode> wallList,  ArrayList<FoodNode> foodList) {
		//System.out.println("是否吃到...");
		ArrayList<SnakeNode> snakeList = player.getSnake();
		Iterator<FoodNode> itFood = foodList.iterator();
		SnakeNode snakeHead = player.getSnake().get(0);
		int headX = snakeHead.getX();
		int headY = snakeHead.getY();
		boolean eaten = false;
		while(itFood.hasNext()) {
			FoodNode food = itFood.next();
			int foodX = food.getX();
			int foodY = food.getY();
		
			if(headX == foodX && headY == foodY) {
				itFood.remove();
				player.addScore(1);
				eaten = true;
			}
		}
		if(eaten) {
			System.out.println("吃到了!!!");
			needPutFood++;
			CreateEvent.snakeAdd(snakeList);
		}
	}
	
	private void checkCollision(Player me, Player another, ArrayList<WallNode> wallList) {
		boolean occur = false;
		SnakeNode myHead = me.getSnake().get(0);
		int headX = myHead.getX();
		int headY = myHead.getY();
		ArrayList<SnakeNode> mySnakeList = me.getSnake();
		ArrayList<SnakeNode> anotherSnakeList = another.getSnake();
		//撞到身體
		for(int i = 1; i < mySnakeList.size(); i++) {
			SnakeNode body = mySnakeList.get(i);
			int bodyX = body.getX();
			int bodyY = body.getY();
			if(bodyX == headX && bodyY == headY) {
				occur = true;
				System.out.println("撞到身體...");
			}
		}
		for(int i = 1; i < anotherSnakeList.size(); i++) {
			SnakeNode body = anotherSnakeList.get(i);
			int bodyX = body.getX();
			int bodyY = body.getY();
			if(bodyX == headX && bodyY == headY) {
				occur = true;
				System.out.println("撞到身體...");
			}
		}
		//撞到牆壁
		for(int i = 0; i < wallList.size(); i++) {
			WallNode wall = wallList.get(i);
			int wallX = wall.getX();
			int wallY = wall.getY();
			if(wallX == headX && wallY == headY) {
				occur = true;
				System.out.println("撞到牆壁...");
			}
		}
		if(occur) {
			state = Define.gameOverState;
			//gameTimer.stop();
		}
	}
	private void move(Player player) {
		SnakeNode nextNode, nowNode;
		ArrayList<SnakeNode> snakeList = player.getSnake();
		int dir = player.getDir();
		for(int i = snakeList.size()-1; i > 0; i--) {
			nowNode = snakeList.get(i);
			nextNode = snakeList.get(i-1);
			nowNode.setX(nextNode.getX());
			nowNode.setY(nextNode.getY());
		}
		SnakeNode snakeHead = player.getSnake().get(0);
		int headX = snakeHead.getX();
		int headY = snakeHead.getY();
		if(dir == Define.up) {
			headY-=Define.unit;
			snakeHead.setY(headY);
		}
		else if(dir == Define.down) {
			headY+=Define.unit;
			snakeHead.setY(headY);
		}
		else if(dir == Define.right) {
			headX+=Define.unit;
			snakeHead.setX(headX);
		}
		else if(dir == Define.left) {
			headX-=Define.unit;
			snakeHead.setX(headX);
		}
	}
	private class PlayerKey extends KeyAdapter{
		  public void keyPressed(KeyEvent e) {
	          int key = e.getKeyCode();
	          if ((key == KeyEvent.VK_LEFT) && (p1.getDir() != Define.right)) {
	              p1.setDir(Define.left);
	              System.out.println("方向left");
	          }
	
	          if ((key == KeyEvent.VK_RIGHT) && (p1.getDir() != Define.left)) {
	              p1.setDir(Define.right);
	              System.out.println("方向right");
	          }
	
	          if ((key == KeyEvent.VK_UP) && (p1.getDir() != Define.down)) {
	        	  p1.setDir(Define.up);
	              System.out.println("方向up");
	          }
	
	          if ((key == KeyEvent.VK_DOWN) && (p1.getDir() != Define.up)) {
	        	  p1.setDir(Define.down);
	              System.out.println("方向down");
	          }
	          //P2
	          if ((key == KeyEvent.VK_A) && (p2.getDir() != Define.right)) {
	              p2.setDir(Define.left);
	              System.out.println("方向left");
	          }
	
	          if ((key == KeyEvent.VK_D) && (p2.getDir() != Define.left)) {
	              p2.setDir(Define.right);
	              System.out.println("方向right");
	          }
	
	          if ((key == KeyEvent.VK_W) && (p2.getDir() != Define.down)) {
	        	  p2.setDir(Define.up);
	              System.out.println("方向up");
	          }
	
	          if ((key == KeyEvent.VK_S) && (p2.getDir() != Define.up)) {
	        	  p2.setDir(Define.down);
	              System.out.println("方向down");
	          }
	          
	          if(key == KeyEvent.VK_ESCAPE) {
	        	  if(state == Define.gameState) {
	        		  state = Define.gamePauseState;
	        	  }
	        	  else if(state == Define.gamePauseState) {
	        		  state = Define.gameState;
	        	  }
	          }
	      }
	  }
}
