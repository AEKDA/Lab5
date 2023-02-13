package data;

import java.io.InputStream;
import java.util.Scanner;

public class GetMovie {
    private Scanner scan;
    public GetMovie(InputStream source) {
        scan = new Scanner(source);
    }

    public Movie getElement(){
        Movie movie = new Movie();

        return movie;
    }

}
