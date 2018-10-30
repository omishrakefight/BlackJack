package com.sg.blackjack;

import java.util.ArrayList;

/**
 *
 * @author omish
 */
public class Dealer {
    final public int dealerStays = 17;
    
    private String name;
    private ArrayList<Cards> dealersHand = new ArrayList<>();
    int cardAmounts;
    boolean busted = false;
    
    
     public int DealerTurn(DeckOfCards deck){
        String stay;
        int dealersHandValue = dealersHand.get(0).getNumber() + dealersHand.get(1).getNumber();
        while(dealersHandValue < dealerStays){
            Cards newCard = deck.DrawCard();
            AddToHand(newCard);
            dealersHandValue += newCard.getNumber();
        }
     ShowHand();       
    return dealersHandValue;
    }
    
    public void dealersCards(DeckOfCards deck){
        AddToHand(deck.DrawCard());
        AddToHand(deck.DrawCard());
        System.out.println("The dealer has : ");
        System.out.print("??    and  ");
        
        if(dealersHand.get(1).getFace()){
                System.out.println(dealersHand.get(1).getFaceCard() + " of " + dealersHand.get(1).getSuit());
            }
            else{
                System.out.println(dealersHand.get(1).getNumber() + " of " + dealersHand.get(1).getSuit()+ "\n");
            }
    }
    
    public void AddToHand(Cards newCard){
        dealersHand.add(cardAmounts, newCard); 
        cardAmounts++; 
    }
    
    public void ShowHand(){
        System.out.println(name + " has in you hand :  ");
        int handValue = 0;
        for (int x = 0; x < cardAmounts; x++) {
            System.out.print("");
            handValue += dealersHand.get(x).getNumber();
            //Prints face is face or number if not.
            if(dealersHand.get(x).getFace()){
                System.out.println(dealersHand.get(x).getFaceCard() + " of " + dealersHand.get(x).getSuit());
            }
            else{
                System.out.println(dealersHand.get(x).getNumber() + " of " + dealersHand.get(x).getSuit());
            }
        }
        System.out.println(name + "'s current hand value is : " + handValue );
        System.out.println("");
        busted = Bust(handValue);
    }
    
    public Dealer(String name){
        this.name = "Dealer " + name;
    }
    
    private boolean Bust(int cardValue){
        boolean bust = false;
        if (cardValue > 21){
            bust = true;
            System.out.println(name + " has busted!\n");
        }
        return bust;
    }
    
    public void clearHand(){
        dealersHand.clear();
        cardAmounts = 0;
    }
    
}
