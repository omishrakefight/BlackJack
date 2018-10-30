package com.sg.blackjack;
import java.util.Random;
/**
 *
 * @author omish
 */
public class DeckOfCards {
    Cards[] deck = new Cards[52];
    Random rng = new Random();
    int deckCard = 0;
    
    public Cards[] MakeDeck(){
        for (int suitCnt = 0; suitCnt < 4; suitCnt++) {
            for (int cardNum = 0; cardNum < 13; cardNum++) {
                // This is so faces can be set to 10
                int cardValue = cardNum + 1;
                boolean isFace = DetermineFace(cardValue);
                boolean isBlack = false;
                String faceValue;
                String suit;
                suit = DetermineSuit(suitCnt);
                faceValue = isFaceCard(cardValue);
                cardValue = FaceValue(cardValue); 
                
                deck[cardNum + (suitCnt * 13)] = new Cards(cardValue, faceValue, suit, isBlack, isFace);
            }
        }
    Shuffle();
    return deck;
    }
    
    private boolean DetermineFace(int cardNum){
        boolean isFace = false;
        if (cardNum >= 11){
                    isFace = true;
                }
        return isFace;
    }
    
    private boolean DetermineColor(String suit){
        boolean isBlack = true;
        if(suit.equals("Spade") || suit.equals("Clover")){
                    isBlack = true;
                }
        return isBlack;
    }
    
    private String DetermineSuit(int x){
        String suit;
        
        switch (x){
                    case 0 :
                        suit = "Spades";
                        break;
                    case 1 :
                        suit = "Hearts";
                        break;
                    case 2:
                        suit = "Clubs";
                        break;
                    default:
                        suit = "Diamonds";
                        break;
                    }
        
        return suit;
    }
   //end of class 
    
    public Cards[] Shuffle(){
        int secondCard;
        Cards swapper;
        
        for (int startCard = 0; startCard < deck.length; startCard++) {
            secondCard = rng.nextInt(deck.length);
            
            swapper = deck[secondCard];
            deck[secondCard] = deck[startCard];
            deck[startCard] = swapper;
            
        }
        deckCard = 0;
        return deck;
    }
    
    public Cards DrawCard(){
        Cards card = deck[deckCard];
        deckCard++;
        return card;
    }
    
    public String isFaceCard(int value){
        String faceValue;
                switch(value){
            case 11:
                faceValue = "Jack";
                break;
            case 12:
                faceValue = "Queen";
                break;
            case 13:
                faceValue = "King";
                break;
            case 14:
                faceValue = "Ace";
                break;
            default:
                faceValue = null;
         }
     return faceValue;
     }
    
    private int FaceValue(int value){
        int cardValue;
                switch(value){
            case 11:
                cardValue = 10;
                break;
            case 12:
                cardValue = 10;
                break;
            case 13:
                cardValue = 10;
                break;
            case 14:
                cardValue = 11;
                break;
            default:
                cardValue = value;
         }
        return cardValue;
        
    }
    
}