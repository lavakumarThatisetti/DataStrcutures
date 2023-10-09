package Java8Features;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Movie implements Comparable<Movie>{

    private double rating;
    private String name;
    private int year;

    @Override
    public int compareTo(Movie m) {
        return this.year-m.year;
    }
    public Movie(String nm, double rt, int yr)
    {
        this.name = nm;
        this.rating = rt;
        this.year = yr;
    }

    // Getter methods for accessing private data
    public double getRating() { return rating; }
    public String getName()   {  return name; }
    public int getYear()      {  return year;  }
}

class RatingCompare implements Comparator<Movie>{

    @Override
    public int compare(Movie o1, Movie o2) {
        if (o1.getRating() > o2.getRating()) return 1;
        else if (o1.getRating() == o2.getRating()) return 0;
        return -1;
    }
}


public class ComparabaleComparator {
    public static void main(String[] args) {
        ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Star Wars", 8.7, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));

        System.out.println("Sorted by rating");
        list.sort(new RatingCompare());
        for (Movie movie: list)
            System.out.println(movie.getRating() + " " +
                    movie.getName() + " " +
                    movie.getYear());

        PriorityQueue<String> queue= new PriorityQueue<>();
    }
}
