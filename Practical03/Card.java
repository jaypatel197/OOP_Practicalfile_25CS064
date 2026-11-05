import java.util.Objects;

class Card {
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(rank, card.rank) && Objects.equals(suit, card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }
}

class CardDriver {
    public static void main(String[] args) {
        Card[] cards = {
            new Card("King", "Hearts"),
            new Card("Ace", "Spades"),
            new Card("10", "Diamonds"),
            new Card("Ace", "Spades")
        };

        Card[] deck = new Card[cards.length];
        int size = 0;

        for (Card c : cards) {
            boolean found = false;
            for (int i = 0; i < size; i++) {
                if (deck[i].equals(c)) {
                    System.out.println("Duplicate found: " + c);
                    found = true;
                    break;
                }
            }
            if (!found) {
                deck[size++] = c;
            }
        }
    }
}