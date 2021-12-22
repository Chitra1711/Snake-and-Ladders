 import java.util.HashMap;
 import java.util.Map;
 import java.util.Random;
 import java.util.Scanner;
 class SnakeNLadder{
	final static int WinPoint =100;
	static Map <Integer, Integer> snake = new HashMap<Integer , Integer>();
	static Map <Integer, Integer> ladder = new HashMap<Integer , Integer>();
						      
	{
								          
		snake.put(99,76);
		snake.put(92,64);
		snake.put(85,15);
		snake.put(64,46);
		snake.put(76,19);
		snake.put(54,30);
		snake.put(11,7);
		ladder.put(71,91);
		ladder.put(63,81);
		ladder.put(28,84);
		ladder.put(40,59);
		ladder.put(20,38);
		ladder.put(9,31);
		ladder.put(4,14);
	}
	public int rollDice(){
		int n=0;
		Random r=new Random();
		n=r.nextInt(7);
		return (n==0?1:n);
	}
	public int PlayerValue(int player , int diceValue){
		player =player+diceValue;
		if(player > WinPoint){
			player=player-diceValue;
			return player;
		}
		if(null !=snake.get(player)){
			System.out.println("Snake  Swallowed" );
			player =snake.get(player);
		}
		if(null !=ladder.get(player)){
			System.out.println(" Climb the ladder" );
			player =ladder.get(player);
		}
		return player;
	}
	public boolean isWin( int player){
		return WinPoint ==player;
	}
	public void startGame(){
		int player1=0,player2=0;
		int currentPlayer=-1;
		Scanner input =new Scanner(System.in);
		String str;
		int diceValue=0;
		do{
			System.out.println(currentPlayer ==-1 ?"\n\n First Player Turn":"Second Player Turn");
			System.out.println("Press d to roll Dice");
			str=input.next();
			diceValue=rollDice();
			if(currentPlayer ==-1){
				player1=PlayerValue(player1, diceValue);
				System.out.println("First Player :" +player1);
				System.out.println("SecondPlayer :" +player2);
				System.out.println("----------------------------------");
				if(isWin(player1)){
					System.out.println("Player 1 Wins the Game");
					return;
				}
			}
			else{
				player2=PlayerValue(player2, diceValue);
				System.out.println("First Player :" +player1);
				System.out.println("SecondPlayer :" +player2);
				System.out.println("----------------------------------");
				if(isWin(player2)){
					System.out.println("Player 2 Wins the Game");
					return;
				}
			}

		
			currentPlayer=-currentPlayer;
		}while("d".equals(str));
	}
 }


public class SnakeAndLadder{
	public static void main(String[]args) {
		int counter= 100;
		System.out.println ("---------------------------------------------------Board Game-----------------------------------------------------");

		while (counter > 0){
			if (counter%10 == 0 && counter != 100){
				if(counter!=0)
					System.out.print("\n" + counter + "\t"); 
			}
			else
				System.out.print(counter + "\t"); 
			counter+=-1; 		
		}
		System.out.println();
		System.out.println ("------------------------------------------------------------------------------------------------------------------");

		SnakeNLadder s=new SnakeNLadder();
		s.startGame();
	}
}
