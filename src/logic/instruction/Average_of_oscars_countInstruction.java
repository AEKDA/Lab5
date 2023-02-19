package logic.instruction;


import models.MovieCollection;
import models.Movie;
import logic.Instruction;

public class Average_of_oscars_countInstruction implements Instruction {

    @Override
    public void execute(String[] args) {
        int oscarsCount = 0;
        for (Movie movie :MovieCollection.getInstance().getData()) {
            oscarsCount += movie.getOscarCount();
        }
        try {
            System.out.printf("Middle count Oscars:%.1f\n", (float)oscarsCount/(float)(MovieCollection.getInstance().getData().size()));
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
