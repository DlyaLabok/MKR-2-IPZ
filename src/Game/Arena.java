package Game;
import java.util.*;
class Arena implements ArenaMediator {
    private List<Character> characters = new ArrayList<>();

    @Override
    public void addCharacter(Character character) {
        characters.add(character);
        notifyCharacters(character);
    }

    @Override
    public void notifyCharacters(Character newCharacter) {
        for (Character character : characters) {
            if (character != newCharacter && isNearby(character, newCharacter)) {
                System.out.println(character.getName() + " is notified about the arrival of " + newCharacter.getName());
            }
        }
    }

    private boolean isNearby(Character c1, Character c2) {
        return Math.abs(c1.getX() - c2.getX()) <= 1 && Math.abs(c1.getY() - c2.getY()) <= 1;
    }
}

