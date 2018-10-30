package com.sg.blackjack;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author omish
 */
public class BlackJack {
    
        public static void PlayGame(){
        Random rng = new Random();
        Scanner input = new Scanner(System.in);
        int playerBet, playerScore, dealerScore;
        
        
        DeckOfCards deck = new DeckOfCards();
        deck.MakeDeck();
        
        Player playerOne = MakePerson();
        Dealer dealer = new Dealer("Guy");
        
        do{
            ClearCards(dealer, playerOne, deck);
            
            playerBet = playerOne.PlaceBet();
            dealer.dealersCards(deck);

            playerScore = playerOne.PlayerTurn(deck);
            dealerScore = dealer.DealerTurn(deck);

            calculateWinner(playerScore, dealerScore, playerOne, playerBet);

        
        }while(PlayAgain());
    }
    
    
        
        
        
        
    public static Player MakePerson(){
        Scanner input = new Scanner(System.in);
        String name;
        int money;
        System.out.println("What is your name?");
        name = input.nextLine();
        System.out.println("How much money do you have?");
        money = input.nextInt();
        
        Player player = new Player(name, money);
        return player;
    }
    
    //rework pls
    // player is only used for name : / im tired ATM though
    public static void calculateWinner(int playerS, int dealerS, Player P1, int P1Bet){
        int winnings = 0;
        if(playerS == 21){
            System.out.println(P1.getName() + " Wins!!!");
            winnings = 2 * P1Bet;
        }
        else if (dealerS == 21){
            System.out.println("Dealer Wins!! (as expected)");
        }
        else if (playerS > dealerS && playerS < 22){
            System.out.println(P1.getName() + " Wins!!!");
            winnings = 2 * P1Bet;
        }
        else if(dealerS > 21){
            System.out.println(P1.getName() + " Wins!!!");
            winnings = 2 * P1Bet;
        }
        else{
            System.out.println("Dealer Wins!! (as expected)");
        }
        
        P1.Winnings(winnings);
        
    }
    
    public static boolean PlayAgain(){
        Scanner input = new Scanner(System.in);
        String playAgain;
        System.out.println("Would you like to play again? (y)es / (n)o");
        playAgain = input.nextLine();
        
        if(playAgain.equalsIgnoreCase("y")){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static void ClearCards(Dealer dealer, Player player, DeckOfCards deck){
        dealer.clearHand();
        player.clearHand();
        deck.Shuffle();
    }
 // Class ends
 }
