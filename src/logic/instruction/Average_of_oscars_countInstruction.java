package logic.instruction;


import data.Movie;
import logic.CollectionManager;
import logic.Instruction;

public class Average_of_oscars_countInstruction implements Instruction {
    private CollectionManager<?> collectionManager;
    public Average_of_oscars_countInstruction(CollectionManager<?> collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        if(!collectionManager.getData().peek().getClass().getName().equals("Movie")) {
            System.out.println("The data from the collection does not consist of the movie class");
            return;
        }
        int oscarsCount = 0;
        for (Object movie :collectionManager.getData()) {
            oscarsCount += ((Movie)movie).getOscarCount();
        }
        System.out.printf("Middle count Oscars:%d\n", oscarsCount/collectionManager.getData().size());
    }
    @Override 
    public String getName() {
        return "average_of_oscars_count";
    }
    @Override
    public String about() {
        return "вывести среднее значение поля oscarsCount для всех элементов коллекции";
    }
}
