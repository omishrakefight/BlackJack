package com.sg.blackjack;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author omish
 */
public class Player {
    private String name;
    private int money = 0;
    //Cards[] hand = new Cards[8];
    private ArrayList<Cards> hand = new ArrayList<>();
    int cardAmounts;
    boolean busted = false;
    Scanner input = new Scanner(System.in);

    public String getName() {
        return name;
    }
    
    public void Winnings(int winnings){
        money += winnings;
        System.out.println("You now have " + money + " dollars.");
    }
    // return score and swap to an int?
    public int PlayerTurn(DeckOfCards deck){
        String stay;
        int handValue;
        
        //Draw for start of turn
        AddToHand(deck.DrawCard());
        AddToHand(deck.DrawCard());
        handValue = ShowHand();
        
        do{
            System.out.println("Do you Hit or Stay? h/s");
            stay = input.nextLine();
            if(stay.equalsIgnoreCase("h")){
                AddToHand(deck.DrawCard());
                handValue = ShowHand();
            }
            else{
                stay = "s";
                }
        }while (stay.equalsIgnoreCase("h") && !busted);
    return handValue;
    }
    
    public int PlaceBet(){
        int bet = 0;
        do{
            System.out.println("How much would you like to bet?  Or place no bet and leave.");
            bet = input.nextInt();
            if(bet <= 0){
                System.out.println("Thank you for playing BlackJack");
            }
            else if(bet > money){
                System.out.println("You do not have that much money available...");
            }
            else{
                System.out.println("Thank you for placing your bet.");
                }
        } while(bet > money);  
        // clears carriage return
        input.nextLine();
        
        money -= bet;
        return bet;
    }
    
    public void AddToHand(Cards newCard){
        hand.add(cardAmounts, newCard);
        cardAmounts++; 
    }
    
    public int ShowHand(){
        System.out.println("You have in your hand :  ");
        int handValue = 0;
        for (int x = 0; x < cardAmounts; x++) {
            System.out.print("");
            handValue += hand.get(x).getNumber();
            //Prints face is face or number if not.
            if(hand.get(x).getFace()){
                System.out.println(hand.get(x).getFaceCard() + " of " + hand.get(x).getSuit());
            }
            else{
                System.out.println(hand.get(x).getNumber() + " of " + hand.get(x).getSuit());
            }
        }
        System.out.println("Your current hand value is : " + handValue );
        System.out.println("");
        busted = Bust(handValue);
        return handValue;
    }
    
    public Player(String name, int money){
        this.name = name;
        this.money = money;
    }
    
    private boolean Bust(int cardValue){
        boolean bust = false;
        if (cardValue > 21){
            bust = true;
            System.out.println("You've busted!");
        }
        return bust;
    }
    
    public void clearHand(){
        hand.clear();
        cardAmounts = 0;
    }
}
