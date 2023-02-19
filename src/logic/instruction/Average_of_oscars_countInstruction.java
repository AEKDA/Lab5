package logic.instruction;


import data.Movie;
import logic.CollectionManager;
import logic.Instruction;

public class Average_of_oscars_countInstruction implements Instruction {
    private CollectionManager<Movie> collectionManager;
    public Average_of_oscars_countInstruction(CollectionManager<Movie> collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute(String[] args) {
        int oscarsCount = 0;
        for (Object movie :collectionManager.getData()) {
            oscarsCount += ((Movie)movie).getOscarCount();
        }
        try {
            System.out.printf("Middle count Oscars:%.1f\n", (float)oscarsCount/(float)(collectionManager.getData().size()));
        } catch(ArithmeticException e) {
            System.out.printf("Middle count Oscars:%d\n", 0);
        }
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
