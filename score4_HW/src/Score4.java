import java.util.Random;
import java.util.Scanner;
public class Score4 {

	public static void main(String[] args) {
		
        Scanner in = new Scanner(System.in);
		
		String player1, player2, winner;
		String[][] stoixeia = new String [2][2];
		int rows, col, totalcol, totalrows, selected_col,l,k,j,i; //Opou l,k,j,i oi diaforoi metrites pou xrisimopoiithikan
		int sum;                                                 // Metraei ta sinexomena dipla chips
		boolean flag = true;                                    //Boithitiki metavliti gia epanalipseis while
		
		//Eisagogi-eisodos stoixeion
		
		System.out.println("Welcome to Score4 game!");
		System.out.println("Please enter the name of the 1st player: ");
		player1 = in.nextLine();
		stoixeia[0][0] = player1;
		System.out.println("Please enter the name of the 2nd player: ");
		player2 = in.nextLine();
		stoixeia[1][0] = player2;
		
		Random rand = new Random();                //Paragogi tyxaiou arithmou
		int upperbound = 2;                        //Paragogi tyxaiou arithmou
		int int_random = rand.nextInt(upperbound); //Paragogi tyxaiou arithmou
		
		//epilegetai tyxaia o paikths pou tha dialeksi chip
		
		System.out.println("\n\n"+stoixeia[int_random][0] + ", please select your chip: ");
		stoixeia[int_random][1] = in.nextLine();
		if (stoixeia[int_random][1].equals("x") || stoixeia[int_random][1].contentEquals("o"))
			flag=false;
		while (flag==true)
		{
			System.out.println("ERROR! The chip must be the 'x' or the 'o' character!");
	        System.out.println("Please try again: ");
	        stoixeia[int_random][1] = in.nextLine();
	        if (stoixeia[int_random][1].equals("x") || stoixeia[int_random][1].contentEquals("o"))
				flag=false;
		}
		if (int_random==0)
		{
			if(stoixeia[0][1].contentEquals("x")) {
				stoixeia[1][1]=" o ";
				stoixeia[0][1]=" x ";
			}
				
			else {
				stoixeia[1][1]=" x ";
				stoixeia[0][1]=" o ";
			}
			System.out.println(stoixeia[1][0]+ ", your chip is: "+ stoixeia[1][1]);
		}
		else
			{if(stoixeia[1][1].contentEquals("x")) {
				stoixeia[0][1]=" o ";
				stoixeia[1][1]=" x ";
			}
			
			else {
				stoixeia[0][1]=" x ";
				stoixeia[1][1]=" o ";
			}
			System.out.println(stoixeia[0][0] + ", yourchip is: "+ stoixeia[0][1]);
			}
		
		System.out.println("\n\nPlease enter the number of rows: ");
		rows = in.nextInt();
		while (rows<4 || rows>15)
		{
			System.out.println("Incorrect input. Please enter again the number of rows: ");
			rows = in.nextInt();
		}
		System.out.println("Please enter the number of columns :");
		col = in.nextInt();
		while (col<4 || col>15)
		{
			System.out.println("Incorrect input. Please enter again the number of columns: ");
			col = in.nextInt();
		}
		totalrows = rows+1;                                     // To kano afto giati mesa stis grammes tou pinaka game_board perilamvanetai kai i seira me tis pavles: ____ ...
		totalcol = col+2;                                       //Exoume 2 parapano sthles gt mesa ston pinaka game_board evala kai ta 2 akriana perithoria deksia kai aristera
		String[][] game_board = new String[rows+1][col+3];     // Orismos pinaka pou tha einai to tampblo paixnidiou(mazi me ta perithoria)

		totalcol=col+2;
		for (i=0; i<totalrows-1; i++)
		{
			game_board[i][0]="|";
			game_board[i][totalcol-1]="|"; 

		}
		
		
		for (i=0; i<totalrows; i++)
		{
			for ( j=1; j<totalcol-1; j++)
			{
				game_board[i][j]=" - ";
			}
		}
		for ( j=0;j<totalcol;j++)
		{
			if(j==totalcol-1)
				game_board[rows][j]="";
			else
				game_board[rows][j]="___";
			
		}
		//ARXH Ektiposis toy arxikou kenou game board
		
		for (i=0; i<totalrows; i++)
		{
			for ( j=0; j<totalcol; j++)
			{
				System.out.print(game_board[i][j]);

			}
			
		
		System.out.println();
        }
		for(i=1;i<totalcol-1;i++)
			System.out.print("  "+i+"" );
		System.out.println("\n");	
		
		//TELOS Ektiposis tou arxikou kenou game board
		
		Random rand2 = new Random();                //Paragogi tyxaiou arithmou (Gia ton paikti pou tha paiksei protos)
		int upperbound2 = 2;                        //Paragogi tyxaiou arithmou (Gia ton paikti pou tha paiksei protos)
		int plays_now = rand2.nextInt(upperbound2); //Paragogi tyxaiou arithmou (Gia ton paikti pou tha paiksei protos)
		
		boolean draw=false;
		boolean we_have_winner=false;
		
		
		//kseikinaei to paixnidi	(Oi gyroi toy paixnidiou)	
		
		
		while (draw==false && we_have_winner == false) {
		
		
		   System.out.println(stoixeia[plays_now][0] +  ",  your turn. Select column: ");
		   flag=false;
		   
		 
		   
		   do {
			   selected_col=in.nextInt(); //O xrhsths epilegei tin sthlh poy thelei na valei to chip
			   
			   while(selected_col<1 || selected_col>=totalcol-1) {
				   System.out.println("Wrong input! Please try again.");
				   selected_col=in.nextInt();
			   }
			   
			   while(game_board[0][selected_col] != " - ") {
				   System.out.println("This column is full! Please pick another column and try again.");
				   selected_col=in.nextInt();
			   }
			   if(selected_col<1 || selected_col>=totalcol-1) {
				   flag=true;
				   System.out.println("This column doesn't exist! Please try again: ");
			   }	   
			   else flag=false;
			   
			   
		   }while(flag==true);
		
		   for(i=totalrows-1;i>=0;i--) {
			   if (game_board[i][selected_col]==" - ") {
				   game_board[i][selected_col]=stoixeia[plays_now][1];

				   i=-1;
			   }
				
		   }
		   if (plays_now==0) //Enallagi tis seiras twn paiktwn
			   plays_now+=1;
		   else
			   plays_now-=1;
		   
		 
		   
		//(START)Edo ginete ektiposi tou pinaka paixnidiou(Enimeromeno me vasi tis epiloges twn paiktwn)
		   for (i=0; i<totalrows; i++)
		   {
			   for ( j=0; j<totalcol; j++)
			   {
				   System.out.print(game_board[i][j]);

			   }
			
		
		   System.out.println();
           }
		   for(i=1;i<totalcol-1;i++)
			   System.out.print("  "+i+"" );
		   System.out.println("\n");	
	//(END)Edo teleionei i ektiposi toy pinaka paixnidiou
		   
		   
   //(START)Edo elegxetai an exei nikisei kapoios paikths
		  
		   // Elegxos ana grammh
		   sum=0;
		   for(i=0; i<totalrows-1; i++) {
			   sum=0;
			   for ( j=1; j<totalcol-2; j++) {
				   if(game_board[i][j] != " - " && game_board[i][j+1] != " - ") {
					   if (game_board[i][j]==game_board[i][j+1])
						   sum += 1;
					   else if(sum!=3)
						   sum=0;
				   }
				   else if(game_board[i][j] == " - " && sum !=3) 
					   sum=0;
			   }
			   if (sum==3) {
				   we_have_winner=true;
				   if(game_board[i][j]==stoixeia[0][1]) {
					   winner=stoixeia[0][0];
					   System.out.println(" GAME OVER. THE WINNER IS " + winner);
					   break;
				   }
				   else {
					   winner = stoixeia[1][0];
					   System.out.println(" GAME OVER. THE WINNER IS " + winner);
					   break;
				   }
					   
					
			   }
				   //we have a winner + end the for
		   }
		   if (we_have_winner)
			   break;
		   
		   //Elegxos ana sthlh
		   sum=0;
		   for ( j=1; j<totalcol-1; j++) {
			   sum=0;
			   for (i=0; i<totalrows-2; i++) {
				   if(game_board[i][j] != " - " && game_board[i+1][j] != " - " ) {
					   if (game_board[i][j]==game_board[i+1][j])
						   sum += 1;
					   else if (sum!=3)
						   sum=0;
				   }
				   else if(game_board[i][j] == " - " && sum !=3) 
					   sum=0;
			   }
			   //we have a winner + end the for
			   if (sum==3) {
				   we_have_winner=true;
				   if(game_board[i][j]==stoixeia[0][1]) {
					   winner=stoixeia[0][0];
					   System.out.println(" GAME OVER. THE WINNER IS " + winner);
					   break;
				   }
				   else {
					   winner = stoixeia[1][0];
					   System.out.println(" GAME OVER. THE WINNER IS " + winner);
					   break;
				   }
		   }
		   }
		   if (we_have_winner)
			   break;
	   
		   
		   //Elegxos diagonia (Apoteleitai apo 3 merh)
		   
		   //proto meros(ksekinaei apo pano aristera kai metakineitai meta apo kathe diagonio elegxo kathe fora mia thesi pros ta deksia )
		   sum=0;

		   for (int m=1; m<totalcol; m++) {
		   l=m;
		   if(sum==3)
			   break;

			   for (k=0; k<totalrows-1; k++) {

				   if(game_board[k][l] != " - " && game_board[k+1][l+1] != " - ") {
					   if(game_board[k][l]==game_board[k+1][l+1]) {
						   sum=sum+1;

					   }
						   
					   else if(sum!=3)
						   sum=0;
				   }
				   else if(game_board[k][l] == " - " && sum !=3) 
					   sum=0;
				   if (l<totalcol-1)
					   l += 1;
				   else if(sum!=3)
					   break;
			   
				   
			   if (sum==3) {                        //An exei brei 4 idia sinexomanea:
				   we_have_winner=true;
				   if(game_board[k][l-1]==stoixeia[0][1]) {
					   winner=stoixeia[0][0];
					   System.out.println(" GAME OVER. THE WINNER IS " + winner);
					   break;
				   }
				   else {
					   winner = stoixeia[1][0];
					   System.out.println(" GAME OVER. THE WINNER IS " + winner);
					   break;
				   }
				   
			   }
				   

		   }
		   }
			   
			   
			   
			   
			   
			   
  //deftero meros (Ksekinaei apo kato aristera kai metakineitai meta apo kathe diagonio elegxo kathe fora mia thesi pros ta deksia)
		sum=0;	   
		 for (int m=1; m<totalcol; m++) {
			   	 
			   if (we_have_winner)
				   break;
			   
			   else {
				   l=m-1;

					   for (k=totalrows-1; k>0; k--) {

						   if(game_board[k][l] != " - " && game_board[k-1][l+1] != " - ") {
							   if(game_board[k][l]==game_board[k-1][l+1]) {
								    sum=sum+1;

							   }
								  
							   else if(sum!=3)
								   sum=0;
						   }
						   else if(game_board[k][l] == " - " && sum !=3) 
							   sum=0;
						   if (l<totalcol-1)
							   l += 1;
						   else if(sum!=3)
							   break;
				   
			   
					   if (sum==3) {
						   //we have a winner + end for
						   we_have_winner=true;
					   if(game_board[k][l-1]==stoixeia[0][1]) {
						   winner=stoixeia[0][0];
						   System.out.println(" GAME OVER. THE WINNER IS " + winner);
						   break;
					   }
					   else {
						   winner = stoixeia[1][0];
						   System.out.println(" GAME OVER. THE WINNER IS " + winner);
						   break;
					   }
					   }

			   }
					   if (we_have_winner)
						   break;
			   }
		   
					   
		   }
		 //trito meros(ksekinaei apo pano deksia kai metakinitai meta apo kathe diagonio elegxo pros ta aristera se kathe epanalipsi (meionentai o arithmos tis sthlhs)
			   
			   if (sum!= 3) {
				   sum=0;
				   l=totalcol-1;
				   sum=0;
					   for (k=totalrows-1; k>0; k--) { // k>0 ???

						   if(game_board[k][l] != " - " && game_board[k-1][l-1] != " - ") {
							   if(game_board[k][l]==game_board[k-1][l-1]) {
								   sum=sum+1;
							   }
								   
							   else if(sum!=3)
								   sum=0;
						   }
						   else if(game_board[k][l] == " - " && sum !=3) 
							   sum=0;
						   if (l>1 && sum != 3)
							   l -= 1;
						   else if(sum!=3)
							   break;
				   
			   
					   if (sum==3) {
						   //we have a winner + end for
						   we_have_winner=true;
						   if(game_board[k][l]==stoixeia[0][1]) {
							   winner=stoixeia[0][0];
							   System.out.println(" GAME OVER. THE WINNER IS " + winner);
							   break;
						   }
						   else {
							   winner = stoixeia[1][0];
							   System.out.println(" GAME OVER. THE WINNER IS " + winner);
							   break;
						   }
					   }
						   
					   else
						   sum=0;
		   
					   
		   }
		    
		}   
   //(END)Edo elegxthike an exei nikisei kapoios paikths
		   
		
	
		//(START) periptosi isopalias
		
		
		int sum2=0;
		for(j=1;j<totalcol-1;j++) {
			if (game_board[0][j] != " - ")
				sum2 +=1;
		}
		
		
		if (sum2==totalcol-2) {
			draw=true;
			System.out.println("GAME OVER. WE HAVE A DRAW\r\n");
			break;
		}
		
		
		//(END)periptosi isopalias

}//Telos gyrou
	}
}
	

