package com.sg.blackjack;

/**
 *
 * @author omish
 */
public class Cards {
    private int number;
    private String suit;
    private String faceCard;
    private boolean face;
    private boolean isBlack;
    private boolean faceUp;

    public String getFaceCard() {
        return faceCard;
    }

    public void setFaceCard(String faceCard) {
        this.faceCard = faceCard;
    }

    public int getNumber() {
        return number;
    }

    public String getSuit() {
        return suit;
    }

    public Boolean getFace() {
        return face;
    }

    public boolean isIsBlack() {
        return isBlack;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public void setFace(boolean face) {
        this.face = face;
    }
    
    
    public Cards(int number, String isFaceCard, String suit, boolean isBlack, boolean face){
        this.number = number;
        this.suit = suit;
        this.isBlack = isBlack;
        this.face = face;
        this.faceCard = isFaceCard;
    }
    public Cards(int number, String suit, boolean isBlack){
        this.number = number;
        this.suit = suit;
        this.isBlack = isBlack;
    }
    
    
    
    
}
