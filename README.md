# Deck of Cards

This is a Java console application that implements a deck of cards game. The program uses a stack data structure to represent a deck of playing cards, and allows the user to shuffle the deck and deal one card at a time. The user can then guess whether the next card will be higher or lower than the current card, and the program checks their guess against the actual outcome.

## Getting Started

To run the program, you need to have Java installed on your computer. You can download the latest version of Java from the [official website](https://www.java.com/en/download/).

Once you have Java installed, you can run the program from the command line by following these steps:

1. Open a terminal or command prompt window.
2. Navigate to the directory where the `DeckOfCards.java` file is located.
3. Compile the program by running the command `javac DeckOfCards.java`.
4. Run the program by running the command `java DeckOfCards`.

## How to Play

When you run the program, it will display the first card in the deck and prompt you to guess whether the next card will be higher or lower. You can enter "h" for higher or "l" for lower, and press Enter to submit your guess.

If you guess correctly, the program will display the next card and prompt you to guess again. If you guess incorrectly, the program will end the game and display your score.

You can play multiple times by running the program again after the game ends.

## Code Structure

The program is implemented using a single class called `DeckOfCards`. This class represents a deck of playing cards as a stack data structure, and provides methods for shuffling the deck, dealing one card at a time, and comparing the rank values of two cards.

The `main` method of the `DeckOfCards` class implements the game logic, using a `Scanner` object to read the user's input for guessing whether the next card will be higher or lower. It displays the current card and prompts the user for their guess, then compares their guess against the actual outcome and displays the next card and the score.

## License

This program is released under the [MIT License](LICENSE). You are free to use, modify, and distribute this program for any purpose, with or without attribution. However, the author of this program is not liable for any damages or losses incurred while using this program.
