package logic.instruction;

import logic.CollectionManager;
import logic.Instruction;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class ShuffleInstruction implements Instruction {

    private CollectionManager<?> collectionManager;

    public ShuffleInstruction(CollectionManager<?> collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        Collections.sort(collectionManager.getData(), new Comparator<Object>() {

            public int compare(Object t1, Object t2) {
                Random rand = new Random();
                return (rand.nextInt() % 3 - 1);
            }
        });
    }
    @Override 
    public String getName() {
        return "shuffle";
    }
    @Override
    public String about() {
        return "shuffle : перемешать элементы коллекции в случайном порядке";
    }
}
