package com.dot.scrim_dot;

public class Pile {
    public int attacked(Card Incomingcard)
    {
        String incoming =  Incomingcard.getName();

        Card top = showTop();
        String topCardName = top.getName();
        if (topCardName == "shield")
        {
            return 1;
        }
        if(topCardName.equals("crown") && Incomingcard.getName().equals("crown") )
        {
            removeTop();
            return -10;
        }
        if(topCardName.equals(incoming))
        {
            removeTop();
            return  0;
        }
        switch (topCardName) {
            case "crown":
                removeTop();
                return -10;
            case "archer":
                removeTop();
                return -1;
            default:
            {
                if(Incomingcard.getValue()>top.getValue())
                {
                    removeTop();
                    return -1;
                }
                else
                    return 1;
            }
        }
    }

    private static final int MAX_SIZE = 5;
    int index;
    int counter;
    Card[] cards;

    public int cardLeft() {
        return cards.length;
    }

    public Pile() {
        cards = new Card[MAX_SIZE];
    }

    public Pile(int index) {
        counter = 0;
        cards = new Card[MAX_SIZE];
        this.index = index;

    }

    public Pile(int index, Card[] cards)
    {
        cards = new Card[MAX_SIZE];
        this.index = index;
        this.cards = cards;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        if (counter == MAX_SIZE)
            return;
        cards[counter++] = card;
    }

    public Card showTop() {
        if (counter == 0)
            return null;
        else return cards[counter - 1];
    }

    public Card removeTop() {
        if (counter == 0) {
            return null;
        }
        counter--;
        Card card = cards[counter];
        return card;

    }
}
